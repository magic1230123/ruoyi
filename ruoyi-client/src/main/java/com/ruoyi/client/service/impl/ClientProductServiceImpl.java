package com.ruoyi.client.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.client.mapper.ClientProductMapper;
import com.ruoyi.client.domain.ClientProduct;
import com.ruoyi.client.service.IClientProductService;

/**
 * 产品Service业务层处理
 *
 * @author magic
 * @date 2022-04-13
 */
@Service
public class ClientProductServiceImpl implements IClientProductService
{
    @Autowired
    private ClientProductMapper clientProductMapper;

    /**
     * 查询产品
     *
     * @param id 产品主键
     * @return 产品
     */
    @Override
    public ClientProduct selectClientProductById(String id)
    {
        return clientProductMapper.selectClientProductById(id);
    }

    /**
     * 查询产品列表
     *
     * @param clientProduct 产品
     * @return 产品
     */
    @Override
    public List<ClientProduct> selectClientProductList(ClientProduct clientProduct)
    {
        return clientProductMapper.selectClientProductList(clientProduct);
    }

    /**
     * 新增产品
     *
     * @param clientProduct 产品
     * @return 结果
     */
    @Override
    public int insertClientProduct(ClientProduct clientProduct)
    {
        clientProduct.setCreateTime(DateUtils.getNowDate());
        return clientProductMapper.insertClientProduct(clientProduct);
    }

    /**
     * 修改产品
     *
     * @param clientProduct 产品
     * @return 结果
     */
    @Override
    public int updateClientProduct(ClientProduct clientProduct)
    {
        clientProduct.setUpdateTime(DateUtils.getNowDate());
        return clientProductMapper.updateClientProduct(clientProduct);
    }

    /**
     * 批量删除产品
     *
     * @param ids 需要删除的产品主键
     * @return 结果
     */
    @Override
    public int deleteClientProductByIds(String[] ids)
    {
        return clientProductMapper.deleteClientProductByIds(ids);
    }

    /**
     * 删除产品信息
     *
     * @param id 产品主键
     * @return 结果
     */
    @Override
    public int deleteClientProductById(String id)
    {
        return clientProductMapper.deleteClientProductById(id);
    }

    @Override
    public int updateProductState(ClientProduct clientProduct) {
        return clientProductMapper.updateProductState(clientProduct);
    }
}
