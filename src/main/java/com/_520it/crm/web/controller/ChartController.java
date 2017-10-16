package com._520it.crm.web.controller;

import com._520it.crm.service.IPetServiceRegisterService;
import com._520it.crm.vo.PetServiceChartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/chart")
public class ChartController {

    @Autowired
    private IPetServiceRegisterService petServiceRegisterService;

    @RequestMapping("")
    public String main(){
        return "chart";
    }

    @RequestMapping("/pieJsp")
    public String pieJsp() {
        return "serviceChartByPie";
    }

    @RequestMapping("/serviceChartByPie")
    @ResponseBody
    public Map<String,Object> saleChartByPie(HttpServletRequest req) throws Exception {

        List<PetServiceChartVO> list = petServiceRegisterService.selectServiceCountByName();
        //存放分组类型列表
        List<String> groupList = new ArrayList<>();
        List<Map<String,Object>> datas = new ArrayList<>();
        for (PetServiceChartVO vo : list) {
            //获取分组类型
            String groupType = vo.getGroupType();
            groupList.add(vo.getGroupType());
            //获取name与value的值 存入map中
            Map<String,Object> data = new HashMap<>();
            data.put("name",groupType);
            data.put("value",vo.getTotalCount());
            //存储
            datas.add(data);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("datas",datas);
        map.put("groupList",groupList);

        return map;
    }
}
