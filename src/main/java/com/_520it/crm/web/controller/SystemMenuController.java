package com._520it.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/systemMenu")
public class SystemMenuController {
	@RequestMapping("")
	public String systemMenu(){
		return "systemMenuNew";
	}
}
