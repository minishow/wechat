package com._520it.crm.mapper;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Position;
import com._520it.crm.query.PositionQueryObject;
import java.util.List;

public interface PositionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Position record);

    Position selectByPrimaryKey(Long id);

    List<Position> selectAll();

    int updateByPrimaryKey(Position record);

    Long selectByCount(PositionQueryObject qo);

    List<Position> selectByPageList(PositionQueryObject qo);
}