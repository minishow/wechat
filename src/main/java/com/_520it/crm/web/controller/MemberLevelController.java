package com._520it.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.MemberLevel;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.MemberLevelQueryObject;
import com._520it.crm.service.IMemberLevelService;

import java.util.List;

@Controller
@RequestMapping("/memberLevel")
public class MemberLevelController {
	@Autowired
	private IMemberLevelService memberLevelService;
	@RequestMapping("")
	public String memberLevel(){
		/*跳转到web-inf下资源*/
		return "memberLevel";
	}
	@RequestMapping("/query")
	@ResponseBody
	public PageResult list(MemberLevelQueryObject qo){
		PageResult pageResult = null;
		try {
			pageResult=memberLevelService.query(qo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageResult;
	}
	@RequestMapping("/queryAll")
	@ResponseBody
	public List<MemberLevel> listAll( ){
		List<MemberLevel> list = null;
		try {
			 list = memberLevelService.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long id){
		try {
			memberLevelService.changeState(id);
			return new AjaxResult(true,"更改成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"更改失败!");
		}
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(MemberLevel memberLevel){
		try {
			memberLevelService.insert(memberLevel);
			return new AjaxResult(true,"添加成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"添加失败!");
		}
	}


}
