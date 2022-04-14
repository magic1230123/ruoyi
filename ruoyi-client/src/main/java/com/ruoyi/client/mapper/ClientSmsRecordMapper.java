package com.ruoyi.client.mapper;

import java.util.List;
import com.ruoyi.client.domain.ClientSmsRecord;

/**
 * 短信记录Mapper接口
 * 
 * @author magic
 * @date 2022-04-13
 */
public interface ClientSmsRecordMapper 
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
     * 删除短信记录
     * 
     * @param id 短信记录主键
     * @return 结果
     */
    public int deleteClientSmsRecordById(Long id);

    /**
     * 批量删除短信记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClientSmsRecordByIds(Long[] ids);
}
