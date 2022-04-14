package com.magic.ruoyiapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 产品对象 client_product
 *
 * @author magic
 * @date 2022-04-13
 */
@Data
public class ClientProduct
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** 产品名称 */
    private String productName;

    /** 产品类型 1小额 2大额 */
    private Integer amountType;

    /** 状态  1：上架，2：下架，3：删除 */
    private Integer state;

    /** 排序 */
    private Long sort;

    /** 最低额度 */
    private Long minAmount;

    /** 最高额度 */
    private Long maxAmount;

    /** 日利息 */
    private String rate;

    /** 是否首页推荐 0否1是 */
    private Integer isRecommend;

    /** 产品描述 */
    private String des;

    /** 产品LOGO */
    private String productLogo;

    /** 第三方url */
    private String productUrl;

    /** 产品标签 */
    private String productTag;

    /** 上架时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date upTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getProductName()
    {
        return productName;
    }
    public void setAmountType(Integer amountType)
    {
        this.amountType = amountType;
    }

    public Integer getAmountType()
    {
        return amountType;
    }
    public void setState(Integer state)
    {
        this.state = state;
    }

    public Integer getState()
    {
        return state;
    }
    public void setSort(Long sort)
    {
        this.sort = sort;
    }

    public Long getSort()
    {
        return sort;
    }
    public void setMinAmount(Long minAmount)
    {
        this.minAmount = minAmount;
    }

    public Long getMinAmount()
    {
        return minAmount;
    }
    public void setMaxAmount(Long maxAmount)
    {
        this.maxAmount = maxAmount;
    }

    public Long getMaxAmount()
    {
        return maxAmount;
    }
    public void setRate(String rate)
    {
        this.rate = rate;
    }

    public String getRate()
    {
        return rate;
    }
    public void setIsRecommend(Integer isRecommend)
    {
        this.isRecommend = isRecommend;
    }

    public Integer getIsRecommend()
    {
        return isRecommend;
    }
    public void setDes(String des)
    {
        this.des = des;
    }

    public String getDes()
    {
        return des;
    }
    public void setProductLogo(String productLogo)
    {
        this.productLogo = productLogo;
    }

    public String getProductLogo()
    {
        return productLogo;
    }
    public void setProductUrl(String productUrl)
    {
        this.productUrl = productUrl;
    }

    public String getProductUrl()
    {
        return productUrl;
    }
    public void setProductTag(String productTag)
    {
        this.productTag = productTag;
    }

    public String getProductTag()
    {
        return productTag;
    }
    public void setUpTime(Date upTime)
    {
        this.upTime = upTime;
    }

    public Date getUpTime()
    {
        return upTime;
    }

}
