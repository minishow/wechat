package com._520it.crm.mapper;

import com._520it.crm.domain.CashBillItem;
import com._520it.crm.query.CashBillItemQueryObject;

import java.util.List;

public interface CashBillItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CashBillItem record);

    CashBillItem selectByPrimaryKey(Long id);

    List<CashBillItem> selectAll();

    int updateByPrimaryKey(CashBillItem record);

    /**
     * 根据订单id 查询所有的明细信息
     * @param qo
     * @return
     */
    List<CashBillItem> queryAllByBillId(CashBillItemQueryObject qo);
}