package com._520it.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Brand;
import com._520it.crm.domain.MemberLevel;
import com._520it.crm.mapper.MemberLevelMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.MemberLevelQueryObject;
import com._520it.crm.service.IMemberLevelService;
@Service
public class MemberLevelServiceImpl implements IMemberLevelService {

	@Autowired
	private MemberLevelMapper memberLevelMapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		return memberLevelMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(MemberLevel memberLevel) {
		return memberLevelMapper.insert(memberLevel);
	}

	@Override
	public MemberLevel selectByPrimaryKey(Long id) {
		return memberLevelMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<MemberLevel> selectAll() {
		return memberLevelMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(MemberLevel memberLevel) {
		return memberLevelMapper.updateByPrimaryKey(memberLevel);
	}

	@Override
	public PageResult query(MemberLevelQueryObject qo) {
		Long total=memberLevelMapper.queryForCount(qo);
		if(total==0){
			return new PageResult(new Long(0),new ArrayList<Brand>());
		}
		List<Brand> rows=memberLevelMapper.queryForList(qo);
		return new PageResult(total,rows);
	}

	@Override
	public void changeState(Long id) {
		memberLevelMapper.changeState(id);
	}

}
