package com.ruoyi.client.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.client.mapper.ClientRequestRecordMapper;
import com.ruoyi.client.domain.ClientRequestRecord;
import com.ruoyi.client.service.IClientRequestRecordService;

/**
 * 请求记录
Service业务层处理
 * 
 * @author magic
 * @date 2022-04-13
 */
@Service
public class ClientRequestRecordServiceImpl implements IClientRequestRecordService 
{
    @Autowired
    private ClientRequestRecordMapper clientRequestRecordMapper;

    /**
     * 查询请求记录

     * 
     * @param id 请求记录
主键
     * @return 请求记录

     */
    @Override
    public ClientRequestRecord selectClientRequestRecordById(Long id)
    {
        return clientRequestRecordMapper.selectClientRequestRecordById(id);
    }

    /**
     * 查询请求记录
列表
     * 
     * @param clientRequestRecord 请求记录

     * @return 请求记录

     */
    @Override
    public List<ClientRequestRecord> selectClientRequestRecordList(ClientRequestRecord clientRequestRecord)
    {
        return clientRequestRecordMapper.selectClientRequestRecordList(clientRequestRecord);
    }

    /**
     * 新增请求记录

     * 
     * @param clientRequestRecord 请求记录

     * @return 结果
     */
    @Override
    public int insertClientRequestRecord(ClientRequestRecord clientRequestRecord)
    {
        clientRequestRecord.setCreateTime(DateUtils.getNowDate());
        return clientRequestRecordMapper.insertClientRequestRecord(clientRequestRecord);
    }

    /**
     * 修改请求记录

     * 
     * @param clientRequestRecord 请求记录

     * @return 结果
     */
    @Override
    public int updateClientRequestRecord(ClientRequestRecord clientRequestRecord)
    {
        return clientRequestRecordMapper.updateClientRequestRecord(clientRequestRecord);
    }

    /**
     * 批量删除请求记录

     * 
     * @param ids 需要删除的请求记录
主键
     * @return 结果
     */
    @Override
    public int deleteClientRequestRecordByIds(Long[] ids)
    {
        return clientRequestRecordMapper.deleteClientRequestRecordByIds(ids);
    }

    /**
     * 删除请求记录
信息
     * 
     * @param id 请求记录
主键
     * @return 结果
     */
    @Override
    public int deleteClientRequestRecordById(Long id)
    {
        return clientRequestRecordMapper.deleteClientRequestRecordById(id);
    }
}
