package com._520it.crm.service.impl;

import com._520it.crm.domain.PetInfo;
import com._520it.crm.mapper.PetInfoMapper;
import com._520it.crm.service.IPetInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PetinfoServiceImpl implements IPetInfoService {

    @Autowired
    private PetInfoMapper petInfoMapper;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return petInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PetInfo record) {

        return petInfoMapper.insert(record);
    }

    @Override
    public PetInfo selectByPrimaryKey(Long id) {

        return petInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PetInfo> selectAll() {

        return petInfoMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(PetInfo record) {

        return petInfoMapper.updateByPrimaryKey(record);
    }
}
