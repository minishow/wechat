package com._520it.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.ProductInfo;
import com._520it.crm.mapper.ProductInfoMapper;
import com._520it.crm.service.IProductInfoService;
@Service
public class ProductInfoServiceImpl implements IProductInfoService {

	@Autowired
	private ProductInfoMapper productInfoMapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		return productInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ProductInfo productInfo) {
		return productInfoMapper.insert(productInfo);
	}

	@Override
	public ProductInfo selectByPrimaryKey(Long id) {
		return productInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ProductInfo> selectAll() {
		return productInfoMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(ProductInfo productInfo) {
		return productInfoMapper.updateByPrimaryKey(productInfo);
	}

}
