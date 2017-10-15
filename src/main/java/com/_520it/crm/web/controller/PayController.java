package com._520it.crm.web.controller;

import com._520it.crm.page.PageResult;
import com._520it.crm.query.PayQueryObject;
import com._520it.crm.service.IPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/pay")
@Controller
public class PayController {
    @Autowired
    private IPayService payService;

    @RequestMapping("")
    public String index() {
        return "pay";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(PayQueryObject qo) {
        PageResult result = null;
        try {
            result = payService.query(qo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


}
