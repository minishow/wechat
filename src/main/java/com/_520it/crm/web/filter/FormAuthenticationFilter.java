package com._520it.crm.web.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;

import com._520it.crm.log.LoginLogHandler;
import com._520it.crm.service.IEmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Setter;
/**
 * 这个类的方法只是用来进行登录成功和失败调用的
 * 其它请求的时候不调用
 * @author Manolin
 *
 */
/*自定义过滤器,进行原来的过滤器的*/
public class FormAuthenticationFilter extends org.apache.shiro.web.filter.authc.FormAuthenticationFilter {
	/*创建自定义的过滤器覆盖之前的过滤器,请求登录的时候
	依据请求的不同,返回网页和json格式数据*/
	@Setter
	private IEmployeeService emloyeeService;
	@Setter
	private LoginLogHandler loginLogHandler;
	/*@Setter
	private ISystemMenuService systemMenuService;*/
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject,
            ServletRequest request, ServletResponse response) throws Exception {
    	/*设置为false,表示不在继续往后走了*/
    	/**
    	 * 返回的数据格式
    	 * flag:true,msg:"",total:0,rows这样的数据格式
    	 */
    	response.setContentType("text/json;charset=utf-8");
    	Map<String,Object> map=new HashMap<>();
    	map.put("flag",true);
    	map.put("msg","登录成功");
    	ObjectMapper objectMapper=new ObjectMapper();
    	response.getWriter().write(objectMapper.writeValueAsString(map));
    	//-----------------------------
    	/*登录成功之后把数据菜单的信息存储到session当中,减少查询的次数,毕竟
    	一次会话之中,变动的机率会很小*/
    	/*List<SystemMenu> menus = systemMenuService.indexMenu();*/
    	/*把数据共享入session当中*/
    	/*SecurityUtils.getSubject().getSession().setAttribute("MENUS_IN_SESSION", menus);*/
    	//-----------------------------
    	/*记录日志*/
    	loginLogHandler.writeLoginLog();
    	
    	return false;
		}
	
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e,
	            ServletRequest request, ServletResponse response) {
		response.setContentType("text/json;charset=utf-8");
				Map<String,Object> map=new HashMap<>();
				map.put("flag",false);
				map.put("msg","登录失败");
				ObjectMapper objectMapper=new ObjectMapper();
				try {
					response.getWriter().write(objectMapper.writeValueAsString(map));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				return false;
		}
}
