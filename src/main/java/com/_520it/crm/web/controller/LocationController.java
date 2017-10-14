package com._520it.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Location;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.LocationQueryObject;
import com._520it.crm.service.ILocationService;

@Controller
@RequestMapping("/location")
public class LocationController {
	@Autowired
	private ILocationService locationService;
	@RequestMapping("/list")
	@ResponseBody
	public List<Location> list(){
		/*
		 * 查询全部的地址信息,给添加品牌的时候下来选择
		 */
		return locationService.selectAll();
	}
	@RequestMapping("")
	public String location(){
		/*跳转到web-inf下资源*/
		return "location";
	}
	@RequestMapping("/query")
	@ResponseBody
	public PageResult list(LocationQueryObject qo){
		PageResult pageResult = null;
		try {
			pageResult=locationService.query(qo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageResult;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long id){
		try {
			locationService.changeState(id);
			return new AjaxResult(true,"更改成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"更改失败!");
		}
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(Location location){
		try {
			locationService.insert(location);
			return new AjaxResult(true,"添加成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"添加失败!");
		}
	}
}
