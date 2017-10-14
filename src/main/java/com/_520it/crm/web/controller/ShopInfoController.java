package com._520it.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.ShopInfo;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.service.IShopInfoService;

@Controller
@RequestMapping("/shopInfo")
public class ShopInfoController {
	@Autowired
	private IShopInfoService shopInfoService;
	@RequestMapping("")
	public String shopInfo(Model model){
		/*
		 * 根据登录用户去查询显示哪个店铺的信息
		 */
		ShopInfo shopInfo = shopInfoService.selectByPrimaryKey(1L);
		model.addAttribute(shopInfo);
		return "shopInfo";
	}
	@RequestMapping("/queryForEdit")
	@ResponseBody
	public ShopInfo queryForEdit(){
		return shopInfoService.selectByPrimaryKey(1L);
	}
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult save(ShopInfo shopInfo){
		try {
			shopInfoService.updateByPrimaryKey(shopInfo);
			return new AjaxResult(true,"添加成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"添加失败!");
		}
	}
}
