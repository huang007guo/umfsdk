package com.wjj.application.utils.umfsdk.common;

import org.apache.commons.beanutils.BeanUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hank
 * @since 2019/10/29 0029 下午 15:24
 */
public class Tools {
    /**
     * An empty array.  Used to invoke accessors via reflection.
     */
    public static final Object[] NULL_ARGUMENTS = {};
    /**
     *
     * bean转换为Map
     * @param bean
     * @param isSuppressException 是否压制异常
     * @return
     */
    public static Map<String, Object> beanToMap(Object bean, boolean isSuppressException) throws Exception{
        if(bean == null) {
            return null;
        }

        final Map<String, String> description = new HashMap<String, String>();

        final Class<?>  beanClass = bean.getClass();
        Map<String, Object> readMethods = new HashMap<>();
        try {
            //BeanInfo beanInfo = Introspector.getBeanInfo( bean, null );
            final BeanInfo beanInfo = Introspector.getBeanInfo( beanClass );
            final PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            if ( propertyDescriptors != null ) {
                for (final PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                    if ( propertyDescriptor != null ) {
                        final String name = propertyDescriptor.getName();
                        final Method readMethod = propertyDescriptor.getReadMethod();

                        if ( readMethod != null && !name.equals("class") ) {
                            try {
                                readMethods.put( name, readMethod.invoke( bean, NULL_ARGUMENTS));
                            } catch (Exception e) {
                                //是否压制异常
                                if(!isSuppressException){
                                    throw e;
                                }else{
                                    System.out.println( "WARN: Exception: " + e );
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }
        catch ( final IntrospectionException e ) {
            //是否压制异常
            if(!isSuppressException){
                throw e;
            }else{
                System.out.println( "WARN: Exception: " + e );
                e.printStackTrace();
            }
        }
        return readMethods;
    }

    /**
     *
     * bean转换为Map
     * @return Map<?,?>    返回类型
     */
    public static <T> T mapToBean(Map map, Class<T> beanClass) throws Exception{
        T bean = beanClass.newInstance();
        BeanUtils.populate(bean, map);
        return bean;
    }

    /**
     * Map value type=String 转码
     * @param map
     * @param source 原始编码 utf-8
     * @param target 转换目标编码 GBK
     * @throws UnsupportedEncodingException
     */
    public static void mapTranscodeing(Map<?, Object> map, String source, String target) throws UnsupportedEncodingException {
        if(map == null){
            return;
        }
        for (Map.Entry<?, Object> now: map.entrySet()){
            if(now.getValue() != null && (now.getValue() instanceof String)){
                now.setValue((new String(now.getValue().toString().getBytes(source),target)));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //请求接口
//        Map<String, Object> map = Tools.beanToMap(new CommercialSignOrderIn(
//                "1",
//                "2",
//                "你好二",
//                "3",
//                "你好",
//                "1"
//        ),true);
//        mapTranscodeing(map, "utf-8", "GBK");
    }
}
