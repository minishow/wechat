package com._520it.crm.service.impl;

import com._520it.crm.domain.OrderBill;
import com._520it.crm.domain.OrderBillItem;
import com._520it.crm.mapper.OrderBillItemMapper;
import com._520it.crm.mapper.OrderBillMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.OrderBillQueryObject;
import com._520it.crm.service.IOrderBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class OrderBillServiceImpl implements IOrderBillService{
    @Autowired
    private OrderBillMapper orderBillMapper;
    @Autowired
    private OrderBillItemMapper orderBillItemMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return orderBillMapper.deleteByPrimaryKey(id);
    }

    //挂单保存
    @Override
    public int insert(OrderBill orderBill) {
        //挂单时间
        orderBill.setOrderTime(new Date());
        int insert = orderBillMapper.insert(orderBill);
        for (OrderBillItem item : orderBill.getItems()) {
            item.setBillId(orderBill.getId());
            orderBillItemMapper.insert(item);
        }
        return insert;
    }

    @Override
    public OrderBill selectByPrimaryKey(Long id) {
        return orderBillMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<OrderBill> selectAll() {
        return orderBillMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(OrderBill record) {
        return orderBillMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult query(OrderBillQueryObject qo) {
        Long total = orderBillMapper.queryCount(qo);
        if (total == 0) {
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        List<OrderBill> rows =orderBillMapper.queryData(qo);
        return new PageResult(total, rows);
    }
}
