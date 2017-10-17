package com._520it.crm.service.impl;

import com._520it.crm.domain.OrderBillItem;
import com._520it.crm.mapper.OrderBillItemMapper;
import com._520it.crm.query.OrderbillitemQueryObject;
import com._520it.crm.service.IOrderBillItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderBillItemServiceImpl implements IOrderBillItemService {
    @Autowired
    private OrderBillItemMapper orderBillItemMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return orderBillItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OrderBillItem record) {
        return orderBillItemMapper.insert(record);
    }

    @Override
    public OrderBillItem selectByPrimaryKey(Long id) {
        return orderBillItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<OrderBillItem> selectAll() {
        return orderBillItemMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(OrderBillItem record) {
        return orderBillItemMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<OrderBillItem> queryAllByBillId(OrderbillitemQueryObject qo) {
        return orderBillItemMapper.queryAllByBillId(qo);
    }

}
