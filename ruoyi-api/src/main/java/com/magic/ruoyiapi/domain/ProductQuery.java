package com.magic.ruoyiapi.domain;

import lombok.Data;

/**
 * @author 林锋
 * @email 904303298@qq.com
 * @create 2018-09-21 23:14
 **/
@Data
public class ProductQuery extends BaseAppModel {

    /**产品分组**/
    private Integer groupId;

    /**产品Id**/
    private Integer productId;

    /**产品地址url**/
    private String url;

    /**转换方式**/
    private String mode;

    /**待解码地址**/
    private String m;

    /**产品码**/
    private String productCode;

    /**渠道**/
    private Integer channelId;
}
