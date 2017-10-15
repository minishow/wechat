package com._520it.crm.mapper;

import java.util.List;

import com._520it.crm.domain.LoginLog;
import com._520it.crm.query.LoginLogQueryObject;

public interface LoginLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LoginLog loginLog);

    LoginLog selectByPrimaryKey(Long id);

    List<LoginLog> selectAll();

    int updateByPrimaryKey(LoginLog loginLog);

	Long queryForCount(LoginLogQueryObject qo);

	List<LoginLog> queryForList(LoginLogQueryObject qo);

	void changeState(Long id);
}