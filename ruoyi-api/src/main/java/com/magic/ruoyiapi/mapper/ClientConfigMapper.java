package com.magic.ruoyiapi.mapper;

import com.magic.ruoyiapi.entity.ClientConfig;

import java.util.List;


/**
 * 配置Mapper接口
 *
 * @author magic
 * @date 2022-04-14
 */
public interface ClientConfigMapper
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
     * 删除配置
     *
     * @param id 配置主键
     * @return 结果
     */
    public int deleteClientConfigById(Long id);

    /**
     * 批量删除配置
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClientConfigByIds(Long[] ids);

    /**
     * 根据key获取value
     * @param key
     * @return
     */
    String getValue(String key);
}
