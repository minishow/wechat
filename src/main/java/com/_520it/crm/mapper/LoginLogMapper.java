package com._520it.crm.mapper;

import com._520it.crm.domain.LoginLog;
import java.util.List;

public interface LoginLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LoginLog loginLog);

    LoginLog selectByPrimaryKey(Long id);

    List<LoginLog> selectAll();

    int updateByPrimaryKey(LoginLog loginLog);
}