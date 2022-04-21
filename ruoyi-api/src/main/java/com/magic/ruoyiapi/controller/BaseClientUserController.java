package com.magic.ruoyiapi.controller;

import com.magic.ruoyiapi.domain.ClientUserQuery;
import com.magic.ruoyiapi.domain.dto.ApiResponse;
import com.magic.ruoyiapi.domain.dto.ResponseCode;
import com.magic.ruoyiapi.service.BaseClientUserService;
import com.magic.ruoyiapi.utils.HttpUtils;
import com.magic.ruoyiapi.utils.MobileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 客户管理
 * @author magic
 */
@RestController
@RequestMapping("/s1/clientUser")
public class BaseClientUserController{

    @Autowired(required = false)
    private BaseClientUserService baseClientUserService;

    /**
     * App验证码登陆
     */
    @RequestMapping(value = "/smsLogin/app", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ApiResponse smsLogin(ClientUserQuery query, HttpServletRequest request) {
        if (!MobileUtils.isMobileNo(query.getPhone())) {
            return new ApiResponse(ResponseCode._100034);
        }
        String ip = HttpUtils.getIPAddress(request);
        query.setRemoteIp(ip);
        return baseClientUserService.smsLogin(query);
    }
}
