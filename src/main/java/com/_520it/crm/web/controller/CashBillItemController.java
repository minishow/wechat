package com._520it.crm.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cashbillitem")
public class CashBillItemController {
    @RequestMapping("")
    public String index(){
        return "cashbillitem";

    }
}

