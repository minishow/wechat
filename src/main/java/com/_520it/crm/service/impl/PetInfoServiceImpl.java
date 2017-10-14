package com._520it.crm.service.impl;

import com._520it.crm.domain.MemberInfo;
import com._520it.crm.domain.PetInfo;
import com._520it.crm.mapper.PetInfoMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PetInfoQueryObject;
import com._520it.crm.service.IPetInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetInfoServiceImpl implements IPetInfoService {

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

    @Override
    public PageResult selectPetInfoList(PetInfoQueryObject qo) {


        PageResult pageResult = null;
        long pagetotal=petInfoMapper.queryMemberInfoByTotal(qo);
        if(pagetotal==0){
            return new PageResult(pagetotal,new ArrayList()) ;
        }
        List<MemberInfo> dataList = petInfoMapper.queryMemberInfoByList(qo);
        return new PageResult(pagetotal,dataList);
    }


}