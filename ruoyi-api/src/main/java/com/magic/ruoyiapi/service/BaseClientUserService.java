package com.magic.ruoyiapi.service;


import com.magic.ruoyiapi.domain.ClientUserQuery;
import com.magic.ruoyiapi.domain.dto.ApiResponse;

/**
 * @author 1
 */
public interface BaseClientUserService {

    /**
     * 校验手机号码是否注册
     *
     * @param phone
     * @return
     */
    boolean checkPhone(String phone);

    /**
     * 用户登录
     * @param query
     * @return
     */
    ApiResponse smsLogin(ClientUserQuery query);
}
