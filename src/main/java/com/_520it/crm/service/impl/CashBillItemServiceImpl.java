package com._520it.crm.service.impl;


import com._520it.crm.domain.CashBillItem;
import com._520it.crm.mapper.CashBillItemMapper;
import com._520it.crm.query.CashBillItemQueryObject;
import com._520it.crm.service.ICashBillItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CashBillItemServiceImpl implements ICashBillItemService{
    @Autowired
    private CashBillItemMapper cashBillItemMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return cashBillItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CashBillItem record) {
        return cashBillItemMapper.insert(record);
    }

    @Override
    public CashBillItem selectByPrimaryKey(Long id) {
        return cashBillItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CashBillItem> selectAll() {
        return cashBillItemMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(CashBillItem record) {
        return cashBillItemMapper.updateByPrimaryKey(record);
    }

    public List<CashBillItem> queryAllByBillId(CashBillItemQueryObject qo) {

        return cashBillItemMapper.queryAllByBillId(qo);
    }
}
