package com._520it.crm.web.controller;

import com._520it.crm.page.PageResult;
import com._520it.crm.query.MembertopQueryObject;
import com._520it.crm.service.IMemberTopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/memberTop")
@Controller
public class MemberTopController {

    @Autowired
    public IMemberTopService memberTopService;


    @RequestMapping("")
    public String login(){
        return "memberTop";
    }



    @RequestMapping("list")
    @ResponseBody
    public PageResult list(MembertopQueryObject qo){

        PageResult pageResult = null;
        pageResult = memberTopService.queryMemberByList( qo);
        return pageResult;
    }
}
