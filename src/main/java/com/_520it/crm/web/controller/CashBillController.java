package com._520it.crm.web.controller;

import com._520it.crm.domain.CashBill;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.CashBillQueryObject;
import com._520it.crm.service.ICashBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cashbill")
public class CashBillController {
    @Autowired
    private ICashBillService cashBillService;

    @RequestMapping("")
    public String index(){
        return "cashbill";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(CashBillQueryObject qo){
        PageResult query = cashBillService.query(qo);
        return query;
    }

    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(CashBill cashBill){
        AjaxResult result = null;
        try {
            cashBillService.insert(cashBill);
            result = new AjaxResult(true,"结账成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "结账失败");
        }
        return result;
    }

}
