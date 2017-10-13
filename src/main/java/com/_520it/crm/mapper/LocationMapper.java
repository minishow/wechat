package com._520it.crm.mapper;

import com._520it.crm.domain.Location;
import java.util.List;

public interface LocationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Location location);

    Location selectByPrimaryKey(Long id);

    List<Location> selectAll();

    int updateByPrimaryKey(Location location);
}