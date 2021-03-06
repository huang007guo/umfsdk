package com.wjj.application.utils.umfsdk.consts;

/**
 * @author hank
 * @since 2019/10/31 下午 15:04,
 */
public enum UmfPayRetCode {
    success("0000", "成功"),
    //自定义的code 不是联动的
    fail("500", "接口请求失败"),
    code00060710("00060710", "签名验签失败"),
    code00060761("00060761", "订单支付中"),
    code00200013("00200013", "商户未开通该银行"),
    code00200076("00200076", "商户未开通产品关系"),
    code00200077("00200077", "生成支付订单失败"),
    code00200078("00200078", "支付订单不存在"),
    code00200079("00200079", "订单已过期请重新下单"),
    code00200080("00200080", "订单已关闭"),
    code00060780("00060780", "订单已支付成功,无须再次支付"),
    code00080730("00080730", "订单正在支付，不能重复发起"),
    code00180018("00180018", "订单状态异常，请重新进行支付"),
    code00200083("00200083", "验证码输入不正确"),
    code00200084("00200084", "验证码错误次数超过最大次数"),
    code00200086("00200086", "验证码一分钟内只可获取一次"),
    code00200087("00200087", "请求验证码次数超过最大次数"),
    code00200088("00200088", "验证码错误次数超过最大次数"),
    code00200089("00200089", "请求手机号和上次获取验证码手机号不一致"),
    code00200090("00200090", "验证码已失效"),
    code00200081("00200081", "查询交易记录不存在"),
    code00200093("00200093", "二维码已过期，请更换后再试"),
    code00200075("00200075", "银行卡类型与支付方式不匹配"),
    code00240402("00240402", "商户请求参数数据校验未通过"),
    code00060766("00060766", "不允许退款"),
    code00060767("00060767", "退款处理失败"),
    code00060768("00060768", "退款金额与支付金额不一致"),
    code00060774("00060774", "累计退款金额大于支付金额"),
    code00060778("00060778", "退款记录不存在"),
    code00060861("00060861", "退费交易，财务处理中"),
    code00060931("00060931", "退费结果不明"),
    code00080728("00080728", "交易撤销成功"),
    code00200091("00200091", "不允许撤销"),
    code00200092("00200092", "撤销金额与支付金额不一致"),
    code00252001("00252001", "订单支付失败，您的账户号被禁止交易"),
    code00252005("00252005", "订单支付失败，您的银行卡被禁止交易"),
    code00252004("00252004", "订单支付失败，该商户已被禁止交易"),
    code00252006("00252006", "订单支付失败，该支付产品已被禁止交易"),
    code00252007("00252007", "订单支付失败，您的手机号已被禁止交易"),
    code00252008("00252008", "订单支付失败，您的身份证已被禁止交易"),
    code00252009("00252009", "订单支付失败，您的终端号被禁止交易"),
    code00252010("00252010", "订单支付失败，您的IP地址已被禁止交易"),
    code00210113("00210113", "银行认为您的交易存在风险，为了您的资金安全，交易被终止，详情可咨询发卡行"),
    code00255003("00255003", "24小时内银行卡发生余额不足次数过多，为了您的资金安全，交易被终止"),
    code00255999("00255999", "交易存在风险，订单支付失败"),
    code00202001("00202001", "验证请求异常"),
    code00080732("00080732", "系统不支持该类卡支付，请更换卡片"),
    code00202005("00202005", "银行卡号输入有误"),
    code00202006("00202006", "姓名输入过长或输入非汉字字符"),
    code00210051("00210051", "户名错误，请核实后再次输入"),
    code00202008("00202008", "手机号输入不正确"),
    code00202009("00202009", "身份证号输入不正确"),
    code00202007("00202007", "身份信息同银行卡信息不一致"),
    code00202011("00202011", "单日认证账户尝试次数过多"),
    code00202012("00202012", "银行卡未开通银联无卡支付服务，通常在网银或者银行柜台可以办理，详情可联系发卡行确认"),
    code00060306("00060306", "银行卡被锁定，无法完成交易"),
    code00090386("00090386", "银行卡为冻结账户，无法完成交易"),
    code00210024("00210024", "卡状态异常，无法完成交易"),
    code00080543("00080543", "您的银行卡密码输入错误次数超限，详情请咨询发卡行。"),
    code00080530("00080530", "亲，您的银行卡已过期或有效期错误，无法完成交易，详情请咨询发卡行"),
    code00210028("00210028", "银行卡信息不匹配，通常是手机号输入不正确所致，可联系发卡行进行核实"),
    code00210008("00210008", "报文格式不正确"),
    code00200014("00200014", "支付结果不明，请稍后查询"),
    code00080550("00080550", "无可用的交易通道"),
    code00210040("00210040", "亲，银行系统出现故障了，银行工程师正在努力恢复…..，请您稍后再试！"),
    code00090396("00090396", "亲，您的银行卡状态有异常，无法完成交易，详情请联系发卡行"),
    code00080537("00080537", "亲，您的银行账户余额不足，请您核实后再来交易。"),
    code00090242("00090242", "亲，您的银行卡不支持此项交易，建议更换支持的银行卡，具体失败原因请联系发卡行核实"),
    code00210077("00210077", "发卡行交易受限，通常为账户交易超过发卡行日交易限额所致，请联系发卡行进行核实"),
    code00090361("00090361", "亲，您的交易金额超过发卡行设置的日限额，详情请联系发卡行."),
    code00060999("00060999", "亲，系统罢工啦，工程师正在努力恢复……，请您稍候片刻，感谢您的支持！"),
    code00060550("00060550", "银行返回交易失败，未告知明确失败原因，请联系发卡行进行核实"),
    code00080557("00080557", "银行返回支付失败,请详询发卡行！"),
    code00060307("00060307", "您的订单金额低于单笔交易最小金额，订单支付失败。"),
    code00060309("00060309", "您的订单金额超过单笔交易限额，订单支付失败。"),
    code00060322("00060322", "您的订单金额超过单笔交易限额，订单支付失败。"),
    code00060341("00060341", "亲，您的交易金额超过当日累计交易金额限制，无法完成交易。"),
    code00060342("00060342", "亲，您的交易金额超过当月累计交易金额限制，无法完成交易。"),
    code00060343("00060343", "亲，您的交易笔数超过当日累计交易笔数限制，无法完成交易。"),
    code00060344("00060344", "亲，您的交易笔数超过当月累计交易笔数限制，无法完成交易。"),
    code00060332("00060332", "您的订单金额超过单笔交易限额，订单支付失败。"),
    code00060340("00060340", "您的订单金额超过单笔交易限额，订单支付失败。"),
    code00060494("00060494", "您的订单金额超过单笔交易限额，订单支付失败。"),
    code00060499("00060499", "您的订单金额超过单笔交易限额，订单支付失败。"),
    code00060544("00060544", "亲，您的交易金额超过银行交易限额，请调整交易金额或者联系发卡行进行处理。"),
    code00160021("00160021", "您的订单金额超过该银行单笔交易限额，订单支付失败。"),
    code00160022("00160022", "您的订单金额超过该银行单笔交易限额。"),
    code00160023("00160023", "您的订单金额超过用户首次交易限额。"),
    code00160028("00160028", "您的订单金额超过该银行用户首次交易限额，订单支付失败。"),
    code00253001("00253001", "您的银行卡在该商户1小时内累计交易金额超限，订单支付失败"),
    code00253002("00253002", "您银行卡在该商户1天内累计交易金额超"),
    code00253003("00253003", "您的银行卡在该商户30天内累计交易金额超限"),
    code00253007("00253007", "您在该商户1小时内累计交易金额超限"),
    code00253008("00253008", "您在该商户1天内累计交易金额超限"),
    code00253009("00253009", "您在该商户30天内累计交易金额超限"),
    code00253010("00253010", "您的手机号在该商户1小时内累计交易金额超限"),
    code00253011("00253011", "您的手机号在该商户1天内累计交易金额超限"),
    code00253012("00253012", "您的手机号在该商户30天内累计交易金额超限"),
    code00253013("00253013", "您在该商户1小时内累计交易金额超限"),
    code00253014("00253014", "您在该商户1天内累计交易金额超限"),
    code00253015("00253015", "您在该商户30天内累计交易金额超限"),
    code00253016("00253016", "您的账户在该商户1小时内累计交易金额超限"),
    code00253017("00253017", "您的账户在该商户1天内累计交易金额超限"),
    code00253018("00253018", "您的账户在该商户30天内累计交易金额超限"),
    code00253022("00253022", "您的银行卡在该商户1小时内累计交易金额超限"),
    code00253023("00253023", "您的银行卡在该商户1天内累计交易金额超限"),
    code00253024("00253024", "您的银行卡在该商户30天内累计交易金额超限"),
    code00253025("00253025", "您在该商户1小时内累计交易金额超限"),
    code00253026("00253026", "您在该商户1天内累计交易金额超限"),
    code00253027("00253027", "您在该商户30天内累计交易金额超限"),
    code00253028("00253028", "您在该商户1小时内累计交易金额超限"),
    code00253029("00253029", "您在该商户1天内累计交易金额超限"),
    code00253030("00253030", "您在该商户30天内累计交易金额超限"),
    code00253031("00253031", "您在该商户1小时内累计交易金额超限"),
    code00253032("00253032", "您在该商户1天内累计交易金额超限"),
    code00253033("00253033", "您在该商户30天内累计交易金额超限"),
    code00253034("00253034", "您的手机号在该商户1小时内累计交易金额超限"),
    code00253035("00253035", "您的手机号在该商户1天内累计交易金额超限"),
    code00253036("00253036", "您的手机号在该商户30天内累计交易金额超限"),
    code00253037("00253037", "您的订单金额超过该商户单笔交易限额"),
    code00253038("00253038", "您的订单金额超过该商户单笔交易限额"),
    code00253039("00253039", "您的订单金额超过该商户单笔交易限额"),
    code00253040("00253040", "您的订单金额超过该商户单笔交易限额"),
    code00253041("00253041", "您的订单金额超过该商户单笔交易限额"),
    code00253042("00253042", "您的订单金额超过该商户单笔交易限额"),
    code00253043("00253043", "您的订单金额超过该商户单笔交易限额"),
    code00253044("00253044", "您的订单金额超过该商户单笔交易限额"),
    code00253045("00253045", "您的订单金额超过该商户单笔交易限额"),
    code00253046("00253046", "您的订单金额超过该商户单笔交易限额"),
    code00253048("00253048", "您的订单金额超过用户首次支付限额，订单支付失败。"),
    code00253049("00253049", "商户产品号新用户银行卡1小时累计交易金额超限"),
    code00253050("00253050", "商户产品号新用户银行卡1个自然日内累计交易金额超限"),
    code00253051("00253051", "商户产品号新用户手机号1小时累计交易金额超限"),
    code00253052("00253052", "商户号产品号新用户手机号单笔交易金额超限"),
    code00253053("00253053", "商户产品号新用户手机号1个自然日累计交易金额超限"),
    code00254001("00254001", "您在该商户1小时内累计交易次数超限"),
    code00254002("00254002", "您在该商户1天内累计交易次数超限"),
    code00254003("00254003", "您在该商户30天内累计交易次数超限"),
    code00254007("00254007", "您在该商户1小时内累计交易次数超限"),
    code00254008("00254008", "您在该商户1天内累计交易次数超限"),
    code00254009("00254009", "您在该商户30天内累计交易次数超限"),
    code00254010("00254010", "您的手机号在该商户1小时内累计交易次数超限"),
    code00254011("00254011", "您的手机号在该商户1天内累计交易次数超限"),
    code00254012("00254012", "您的手机号在该商户30天内累计交易金额次数超限"),
    code00254013("00254013", "您在该商户1小时内累计交易次数超限"),
    code00254014("00254014", "您在该商户1天内累计交易次数超限"),
    code00254015("00254015", "您在该商户30天内累计交易次数超限"),
    code00254016("00254016", "您在该商户1小时内累计交易次数超限"),
    code00254017("00254017", "您在该商户1天内累计交易次数超限"),
    code00254018("00254018", "您在该商户30天内累计交易次数超限"),
    code00254022("00254022", "您的银行卡在该商户1小时内累计交易次数超限"),
    code00254023("00254023", "您的银行卡在该商户1天内累计交易次数超限"),
    code00254024("00254024", "您的银行卡在该商户30天内累计交易次数超限"),
    code00254025("00254025", "您在该商户1小时内累计交易次数超限"),
    code00254026("00254026", "您在该商户1天内累计交易次数超限"),
    code00254027("00254027", "您在该商户30天内累计交易次数超限"),
    code00254028("00254028", "您在该商户1小时内累计交易次数超限"),
    code00254029("00254029", "您在该商户1天内累计交易次数超限"),
    code00254030("00254030", "您在该商户30天内累计交易次数超限"),
    code00254031("00254031", "您在该商户1小时内累计交易次数超限"),
    code00254032("00254032", "您在该商户1天内累计交易次数超限"),
    code00254033("00254033", "您在该商户30天内累计交易次数超限"),
    code00254034("00254034", "您的手机号在该商户1小时内累计交易次数超限"),
    code00254035("00254035", "您的手机号在该商户1天内累计交易次数超限"),
    code00254036("00254036", "您的手机号在该商户30天内累计交易金额次数超限"),
    code00254037("00254037", "某商户产品号新用户银行卡1小时累计交易次数超限"),
    code00254038("00254038", "某商户产品号新用户银行卡1个自然日内累计交易次数超限"),
    code00254039("00254039", "某商户产品号新用户手机号1小时累计交易次数超限"),
    code00254040("00254040", "某商户产品号新用户手机号1个自然日累计交易次数超限"),
    code00253058("00253058", "商户未上线且交易金额超限"),
    code00255888("00255888", "交易存在风险，产品未在风控系统注册或未激活"),
    code00160103("00160103", "注册鉴权失败"),
    code00160108("00160108", "银行卡已签约"),
    code00060674("00060674", "签业务协议失败"),
    code00160102("00160102", "请求银行签约失败"),
    code00200101("00200101", "查询签约订单信息失败,签约订单不存在或已过期，请重新申请签约"),
    code00060675("00060675", "签约订单已完成签约"),
    code00201071("00201071", "银行卡未签约"),
    code00160129("00160129", "支付协议不存在或状态异常（未签约成功）"),
    code00160130("00160130", "银行卡不存在或状态异常（未签约成功）"),
    code00060015("00060015", "未找到订单，未申请或者已失效"),
    code00060406("00060406", "未能查询到媒介对应用户"),
    code00060700("00060700", "数据校验未通过"),
    code00210124("00210124", "暂无可用的支付方式,请绑定其它银行卡完成支付"),
    ;

    public static UmfPayRetCode getByCode(String code){
        if(code != null) {
            for (UmfPayRetCode umfPayRetCode : UmfPayRetCode.values()) {
                if (umfPayRetCode.getCode().equals(code)) {
                    return umfPayRetCode;
                }
            }
        }
        return null;
    }

    UmfPayRetCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
