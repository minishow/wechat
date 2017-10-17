package com._520it.crm.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Role;
import com._520it.crm.service.IEmployeeService;
import com._520it.crm.service.IRoleService;

import lombok.Setter;

public class UserRealm extends AuthorizingRealm{

	@Setter
	private IEmployeeService employeeService;
	@Setter
	private IRoleService roleService;
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
		 * 进行角色分配
		 */
		Employee employee = (Employee) principals.getPrimaryPrincipal();
		List<Role> roles=roleService.queryRolesByEmployeeId(employee.getId());
		List<String> rolesStr=new ArrayList<>();
		for(Role role:roles){
			rolesStr.add(role.getSn());
		}
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		info.addRoles(rolesStr);
		return info;
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
