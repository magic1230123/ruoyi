package com.magic.ruoyiapi.controller;


import com.magic.ruoyiapi.contants.RedisKeyConstants;
import com.magic.ruoyiapi.domain.dto.ApiResponse;
import com.magic.ruoyiapi.mapper.ClientConfigMapper;
import com.magic.ruoyiapi.mapper.ClientUserMapper;
import com.magic.ruoyiapi.redis.RedisClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author 1
 */
@RestController
@RequestMapping("/system")
public class SystemConfController {

    @Resource
    private ClientConfigMapper clientConfigMapper;
    /**
     * 系统配置
     */
    @RequestMapping(value = "/config", produces = {"application/json;charset=UTF-8"})
    public ApiResponse config() {
        HashMap<String, String> hash = new HashMap<>(1);
        hash.put("isCode",clientConfigMapper.getValue("IS_SMS_CODE"));
        hash.put("version",clientConfigMapper.getValue("VERSION"));
        return new ApiResponse(hash);
    }

}
