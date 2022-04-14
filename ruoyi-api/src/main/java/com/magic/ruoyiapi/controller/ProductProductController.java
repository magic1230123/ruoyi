package com.magic.ruoyiapi.controller;


import com.magic.ruoyiapi.domain.ProductQuery;
import com.magic.ruoyiapi.domain.dto.ApiResponse;
import com.magic.ruoyiapi.service.product.ProductProductService;
import com.magic.ruoyiapi.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/s3/product")
public class ProductProductController {

    @Autowired
    private ProductProductService productProductService;

    /**
     * 获取分组产品
     *
     * @return
     */
    @RequestMapping(value = "/group/redirect", produces = {"application/json;charset=UTF-8"})
    public ApiResponse groupRedirect(ProductQuery query) {
        ApiResponse apiResponse = productProductService.getProductInGroup(query);
        return apiResponse;
    }


    /**
     * 统计请求次数
     * @param productId
     * @param phone
     * @return
     */
    @RequestMapping(value = "/statistics", produces = {"application/json;charset=UTF-8"})
    public ApiResponse statistics(@RequestParam String productId, @RequestParam String phone, HttpServletRequest request) {
        String requestIp = HttpUtils.getIPAddress(request);
        return productProductService.statistics(productId, phone, requestIp);
    }
}
