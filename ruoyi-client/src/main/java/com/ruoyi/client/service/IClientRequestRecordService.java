package com.ruoyi.client.service;

import java.util.List;
import com.ruoyi.client.domain.ClientRequestRecord;

/**
 * 请求记录
Service接口
 *
 * @author magic
 * @date 2022-04-13
 */
public interface IClientRequestRecordService
{
    /**
     * 查询请求记录

     *
     * @param id 请求记录主键
     * @return 请求记录

     */
    public ClientRequestRecord selectClientRequestRecordById(Long id);

    /**
     * 查询请求记录列表
     *
     * @param clientRequestRecord 请求记录

     * @return 请求记录集合
     */
    public List<ClientRequestRecord> selectClientRequestRecordList(ClientRequestRecord clientRequestRecord);

    /**
     * 新增请求记录

     *
     * @param clientRequestRecord 请求记录

     * @return 结果
     */
    public int insertClientRequestRecord(ClientRequestRecord clientRequestRecord);

    /**
     * 修改请求记录

     *
     * @param clientRequestRecord 请求记录

     * @return 结果
     */
    public int updateClientRequestRecord(ClientRequestRecord clientRequestRecord);

    /**
     * 批量删除请求记录

     *
     * @param ids 需要删除的请求记录主键集合
     * @return 结果
     */
    public int deleteClientRequestRecordByIds(Long[] ids);

    /**
     * 删除请求记录信息
     *
     * @param id 请求记录主键
     * @return 结果
     */
    public int deleteClientRequestRecordById(Long id);
}
