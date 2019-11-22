package com.wjj.application.utils.umfsdk.entity.in;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author hank
 * @since 2019/10/30 0030 下午 18:18
 *
 *
 *  mer_id	商户编号	String(8)	Y	由平台统一分配合作商户唯一标识	60000100
 *  bind_id	签约订单号	String(16)	Y	联动生成的订单号
 *  verify_code	验证码	String(8)	Y	用户收到的短信验证码	0605
 */
@Data
@AllArgsConstructor
public class CommercialSignConfirmIn {
	     private String bind_id;
	     private String verify_code;
}
