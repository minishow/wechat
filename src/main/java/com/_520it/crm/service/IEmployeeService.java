package com._520it.crm.service;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.LeaveRecord;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQueryObject;

import java.util.List;

public interface IEmployeeService {
    //离职
    int dimissionByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);
    /**
     * @param qo 分页
     * */
    PageResult queryByPageList(EmployeeQueryObject qo);

    List<Employee> selectListByLeaveRecord();

}
