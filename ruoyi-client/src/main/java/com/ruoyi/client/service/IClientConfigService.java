package com.ruoyi.client.service;

import java.util.List;
import com.ruoyi.client.domain.ClientConfig;
import com.ruoyi.client.domain.vo.DataStatistics;

/**
 * 配置Service接口
 *
 * @author magic
 * @date 2022-04-14
 */
public interface IClientConfigService
{
    /**
     * 查询配置
     *
     * @param id 配置主键
     * @return 配置
     */
    public ClientConfig selectClientConfigById(Long id);

    /**
     * 查询配置列表
     *
     * @param clientConfig 配置
     * @return 配置集合
     */
    public List<ClientConfig> selectClientConfigList(ClientConfig clientConfig);

    /**
     * 新增配置
     *
     * @param clientConfig 配置
     * @return 结果
     */
    public int insertClientConfig(ClientConfig clientConfig);

    /**
     * 修改配置
     *
     * @param clientConfig 配置
     * @return 结果
     */
    public int updateClientConfig(ClientConfig clientConfig);

    /**
     * 批量删除配置
     *
     * @param ids 需要删除的配置主键集合
     * @return 结果
     */
    public int deleteClientConfigByIds(Long[] ids);

    /**
     * 删除配置信息
     *
     * @param id 配置主键
     * @return 结果
     */
    public int deleteClientConfigById(Long id);

    DataStatistics dataStatistics();

}
