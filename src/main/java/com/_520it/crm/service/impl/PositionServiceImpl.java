package com._520it.crm.service.impl;

import com._520it.crm.domain.Position;
import com._520it.crm.mapper.PositionMapper;
import com._520it.crm.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements IPositionService {

    @Autowired
    private PositionMapper employeeMapper;

    public int deleteByPrimaryKey(Long id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Position record) {
        return employeeMapper.insert(record);
    }

    @Override
    public Position selectByPrimaryKey(Long id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Position> selectAll() {
        return employeeMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Position record) {
        return employeeMapper.updateByPrimaryKey(record);
    }
}
