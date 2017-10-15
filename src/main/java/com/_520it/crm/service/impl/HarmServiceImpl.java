package com._520it.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Harm;
import com._520it.crm.mapper.HarmMapper;
import com._520it.crm.service.IHarmService;
@Service
public class HarmServiceImpl implements IHarmService {

	@Autowired
	private HarmMapper harmMapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		return harmMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Harm harm) {
		return harmMapper.insert(harm);
	}

	@Override
	public Harm selectByPrimaryKey(Long id) {
		return harmMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Harm> selectAll() {
		return harmMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Harm harm) {
		return harmMapper.updateByPrimaryKey(harm);
	}

}
