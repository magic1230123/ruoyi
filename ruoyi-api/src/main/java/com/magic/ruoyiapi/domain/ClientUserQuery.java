package com.magic.ruoyiapi.domain;


import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author 林锋
 * @email 904303298@qq.com
 * @create 2018-09-21 17:11
 **/
@Data
public class ClientUserQuery extends BaseAppModel {

    /**
     * 验证码
     */
    private String code;

    /***
     * 用户昵称
     */
    private String userName;

    /**渠道**/
    private Integer channel;
}
