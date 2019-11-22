package com.wjj.application.utils.umfsdk.entity.in;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 协议支付入参
 * @author hank
 * @since 2019/11/13 0013 下午 13:55
 * @apiNote
    mer_id	商户编号	String(8)	Y	由平台统一分配合作商户唯一标识	60000100
    verify_code	验证码	String(8)	N	联动平台给用户下发的短信验证码。如果商户线下明确要求不用联动下发验证码的，可以不传该值。下发验证码为绑定的手机号。	0605
    trade_no	联动交易号	String(16)	Y	平台下单响应商户的订单号值	3709141130507194
    mer_cust_id	商户用户标识	String(32)	N（协议支付时商户用户标识、用户业务协议号必传其一）	用户在商户端的唯一标识。
    首次支付时：如果用户同意注册协议支付服务，就输入该值，支付成功后，平台会为用户注册协议支付业务协议；如果没有输入，平台不会注册用户业务协议。
    协议支付时：如果用户已经注册协议支付业务协议，平台会根据该值查找用户业务协议，提供协议支付服务。	1111
    usr_busi_agreement_id	用户业务协议号	String(64)	N（协议支付时商户用户标识、用户业务协议号必传其一）	用户注册协议支付服务时在联动生成的协议号，每个商户的用户标识在平台对应唯一一个用户业务协议号。平台会根据该值提供协议支付服务。	UB201712082243360000000026512093
    usr_pay_agreement_id	支付协议号	String(64)	Y	用户协议支付注册成功后，会为每一个首次支付成功的银行卡注册支付协议。指定支付协议号，平台就能为用户提供相应的银行卡支付服务。协议支付时该值必填。	P2017111208553000000000033565625
    cvv2	安全码(cvv2/cvn2)	String(256)	N	使用联动公钥进行RSA加密后，BASE64(GBK编码)加密该字段	789
    valid_date	有效期(YYMM）	String(256)	N	使用联动公钥进行RSA加密后，BASE64(GBK编码)加密该字段	2508
    user_ip	用户IP地址	String(16)	N	用户在确认支付时，该用户当前所使用机器的 IP。可能与下单时的IP不同	111.16.224.53
 */
@Data
@AllArgsConstructor
public class AgreementPaymentIn {
    private String verify_code;
    private String trade_no;
    private String mer_cust_id;
    private String usr_busi_agreement_id;
    private String usr_pay_agreement_id;
    private String cvv2;
    private String valid_date;
    private String user_ip;

}
