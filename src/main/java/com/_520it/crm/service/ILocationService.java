package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.Location;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.LocationQueryObject;

public interface ILocationService {
    int deleteByPrimaryKey(Long id);

    int insert(Location location);

    Location selectByPrimaryKey(Long id);

    List<Location> selectAll();

    int updateByPrimaryKey(Location location);

	PageResult query(LocationQueryObject qo);

	void changeState(Long id);
}
