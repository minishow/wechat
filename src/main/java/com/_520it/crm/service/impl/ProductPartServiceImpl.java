package com._520it.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.ProductPart;
import com._520it.crm.mapper.ProductPartMapper;
import com._520it.crm.service.IProductPartService;
@Service
public class ProductPartServiceImpl implements IProductPartService {

	@Autowired
	private ProductPartMapper productPartMapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		return productPartMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ProductPart productPart) {
		return productPartMapper.insert(productPart);
	}

	@Override
	public ProductPart selectByPrimaryKey(Long id) {
		return productPartMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ProductPart> selectAll() {
		return productPartMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(ProductPart productPart) {
		return productPartMapper.updateByPrimaryKey(productPart);
	}

}
