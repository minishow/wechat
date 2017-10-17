package com._520it.crm.web.controller;

import com._520it.crm.domain.Harm;
import com._520it.crm.domain.PetInfo;
import com._520it.crm.domain.PetKind;
import com._520it.crm.domain.PetType;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PetInfoQueryObject;
import com._520it.crm.service.IPetInfoService;
import com._520it.crm.service.IPetKindService;
import com._520it.crm.util.AjaxObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/petInfo")
public class PetInfoController {

    @Autowired
    private IPetInfoService petInfoService;

    @Autowired
    private IPetKindService petKindService;

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


    @RequestMapping("/addPet")
    @ResponseBody
    public AjaxObject addPet(PetInfo info){
        try {

            petInfoService.insert(info);
        return new AjaxObject(true,"宠物增加成功");
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxObject(false,"宠物增加失败");

        }
    }
    @RequestMapping("/addPetTypeList")
    @ResponseBody
    public List<PetType> addPetTypeList(){
        try {

            List<PetType> list = petInfoService.addPetTypeList();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;

        }
    }
    @RequestMapping("/addPetKindList")
    @ResponseBody
    public List<PetKind> addPetKindList(Long kindID){
        try {

            System.out.println(kindID);
            List<PetKind> list = petKindService.selectKindAll(kindID);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;

        }
    }
    @RequestMapping("/addHarmList")
    @ResponseBody
        public List<Harm> addHarmList(){
        try {

            List<Harm> list = petKindService.addHarmList();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;

        }
    }
}
