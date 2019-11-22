package com.wjj.application.utils.umfsdk.service;

import com.wjj.application.utils.umfsdk.common.Tools;
import com.wjj.application.utils.umfsdk.entity.in.*;
import com.wjj.application.utils.umfsdk.entity.out.AgreementPaymentOut;
import com.wjj.application.utils.umfsdk.entity.out.CommercialSignOrderOut;
import com.wjj.application.utils.umfsdk.entity.out.QuickOrderOut;
import com.wjj.application.utils.umfsdk.entity.out.UmfPayOut;

import java.util.Map;

/**
 * @author hank
 * @since 2019/10/30 0030 下午 18:15
 * @deprecated 不建议使用,请使用 UmfServiceProxyHandler 自动代理实现
 */
@Deprecated
public class UmfServiceImpl extends com.umf.api.service.UmfServiceImpl implements UmfService{
    private String merId;



    //签约申请
    public UmfPayOut<CommercialSignOrderOut> CommercialSignOrder(CommercialSignOrderIn commercialSignOrderIn) {
        //请求接口
        return mapToUmfPayOut(this.CommercialSignOrderMap(this.beanToMap(commercialSignOrderIn)), CommercialSignOrderOut.class);
    }

    //签约确认
    public UmfPayOut<CommercialSignOrderOut> CommercialSignConfirm(CommercialSignConfirmIn commercialSignConfirmIn){
        return mapToUmfPayOut(this.CommercialSignConfirmMap(this.beanToMap(commercialSignConfirmIn)), CommercialSignOrderOut.class);
    }

    //解约
    @Override
    public UmfPayOut unbind(UnbindIn unbindIn) {
        return mapToUmfPayOut(this.unbindMap(this.beanToMap(unbindIn)), null);
    }

    //支付下单
    @Override
    public UmfPayOut<QuickOrderOut> quickOrder(QuickOrderIn quickOrderIn) {
        return mapToUmfPayOut(this.quickOrderMap(this.beanToMap(quickOrderIn)), QuickOrderOut.class);
    }

    @Override
    public UmfPayOut<AgreementPaymentOut> agreementPayment(AgreementPaymentIn agreementPaymentIn) {
        return null;
    }


    public UmfServiceImpl(String merId, String merid_prikey_path) {
        super(merId, merid_prikey_path);
        this.merId = merId;
    }

    /**
     * bean转换到map
     * 自动塞入merId
     * @param bean
     * @return
     * @throws Exception
     */
    public Map beanToMap(Object bean){
        if(bean == null) {
            return null;
        }
        Map<String, Object> map = null;
        try {
            map = Tools.beanToMap(bean, true);
            Tools.mapTranscodeing(map, "utf-8", "GBK");
            map.put("mer_id", merId);
        } catch (Exception e) {
            //日志
            e.printStackTrace();
        }
        return map;
    }

    /**
     * map转换到mapToUmfPayOut
     * @return
     * @throws Exception
     */
    public <T> UmfPayOut<T> mapToUmfPayOut(Map map, Class<T> beanClass){
        UmfPayOut<T> umfPayOut = UmfPayOut.getOverrideFailInstance(
                (String) map.get("mer_id"),
                (String) map.get("ret_code"),
                (String) map.get("ret_msg")
        );
        if(beanClass != null) {
            try {
                umfPayOut.setData(Tools.mapToBean(map, beanClass));
            } catch (Exception e) {
                //日志
                e.printStackTrace();
            }
        }
        return umfPayOut;
    }

}
