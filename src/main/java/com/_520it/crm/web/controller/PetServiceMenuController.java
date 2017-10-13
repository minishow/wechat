package com._520it.crm.web.controller;

import com._520it.crm.domain.PetServiceMenu;
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
    public List<PetServiceMenu> indexMenu(){
        List<PetServiceMenu> result = petServiceMenuService.queryTree();
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public void save(PetServiceMenu petServiceMenu){
        petServiceMenuService.insert(petServiceMenu);
    }
}
