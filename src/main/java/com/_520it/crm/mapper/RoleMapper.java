package com._520it.crm.mapper;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Role;
import com._520it.crm.query.EmployeeQueryObject;
import com._520it.crm.query.QueryObject;
import com._520it.crm.query.RoleQueryObject;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    Role selectByPrimaryKey(Long id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    Long selectByCount(RoleQueryObject qo);

    List<Role> selectByPageList(RoleQueryObject qo);
}