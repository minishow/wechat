package com._520it.crm.mapper;

import com._520it.crm.domain.OrderBill;
import com._520it.crm.query.OrderBillQueryObject;

import java.util.List;

public interface OrderBillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderBill record);

    OrderBill selectByPrimaryKey(Long id);

    List<OrderBill> selectAll();

    int updateByPrimaryKey(OrderBill record);

    Long queryCount(OrderBillQueryObject qo);

    List<OrderBill> queryData(OrderBillQueryObject qo);
}