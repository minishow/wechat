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

<<<<<<< HEAD

=======
    List<CashBill> selectByTypeId(Long typeId);
>>>>>>> dec2b6a5f90d0dab3820ccc6d2795e8f35f3ff28
}