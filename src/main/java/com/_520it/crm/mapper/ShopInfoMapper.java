package com._520it.crm.mapper;

import com._520it.crm.domain.ShopInfo;
import java.util.List;

public interface ShopInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShopInfo shopInfo);

    ShopInfo selectByPrimaryKey(Long id);

    List<ShopInfo> selectAll();

    int updateByPrimaryKey(ShopInfo shopInfo);

    /**
     * 根据员工id查询店铺名称
     * @param employeeId
     * @return
     */
    String queryShopNameByEmployeeId(Long employeeId);
}