package com.ruoyi.client.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.client.mapper.ClientLoginRecordMapper;
import com.ruoyi.client.domain.ClientLoginRecord;
import com.ruoyi.client.service.IClientLoginRecordService;

/**
 * 登录记录Service业务层处理
 * 
 * @author magic
 * @date 2022-04-13
 */
@Service
public class ClientLoginRecordServiceImpl implements IClientLoginRecordService 
{
    @Autowired
    private ClientLoginRecordMapper clientLoginRecordMapper;

    /**
     * 查询登录记录
     * 
     * @param id 登录记录主键
     * @return 登录记录
     */
    @Override
    public ClientLoginRecord selectClientLoginRecordById(Long id)
    {
        return clientLoginRecordMapper.selectClientLoginRecordById(id);
    }

    /**
     * 查询登录记录列表
     * 
     * @param clientLoginRecord 登录记录
     * @return 登录记录
     */
    @Override
    public List<ClientLoginRecord> selectClientLoginRecordList(ClientLoginRecord clientLoginRecord)
    {
        return clientLoginRecordMapper.selectClientLoginRecordList(clientLoginRecord);
    }

    /**
     * 新增登录记录
     * 
     * @param clientLoginRecord 登录记录
     * @return 结果
     */
    @Override
    public int insertClientLoginRecord(ClientLoginRecord clientLoginRecord)
    {
        return clientLoginRecordMapper.insertClientLoginRecord(clientLoginRecord);
    }

    /**
     * 修改登录记录
     * 
     * @param clientLoginRecord 登录记录
     * @return 结果
     */
    @Override
    public int updateClientLoginRecord(ClientLoginRecord clientLoginRecord)
    {
        return clientLoginRecordMapper.updateClientLoginRecord(clientLoginRecord);
    }

    /**
     * 批量删除登录记录
     * 
     * @param ids 需要删除的登录记录主键
     * @return 结果
     */
    @Override
    public int deleteClientLoginRecordByIds(Long[] ids)
    {
        return clientLoginRecordMapper.deleteClientLoginRecordByIds(ids);
    }

    /**
     * 删除登录记录信息
     * 
     * @param id 登录记录主键
     * @return 结果
     */
    @Override
    public int deleteClientLoginRecordById(Long id)
    {
        return clientLoginRecordMapper.deleteClientLoginRecordById(id);
    }
}
