package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.LoginLog;

public interface ILoginLogService {
    int deleteByPrimaryKey(Long id);

    int insert(LoginLog loginLog);

    LoginLog selectByPrimaryKey(Long id);

    List<LoginLog> selectAll();

    int updateByPrimaryKey(LoginLog loginLog);
}
