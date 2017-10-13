package com._520it.crm.mapper;

import com._520it.crm.domain.StockOprationBill;

import java.util.List;

public interface StockOprationBillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StockOprationBill record);

    StockOprationBill selectByPrimaryKey(Long id);

    List<StockOprationBill> selectAll();

    int updateByPrimaryKey(StockOprationBill record);
}