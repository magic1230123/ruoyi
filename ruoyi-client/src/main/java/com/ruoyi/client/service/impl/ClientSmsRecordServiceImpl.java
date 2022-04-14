package com.ruoyi.client.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.client.mapper.ClientSmsRecordMapper;
import com.ruoyi.client.domain.ClientSmsRecord;
import com.ruoyi.client.service.IClientSmsRecordService;

/**
 * 短信记录Service业务层处理
 * 
 * @author magic
 * @date 2022-04-13
 */
@Service
public class ClientSmsRecordServiceImpl implements IClientSmsRecordService 
{
    @Autowired
    private ClientSmsRecordMapper clientSmsRecordMapper;

    /**
     * 查询短信记录
     * 
     * @param id 短信记录主键
     * @return 短信记录
     */
    @Override
    public ClientSmsRecord selectClientSmsRecordById(Long id)
    {
        return clientSmsRecordMapper.selectClientSmsRecordById(id);
    }

    /**
     * 查询短信记录列表
     * 
     * @param clientSmsRecord 短信记录
     * @return 短信记录
     */
    @Override
    public List<ClientSmsRecord> selectClientSmsRecordList(ClientSmsRecord clientSmsRecord)
    {
        return clientSmsRecordMapper.selectClientSmsRecordList(clientSmsRecord);
    }

    /**
     * 新增短信记录
     * 
     * @param clientSmsRecord 短信记录
     * @return 结果
     */
    @Override
    public int insertClientSmsRecord(ClientSmsRecord clientSmsRecord)
    {
        return clientSmsRecordMapper.insertClientSmsRecord(clientSmsRecord);
    }

    /**
     * 修改短信记录
     * 
     * @param clientSmsRecord 短信记录
     * @return 结果
     */
    @Override
    public int updateClientSmsRecord(ClientSmsRecord clientSmsRecord)
    {
        return clientSmsRecordMapper.updateClientSmsRecord(clientSmsRecord);
    }

    /**
     * 批量删除短信记录
     * 
     * @param ids 需要删除的短信记录主键
     * @return 结果
     */
    @Override
    public int deleteClientSmsRecordByIds(Long[] ids)
    {
        return clientSmsRecordMapper.deleteClientSmsRecordByIds(ids);
    }

    /**
     * 删除短信记录信息
     * 
     * @param id 短信记录主键
     * @return 结果
     */
    @Override
    public int deleteClientSmsRecordById(Long id)
    {
        return clientSmsRecordMapper.deleteClientSmsRecordById(id);
    }
}
