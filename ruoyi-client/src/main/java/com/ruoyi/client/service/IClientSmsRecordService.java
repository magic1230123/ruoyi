package com.ruoyi.client.service;

import java.util.List;
import com.ruoyi.client.domain.ClientSmsRecord;

/**
 * 短信记录Service接口
 * 
 * @author magic
 * @date 2022-04-13
 */
public interface IClientSmsRecordService 
{
    /**
     * 查询短信记录
     * 
     * @param id 短信记录主键
     * @return 短信记录
     */
    public ClientSmsRecord selectClientSmsRecordById(Long id);

    /**
     * 查询短信记录列表
     * 
     * @param clientSmsRecord 短信记录
     * @return 短信记录集合
     */
    public List<ClientSmsRecord> selectClientSmsRecordList(ClientSmsRecord clientSmsRecord);

    /**
     * 新增短信记录
     * 
     * @param clientSmsRecord 短信记录
     * @return 结果
     */
    public int insertClientSmsRecord(ClientSmsRecord clientSmsRecord);

    /**
     * 修改短信记录
     * 
     * @param clientSmsRecord 短信记录
     * @return 结果
     */
    public int updateClientSmsRecord(ClientSmsRecord clientSmsRecord);

    /**
     * 批量删除短信记录
     * 
     * @param ids 需要删除的短信记录主键集合
     * @return 结果
     */
    public int deleteClientSmsRecordByIds(Long[] ids);

    /**
     * 删除短信记录信息
     * 
     * @param id 短信记录主键
     * @return 结果
     */
    public int deleteClientSmsRecordById(Long id);
}
