package com._520it.crm.service.impl;


import com._520it.crm.domain.CashBill;
import com._520it.crm.mapper.CashBillMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.CashBillQueryObject;
import com._520it.crm.service.ICashBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.List;
@Controller
public class CashBillServiceImpl implements ICashBillService{
    @Autowired
    private CashBillMapper cashBillMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return cashBillMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CashBill record) {
        return cashBillMapper.insert(record);
    }

    @Override
    public CashBill selectByPrimaryKey(Long id) {
        return cashBillMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CashBill> selectAll() {
        return cashBillMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(CashBill record) {
        return cashBillMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult query(CashBillQueryObject qo) {
        Long total = cashBillMapper.queryCount(qo);
        if (total == 0) {
            return new PageResult(0L,Collections.EMPTY_LIST);
        }
        List<CashBill> rows =cashBillMapper.queryData(qo);
        return new PageResult(total, rows);
    }
}
