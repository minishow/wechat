package com._520it.crm.mapper;

import com._520it.crm.domain.OrderBillItem;
import com._520it.crm.query.OrderbillitemQueryObject;

import java.util.List;

public interface OrderBillItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderBillItem record);

    OrderBillItem selectByPrimaryKey(Long id);

    List<OrderBillItem> selectAll();

    int updateByPrimaryKey(OrderBillItem record);

    /**
     * 根据挂单id 查询所有的明细信息
     * @param qo
     * @return
     */
    List<OrderBillItem> queryAllByBillId(OrderbillitemQueryObject qo);


}