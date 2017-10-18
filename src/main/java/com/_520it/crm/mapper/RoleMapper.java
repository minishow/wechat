package com._520it.crm.mapper;

import com._520it.crm.domain.Role;

import java.util.List;
import java.util.Map;

public interface RoleMapper {

    Role selectByPrimaryKey(Long id);

    List<Role> selectAll();

    Long selectByCount();

    List<Map> selectByPageList();

    List<Long> selectRoleByEmployeeId(Long employeeId);

    /**
     * 根据员工id查询拥有的全部角色
     * @param id
     * @return
     */
	List<Role> queryRolesByEmployeeId(Long id);

}