package com._520it.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Brand;
import com._520it.crm.domain.Location;
import com._520it.crm.domain.StockOutType;
import com._520it.crm.mapper.StockOutTypeMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.StockOutTypeQueryObject;
import com._520it.crm.service.IStockOutTypeService;
@Service
public class StockOutTypeServiceImpl implements IStockOutTypeService {

	@Autowired
	private StockOutTypeMapper stockOutTypeMapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		return stockOutTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(StockOutType stockOutType) {
		return stockOutTypeMapper.insert(stockOutType);
	}

	@Override
	public StockOutType selectByPrimaryKey(Long id) {
		return stockOutTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<StockOutType> selectAll() {
		return stockOutTypeMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(StockOutType stockOutType) {
		return stockOutTypeMapper.updateByPrimaryKey(stockOutType);
	}

	@Override
	public PageResult query(StockOutTypeQueryObject qo) {
		Long total=stockOutTypeMapper.queryForCount(qo);
		if(total==0){
			return new PageResult(new Long(0),new ArrayList<Brand>());
		}
		List<Location> rows=stockOutTypeMapper.queryForList(qo);
		return new PageResult(total,rows);
	}

	@Override
	public void changeState(Long id) {
		stockOutTypeMapper.changeState(id);
	}

}
