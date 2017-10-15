package com._520it.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Employee;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.service.IEmployeeService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private IEmployeeService employeeService;
	@RequestMapping("")
	public String login(){
		/*跳转到login.jsp页面*/
		return "login";
	}
	@RequestMapping("/register")
	public String register(){
		return "register";
	}
	@RequestMapping("/loginRegister")
	@ResponseBody
	public AjaxResult loginRegister(Employee employee){
		try {
			employeeService.insert(employee);
			return new AjaxResult(true,"注册成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"注册失败");
		}
	}
}
