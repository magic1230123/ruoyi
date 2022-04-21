package com.ruoyi.client.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ruoyi.client.mapper.ClientConfigMapper;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.client.mapper.ClientBusinessMapper;
import com.ruoyi.client.domain.ClientBusiness;
import com.ruoyi.client.service.IClientBusinessService;

import javax.annotation.Resource;

/**
 * 经营报表Service业务层处理
 *
 * @author magic
 * @date 2022-04-21
 */
@Service
public class ClientBusinessServiceImpl implements IClientBusinessService
{
    @Autowired
    private ClientBusinessMapper clientBusinessMapper;
    @Resource
    private ClientConfigMapper clientConfigMapper;

    /**
     * 查询经营报表
     *
     * @param id 经营报表主键
     * @return 经营报表
     */
    @Override
    public ClientBusiness selectClientBusinessById(Long id)
    {
        return clientBusinessMapper.selectClientBusinessById(id);
    }

    /**
     * 查询经营报表列表
     *
     * @param clientBusiness 经营报表
     * @return 经营报表
     */
    @Override
    public List<ClientBusiness> selectClientBusinessList(ClientBusiness clientBusiness)
    {
        List<ClientBusiness> returnClientBusinesses = new ArrayList<>();
        ClientBusiness clientBusinessToday = clientBusinessMapper.selectClientBusinessToday();
        clientBusinessToday.setDate(DateUtils.getDate());
        BigDecimal a= BigDecimal.ZERO;
        if (clientBusinessToday.getLoginNum() != 0){
          a = BigDecimal.valueOf(clientBusinessToday.getAllUv()).divide(BigDecimal.valueOf(clientBusinessToday.getLoginNum()));

        }
        clientBusinessToday.setLoginChanchu(a);
        clientBusinessToday.setZhichu(BigDecimal.ZERO);
        Long b = clientBusinessToday.getAllUv()*25;
        clientBusinessToday.setShouru(BigDecimal.valueOf(b));
        clientBusinessToday.setLirun(BigDecimal.valueOf(b));
        returnClientBusinesses.add(clientBusinessToday);
        List<ClientBusiness> returnClient =clientBusinessMapper.selectClientBusinessList(clientBusiness);
        if (null!=returnClient){
            returnClientBusinesses.addAll(returnClient);
        }
        return returnClientBusinesses;
    }

    /**
     * 新增经营报表
     *
     * @param clientBusiness 经营报表
     * @return 结果
     */
    @Override
    public int insertClientBusiness(ClientBusiness clientBusiness)
    {
        return clientBusinessMapper.insertClientBusiness(clientBusiness);
    }

    /**
     * 修改经营报表
     *
     * @param clientBusiness 经营报表
     * @return 结果
     */
    @Override
    public int updateClientBusiness(ClientBusiness clientBusiness)
    {
        return clientBusinessMapper.updateClientBusiness(clientBusiness);
    }

    /**
     * 批量删除经营报表
     *
     * @param ids 需要删除的经营报表主键
     * @return 结果
     */
    @Override
    public int deleteClientBusinessByIds(Long[] ids)
    {
        return clientBusinessMapper.deleteClientBusinessByIds(ids);
    }

    /**
     * 删除经营报表信息
     *
     * @param id 经营报表主键
     * @return 结果
     */
    @Override
    public int deleteClientBusinessById(Long id)
    {
        return clientBusinessMapper.deleteClientBusinessById(id);
    }

    public static void main(String[] args) {
        Long a =Long.valueOf(2)/Long.valueOf(0);
        System.out.println(a);
    }
}
