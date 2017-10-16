package com._520it.crm.service.impl;

import com._520it.crm.domain.Membertop;
import com._520it.crm.mapper.MembertopMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.MembertopQueryObject;
import com._520it.crm.service.IMemberTopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberTopServiceImpl implements IMemberTopService {

    @Autowired
    private MembertopMapper membertopMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {

        return membertopMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Membertop record) {

        return membertopMapper.insert(record);
    }

    @Override
    public Membertop selectByPrimaryKey(Long id) {
        return membertopMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Membertop> selectAll() {
        return membertopMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Membertop record) {
        return membertopMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult queryMemberByList(MembertopQueryObject qo) {

        PageResult pageResult = null;
        long total = membertopMapper.queryMemberTopByTotal(qo);
        if (total==0){
            return new PageResult(total,new ArrayList());
        }
        List<Membertop> list = membertopMapper.queryMemberTopByList(qo);


        return new PageResult(total,list);
    }

}
