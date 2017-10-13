package com._520it.crm.service;

import com._520it.crm.domain.StockIncomeRecord;

import java.util.List;

/**
 * Created by Administrator on 2017/10/13.
 */
public interface IStockIncomeRecordService {
    int deleteByPrimaryKey(Long id);

    int insert(StockIncomeRecord record);

    StockIncomeRecord selectByPrimaryKey(Long id);

    List<StockIncomeRecord> selectAll();

    int updateByPrimaryKey(StockIncomeRecord record);
}
