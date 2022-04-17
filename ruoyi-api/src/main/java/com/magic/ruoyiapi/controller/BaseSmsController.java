package com.magic.ruoyiapi.controller;


import com.magic.ruoyiapi.domain.Code;
import com.magic.ruoyiapi.domain.Phone;
import com.magic.ruoyiapi.domain.SmsQuery;
import com.magic.ruoyiapi.domain.Type;
import com.magic.ruoyiapi.domain.dto.ApiResponse;
import com.magic.ruoyiapi.domain.dto.ResponseCode;
import com.magic.ruoyiapi.service.sms.BaseSmsService;
import com.magic.ruoyiapi.utils.MobileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 1
 */
@RestController
@RequestMapping("/s1/sms")
public class BaseSmsController {

    @Autowired
    private BaseSmsService baseSmsService;

    /**
     * 获取短信验证码
     *
     * @param query
     * @return
     */
    @RequestMapping(value = "/sendSms", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ApiResponse sendSms(@Validated({Phone.class, Type.class}) SmsQuery query)  {
        if (!MobileUtils.isMobileNo(query.getPhone())) {
            return new ApiResponse(ResponseCode._100034);
        }

        return baseSmsService.sendSmsCode(query);
    }

    /**
     * 校验短信验证码
     *
     * @param query
     * @param remoteIp
     * @return
     */
    @RequestMapping(value = "/checkCode", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ApiResponse checkCode(@Validated({Phone.class, Type.class, Code.class}) SmsQuery query, @RequestAttribute(name = "remoteIp") String remoteIp) {
        if (!MobileUtils.isMobileNo(query.getPhone())) {
            return new ApiResponse(ResponseCode._100034);
        }
        // 设置远程Ip
        query.setRemoteIp(remoteIp);

        return baseSmsService.checkCode(query);
    }
}
