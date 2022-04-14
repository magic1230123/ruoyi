package com.ruoyi.client.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 配置对象 client_config
 *
 * @author magic
 * @date 2022-04-14
 */
@Data
public class ClientConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID自增 */
    private Long id;

    /** KEY */
    @Excel(name = "KEY")
    private String key;

    /** VALUE */
    @Excel(name = "VALUE")
    private String value;


    /** VALUE */
    @Excel(name = "备注")
    private String remark;
    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setKey(String key)
    {
        this.key = key;
    }

    public String getKey()
    {
        return key;
    }
    public void setValue(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("key", getKey())
            .append("value", getValue())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
