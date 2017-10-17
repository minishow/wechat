package com._520it.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Brand;
import com._520it.crm.domain.LoginLog;
import com._520it.crm.mapper.LoginLogMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.LoginLogQueryObject;
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

	@Override
	public PageResult query(LoginLogQueryObject qo) {
		Long total=loginLogMapper.queryForCount(qo);
		if(total==0){
			return new PageResult(new Long(0),new ArrayList<Brand>());
		}
		List<LoginLog> rows=loginLogMapper.queryForList(qo);
		return new PageResult(total,rows);
	}

	@Override
	public void changeState(Long id) {
		loginLogMapper.changeState(id);
	}

}
