package com.wjj.application.utils.umfsdk.entity.out;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 协议支付出参
 * @author hank
 * @since 2019/11/13 0013 下午 14:04
 * @apiNote
    order_id	商户订单号	String(32)	Y	商户下单时提交的order_id	707794189
    mer_date	商户订单日期	定长String(8)	Y	商户下单时提交的mer_date	20180321
    pay_date	支付日期	定长String(8)	Y	用户对订单进行支付的日期，格式是YYYYMMDD	20180321
    amount	付款金额	String(13)	Y	如果是人民币，则以分为单位	1
    amt_type	付款币种	String(8)	Y	取值范围：RMB	RMB
    ret_code	返回码	String(8)	Y	详见重要返回码	0000
    ret_msg	返回信息	String(128)	N		交易成功
    settle_date	对账日期	定长String(8)	N	商户的对账报表均以此日期为准，格式为YYYYMMDD
    扣款成功时，此字段必有值	20180322
    mer_priv	商户私有域	String(128)	N	联动优势支付平台原样返回，用于商户的私有信息。如果传递中文，需确保该字段在传入接口前，编码正确。建议使用使用utf-8 编码。	7242A100005259
    trade_state	交易状态	String(32)	Y	参考交易状态说明	TRADE_SUCCESS
 */
@Data
@AllArgsConstructor
public class AgreementPaymentOut {
    private String order_id;
    private String mer_date;
    private String pay_date;
    private String amount;
    private String amt_type;
    private String settle_date;
    private String mer_priv;
    private String trade_state;
}
