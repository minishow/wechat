package com._520it.crm.web.controller;

import com._520it.crm.domain.PetServiceRegister;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PetServiceRegisterQueryObject;
import com._520it.crm.service.IPetServiceRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/petServiceRegister")
public class PetServiceRegisterController {

    @Autowired
    private IPetServiceRegisterService petServiceRegisterService;

    @RequestMapping("")
    public String index(){
        return "petServiceRegister";
    }
    
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(PetServiceRegisterQueryObject qo){
        PageResult result = petServiceRegisterService.queryPage(qo);
        return result;
    }
    
    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(PetServiceRegister petServiceRegister){
        AjaxResult result = null;
        try{
            petServiceRegisterService.insert(petServiceRegister);
            result = new AjaxResult(true,"添加服务成功");
        }catch(Exception e){
            e.printStackTrace();
            result = new AjaxResult("添加服务失败,请联系管理员!");
        }
        return result;
    }
    
    @RequestMapping("/startService")
    public void startService(PetServiceRegister petServiceRegister){
        petServiceRegisterService.startService();
    }

    @RequestMapping("/endService")
    public void endService(PetServiceRegister petServiceRegister){
        petServiceRegisterService.endService();
    }
}