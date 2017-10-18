package com._520it.crm.service.impl;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Role;
import com._520it.crm.mapper.EmployeeMapper;
import com._520it.crm.mapper.RoleMapper;
import com._520it.crm.service.IRoleService;
import com._520it.crm.util.EmployeeRoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private EmployeeMapper employeeMapper;



    @Override
    public Role selectByPrimaryKey(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }



    public List<Map> queryByPageList() {
        List<Map> data = roleMapper.selectByPageList();
        return data;
    }

	public List<Role> queryRolesByEmployeeId(Long id) {
		 /*
	     * 根据员工的id查询全部的角色列表
	     */
		return roleMapper.queryRolesByEmployeeId(id);
	}

	@Override
    public int inputRoleByEmployee(EmployeeRoleVO e) {
        employeeMapper.deleteByRelevance(e.getE_id()); //删除中间表
        System.out.println(e);
        Employee employee =  employeeMapper.selectByPrimaryKey(e.getE_id());
        employee.setPassword(e.getE_password());
        employee.setRealName(e.getE_realName());
        employee.setTel(e.getE_tel());
        employee.setLoginTime(new Date());
        employeeMapper.inputRoleByEmployee(employee);
        //再保存中间表..维护中间表
        if(e.getR_id() != null && e.getE_id() != null){
            employeeMapper.insertByRelevance(e.getE_id(),e.getR_id());
        }
        return 0;
    }

	@Override
    public List<Long> selectRoleByEmployeeId(Long employeeId) {
        return roleMapper.selectRoleByEmployeeId(employeeId);
    }
}

