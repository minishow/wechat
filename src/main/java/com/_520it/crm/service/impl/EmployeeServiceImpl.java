package com._520it.crm.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Employee;
import com._520it.crm.mapper.EmployeeMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQueryObject;
import com._520it.crm.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public int deleteByPrimaryKey(Long id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Employee record) {
        return employeeMapper.insert(record);
    }

    @Override
    public Employee selectByPrimaryKey(Long id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Employee> selectAll() {
        return employeeMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Employee record) {
        return employeeMapper.updateByPrimaryKey(record);
    }
    //分页数据操作
    public PageResult queryByPageList(EmployeeQueryObject qo) {
        Long count = employeeMapper.selectByCount(qo);
        if(count <= 0){
            return new PageResult(0L,Collections.EMPTY_LIST);
        }
        List<Employee> data = employeeMapper.selectByPageList(qo);
        return new PageResult(count,data);
    }
    /**
     * 添加根据username来查询Employee对象的方法
     */
	@Override
	public Employee selectEmployeeByUsername(String username) {
		return employeeMapper.selectEmployeeByUsername(username);
	}
}
