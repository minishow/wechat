package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.LoginLog;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.LoginLogQueryObject;

public interface ILoginLogService {
    int deleteByPrimaryKey(Long id);

    int insert(LoginLog loginLog);

    LoginLog selectByPrimaryKey(Long id);

    List<LoginLog> selectAll();

    int updateByPrimaryKey(LoginLog loginLog);

	PageResult query(LoginLogQueryObject qo);

	void changeState(Long id);
}
