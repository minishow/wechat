package com._520it.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.LoginLog;
import com._520it.crm.mapper.LoginLogMapper;
import com._520it.crm.service.ILoginLogService;
@Service
public class LoginLogServiceImpl implements ILoginLogService {

	@Autowired
	private LoginLogMapper loginLogMapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		return loginLogMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(LoginLog loginLog) {
		return loginLogMapper.insert(loginLog);
	}

	@Override
	public LoginLog selectByPrimaryKey(Long id) {
		return loginLogMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<LoginLog> selectAll() {
		return loginLogMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(LoginLog loginLog) {
		return loginLogMapper.updateByPrimaryKey(loginLog);
	}

}
