package com.magic.ruoyiapi.service.product;

import com.magic.ruoyiapi.domain.ProductQuery;
import com.magic.ruoyiapi.domain.dto.ApiResponse;
import com.magic.ruoyiapi.entity.ClientProduct;
import com.magic.ruoyiapi.entity.ClientUser;
import com.magic.ruoyiapi.mapper.ClientUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class ProductProductServiceImpl implements ProductProductService {
    private final static String AND_MARK = "&";

    @Autowired(required = false)
    private ClientUserMapper clientUserMapper;

    @Override
    public ApiResponse getProductInGroup(ProductQuery query) {
        List<ClientProduct> list = clientUserMapper.getProductList(query);
        if (CollectionUtils.isEmpty(list)) {
            return new ApiResponse(new ArrayList<>());
        }
        return new ApiResponse(list);
    }

    @Override
    public ApiResponse statistics(String productId, String phone, String requestIp) {

        ClientUser clientUser =clientUserMapper.getUserByPhone(phone);
        if (clientUser == null){
            return null;
        }
        int result = clientUserMapper.updateRequestRecord(productId,clientUser.getId());
        if (result<=0){
            clientUserMapper.insertRequestRecord(productId,String.valueOf(clientUser.getId()),phone,requestIp);
        }
        return new ApiResponse();
    }


}
