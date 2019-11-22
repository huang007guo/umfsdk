package com.wjj.application.utils.umfsdk.consts;

import lombok.Data;

/**
 * @author hank
 * @since 2019/11/13 0013 上午 11:06
 */
public enum  TradeStateEnum {
    WAIT_BUYER_PAY("1", "WAIT_BUYER_PAY"),//		交易创建，等待买家付款
    TRADE_SUCCESS("2", "TRADE_SUCCESS"),//		交易成功，不能再次进行交易
    TRADE_CLOSE("3", "TRADE_CLOSE"),//	交易关闭， 在指定时间段内未支付时关闭的交易	交易关闭，商户支付或者查询已经过期的订单后，订单状态才会改变为交易关闭
    TRADE_CANCEL("4", "TRADE_CLOSE"),//	交易撤销
	TRADE_FAIL("5", "TRADE_FAIL"),//	交易失败
    ;

    private String no;
    private String name;

    TradeStateEnum(String no, String name) {
        this.no = no;
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
