package com._520it.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Brand;
import com._520it.crm.domain.Location;
import com._520it.crm.domain.ProductScale;
import com._520it.crm.mapper.ProductScaleMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductScaleQueryObject;
import com._520it.crm.service.IProductScaleService;
@Service
public class ProductScaleServiceImpl implements IProductScaleService {

	@Autowired
	private ProductScaleMapper productScaleMapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		return productScaleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ProductScale productScale) {
		return productScaleMapper.insert(productScale);
	}

	@Override
	public ProductScale selectByPrimaryKey(Long id) {
		return productScaleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ProductScale> selectAll() {
		return productScaleMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(ProductScale productScale) {
		return productScaleMapper.updateByPrimaryKey(productScale);
	}

	@Override
	public PageResult query(ProductScaleQueryObject qo) {
		Long total=productScaleMapper.queryForCount(qo);
		if(total==0){
			return new PageResult(new Long(0),new ArrayList<Brand>());
		}
		List<Location> rows=productScaleMapper.queryForList(qo);
		return new PageResult(total,rows);
	}

	@Override
	public void changeState(Long id) {
		productScaleMapper.changeState(id);
	}

}
