package com.wjj.application.utils.umfsdk.entity.out;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 trade_no	联动交易号	String(16)	N	对于商户的每次非重复下单，联动都会生成一个唯一交易号。	3709141130507194
 trade_state	交易状态	String(32)	N	参考交易状态说明	1
 * @author hank
 * @since 2019/10/31 0031 下午 14:37
 */
@Data
public class QuickOrderOut {
    private String trade_no;
    private String trade_state;
}
