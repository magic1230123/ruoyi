package com.magic.ruoyiapi.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @author 林锋
 * @email 904303298@qq.com
 * @create 2018-09-21 13:54
 **/
@Data
public class SmsQuery extends BaseAppModel {

    /**
     * 短信类型 0-通用 1-注册 2-登陆
     */
    @NotNull(message = "100037:请输入短信类型", groups = {Type.class})
    private Integer type;

    /**
     * 验证码
     */
    @NotEmpty(message = "100037:请输入验证码", groups = {Code.class})
    private String code;



    /**
     * 渠道
     */
    private String packageName;
}
