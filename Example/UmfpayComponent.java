package com.wjj.application.component.umfpay;
import com.wjj.application.config.UmfpayConfig;
import com.wjj.application.utils.umfsdk.service.UmfService;
import com.wjj.application.utils.umfsdk.service.UmfServiceProxyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * @author hank
 * @since 2019/11/1 0001 下午 17:18
 */
@Slf4j
@Component
public class UmfpayComponent implements InitializingBean {
    private static UmfService instance;

    @Autowired
    private UmfpayConfig umfpayConfig;

    // 静态方法返回该类的实例
    public static UmfService getInstance() {
        return instance;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("---------- UmfService instance init -------------");
        UmfService umfService = (UmfService) Proxy.newProxyInstance(
                UmfService.class.getClassLoader(),
                new Class[]{ UmfService.class },
                //分别传入商户号和商户私钥的证书地址
                new UmfServiceProxyHandler(new com.umf.api.service.UmfServiceImpl(umfpayConfig.getMerId(),umfpayConfig.getPriKeyPath()), umfpayConfig.getMerId())
        );
        instance = (UmfService) Proxy.newProxyInstance(
                UmfService.class.getClassLoader(),
                new Class[]{ UmfService.class },
                new UmfComponentProxyHandler(umfService)
        );
    }
}
