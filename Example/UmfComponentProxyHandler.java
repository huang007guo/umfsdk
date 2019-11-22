package com.wjj.application.component.umfpay;

import com.wjj.application.paymentapi.consts.enums.PaymentReturnCode;
import com.wjj.application.utils.ResponseUtils;
import com.wjj.application.utils.umfsdk.consts.UmfPayRetCode;
import com.wjj.application.utils.umfsdk.entity.out.UmfPayOut;
import com.wjj.application.utils.umfsdk.service.UmfService;
import com.wjj.application.wjjutil.excption.ResponseException;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 联动支付代理组件(代理UmfService)
 * 1.自动try catch throw ResponseException
 * 2.前后置处理
 * @author hank
 * @since 2019/11/7 0007 下午 16:19
 */
@Slf4j
public class UmfComponentProxyHandler implements InvocationHandler {
    private UmfService instance;

    public UmfComponentProxyHandler(UmfService instance) {
        this.instance = instance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = null;
        try {
            ret = method.invoke(instance, args);
        } catch (Exception e) {
            log.error("调用umfpay " + method.getName() + " 异常", e);
            ResponseUtils.throwExceptionType(PaymentReturnCode.THIRD_API_EXCEPTION);
        }
        if(ret != null && ret instanceof UmfPayOut){
            UmfPayOut umfPayOut = (UmfPayOut)ret;
            //这里后期可能需要处理一些常见的code
            if (!UmfPayRetCode.success.getCode().equals(umfPayOut.getRet_code()) || umfPayOut.getData() == null) {
                log.warn("调用umfpay " + method.getName() + " 失败: {}", umfPayOut);
                ResponseException.throwExc(PaymentReturnCode.THIRD_API_FAIL.getErrorCode(), umfPayOut.getRet_msg());
            }
        }
        return ret;
    }
}
