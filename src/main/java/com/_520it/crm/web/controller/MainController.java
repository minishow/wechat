package com._520it.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	public MainController(){
		System.out.println("......................");
	}
	@RequestMapping("/main")
	public String main(){
		return "main";
	}
}
