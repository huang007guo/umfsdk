package com.wjj.application.utils.umfsdk.service;

import com.wjj.application.utils.umfsdk.entity.in.*;
import com.wjj.application.utils.umfsdk.entity.out.AgreementPaymentOut;
import com.wjj.application.utils.umfsdk.entity.out.CommercialSignOrderOut;
import com.wjj.application.utils.umfsdk.entity.out.QuickOrderOut;
import com.wjj.application.utils.umfsdk.entity.out.UmfPayOut;

import java.util.Map;

/**
 * @author hank
 * @since 2019/10/31 0031 下午 14:22
 */
public interface UmfService extends com.umf.api.service.UmfService{
    //签约下单
    UmfPayOut<CommercialSignOrderOut> CommercialSignOrder(CommercialSignOrderIn commercialSignOrderIn);

    //签约确认
    UmfPayOut<CommercialSignOrderOut> CommercialSignConfirm(CommercialSignConfirmIn commercialSignConfirmIn);

    //解约
    UmfPayOut unbind(UnbindIn unbindIn);

    //支付下单
    UmfPayOut<QuickOrderOut> quickOrder(QuickOrderIn quickOrderIn);

    //协议支付
    UmfPayOut<AgreementPaymentOut> agreementPayment(AgreementPaymentIn agreementPaymentIn);
}
