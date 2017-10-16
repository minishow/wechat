package com._520it.crm.service.impl;


import com._520it.crm.domain.CashBill;
import com._520it.crm.domain.CashBillItem;
import com._520it.crm.mapper.CashBillItemMapper;
import com._520it.crm.mapper.CashBillMapper;
import com._520it.crm.mapper.ShopInfoMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.CashBillQueryObject;
import com._520it.crm.service.ICashBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class CashBillServiceImpl implements ICashBillService{
    @Autowired
    private CashBillMapper cashBillMapper;
    @Autowired
    private CashBillItemMapper cashBillItemMapper;
    @Autowired
    private ShopInfoMapper shopInfoMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return cashBillMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CashBill cashBill) {
        Date d = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String formatDate = formatter.format(d);
        String sn = "DO" + formatDate;
        cashBill.setSn(sn); //编码
        cashBill.setOrderTime(d);
         //总数量
        Integer totalNumber = 0;
        List<CashBillItem> items = cashBill.getItems();
        for (CashBillItem item : items) {
            totalNumber = totalNumber + item.getNumber();

        }
        cashBill.setTotalNumber(totalNumber);
         //操作人
       /* Employee current = (Employee) SecurityUtils.getSubject();*/
        cashBill.setEmployeeName("admin");
        //店铺名称
       /* String shopName =  shopInfoMapper.queryShopNameByEmployeeId(current.getId());*/
        cashBill.setShopName("宠物店");
        //保存记录
        int insert = 0;
        try {
            insert = cashBillMapper.insert(cashBill);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //保存明细的记录id
        for (CashBillItem item : items) {
            item.setBillId(cashBill.getId());
            cashBillItemMapper.insert(item);
        }

        if(cashBill.getPaymentTerm() == 4){

        }
        return insert ;
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

    @Override
    public List<CashBill> selectByTypeId(Long typeId) {
        return cashBillMapper.selectByTypeId(typeId);
    }
}
