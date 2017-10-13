package com._520it.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Location;
import com._520it.crm.mapper.LocationMapper;
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

}
