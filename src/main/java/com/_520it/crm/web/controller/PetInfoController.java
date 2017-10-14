package com._520it.crm.web.controller;

import com._520it.crm.page.PageResult;
import com._520it.crm.query.PetInfoQueryObject;
import com._520it.crm.service.IPetInfoService;
import com._520it.crm.util.AjaxObject;
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

    @RequestMapping("/addMoney")
    @ResponseBody
    public AjaxObject addMoney(){
        try {

        return new AjaxObject(true,"充值成功");
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxObject(false,"充值失败");

        }
    }
    @RequestMapping("/addMember")
    @ResponseBody
    public AjaxObject addMember(){
        try {

        return new AjaxObject(true,"充值成功");
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxObject(false,"充值失败");

        }
    }
}
