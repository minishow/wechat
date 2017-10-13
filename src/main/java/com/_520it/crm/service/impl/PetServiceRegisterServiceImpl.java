package com._520it.crm.service.impl;

import com._520it.crm.domain.PetServiceRegister;
import com._520it.crm.mapper.PetServiceRegisterMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PetServiceRegisterQueryObject;
import com._520it.crm.service.IPetServiceRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

    @Override
    public PageResult queryPage(PetServiceRegisterQueryObject qo) {
        Long count = petServiceRegisterMapper.queryForCount(qo);
        if(count <= 0){
            return new PageResult(0L, Collections.EMPTY_LIST);
        }
        List<PetServiceRegister> result =  petServiceRegisterMapper.queryForList(qo);
        return new PageResult(count, result);
    }

    @Override
    public void startService() {
        petServiceRegisterMapper.startService();
    }

    @Override
    public void endService() {
        petServiceRegisterMapper.endService();
    }
}
