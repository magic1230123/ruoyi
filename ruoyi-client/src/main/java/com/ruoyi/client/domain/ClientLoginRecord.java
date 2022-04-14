package com.ruoyi.client.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 登录记录对象 client_login_record
 *
 * @author magic
 * @date 2022-04-13
 */
public class ClientLoginRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID自增 */
    private Long id;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 登录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "登录时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date loginTime;

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
    public void setLoginTime(Date loginTime)
    {
        this.loginTime = loginTime;
    }

    public Date getLoginTime()
    {
        return loginTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("phone", getPhone())
            .append("loginTime", getLoginTime())
            .toString();
    }
}
