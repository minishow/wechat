package com._520it.crm.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com._520it.crm.domain.Employee;
import com._520it.crm.service.IEmployeeService;

import lombok.Setter;

public class UserRealm extends AuthorizingRealm{

	@Setter
	private IEmployeeService employeeService;
	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}
	/**
	 * 授权方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		/**
		 * 暂时不做任何授权操作
		 */
		return null;
	}
	/**
	 * 认证方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		Employee employee=employeeService.selectEmployeeByUsername(username);
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(employee,employee.getPassword(),this.getName());
		return info;
	}

}
