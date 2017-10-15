package com._520it.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Brand;
import com._520it.crm.domain.ProductInfo;
import com._520it.crm.mapper.ProductInfoMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductInfoQueryObject;
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

	@Override
	public PageResult query(ProductInfoQueryObject qo) {
		Long total=productInfoMapper.queryForCount(qo);
		if(total==0){
			return new PageResult(new Long(0),new ArrayList<Brand>());
		}
		List<Brand> rows=productInfoMapper.queryForList(qo);
		return new PageResult(total,rows);
	}

	@Override
	public void changeState(Long id) {
		productInfoMapper.changeState(id);
	}

}
