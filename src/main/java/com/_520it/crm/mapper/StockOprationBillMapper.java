package com._520it.crm.mapper;

import com._520it.crm.domain.StockOprationBill;
import com._520it.crm.domain.StockOutRecord;
import com._520it.crm.query.StockOprationBillQueryObject;

import java.util.List;

public interface StockOprationBillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StockOprationBill record);

    StockOprationBill selectByPrimaryKey(Long id);

    List<StockOprationBill> selectAll();

    int updateByPrimaryKey(StockOprationBill record);

    List<StockOutRecord> queryForData(StockOprationBillQueryObject qo);

    Long queryForCount(StockOprationBillQueryObject qo);
}