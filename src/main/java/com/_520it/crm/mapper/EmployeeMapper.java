package com._520it.crm.mapper;

import com._520it.crm.domain.Employee;
import com._520it.crm.query.EmployeeQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    int dimissionByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);

    Long selectByCount(EmployeeQueryObject qo);

    List<Employee> selectByPageList(EmployeeQueryObject qo);

    /*
     * 根据username查询出对象
     */
	Employee selectEmployeeByUsername(String username);


    List<Employee> selectListByLeaveRecord();

	void updatePasswordByEmployeeId(@Param("newPassword")String newPassword, @Param("employeeId")Long id);

}