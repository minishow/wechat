package com._520it.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.PetKind;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PetKindQueryObject;
import com._520it.crm.service.IPetKindService;

@Controller
@RequestMapping("/petKind")
public class PetKindController {
	@Autowired
	private IPetKindService petKindService;
	@RequestMapping("")
	public String petKind(){
		/*跳转到web-inf下资源*/
		return "petKind";
	}
	@RequestMapping("/query")
	@ResponseBody
	public PageResult query(PetKindQueryObject qo){
		PageResult pageResult = null;
		try {
			pageResult=petKindService.query(qo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageResult;
	}
	@RequestMapping("/list")
	@ResponseBody
	public List<PetKind> list(){
		return petKindService.selectAll();
	}
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long id){
		try {
			petKindService.changeState(id);
			return new AjaxResult(true,"更改成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"更改失败!");
		}
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(PetKind petKind){
		try {
			petKindService.insert(petKind);
			return new AjaxResult(true,"添加成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"添加失败!");
		}
	}
}
