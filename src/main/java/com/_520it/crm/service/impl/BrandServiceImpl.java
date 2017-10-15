package com._520it.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Brand;
import com._520it.crm.mapper.BrandMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.BrandQueryObject;
import com._520it.crm.service.IBrandService;
@Service
public class BrandServiceImpl implements IBrandService {
	@Autowired
	private BrandMapper brandMapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		return brandMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Brand brand) {
		return brandMapper.insert(brand);
	}

	@Override
	public Brand selectByPrimaryKey(Long id) {
		return brandMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Brand> selectAll() {
		return brandMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Brand brand) {
		return brandMapper.updateByPrimaryKey(brand);
	}

	@Override
	public PageResult query(BrandQueryObject qo) {
		Long total=brandMapper.queryForCount(qo);
		if(total==0){
			return new PageResult(new Long(0),new ArrayList<Brand>());
		}
		List<Brand> rows=brandMapper.queryForList(qo);
		return new PageResult(total,rows);
	}

	@Override
	public void changeState(Long id) {
		brandMapper.changeState(id);
	}

}
