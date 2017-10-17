package com._520it.crm.mapper;

import com._520it.crm.domain.Membertop;
import com._520it.crm.query.MembertopQueryObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MembertopMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Membertop record);

    Membertop selectByPrimaryKey(Long id);

    List<Membertop> selectAll();

    int updateByPrimaryKey(Membertop record);

    long queryMemberTopByTotal(MembertopQueryObject qo);

    List<Membertop> queryMemberTopByList(MembertopQueryObject qo);
}