package com._520it.crm.service.impl;

import com._520it.crm.domain.PetServiceRegister;
import com._520it.crm.mapper.PetServiceRegisterMapper;
import com._520it.crm.service.IPetServiceRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceRegisterServiceImpl implements IPetServiceRegisterService {

    @Autowired
    private PetServiceRegisterMapper petServiceRegisterMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return petServiceRegisterMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PetServiceRegister record) {
        return petServiceRegisterMapper.insert(record);
    }

    @Override
    public PetServiceRegister selectByPrimaryKey(Long id) {
        return petServiceRegisterMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PetServiceRegister> selectAll() {
        return petServiceRegisterMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(PetServiceRegister record) {
        return petServiceRegisterMapper.updateByPrimaryKey(record);
    }
}
