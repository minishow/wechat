package com._520it.crm.service.impl;

import com._520it.crm.domain.Brand;
import com._520it.crm.domain.Harm;
import com._520it.crm.domain.PetKind;
import com._520it.crm.mapper.HarmMapper;
import com._520it.crm.mapper.PetKindMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PetKindQueryObject;
import com._520it.crm.service.IPetKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PetKindServiceImpl implements IPetKindService {
	@Autowired
	private PetKindMapper petKindMapper;

	@Autowired
	private HarmMapper harmMapper;
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

	@Override
	public List<PetKind> selectKindAll(Long kindID) {

		return petKindMapper.selectKindAll(kindID);
	}

	/**
	 * 过敏物查询
	 * @return
     */
	@Override
	public List<Harm> addHarmList() {
		return harmMapper.selectAll();
	}
	@Override
	public PageResult query(PetKindQueryObject qo) {
		Long total=petKindMapper.queryForCount(qo);
		if(total==0){
			return new PageResult(new Long(0),new ArrayList<Brand>());
		}
		List<PetKind> rows=petKindMapper.queryForList(qo);
		return new PageResult(total,rows);
	}

	@Override
	public void changeState(Long id) {
		petKindMapper.changeState(id);
	}

	@Override
	public List<PetKind> queryKindByTypeId(Long id) {
		return petKindMapper.queryKindByTypeId(id);
	}

}
