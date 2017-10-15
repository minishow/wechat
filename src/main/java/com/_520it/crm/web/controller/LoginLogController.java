package com._520it.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.LoginLogQueryObject;
import com._520it.crm.service.ILoginLogService;

@Controller
@RequestMapping("/loginLog")
public class LoginLogController {
	@Autowired
	private ILoginLogService loginLogService;
	@RequestMapping("")
	public String loginLog(){
		/*跳转到web-inf下资源*/
		return "loginLog";
	}
	@RequestMapping("/query")
	@ResponseBody
	public PageResult query(LoginLogQueryObject qo){
		PageResult pageResult = null;
		try {
			pageResult=loginLogService.query(qo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageResult;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(Long id){
		try {
			loginLogService.changeState(id);
			return new AjaxResult(true,"更改成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"更改失败!");
		}
	}
}
