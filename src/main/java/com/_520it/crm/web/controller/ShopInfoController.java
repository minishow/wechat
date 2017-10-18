package com._520it.crm.web.controller;

import com._520it.crm.domain.ShopInfo;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.service.IShopInfoService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

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
		/*把登录用户关联店主的店铺信息查询出来,如果本身就是店主登录,直接显示店主店铺信息*/
		/*ShopInfo shopInfo=shopInfoService.queryMessagesOfBoss();*/
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
			return new AjaxResult(true,"修改成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"修改失败!");
		}
	}
	@RequestMapping("/changeImg")
	@ResponseBody
	public AjaxResult changeImg(MultipartFile file,HttpServletRequest request,Long id){
		try {
			String originalFilename = file.getOriginalFilename();
			/*获取上下文路径*/
			ServletContext servletContext = request.getSession().getServletContext();
			String realPath = servletContext.getRealPath("/static/img/shopInfo");
			String name=UUID.randomUUID().toString();
			String suffix=StringUtils.getFilenameExtension(originalFilename);
			String imgName=name+"."+suffix;
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath,imgName));
			/*数据库操作*/
			ShopInfo shopInfo = shopInfoService.selectByPrimaryKey(id);
			String img = shopInfo.getImg();
			new File(realPath,img).delete();
			shopInfoService.updateImg(id,imgName);
			return new AjaxResult(true,imgName);
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"图片修改失败!");
		}
	}
}
