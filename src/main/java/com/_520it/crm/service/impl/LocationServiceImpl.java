package com._520it.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Brand;
import com._520it.crm.domain.Location;
import com._520it.crm.mapper.LocationMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.LocationQueryObject;
import com._520it.crm.service.ILocationService;
@Service
public class LocationServiceImpl implements ILocationService {

	@Autowired
	private LocationMapper locationMapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		return locationMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Location location) {
		return locationMapper.insert(location);
	}

	@Override
	public Location selectByPrimaryKey(Long id) {
		return locationMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Location> selectAll() {
		return locationMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Location location) {
		return locationMapper.updateByPrimaryKey(location);
	}

	@Override
	public PageResult query(LocationQueryObject qo) {
		Long total=locationMapper.queryForCount(qo);
		if(total==0){
			return new PageResult(new Long(0),new ArrayList<Brand>());
		}
		List<Location> rows=locationMapper.queryForList(qo);
		return new PageResult(total,rows);
	}

	@Override
	public void changeState(Long id) {
		locationMapper.changeState(id);
	}

}
