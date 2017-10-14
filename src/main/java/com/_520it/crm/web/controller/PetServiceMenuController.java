package com._520it.crm.web.controller;

import com._520it.crm.domain.PetServiceMenu;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.service.IPetServiceMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/petServiceMenu")
public class PetServiceMenuController {

    @Autowired
    private IPetServiceMenuService petServiceMenuService;

    @RequestMapping("/queryTree")
    @ResponseBody
    public List<PetServiceMenu> queryTree(){
        List<PetServiceMenu> result = petServiceMenuService.queryTree();
        return result;
    }

    @RequestMapping("/queryTopTree")
    @ResponseBody
    public List<PetServiceMenu> queryTopTree(){
        List<PetServiceMenu> result = petServiceMenuService.queryTopTree();
        return result;
    }

    @RequestMapping("/queryChildrenByParentId")
    @ResponseBody
    public List<PetServiceMenu> queryChildrenByParentId(Long id){
        List<PetServiceMenu> result = petServiceMenuService.queryChildrenByParentId(id);
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(PetServiceMenu petServiceMenu){
        AjaxResult result = null;
        try{
            petServiceMenuService.insert(petServiceMenu);
            result = new AjaxResult(true,"添加项目成功");
        }catch(Exception e){
            e.printStackTrace();
            result = new AjaxResult("添加项目失败");
        }
        return result;
    }
}
