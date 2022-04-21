package com.ruoyi.client.domain.vo;

import lombok.Data;

/**
 * @Author magic
 * @create 2022/4/15 1:48 PM
 */
@Data
public class ProductData {
    private Long productId;
    private String productName;
    private Integer uv;
    private Integer requestNum;
}
