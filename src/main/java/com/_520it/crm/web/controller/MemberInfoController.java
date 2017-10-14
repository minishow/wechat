package com._520it.crm.web.controller;

import com._520it.crm.page.PageResult;
import com._520it.crm.query.MemberInfoQueryObject;
import com._520it.crm.service.IMemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/memberInfo")
public class MemberInfoController {


    @Autowired
    private IMemberInfoService memberInfoService;

    @RequestMapping("")
    private String login(){

        return "memberInfo";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageResult list(MemberInfoQueryObject qo){

        PageResult pageResult = null;
        pageResult = memberInfoService.queryMemberByList(qo);

        return pageResult;
    }

}