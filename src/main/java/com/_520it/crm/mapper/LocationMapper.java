package com._520it.crm.mapper;

import com._520it.crm.domain.Location;
import com._520it.crm.query.LocationQueryObject;

import java.util.List;

public interface LocationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Location location);

    Location selectByPrimaryKey(Long id);

    List<Location> selectAll();

    int updateByPrimaryKey(Location location);

	Long queryForCount(LocationQueryObject qo);

	List<Location> queryForList(LocationQueryObject qo);

	void changeState(Long id);
}