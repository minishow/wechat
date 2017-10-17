package com._520it.crm.web.controller;

import com._520it.crm.domain.OrderBillItem;
import com._520it.crm.query.OrderbillitemQueryObject;
import com._520it.crm.service.IOrderBillItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/orderbillitem")
public class OrderBillItemController {
    @Autowired
    private IOrderBillItemService orderBillItemService;

    @RequestMapping("/quertAllByBillId")
    @ResponseBody
    public List<OrderBillItem> quertAllByBillId(OrderbillitemQueryObject qo){
        List<OrderBillItem> result = orderBillItemService.queryAllByBillId(qo);
        return result;
    }
}
