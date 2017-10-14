package com._520it.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Brand;
import com._520it.crm.domain.Location;
import com._520it.crm.domain.ProductPart;
import com._520it.crm.mapper.ProductPartMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductPartQueryObject;
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

	@Override
	public PageResult query(ProductPartQueryObject qo) {
		Long total=productPartMapper.queryForCount(qo);
		if(total==0){
			return new PageResult(new Long(0),new ArrayList<Brand>());
		}
		List<Location> rows=productPartMapper.queryForList(qo);
		return new PageResult(total,rows);
	}

	@Override
	public void changeState(Long id) {
		productPartMapper.changeState(id);
		
	}

}
