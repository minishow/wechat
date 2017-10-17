package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.ShopInfo;

public interface IShopInfoService {
    int deleteByPrimaryKey(Long id);

    int insert(ShopInfo shopInfo);

    ShopInfo selectByPrimaryKey(Long id);

    List<ShopInfo> selectAll();

    int updateByPrimaryKey(ShopInfo shopInfo);

	ShopInfo queryMessagesOfBoss();

	void updateImg(Long id, String imgName);
}
