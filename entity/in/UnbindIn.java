package com.wjj.application.utils.umfsdk.entity.in;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author hank
 * @since 2019/10/31 0031 下午 14:37
 */
@Data
@AllArgsConstructor
public class UnbindIn {
    private String mer_cust_id;//用户在商户端的唯一标识。
    private String usr_pay_agreement_id;//支付协议号
}
