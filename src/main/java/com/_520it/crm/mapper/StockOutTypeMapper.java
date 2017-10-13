package com._520it.crm.mapper;

import com._520it.crm.domain.StockOutType;
import java.util.List;

public interface StockOutTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StockOutType stockOutType);

    StockOutType selectByPrimaryKey(Long id);

    List<StockOutType> selectAll();

    int updateByPrimaryKey(StockOutType stockOutType);
}