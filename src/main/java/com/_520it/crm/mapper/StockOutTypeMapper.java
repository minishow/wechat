package com._520it.crm.mapper;

import com._520it.crm.domain.Location;
import com._520it.crm.domain.StockOutType;
import com._520it.crm.query.StockOutTypeQueryObject;

import java.util.List;

public interface StockOutTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StockOutType stockOutType);

    StockOutType selectByPrimaryKey(Long id);

    List<StockOutType> selectAll();

    int updateByPrimaryKey(StockOutType stockOutType);

	Long queryForCount(StockOutTypeQueryObject qo);

	List<Location> queryForList(StockOutTypeQueryObject qo);

	void changeState(Long id);
}