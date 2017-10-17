package com._520it.crm.service;

import com._520it.crm.domain.StockOprationBill;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.StockOprationBillQueryObject;
import com._520it.crm.util.StockBIll;

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

    PageResult queryForList(StockOprationBillQueryObject qo);

    void insertBill(StockBIll stockObjects);

    Long queryProductIdByName(String productInfoId);

    Long querySpecificIdByName(String productInfoId);

    Long queryOpenStocksIdByName(String productInfoId);

    Long queryStockIncomesIdByName(String productInfoId);
}
