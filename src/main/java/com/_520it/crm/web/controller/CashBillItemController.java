package com._520it.crm.web.controller;


import com._520it.crm.domain.CashBillItem;
import com._520it.crm.query.CashBillItemQueryObject;
import com._520it.crm.service.ICashBillItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/cashbillitem")
public class CashBillItemController {
    @Autowired
    private ICashBillItemService cashBillItemService;

    @RequestMapping("")
    public String index(){
        return "cashbillitem";
    }

    @RequestMapping("/queryAllByBillId")
    @ResponseBody
    public List<CashBillItem> queryItems(CashBillItemQueryObject qo){
        List<CashBillItem> result = cashBillItemService.queryAllByBillId(qo);
        return result;
    }
}

