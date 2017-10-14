package com._520it.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.ProductType;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductTypeQueryObject;
import com._520it.crm.service.IProductTypeService;

@Controller
@RequestMapping("/productType")
public class ProductTypeController {
	@Autowired
	private IProductTypeService productTypeService;
	@RequestMapping("")
	public String productType(){
		/*跳转到web-inf下资源*/
		return "productType";
	}
	@RequestMapping("/query")
	@ResponseBody
	public PageResult query(ProductTypeQueryObject qo){
		/*高级查询部分*/
		PageResult pageResult = null;
		try {
			pageResult=productTypeService.query(qo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageResult;
	}
	@RequestMapping("/list")
	@ResponseBody
	public List<ProductType> list(){
		/*列表查询部分*/
		return productTypeService.selectAll();
	}
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long id){
		try {
			productTypeService.changeState(id);
			return new AjaxResult(true,"更改成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"更改失败!");
		}
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(ProductType productType){
		try {
			productTypeService.insert(productType);
			return new AjaxResult(true,"添加成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"添加失败!");
		}
	}
}
