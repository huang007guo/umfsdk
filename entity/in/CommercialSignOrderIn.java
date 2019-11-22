package com.wjj.application.utils.umfsdk.entity.in;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author hank
 * @since 2019/10/30 0030 下午 18:18
 *
 *
 *  mer_id	商户编号	String(8)	Y	由平台统一分配合作商户唯一标识	60000100
    media_id	媒介标识	String(32)	Y	用户在银行预留手机号码	15969999999
    media_type	媒介类型	String(32)	Y	取值范围：MOBILE（手机号）	MOBILE
    card_id	卡号	String(256)	Y	使用联动公钥进行RSA加密后，BASE64(GBK编码)加密该字段	XXXXXXXXXXXXXXXXXXXXXX
    identity_type	证件类型	String(32)	Y	1:身份证号	1
    identity_code	证件号	String(256)	Y	使用联动公钥进行RSA加密后，BASE64(GBK编码)加密该字段	XXXXXXXXXXXXXXXXXXX
    card_holder	证卡人姓名	String(32)	Y	使用联动公钥进行RSA加密后，BASE64(GBK编码)加密该字段	张三
    cvv2	安全码(cvv2/cvn2)	String(256)	N	使用联动公钥进行RSA加密后，BASE64(GBK编码)加密该字段	789
    valid_date	有效期(YYMM）	String(256)	N	使用联动公钥进行RSA加密后，BASE64(GBK编码)加密该字段	2508
    mer_cust_id	商户用户标识	String(32)	Y	用户在商户端的唯一标识。注册用户业务协议使用。	1111111
    contract_mode	签约模式	String(32)	N	01：协议支付签约（默认）	01
 */
@Data
@AllArgsConstructor
public class CommercialSignOrderIn {
	     private String card_id;
	     private String media_id;
	     private String identity_type;
	     private String identity_code;
	     private String card_holder;
	     private String mer_cust_id;
}
