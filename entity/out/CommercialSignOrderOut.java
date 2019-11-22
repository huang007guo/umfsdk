package com.wjj.application.utils.umfsdk.entity.out;

import lombok.Data;

/**
 * @author hank
 * @since 2019/10/31 0031 下午 14:37
 */
@Data
public class CommercialSignOrderOut {
    private String bind_id;//签约订单号
    private String usr_busi_agreement_id;//用户业务协议号
    private String usr_pay_agreement_id;//支付协议号
}
