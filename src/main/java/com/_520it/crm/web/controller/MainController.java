package com._520it.crm.web.controller;

import com._520it.crm.domain.Employee;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	public MainController(){
	}
	@RequestMapping("/main")
	public String main(Model model){
		String name=((Employee) SecurityUtils.getSubject().getPrincipal()).getName();
		model.addAttribute("name", name);
		return "main";
	}
}
