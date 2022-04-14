package com.magic.ruoyiapi.service.impl;


import com.magic.ruoyiapi.contants.SystemConstans;
import com.magic.ruoyiapi.domain.ClientUserQuery;
import com.magic.ruoyiapi.domain.dto.ApiResponse;
import com.magic.ruoyiapi.domain.dto.ResponseCode;
import com.magic.ruoyiapi.entity.ClientUser;
import com.magic.ruoyiapi.mapper.ClientUserMapper;
import com.magic.ruoyiapi.service.BaseClientUserService;
import com.magic.ruoyiapi.service.ConfigService;
import com.magic.ruoyiapi.service.sms.BaseSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 1
 */
@Service
public class BaseClientUserServiceImpl implements BaseClientUserService {

    @Resource
    private ConfigService configService;
    @Resource
    private ClientUserMapper clientUserMapper;
    @Autowired
    private BaseSmsService baseSmsService;

    @Override
    public boolean checkPhone(String phone) {
        ClientUser clientUser = clientUserMapper.getUserByPhone(phone);
        if (null != clientUser) {
            return true;
        }
        return false;
    }


    @Override
    public ApiResponse smsLogin(ClientUserQuery query) {
        if (configService.getValue("IS_SMS_CODE").equals("0")) {
            if (!query.getPhone().equals(configService.getValue("TEST_PHONE"))) {
                // 登陆验证码校验
                if (!baseSmsService.checkSmsCode(SystemConstans.Sms.LOGIN, query.getPhone(), query.getCode())) {
                    return new ApiResponse(ResponseCode._100007);
                }
            }
        }
        // 用户已注册
        if (checkPhone(query.getPhone())) {
            ClientUser user = clientUserMapper.getUserByPhone(query.getPhone());
            // 保存登录记录
            clientUserMapper.insertLoginRecord(user.getPhone(), query.getRemoteIp(), query.getDeviceId());
            return new ApiResponse(user);
        }
        ClientUser user = registerUser(query);
        // 保存登录记录
        clientUserMapper.insertLoginRecord(user.getPhone(), query.getRemoteIp(), query.getDeviceId());
        return new ApiResponse(user);
    }

    private ClientUser registerUser(ClientUserQuery query) {
        ClientUser clientUser = new ClientUser();
        clientUser.setDevice(query.getDeviceId());
        clientUser.setIp(query.getRemoteIp());
        clientUser.setPhone(query.getPhone());
        clientUserMapper.insertClientUser(clientUser);
        return clientUser;
    }


}
