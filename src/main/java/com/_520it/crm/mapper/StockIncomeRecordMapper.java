package com._520it.crm.mapper;

import com._520it.crm.domain.StockIncomeRecord;
import com._520it.crm.query.StockIncomeRecordQueryObject;

import java.util.List;

public interface StockIncomeRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StockIncomeRecord record);

    StockIncomeRecord selectByPrimaryKey(Long id);

    List<StockIncomeRecord> selectAll();

    int updateByPrimaryKey(StockIncomeRecord record);

    List<StockIncomeRecord> queryForData(StockIncomeRecordQueryObject qo);

    Long queryForCount(StockIncomeRecordQueryObject qo);
}