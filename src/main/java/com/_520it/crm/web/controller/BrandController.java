package com._520it.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.page.PageResult;
import com._520it.crm.query.BrandQueryObject;
import com._520it.crm.service.IBrandService;

@Controller
@RequestMapping("/brand")
public class BrandController {
	@Autowired
	private IBrandService brandService;
	@RequestMapping("")
	public String brand(){
		/*跳转到web-inf下资源*/
		System.out.println("hahaha");
		return "brand";
	}
	@RequestMapping("/list")
	@ResponseBody
	public PageResult list(BrandQueryObject qo){
		PageResult pageResult = null;
		try {
			pageResult=brandService.query(qo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageResult;
	}
}
