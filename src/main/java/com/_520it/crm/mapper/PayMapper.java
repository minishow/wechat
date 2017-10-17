package com._520it.crm.mapper;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Pay;
import com._520it.crm.query.EmployeeQueryObject;
import com._520it.crm.query.PayQueryObject;
import com._520it.crm.query.QueryObject;

import java.util.List;

public interface PayMapper {

    Long selectByCount(PayQueryObject qo);

    List<Pay> selectByPageList(PayQueryObject qo);
}