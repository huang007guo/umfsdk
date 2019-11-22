package com.wjj.application.utils.umfsdk.service;

import com.umf.api.service.UmfService;
import com.wjj.application.utils.umfsdk.common.Tools;
import com.wjj.application.utils.umfsdk.entity.out.UmfPayOut;

import java.lang.reflect.*;
import java.util.Map;

/**
 * umfService 代理类
 * 1.处理map传输的方法变成实例传输
 * 2.原始map方法自动转码uft8->GBK
 * @author hank
 * @version 0.1
 * @since 2019/11/5 0005 下午 13:56
 * @see UmfServiceImpl 参考实现
 * @see com.wjj.application.utils.umfsdk.UmfpayComponentExample 例子
 */
public class UmfServiceProxyHandler implements InvocationHandler {
    private String merId;

    private UmfService umfService;

    public UmfServiceProxyHandler(UmfService umfService, String merId) {
        this.umfService = umfService;
        this.merId = merId;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        boolean isMapMethod = methodName.contains("Map");
        //类型列表
        Class<?>[] parameterTypes = null;
        //遍历参数,获得类型列表
        if(args != null && args.length > 0) {
            parameterTypes = new Class<?>[args.length];
            for (int i=0; i< args.length; i++) {
                if(isMapMethod && Map.class.isAssignableFrom(args[i].getClass())){
                    parameterTypes[i] = Map.class;
                }else {
                    parameterTypes[i] = args[i].getClass();
                }
            }
        }
        Method toMethod;
        //这里判断方法名是否存在Map (因为存在MapNew,所以不判断最后而是判断存在)
        if(!isMapMethod){
            //如果不存在Map先调用+Map方法,在尝试原始方法
            try {
                toMethod = umfService.getClass().getMethod(methodName + "Map", Map.class);
            }catch (NoSuchMethodException e){
                //没有方法尝试调用原始方法
                toMethod = umfService.getClass().getMethod(methodName, parameterTypes);
            }
        }else {
            //如果存在Map先调用原始方法,在尝试+Map方法
            try {
                toMethod = umfService.getClass().getMethod(methodName, parameterTypes);
            }catch (NoSuchMethodException e){
                //没有方法尝试调用原始方法
                toMethod = umfService.getClass().getMethod(methodName + "Map", Map.class);
            }
        }
        //调用原始方法
        if(toMethod.getName().equals(methodName)){
            //如果原始方法是Map方法,转码args中的Map
            if(toMethod.getName().contains("Map") && args != null && args.length > 0){
                for (int i=0; i< args.length; i++) {
                    if(args[i] instanceof Map){
                        Tools.mapTranscodeing((Map)args[i], "utf-8", "GBK");
                    }
                }
            }
            return toMethod.invoke(umfService, args);
        }
        //调用+Map方法
        else{
            Object retRaw = toMethod.invoke(umfService, args != null ? beanToMap(args[0]) : null);
            Type returnType = method.getGenericReturnType();
            //mapToUmfPayOut
            if(retRaw instanceof Map && returnType != null && returnType instanceof ParameterizedType){
                ParameterizedType paramReturnType = (ParameterizedType) returnType;
                if(UmfPayOut.class.equals(paramReturnType.getRawType())){
                    // 输出的beanClass
                    Class<?> outBeanClass = null;
                    if(paramReturnType.getActualTypeArguments() != null
                            && paramReturnType.getActualTypeArguments().length > 0
                            && paramReturnType.getActualTypeArguments()[0] instanceof Class
                            ){
                        outBeanClass = (Class) paramReturnType.getActualTypeArguments()[0];
                    }
                    return mapToUmfPayOut((Map)retRaw, outBeanClass);
                }
            }
            return retRaw;
        }
    }

    /**
     * bean转换到map
     * 自动塞入merId
     * @param bean
     * @return
     * @throws Exception
     */
    public Map beanToMap(Object bean) throws Exception {
        Map<String, Object> map = Tools.beanToMap(bean,true);
        Tools.mapTranscodeing(map, "utf-8", "GBK");
        map.put("mer_id", merId);
        return map;
    }

    /**
     * map转换到mapToUmfPayOut
     * @return
     * @throws Exception
     */
    public <T> UmfPayOut<T> mapToUmfPayOut(Map map, Class<T> beanClass) throws Exception {
        UmfPayOut<T> umfPayOut = UmfPayOut.getOverrideFailInstance(
                (String) map.get("mer_id"),
                (String) map.get("ret_code"),
                (String) map.get("ret_msg")
        );
        if(beanClass != null) {
            umfPayOut.setData(Tools.mapToBean(map, beanClass));
        }
        return umfPayOut;
    }
}
