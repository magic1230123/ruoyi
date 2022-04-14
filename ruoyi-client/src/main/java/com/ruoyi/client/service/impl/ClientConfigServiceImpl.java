package com.ruoyi.client.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.client.mapper.ClientConfigMapper;
import com.ruoyi.client.domain.ClientConfig;
import com.ruoyi.client.service.IClientConfigService;

/**
 * 配置Service业务层处理
 * 
 * @author magic
 * @date 2022-04-14
 */
@Service
public class ClientConfigServiceImpl implements IClientConfigService 
{
    @Autowired
    private ClientConfigMapper clientConfigMapper;

    /**
     * 查询配置
     * 
     * @param id 配置主键
     * @return 配置
     */
    @Override
    public ClientConfig selectClientConfigById(Long id)
    {
        return clientConfigMapper.selectClientConfigById(id);
    }

    /**
     * 查询配置列表
     * 
     * @param clientConfig 配置
     * @return 配置
     */
    @Override
    public List<ClientConfig> selectClientConfigList(ClientConfig clientConfig)
    {
        return clientConfigMapper.selectClientConfigList(clientConfig);
    }

    /**
     * 新增配置
     * 
     * @param clientConfig 配置
     * @return 结果
     */
    @Override
    public int insertClientConfig(ClientConfig clientConfig)
    {
        clientConfig.setCreateTime(DateUtils.getNowDate());
        return clientConfigMapper.insertClientConfig(clientConfig);
    }

    /**
     * 修改配置
     * 
     * @param clientConfig 配置
     * @return 结果
     */
    @Override
    public int updateClientConfig(ClientConfig clientConfig)
    {
        clientConfig.setUpdateTime(DateUtils.getNowDate());
        return clientConfigMapper.updateClientConfig(clientConfig);
    }

    /**
     * 批量删除配置
     * 
     * @param ids 需要删除的配置主键
     * @return 结果
     */
    @Override
    public int deleteClientConfigByIds(Long[] ids)
    {
        return clientConfigMapper.deleteClientConfigByIds(ids);
    }

    /**
     * 删除配置信息
     * 
     * @param id 配置主键
     * @return 结果
     */
    @Override
    public int deleteClientConfigById(Long id)
    {
        return clientConfigMapper.deleteClientConfigById(id);
    }
}
