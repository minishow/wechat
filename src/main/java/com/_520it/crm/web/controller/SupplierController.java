package com._520it.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Supplier;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.SupplierQueryObject;
import com._520it.crm.service.ISupplierService;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
	@Autowired
	private ISupplierService supplierService;
	@RequestMapping("")
	public String supplier(){
		/*跳转到web-inf下资源*/
		return "supplier";
	}
	@RequestMapping("/query")
	@ResponseBody
	public PageResult query(SupplierQueryObject qo){
		PageResult pageResult = null;
		try {
			pageResult=supplierService.query(qo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageResult;
	}
	@RequestMapping("/list")
	@ResponseBody
	public List<Supplier> list(){
		return supplierService.selectAll();
	}
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long id){
		try {
			supplierService.changeState(id);
			return new AjaxResult(true,"更改成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"更改失败!");
		}
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(Supplier supplier){
		try {
			supplierService.insert(supplier);
			return new AjaxResult(true,"添加成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"添加失败!");
		}
	}
}
