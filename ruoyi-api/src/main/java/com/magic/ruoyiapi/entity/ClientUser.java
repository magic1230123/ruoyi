package com.magic.ruoyiapi.entity;


import lombok.Data;

/**
 * 用户对象 client_user
 *
 * @author magic
 * @date 2022-04-13
 */
@Data
public class ClientUser
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 手机号 */
    private String phone;

    /** 状态   1正常；0封号；2申请注销 */
    private Integer state;

    /** 移动设备 */
    private String device;

    /** IP */
    private String ip;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改时间
     */
    private String updateTime;

}
