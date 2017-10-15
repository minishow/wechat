package com._520it.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chart")
public class ChartController {

    @RequestMapping("")
    public String main(){
        return "chart";
    }

    @RequestMapping("/serviceChartByPie")
    public String saleChartByPie() throws Exception {
        return "serviceChartByPie";
    }
}
