package com.ruoyi.client.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 经营报表对象 client_business
 * 
 * @author magic
 * @date 2022-04-21
 */
public class ClientBusiness extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键自增 */
    private Long id;

    /** 日期 */
    @Excel(name = "日期")
    private String date;

    /** 登录数 */
    @Excel(name = "登录数")
    private Long loginNum;

    /** 总uv */
    @Excel(name = "总uv")
    private Long allUv;

    /** 余量uv */
    @Excel(name = "余量uv")
    private Long yuUv;

    /** 当天uv */
    @Excel(name = "当天uv")
    private Long todayUv;

    /** uv成本 */
    @Excel(name = "uv成本")
    private Long uvChengben;

    /** 登录产出比 */
    @Excel(name = "登录产出比")
    private BigDecimal loginChanchu;

    /** 支出 */
    @Excel(name = "支出")
    private BigDecimal zhichu;

    /** 收入 */
    @Excel(name = "收入")
    private BigDecimal shouru;

    /** 利润 */
    @Excel(name = "利润")
    private BigDecimal lirun;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDate(String date) 
    {
        this.date = date;
    }

    public String getDate() 
    {
        return date;
    }
    public void setLoginNum(Long loginNum) 
    {
        this.loginNum = loginNum;
    }

    public Long getLoginNum() 
    {
        return loginNum;
    }
    public void setAllUv(Long allUv) 
    {
        this.allUv = allUv;
    }

    public Long getAllUv() 
    {
        return allUv;
    }
    public void setYuUv(Long yuUv) 
    {
        this.yuUv = yuUv;
    }

    public Long getYuUv() 
    {
        return yuUv;
    }
    public void setTodayUv(Long todayUv) 
    {
        this.todayUv = todayUv;
    }

    public Long getTodayUv() 
    {
        return todayUv;
    }
    public void setUvChengben(Long uvChengben) 
    {
        this.uvChengben = uvChengben;
    }

    public Long getUvChengben() 
    {
        return uvChengben;
    }
    public void setLoginChanchu(BigDecimal loginChanchu) 
    {
        this.loginChanchu = loginChanchu;
    }

    public BigDecimal getLoginChanchu() 
    {
        return loginChanchu;
    }
    public void setZhichu(BigDecimal zhichu) 
    {
        this.zhichu = zhichu;
    }

    public BigDecimal getZhichu() 
    {
        return zhichu;
    }
    public void setShouru(BigDecimal shouru) 
    {
        this.shouru = shouru;
    }

    public BigDecimal getShouru() 
    {
        return shouru;
    }
    public void setLirun(BigDecimal lirun) 
    {
        this.lirun = lirun;
    }

    public BigDecimal getLirun() 
    {
        return lirun;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("date", getDate())
            .append("loginNum", getLoginNum())
            .append("allUv", getAllUv())
            .append("yuUv", getYuUv())
            .append("todayUv", getTodayUv())
            .append("uvChengben", getUvChengben())
            .append("loginChanchu", getLoginChanchu())
            .append("zhichu", getZhichu())
            .append("shouru", getShouru())
            .append("lirun", getLirun())
            .toString();
    }
}
