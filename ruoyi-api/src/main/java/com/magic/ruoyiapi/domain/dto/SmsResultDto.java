package com.magic.ruoyiapi.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * ${DESCRIPTION}
 *
 * @author linfeng
 * @email 904303298@qq.com
 * @date 2018-12-17 14:00
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class SmsResultDto {

    /**手机号码**/
    private String phone;

    /** 新注册标记 0-否，1-是*/
    private Integer register = 0;
}
