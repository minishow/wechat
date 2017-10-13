package com._520it.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.StockOutType;
import com._520it.crm.mapper.StockOutTypeMapper;
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

}
