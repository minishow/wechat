package com._520it.crm.service.impl;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Position;
import com._520it.crm.mapper.PositionMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PositionQueryObject;
import com._520it.crm.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PositionServiceImpl implements IPositionService {

    @Autowired
    private PositionMapper positionMapper;

    public int deleteByPrimaryKey(Long id) {
        return positionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Position record) {
        return positionMapper.insert(record);
    }

    @Override
    public Position selectByPrimaryKey(Long id) {
        return positionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Position> selectAll() {
        return positionMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Position record) {
        return positionMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult queryByPageList(PositionQueryObject qo) {
        Long count = positionMapper.selectByCount(qo);
        if(count <= 0){
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        List<Position> data = positionMapper.selectByPageList(qo);
        return new PageResult(count,data);
    }
}
