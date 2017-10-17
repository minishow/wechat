package com._520it.crm.service;

import com._520it.crm.domain.CashBillItem;
import com._520it.crm.query.CashBillItemQueryObject;

import java.util.List;

public interface ICashBillItemService {
    int deleteByPrimaryKey(Long id);

    int insert(CashBillItem record);

    CashBillItem selectByPrimaryKey(Long id);

    List<CashBillItem> selectAll();

    int updateByPrimaryKey(CashBillItem record);

    List<CashBillItem> queryAllByBillId(CashBillItemQueryObject qo);
}