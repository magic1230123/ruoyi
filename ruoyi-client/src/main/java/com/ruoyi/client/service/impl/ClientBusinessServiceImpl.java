package com.ruoyi.client.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.client.mapper.ClientBusinessMapper;
import com.ruoyi.client.domain.ClientBusiness;
import com.ruoyi.client.service.IClientBusinessService;

/**
 * 经营报表Service业务层处理
 * 
 * @author magic
 * @date 2022-04-21
 */
@Service
public class ClientBusinessServiceImpl implements IClientBusinessService 
{
    @Autowired
    private ClientBusinessMapper clientBusinessMapper;

    /**
     * 查询经营报表
     * 
     * @param id 经营报表主键
     * @return 经营报表
     */
    @Override
    public ClientBusiness selectClientBusinessById(Long id)
    {
        return clientBusinessMapper.selectClientBusinessById(id);
    }

    /**
     * 查询经营报表列表
     * 
     * @param clientBusiness 经营报表
     * @return 经营报表
     */
    @Override
    public List<ClientBusiness> selectClientBusinessList(ClientBusiness clientBusiness)
    {
        return clientBusinessMapper.selectClientBusinessList(clientBusiness);
    }

    /**
     * 新增经营报表
     * 
     * @param clientBusiness 经营报表
     * @return 结果
     */
    @Override
    public int insertClientBusiness(ClientBusiness clientBusiness)
    {
        return clientBusinessMapper.insertClientBusiness(clientBusiness);
    }

    /**
     * 修改经营报表
     * 
     * @param clientBusiness 经营报表
     * @return 结果
     */
    @Override
    public int updateClientBusiness(ClientBusiness clientBusiness)
    {
        return clientBusinessMapper.updateClientBusiness(clientBusiness);
    }

    /**
     * 批量删除经营报表
     * 
     * @param ids 需要删除的经营报表主键
     * @return 结果
     */
    @Override
    public int deleteClientBusinessByIds(Long[] ids)
    {
        return clientBusinessMapper.deleteClientBusinessByIds(ids);
    }

    /**
     * 删除经营报表信息
     * 
     * @param id 经营报表主键
     * @return 结果
     */
    @Override
    public int deleteClientBusinessById(Long id)
    {
        return clientBusinessMapper.deleteClientBusinessById(id);
    }
}
