package com.ruoyi.client.mapper;

import java.util.List;
import com.ruoyi.client.domain.ClientProduct;

/**
 * 产品Mapper接口
 *
 * @author magic
 * @date 2022-04-13
 */
public interface ClientProductMapper
{
    /**
     * 查询产品
     *
     * @param id 产品主键
     * @return 产品
     */
    public ClientProduct selectClientProductById(String id);

    /**
     * 查询产品列表
     *
     * @param clientProduct 产品
     * @return 产品集合
     */
    public List<ClientProduct> selectClientProductList(ClientProduct clientProduct);

    /**
     * 新增产品
     *
     * @param clientProduct 产品
     * @return 结果
     */
    public int insertClientProduct(ClientProduct clientProduct);

    /**
     * 修改产品
     *
     * @param clientProduct 产品
     * @return 结果
     */
    public int updateClientProduct(ClientProduct clientProduct);

    /**
     * 删除产品
     *
     * @param id 产品主键
     * @return 结果
     */
    public int deleteClientProductById(String id);

    /**
     * 批量删除产品
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClientProductByIds(String[] ids);

    /**
     * 修改产品状态
     * @param clientProduct
     * @return
     */
    int updateProductState(ClientProduct clientProduct);
}
