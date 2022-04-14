package com.magic.ruoyiapi.mapper;


import com.magic.ruoyiapi.domain.ProductQuery;
import com.magic.ruoyiapi.entity.ClientProduct;
import com.magic.ruoyiapi.entity.ClientUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 根据手机号查询用户
     * @param phone
     * @return
     */
    ClientUser getUserByPhone(@Param("phone") String phone);


    /**
     * 保存登录记录
     * @param phone
     * @param ip
     * @param deviceId
     * @return
     */
    int insertLoginRecord(@Param("phone") String phone,@Param("ip") String ip,@Param("deviceId") String deviceId);

    /**
     * 获取产品记录
     * @param query
     * @return
     */
    List<ClientProduct> getProductList(ProductQuery query);

    /**
     * 插入请求记录
     * @return
     */
    int insertRequestRecord(@Param("productId") String productId,@Param("userId") String userId,@Param("phone") String phone,@Param("ip") String ip);

    /**
     * 插入发送短信记录
     * @return
     */
    int insertSendSmsRecord(@Param("phone") String phone,@Param("code") String code);

    /**
     * 增量添加请求记录
     * @param productId
     * @param id
     * @return
     */
    int updateRequestRecord(@Param("productId") String productId, @Param("id") Long id);
}
