package com.wjj.application.utils.umfsdk.entity.in;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 下单 in
 * mer_id	商户编号	String(8)	Y	由平台统一分配合作商户唯一标识	60000100
 notify_url	服务器异步通知页面路径	String(128)	N	交易完成后，联动优势支付平台会按照此地址将交易结果以后台的方式发送到商户网站。	http://www.xxx.com
 goods_id	商品号	String(8)	N	支持数字，字母；该参数为唯一一个对账文件返回的商户保留字段	1
 goods_inf	商品描述信息	String(64)	N	如果传递中文，需确保该字段在传入接口前，编码正确，建议使用UTF-8编码（根据商户服务器编码环境而定）。	1HFHF
 order_id	商户订单号	String(32)	Y	订单号码支持数字、英文字母、-、_、*、+、#，其他字符将不支持,订单号不能小于4位.	707794189
 mer_date	原商户订单日期	定长String(8)	Y	商户生成订单的日期，格式YYYYMMDD，订单日期必须为当日。	20180321
 amount	付款金额	String(13)	Y	如果是人民币，则以分为单位	1
 amt_type	付款币种	String(8)	Y	“取值范围：RMB”	RMB
 mer_priv	商户私有域	String(128)	N	联动优势支付平台原样返回，用于商户的私有信息。如果传递中文，需确保该字段在传入接口前，编码正确。建议使用使用utf-8 编码。	7242A100005259
 user_ip	用户IP地址	String(16)	N	用户在创建交易时，该用户当前所使用机器的 IP。用作防钓鱼校验	111.16.224.53
 expand	业务扩展信息	String(128)	N	主要保存扩展字段的信息
 expire_time	订单过期时长	String(8)	N	单位为分钟，默认1440分钟（24小时）	00001440
 risk_expand	风控扩展信息	String(512)	N	格式：代码:内容#代码:内容……如：A0001:二级商户号#A0002:二级商户名称……(此字段要使用UTF-8 urlencode编码)	A0001

 * @author hank
 * @since 2019/10/31 0031 下午 14:37
 */
@Data
@AllArgsConstructor
public class QuickOrderIn {
    private String notify_url;
    private String goods_id;
    private String goods_inf;
    private String order_id;
    private String mer_date;
    private String amount;
    private String amt_type;
    private String mer_priv;
    private String user_ip;
    private String expand;
    private String expire_time;
    private String risk_expand;
}
