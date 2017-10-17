package com._520it.crm.service.impl;

import com._520it.crm.domain.Brand;
import com._520it.crm.domain.Location;
import com._520it.crm.domain.PetType;
import com._520it.crm.mapper.PetTypeMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PetTypeQueryObject;
import com._520it.crm.service.IPetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

	@Override
	public PageResult query(PetTypeQueryObject qo) {
		Long total=petTypeMapper.queryForCount(qo);
		if(total==0){
			return new PageResult(new Long(0),new ArrayList<Brand>());
		}
		List<Location> rows=petTypeMapper.queryForList(qo);
		return new PageResult(total,rows);
	}

	@Override
	public void changeState(Long id) {
		petTypeMapper.changeState(id);
	}

}
