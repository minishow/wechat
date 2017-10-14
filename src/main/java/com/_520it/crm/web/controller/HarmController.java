package com._520it.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Harm;
import com._520it.crm.service.IHarmService;

@Controller
@RequestMapping("/harm")
public class HarmController {
	@Autowired
	private IHarmService harmService;
	@RequestMapping("/list")
	@ResponseBody
	public List<Harm> list(){
		return harmService.selectAll();
	}
}
