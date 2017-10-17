package com._520it.crm.service;

import com._520it.crm.domain.Position;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PositionQueryObject;

import java.util.List;

public interface IPositionService {
    int deleteByPrimaryKey(Long id);

    int insert(Position record);

    Position selectByPrimaryKey(Long id);

    List<Position> selectAll();

    int updateByPrimaryKey(Position record);

    PageResult queryByPageList(PositionQueryObject qo);
}
