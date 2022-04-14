package com.ruoyi.client.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 请求记录
对象 client_request_record
 *
 * @author magic
 * @date 2022-04-13
 */
@Data
public class ClientRequestRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id自增 */
    private Long id;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 产品ID */
    @Excel(name = "产品ID")
    private Long productId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 请求IP */
    @Excel(name = "请求IP")
    private String ip;

    /** 请求次数 */
    @Excel(name = "请求次数")
    private Long requestCount;

    private String productName;


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
    public void setProductId(Long productId)
    {
        this.productId = productId;
    }

    public Long getProductId()
    {
        return productId;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getIp()
    {
        return ip;
    }
    public void setRequestCount(Long requestCount)
    {
        this.requestCount = requestCount;
    }

    public Long getRequestCount()
    {
        return requestCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("phone", getPhone())
            .append("productId", getProductId())
            .append("userId", getUserId())
            .append("ip", getIp())
            .append("createTime", getCreateTime())
            .append("requestCount", getRequestCount())
            .toString();
    }
}
