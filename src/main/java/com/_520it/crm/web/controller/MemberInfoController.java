package com._520it.crm.web.controller;

import com._520it.crm.domain.MemberInfo;
import com._520it.crm.domain.Membertop;
import com._520it.crm.domain.PetInfo;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.MemberInfoQueryObject;
import com._520it.crm.service.IMemberInfoService;
import com._520it.crm.util.AjaxObject;
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
    @RequestMapping("addMemberAndPet")
    @ResponseBody
    public AjaxResult addMemberAndPet(MemberInfo mem, PetInfo pet){

        try {
            mem.setRemark(0);
            memberInfoService.insertMemberAndpet(mem,pet);
            return new AjaxResult(true,"会员增加成功");
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResult(false,"会员增加失败");
        }

    }
    @RequestMapping("/updateRemark")
    @ResponseBody
    public AjaxObject updateRemark(){
        try {

            memberInfoService.updateRemark();
            return new AjaxObject(true,"退卡成功");
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxObject(false,"退卡失败");

        }
    }
    @RequestMapping("/addMomberMoney")
    @ResponseBody
    public AjaxObject addMonberMoney(Membertop memLevel, MemberInfo info){
        try {

            memberInfoService.addMonberMoney(memLevel,info);
            return new AjaxObject(true,"充值成功");
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxObject(false,"充值失败");

        }
    }


}
