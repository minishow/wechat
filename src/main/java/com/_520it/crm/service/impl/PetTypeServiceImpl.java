package com._520it.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.PetType;
import com._520it.crm.mapper.PetTypeMapper;
import com._520it.crm.service.IPetTypeService;
@Service 
public class PetTypeServiceImpl implements IPetTypeService {
	@Autowired
	private PetTypeMapper petTypeMapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		return petTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(PetType petType) {
		return petTypeMapper.insert(petType);
	}

	@Override
	public PetType selectByPrimaryKey(Long id) {
		return petTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<PetType> selectAll() {
		return petTypeMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(PetType petType) {
		return petTypeMapper.updateByPrimaryKey(petType);
	}

}
