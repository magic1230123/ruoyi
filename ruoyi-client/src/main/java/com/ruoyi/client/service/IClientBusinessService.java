package com.ruoyi.client.service;

import java.util.List;
import com.ruoyi.client.domain.ClientBusiness;

/**
 * 经营报表Service接口
 * 
 * @author magic
 * @date 2022-04-21
 */
public interface IClientBusinessService 
{
    /**
     * 查询经营报表
     * 
     * @param id 经营报表主键
     * @return 经营报表
     */
    public ClientBusiness selectClientBusinessById(Long id);

    /**
     * 查询经营报表列表
     * 
     * @param clientBusiness 经营报表
     * @return 经营报表集合
     */
    public List<ClientBusiness> selectClientBusinessList(ClientBusiness clientBusiness);

    /**
     * 新增经营报表
     * 
     * @param clientBusiness 经营报表
     * @return 结果
     */
    public int insertClientBusiness(ClientBusiness clientBusiness);

    /**
     * 修改经营报表
     * 
     * @param clientBusiness 经营报表
     * @return 结果
     */
    public int updateClientBusiness(ClientBusiness clientBusiness);

    /**
     * 批量删除经营报表
     * 
     * @param ids 需要删除的经营报表主键集合
     * @return 结果
     */
    public int deleteClientBusinessByIds(Long[] ids);

    /**
     * 删除经营报表信息
     * 
     * @param id 经营报表主键
     * @return 结果
     */
    public int deleteClientBusinessById(Long id);
}
