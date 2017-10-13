package com._520it.crm.service;

import com._520it.crm.domain.StockOutRecord;

import java.util.List;

/**
 * Created by Administrator on 2017/10/13.
 */
public interface IStockOutRecordService {
    int deleteByPrimaryKey(Long id);

    int insert(StockOutRecord record);

    StockOutRecord selectByPrimaryKey(Long id);

    List<StockOutRecord> selectAll();

    int updateByPrimaryKey(StockOutRecord record);
}
