package com.wjj.application.utils.umfsdk.entity.out;

import com.wjj.application.utils.umfsdk.consts.UmfPayRetCode;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hank
 * @since 2019/10/31 0031 下午 14:30
 */
@Data
public class UmfPayOut<T> {
    private String mer_id;
    private String ret_code;
    private String ret_msg;
    private T data;

    /**
     * 用fail覆盖code为空的 code 和 msg(msg为空才覆盖)
     * @param mer_id
     * @param ret_code
     * @param ret_msg
     * @return
     */
    public static <T> UmfPayOut<T> getOverrideFailInstance(String mer_id, String ret_code, String ret_msg){
        UmfPayOut<T> umfPayOut = new UmfPayOut<>();
        umfPayOut.setMer_id(mer_id);
        umfPayOut.setRet_code(StringUtils.isBlank(ret_code) ? UmfPayRetCode.fail.getCode() : ret_code);
        umfPayOut.setRet_msg(StringUtils.isBlank(ret_msg) ? UmfPayRetCode.fail.getMsg() : ret_msg);
        return umfPayOut;
    }
}
