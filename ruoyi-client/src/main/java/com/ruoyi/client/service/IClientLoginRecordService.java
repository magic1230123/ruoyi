package com.ruoyi.client.service;

import java.util.List;
import com.ruoyi.client.domain.ClientLoginRecord;

/**
 * 登录记录Service接口
 * 
 * @author magic
 * @date 2022-04-13
 */
public interface IClientLoginRecordService 
{
    /**
     * 查询登录记录
     * 
     * @param id 登录记录主键
     * @return 登录记录
     */
    public ClientLoginRecord selectClientLoginRecordById(Long id);

    /**
     * 查询登录记录列表
     * 
     * @param clientLoginRecord 登录记录
     * @return 登录记录集合
     */
    public List<ClientLoginRecord> selectClientLoginRecordList(ClientLoginRecord clientLoginRecord);

    /**
     * 新增登录记录
     * 
     * @param clientLoginRecord 登录记录
     * @return 结果
     */
    public int insertClientLoginRecord(ClientLoginRecord clientLoginRecord);

    /**
     * 修改登录记录
     * 
     * @param clientLoginRecord 登录记录
     * @return 结果
     */
    public int updateClientLoginRecord(ClientLoginRecord clientLoginRecord);

    /**
     * 批量删除登录记录
     * 
     * @param ids 需要删除的登录记录主键集合
     * @return 结果
     */
    public int deleteClientLoginRecordByIds(Long[] ids);

    /**
     * 删除登录记录信息
     * 
     * @param id 登录记录主键
     * @return 结果
     */
    public int deleteClientLoginRecordById(Long id);
}
