package com._520it.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.ProductPart;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductPartQueryObject;
import com._520it.crm.service.IProductPartService;

@Controller
@RequestMapping("/productPart")
public class ProductPartController {
	@Autowired
	private IProductPartService productPartService;
	@RequestMapping("/list")
	@ResponseBody
	public List<ProductPart> list(){
		/*
		 * 查询全部的地址信息,给添加品牌的时候下来选择
		 */
		return productPartService.selectAll();
	}
	@RequestMapping("")
	public String productPart(){
		/*跳转到web-inf下资源*/
		return "productPart";
	}
	@RequestMapping("/query")
	@ResponseBody
	public PageResult list(ProductPartQueryObject qo){
		PageResult pageResult = null;
		try {
			pageResult=productPartService.query(qo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageResult;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long id){
		try {
			productPartService.changeState(id);
			return new AjaxResult(true,"更改成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"更改失败!");
		}
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(ProductPart productPart){
		try {
			productPartService.insert(productPart);
			return new AjaxResult(true,"添加成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"添加失败!");
		}
	}
}
