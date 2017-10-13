package com._520it.crm.service.impl;

import com._520it.crm.domain.PetServiceMenu;
import com._520it.crm.mapper.PetServiceMenuMapper;
import com._520it.crm.service.IPetServiceMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceMenuServiceImpl implements IPetServiceMenuService {

    @Autowired
    private PetServiceMenuMapper petServiceMenuMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return petServiceMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PetServiceMenu record) {
        return petServiceMenuMapper.insert(record);
    }

    @Override
    public PetServiceMenu selectByPrimaryKey(Long id) {
        return petServiceMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PetServiceMenu> selectAll() {
        return petServiceMenuMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(PetServiceMenu record) {
        return petServiceMenuMapper.updateByPrimaryKey(record);
    }
}
