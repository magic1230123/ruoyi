package com.magic.ruoyiapi.service.sms;


import com.magic.ruoyiapi.domain.SmsQuery;
import com.magic.ruoyiapi.domain.dto.ApiResponse;


/**
 * @author 1
 */
public interface BaseSmsService {

    /**
     * 发送短信验证码
     *
     * @param query
     * @return
     */
    ApiResponse sendSmsCode(SmsQuery query);

    /**
     * 检查验证码
     * @param type
     * @param phone
     * @param code
     * @return
     */
    boolean checkSmsCode(Integer type, String phone, String code);

    /**
     * 校验验证码
     * @param query
     * @return
     */
    ApiResponse checkCode(SmsQuery query);
}
