package com._520it.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.ProductScale;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductScaleQueryObject;
import com._520it.crm.service.IProductScaleService;

@Controller
@RequestMapping("/productScale")
public class ProductScaleController {
	@Autowired
	private IProductScaleService productScaleService;
	@RequestMapping("/list")
	@ResponseBody
	public List<ProductScale> list(){
		/*
		 * 查询全部的地址信息,给添加品牌的时候下来选择
		 */
		return productScaleService.selectAll();
	}
	@RequestMapping("")
	public String productScale(){
		/*跳转到web-inf下资源*/
		return "productScale";
	}
	@RequestMapping("/query")
	@ResponseBody
	public PageResult list(ProductScaleQueryObject qo){
		PageResult pageResult = null;
		try {
			pageResult=productScaleService.query(qo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageResult;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long id){
		try {
			productScaleService.changeState(id);
			return new AjaxResult(true,"更改成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"更改失败!");
		}
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(ProductScale productScale){
		try {
			productScaleService.insert(productScale);
			return new AjaxResult(true,"添加成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"添加失败!");
		}
	}
}
