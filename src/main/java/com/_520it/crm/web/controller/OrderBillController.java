package com._520it.crm.web.controller;

import com._520it.crm.domain.OrderBill;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.OrderBillQueryObject;
import com._520it.crm.service.IOrderBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/orderbill")
public class OrderBillController {
    @Autowired
    private IOrderBillService orderBillService;

    //挂单保存
    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(OrderBill orderBill){
        AjaxResult result = null;
        try {
            orderBillService.insert(orderBill);
            result = new AjaxResult(true,"挂单成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "挂单失败");
        }
        return result;
    }

    //挂单保存
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(OrderBillQueryObject qo){
        PageResult result = orderBillService.query(qo);
        return result;
    }
}
