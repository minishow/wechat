package com._520it.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Brand;
import com._520it.crm.page.AjaxResult;
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
		return "brand";
	}
	@RequestMapping("/query")
	@ResponseBody
	public PageResult query(BrandQueryObject qo){
		PageResult pageResult = null;
		try {
			pageResult=brandService.query(qo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageResult;
	}
	@RequestMapping("/list")
	@ResponseBody
	public List<Brand> list(){
		return brandService.selectAll();
	}
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long id){
		try {
			brandService.changeState(id);
			return new AjaxResult(true,"更改成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"更改失败!");
		}
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(Brand brand){
		try {
			brandService.insert(brand);
			return new AjaxResult(true,"添加成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"添加失败!");
		}
	}
}
