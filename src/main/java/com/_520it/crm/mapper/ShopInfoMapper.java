package com._520it.crm.mapper;

import com._520it.crm.domain.ShopInfo;
import java.util.List;

public interface ShopInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShopInfo shopInfo);

    ShopInfo selectByPrimaryKey(Long id);

    List<ShopInfo> selectAll();

    int updateByPrimaryKey(ShopInfo shopInfo);
}