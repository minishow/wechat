package com._520it.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.ProductType;
import com._520it.crm.mapper.ProductTypeMapper;
import com._520it.crm.service.IProductTypeService;
@Service
public class ProductTypeServiceImpl implements IProductTypeService {
	@Autowired
	private ProductTypeMapper productTypeMapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		return productTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ProductType productType) {
		return productTypeMapper.insert(productType);
	}

	@Override
	public ProductType selectByPrimaryKey(Long id) {
		return productTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ProductType> selectAll() {
		return productTypeMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(ProductType productType) {
		return productTypeMapper.updateByPrimaryKey(productType);
	}

}
