package com.magic.ruoyiapi.service.product;

import com.magic.ruoyiapi.domain.ProductQuery;
import com.magic.ruoyiapi.domain.dto.ApiResponse;

public interface ProductProductService {

    /**
     * 获取分组内的产品
     * @param query
     * @return
     */
    ApiResponse getProductInGroup(ProductQuery query);

    /**
     * 统计请求数据
     * @param productId
     * @param phone
     * @param requestIp
     * @return
     */
    ApiResponse statistics(String productId, String phone, String requestIp);
}
