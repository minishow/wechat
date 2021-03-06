package com._520it.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.StockOutType;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.StockOutTypeQueryObject;
import com._520it.crm.service.IStockOutTypeService;

@Controller
@RequestMapping("/stockOutType")
public class StockOutTypeController {
	@Autowired
	private IStockOutTypeService stockOutTypeService;
	@RequestMapping("/list")
	@ResponseBody
	public List<StockOutType> list(){
		/*
		 * 查询全部的地址信息,给添加品牌的时候下来选择
		 */
		return stockOutTypeService.selectAll();
	}
	@RequestMapping("")
	public String stockOutType(){
		/*跳转到web-inf下资源*/
		return "stockOutType";
	}
	@RequestMapping("/query")
	@ResponseBody
	public PageResult list(StockOutTypeQueryObject qo){
		PageResult pageResult = null;
		try {
			pageResult=stockOutTypeService.query(qo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageResult;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long id){
		try {
			stockOutTypeService.changeState(id);
			return new AjaxResult(true,"更改成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"更改失败!");
		}
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(StockOutType stockOutType){
		try {
			stockOutTypeService.insert(stockOutType);
			return new AjaxResult(true,"添加成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"添加失败!");
		}
	}
}
