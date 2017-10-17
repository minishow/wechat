package com._520it.crm.log;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.LoginLog;
import com._520it.crm.service.ILoginLogService;
@Component
public class LoginLogHandler {
	@Autowired
	private ILoginLogService loginLogService;
	public void writeLoginLog(){
		LoginLog log=new LoginLog();
		/*引入全局Request请求对象*/
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		/*从session中取出employee对象*/
		Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
		log.setLoginTime(new Date());
		log.setIp(request.getRemoteAddr());
		log.setEmployee(employee);
		/*物理地址: ‎74-2F-68-56-BE-62*/
		log.setMac("74-2F-68-56-BE-62");
		log.setState(1);
		loginLogService.insert(log);
	}
}
