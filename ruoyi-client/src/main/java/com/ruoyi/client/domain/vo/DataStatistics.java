package com.ruoyi.client.domain.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class DataStatistics {


    //今日注册
    private Integer todayRegisterNum;
    //总注册
    private Integer allRegisterNum;
    //今日登录
    private Integer todayLoginNum;
    //今日各产品Uv和点击
    private List<ProductData> todayUv;
    //总计各产品Uv和点击
    private List<ProductData> allUv;

}
