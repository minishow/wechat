package com._520it.crm.web.controller;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Employee;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.service.IEmployeeService;
import com._520it.crm.util.VerifyCodeUtils;


@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private IEmployeeService employeeService;
	@RequestMapping("")
	public String login(HttpServletRequest request,Model model){
		/*每次登录之前删除全部验证码图片*/
		FileUtil.deleteContents(new File(request.getSession().getServletContext().getRealPath("/static/img/loginCheck")));
		/*跳转到login.jsp页面*/
		/*产生验证码并且把验证码信息传递给前台,前台使用EL表达式取值*/
		/*得到随机码6个随机码*/
		String randomCode=VerifyCodeUtils.generateVerifyCode(6);
		String codeImgName=UUID.randomUUID().toString()+".jpg";
		/*把图片保存到服务器*/
		File outputFile=new File(request.getSession().getServletContext().getRealPath("/static/img/loginCheck"),codeImgName);
		try {
			VerifyCodeUtils.outputImage(104, 22, outputFile, randomCode);
		} catch (IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("codeImgName", codeImgName);
		model.addAttribute("randomCode", randomCode);
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
	@RequestMapping("/clickChangeValidateImg")
	@ResponseBody
	public AjaxResult clickChangeValidateImg(String imgName,HttpServletRequest request){
		try {
			String realDir = request.getSession().getServletContext().getRealPath("/static/img/loginCheck");
			/*删除原来图片*/
			new File(realDir,imgName).delete();
			/*得到随机码6个随机码*/
			String randomCode=VerifyCodeUtils.generateVerifyCode(6);
			String codeImgName=UUID.randomUUID().toString()+".jpg";
			File outputFile=new File(realDir,codeImgName);
			VerifyCodeUtils.outputImage(104, 22, outputFile, randomCode);
			/*把图片保存到服务器*/
			return new AjaxResult(true,"/static/img/loginCheck/"+codeImgName+"="+randomCode);
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"");
		}
	}
	@RequestMapping("/deleteValidateImg")
	@ResponseBody
	public AjaxResult deleteValidateImg(String imgName,HttpServletRequest request){
		try {
			new File(request.getSession().getServletContext().getRealPath("/static/img/loginCheck"),imgName).delete();
			return new AjaxResult(true,"删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"删除成功");
		}
	}
}
