package com._520it.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com._520it.crm.domain.ShopInfo;

public interface ShopInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShopInfo shopInfo);

    ShopInfo selectByPrimaryKey(Long id);

    List<ShopInfo> selectAll();

    int updateByPrimaryKey(ShopInfo shopInfo);


	void updateImg(@Param("id")Long id, @Param("imgName")String imgName);

    /**
     * 根据员工id查询店铺名称
     * @param employeeId
     * @return
     */
    String queryShopNameByEmployeeId(Long employeeId);

}