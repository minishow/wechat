package com._520it.crm.service.impl;

import com._520it.crm.domain.MemberInfo;
import com._520it.crm.mapper.MemberInfoMapper;
import com._520it.crm.service.IMemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberinfoServiceImpl implements IMemberInfoService {



    @Autowired
    private MemberInfoMapper memberInfoMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {


        return memberInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MemberInfo record) {

        return memberInfoMapper.insert(record);
    }

    @Override
    public MemberInfo selectByPrimaryKey(Long id) {

        return memberInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<MemberInfo> selectAll() {

        return memberInfoMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(MemberInfo record) {

        return memberInfoMapper.updateByPrimaryKey(record);
    }
}
