package com.ruoyi.client.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户对象 client_user
 *
 * @author magic
 * @date 2022-04-13
 */
public class ClientUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 状态   1正常；0封号；2申请注销 */
    @Excel(name = "状态   1正常；0封号；2申请注销")
    private Integer state;

    /** 移动设备 */
    @Excel(name = "移动设备")
    private String device;

    /** IP */
    @Excel(name = "IP")
    private String ip;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setState(Integer state)
    {
        this.state = state;
    }

    public Integer getState()
    {
        return state;
    }
    public void setDevice(String device)
    {
        this.device = device;
    }

    public String getDevice()
    {
        return device;
    }
    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getIp()
    {
        return ip;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("phone", getPhone())
            .append("state", getState())
            .append("device", getDevice())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("ip", getIp())
            .toString();
    }
}
