package com._520it.crm.web.controller;

import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQueryObject;
import com._520it.crm.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/employee")
@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("")
    public String index(){
        return "employee";
    }
    @RequestMapping("/queryByPageList")
    @ResponseBody
    public PageResult queryByPageList(EmployeeQueryObject qo){

        return employeeService.queryByPageList(qo);
    }

}
