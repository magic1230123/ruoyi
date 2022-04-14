package com.ruoyi.client.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.client.mapper.ClientUserMapper;
import com.ruoyi.client.domain.ClientUser;
import com.ruoyi.client.service.IClientUserService;

/**
 * 用户Service业务层处理
 * 
 * @author magic
 * @date 2022-04-13
 */
@Service
public class ClientUserServiceImpl implements IClientUserService 
{
    @Autowired
    private ClientUserMapper clientUserMapper;

    /**
     * 查询用户
     * 
     * @param id 用户主键
     * @return 用户
     */
    @Override
    public ClientUser selectClientUserById(Long id)
    {
        return clientUserMapper.selectClientUserById(id);
    }

    /**
     * 查询用户列表
     * 
     * @param clientUser 用户
     * @return 用户
     */
    @Override
    public List<ClientUser> selectClientUserList(ClientUser clientUser)
    {
        return clientUserMapper.selectClientUserList(clientUser);
    }

    /**
     * 新增用户
     * 
     * @param clientUser 用户
     * @return 结果
     */
    @Override
    public int insertClientUser(ClientUser clientUser)
    {
        clientUser.setCreateTime(DateUtils.getNowDate());
        return clientUserMapper.insertClientUser(clientUser);
    }

    /**
     * 修改用户
     * 
     * @param clientUser 用户
     * @return 结果
     */
    @Override
    public int updateClientUser(ClientUser clientUser)
    {
        clientUser.setUpdateTime(DateUtils.getNowDate());
        return clientUserMapper.updateClientUser(clientUser);
    }

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的用户主键
     * @return 结果
     */
    @Override
    public int deleteClientUserByIds(Long[] ids)
    {
        return clientUserMapper.deleteClientUserByIds(ids);
    }

    /**
     * 删除用户信息
     * 
     * @param id 用户主键
     * @return 结果
     */
    @Override
    public int deleteClientUserById(Long id)
    {
        return clientUserMapper.deleteClientUserById(id);
    }
}
