package com._520it.crm.mapper;

import com._520it.crm.domain.CashBill;
import com._520it.crm.query.CashBillQueryObject;

import java.util.List;

public interface CashBillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CashBill record);

    CashBill selectByPrimaryKey(Long id);

    List<CashBill> selectAll();

    int updateByPrimaryKey(CashBill record);

    //分页
    Long queryCount(CashBillQueryObject qo);
    List<CashBill> queryData(CashBillQueryObject qo);

    List<CashBill> selectByTypeId(Long typeId);
}