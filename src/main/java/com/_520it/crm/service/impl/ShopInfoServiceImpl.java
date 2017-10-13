package com._520it.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.ShopInfo;
import com._520it.crm.mapper.ShopInfoMapper;
import com._520it.crm.service.IShopInfoService;
@Service
public class ShopInfoServiceImpl implements IShopInfoService {

	@Autowired
	private ShopInfoMapper shopInfoMapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		return shopInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ShopInfo shopInfo) {
		return shopInfoMapper.insert(shopInfo);
	}

	@Override
	public ShopInfo selectByPrimaryKey(Long id) {
		return shopInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ShopInfo> selectAll() {
		return shopInfoMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(ShopInfo shopInfo) {
		return shopInfoMapper.updateByPrimaryKey(shopInfo);
	}

}
