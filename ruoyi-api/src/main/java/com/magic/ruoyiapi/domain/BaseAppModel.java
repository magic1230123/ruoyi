package com.magic.ruoyiapi.domain;


import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * 客户端请求参数
 *
 * @author 林锋
 * @email 904303298@qq.com
 * @create 2018-05-09 15:07
 **/
@Data
public class BaseAppModel extends BaseModel {


    /**
     * 手机号码
     */
    @NotEmpty(message = "100033:请输入手机号", groups = {Phone.class})
    private String phone;

    /**
     * 设备Id
     **/
    @NotEmpty(message = "100010:设备标识为空", groups = {Common.class})
    private String deviceId;

    /**
     * 远程Ip
     */
    private String remoteIp;




}
