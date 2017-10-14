package com._520it.crm.service;

import com._520it.crm.domain.CashBill;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.CashBillQueryObject;

import java.util.List;

public interface ICashBillService {
    int deleteByPrimaryKey(Long id);

    int insert(CashBill record);

    CashBill selectByPrimaryKey(Long id);

    List<CashBill> selectAll();

    int updateByPrimaryKey(CashBill record);

    PageResult query(CashBillQueryObject qo);
}