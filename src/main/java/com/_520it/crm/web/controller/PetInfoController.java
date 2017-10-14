package com._520it.crm.web.controller;

import com._520it.crm.page.PageResult;
import com._520it.crm.query.PetInfoQueryObject;
import com._520it.crm.service.IPetInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/petInfo")
public class PetInfoController {

    @Autowired
    private IPetInfoService petInfoService;

    @RequestMapping("")
    public String login(){


        return "petInfo";
    }

    @RequestMapping("list")
    @ResponseBody
    public PageResult list(PetInfoQueryObject qo){

        PageResult pageResult = null;
            pageResult = petInfoService.selectPetInfoList( qo);
        return pageResult;
    }
}
