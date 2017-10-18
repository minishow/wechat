package com._520it.crm.service;

import com._520it.crm.domain.Role;
import com._520it.crm.util.EmployeeRoleVO;

import java.util.List;
import java.util.Map;

public interface IRoleService {
    

    Role selectByPrimaryKey(Long id);

    List<Role> selectAll();


    List<Map> queryByPageList();
    /*
     * 根据员工的id查询全部的角色列表
     */
	List<Role> queryRolesByEmployeeId(Long id);


    int inputRoleByEmployee(EmployeeRoleVO employee);

    List<Long> selectRoleByEmployeeId(Long employeeId);
}
