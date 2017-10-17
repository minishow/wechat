package com._520it.crm.mapper;

import com._520it.crm.domain.StockIncome;
import java.util.List;

public interface StockIncomeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StockIncome record);

    StockIncome selectByPrimaryKey(Long id);

    List<StockIncome> selectAll();

    int updateByPrimaryKey(StockIncome record);
}