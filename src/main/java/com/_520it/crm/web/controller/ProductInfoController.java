package com._520it.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.ProductInfo;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductInfoQueryObject;
import com._520it.crm.service.IProductInfoService;

@Controller
@RequestMapping("/productInfo")
public class ProductInfoController {
	@Autowired
	private IProductInfoService productInfoService;
	@RequestMapping("")
	public String productInfo(){
		/*跳转到web-inf下资源*/
		return "productInfo";
	}
	@RequestMapping("/query")
	@ResponseBody
	public PageResult query(ProductInfoQueryObject qo){
		PageResult pageResult = null;
		try {
			pageResult=productInfoService.query(qo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageResult;
	}
	@RequestMapping("/list")
	@ResponseBody
	public List<ProductInfo> list(){
		return productInfoService.selectAll();
	}
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long id){
		try {
			productInfoService.changeState(id);
			return new AjaxResult(true,"更改成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"更改失败!");
		}
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(ProductInfo productInfo){
		try {
			productInfoService.insert(productInfo);
			return new AjaxResult(true,"添加成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"添加失败!");
		}
	}
}
