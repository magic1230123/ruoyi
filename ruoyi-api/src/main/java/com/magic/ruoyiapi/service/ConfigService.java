package com.magic.ruoyiapi.service;

import com.magic.ruoyiapi.mapper.ClientConfigMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @Author magic
 * @create 2022/4/14 11:52 AM
 */
@Service
public class ConfigService {


    @Resource
    ClientConfigMapper clientConfigMapper;

    public String getValue(String key){
        String val = "";
        if (StringUtils.isEmpty(key)){
            return val;
        }
        try {
            val = clientConfigMapper.getValue(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }
}
