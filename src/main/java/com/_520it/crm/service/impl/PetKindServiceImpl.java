package com._520it.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.PetKind;
import com._520it.crm.mapper.PetKindMapper;
import com._520it.crm.service.IPetKindService;
@Service
public class PetKindServiceImpl implements IPetKindService {
	@Autowired
	private PetKindMapper petKindMapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		return petKindMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(PetKind petKind) {
		return petKindMapper.insert(petKind);
	}

	@Override
	public PetKind selectByPrimaryKey(Long id) {
		return petKindMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<PetKind> selectAll() {
		return petKindMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(PetKind petKind) {
		return petKindMapper.updateByPrimaryKey(petKind);
	}

}
