package com.magic.ruoyiapi.entity;


import lombok.Data;

/**
 * 配置对象 client_config
 *
 * @author magic
 * @date 2022-04-14
 */
@Data
public class ClientConfig
{
    private static final long serialVersionUID = 1L;

    /** 主键ID自增 */
    private Long id;

    /** KEY */
    private String key;

    /** VALUE */
    private String value;

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

}
