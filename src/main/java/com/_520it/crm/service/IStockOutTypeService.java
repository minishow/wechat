package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.StockOutType;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.StockOutTypeQueryObject;

public interface IStockOutTypeService {
    int deleteByPrimaryKey(Long id);

    int insert(StockOutType stockOutType);

    StockOutType selectByPrimaryKey(Long id);

    List<StockOutType> selectAll();

    int updateByPrimaryKey(StockOutType stockOutType);

	PageResult query(StockOutTypeQueryObject qo);

	void changeState(Long id);
}
