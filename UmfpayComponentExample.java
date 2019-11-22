package com.wjj.application.utils.umfsdk;
import com.wjj.application.utils.umfsdk.service.UmfService;
import com.wjj.application.utils.umfsdk.service.UmfServiceProxyHandler;

import java.lang.reflect.Proxy;

/**
 * 联动sdk 组件例子
 * @author hank
 * @since 2019/11/1 0001 下午 17:18
 */
//@Component
public class UmfpayComponentExample {
    //分别传入商户号和商户私钥的证书地址
    private static final UmfService instance = (UmfService) Proxy.newProxyInstance(
            UmfService.class.getClassLoader(),
            new Class[]{ UmfService.class },
            new UmfServiceProxyHandler(new com.umf.api.service.UmfServiceImpl("60000100","G:/rsa_private_key_pkcs8.p8"), "60000100")
    );

    // 静态方法返回该类的实例
    public static UmfService getInstance() {
        return instance;
    }
}
