package com.ruoyi.client.mapper;

import java.util.List;
import com.ruoyi.client.domain.ClientUser;

/**
 * 用户Mapper接口
 * 
 * @author magic
 * @date 2022-04-13
 */
public interface ClientUserMapper 
{
    /**
     * 查询用户
     * 
     * @param id 用户主键
     * @return 用户
     */
    public ClientUser selectClientUserById(Long id);

    /**
     * 查询用户列表
     * 
     * @param clientUser 用户
     * @return 用户集合
     */
    public List<ClientUser> selectClientUserList(ClientUser clientUser);

    /**
     * 新增用户
     * 
     * @param clientUser 用户
     * @return 结果
     */
    public int insertClientUser(ClientUser clientUser);

    /**
     * 修改用户
     * 
     * @param clientUser 用户
     * @return 结果
     */
    public int updateClientUser(ClientUser clientUser);

    /**
     * 删除用户
     * 
     * @param id 用户主键
     * @return 结果
     */
    public int deleteClientUserById(Long id);

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClientUserByIds(Long[] ids);
}
