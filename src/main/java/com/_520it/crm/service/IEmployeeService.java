package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.Employee;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQueryObject;

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


	Employee selectEmployeeByUsername(String username);

    List<Employee> selectListByLeaveRecord();

	Boolean checkPassword(String oldPassword);

	void changePassword(String newPassword);

	void checkEmailToDB(String email);

}
