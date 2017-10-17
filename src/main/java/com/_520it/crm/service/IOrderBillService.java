package com._520it.crm.service;

import com._520it.crm.domain.OrderBill;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.OrderBillQueryObject;

import java.util.List;

public interface IOrderBillService {
    int deleteByPrimaryKey(Long id);

    int insert(OrderBill record);

    OrderBill selectByPrimaryKey(Long id);

    List<OrderBill> selectAll();

    int updateByPrimaryKey(OrderBill record);

    PageResult query(OrderBillQueryObject qo);
}