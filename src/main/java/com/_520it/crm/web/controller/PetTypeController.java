package com._520it.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.PetType;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PetTypeQueryObject;
import com._520it.crm.service.IPetTypeService;

@Controller
@RequestMapping("/petType")
public class PetTypeController {
	@Autowired
	private IPetTypeService petTypeService;
	@RequestMapping("")
	public String petType(){
		/*跳转到web-inf下资源*/
		return "petType";
	}
	@RequestMapping("/list")
	@ResponseBody
	public List<PetType> list(){
		return petTypeService.selectAll();
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(PetType petType){
		try {
			petTypeService.insert(petType);
			return new AjaxResult(true,"添加成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"添加失败!");
		}
	}
	@RequestMapping("/query")
	@ResponseBody
	public PageResult list(PetTypeQueryObject qo){
		PageResult pageResult = null;
		try {
			pageResult=petTypeService.query(qo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageResult;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long id){
		try {
			petTypeService.changeState(id);
			return new AjaxResult(true,"更改成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"更改失败!");
		}
	}
}
