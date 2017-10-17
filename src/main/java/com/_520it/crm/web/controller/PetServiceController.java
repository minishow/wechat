package com._520it.crm.web.controller;

import com._520it.crm.domain.MemberInfo;
import com._520it.crm.domain.PetKind;
import com._520it.crm.domain.PetType;
import com._520it.crm.service.IMemberInfoService;
import com._520it.crm.service.IPetKindService;
import com._520it.crm.service.IPetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/petService")
public class PetServiceController {

    @Autowired
    private IPetKindService petKindService;
    @Autowired
    private IPetTypeService petTypeService;
    @Autowired
    private IMemberInfoService memberInfoService;

    @RequestMapping("")
    public String main(){
        return "petService";
    }

    @RequestMapping("/queryKindByTypeId")
    @ResponseBody
    public List<PetKind> queryKindByTypeId(Long id){
        List<PetKind> result = petKindService.queryKindByTypeId(id);
        return result;
    }
    @RequestMapping("/queryPetType")
    @ResponseBody
    public List<PetType> queryPetType(){
        List<PetType> result = petTypeService.selectAll();
        return result;
    }

    @RequestMapping("/queryInfoByMemberId")
    @ResponseBody
    public MemberInfo queryInfoByMemberId(String memberId){
        MemberInfo result = memberInfoService.queryInfoByMemberId(memberId);
        return result;
    }
}
