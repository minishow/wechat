package com._520it.crm.service.impl;

import com._520it.crm.domain.Employee;
import com._520it.crm.mapper.EmployeeMapper;
import com._520it.crm.service.IEmployeeService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
