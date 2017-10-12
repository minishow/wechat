package com._520it.crm.mapper;

import com._520it.crm.domain.Position;
import java.util.List;

public interface PositionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Position record);

    Position selectByPrimaryKey(Long id);

    List<Position> selectAll();

    int updateByPrimaryKey(Position record);
}