package com._520it.crm.service.impl;

import com._520it.crm.domain.PetServiceCash;
import com._520it.crm.mapper.PetServiceCashMapper;
import com._520it.crm.service.IPetServiceCashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceCashServiceImpl implements IPetServiceCashService {

    @Autowired
    private PetServiceCashMapper petServiceCashMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return petServiceCashMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PetServiceCash record) {
        return petServiceCashMapper.insert(record);
    }

    @Override
    public PetServiceCash selectByPrimaryKey(Long id) {
        return petServiceCashMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PetServiceCash> selectAll() {
        return petServiceCashMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(PetServiceCash record) {
        return petServiceCashMapper.updateByPrimaryKey(record);
    }
}
