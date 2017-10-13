package com._520it.crm.service;

import com._520it.crm.domain.StockOprationBill;

import java.util.List;

/**
 * Created by Administrator on 2017/10/13.
 */
public interface IStockOprationBillService {
    int deleteByPrimaryKey(Long id);

    int insert(StockOprationBill record);

    StockOprationBill selectByPrimaryKey(Long id);

    List<StockOprationBill> selectAll();

    int updateByPrimaryKey(StockOprationBill record);
}
