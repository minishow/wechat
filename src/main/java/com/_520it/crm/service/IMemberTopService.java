package com._520it.crm.service;

import com._520it.crm.domain.Membertop;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.MembertopQueryObject;

import java.util.List;

public interface IMemberTopService {
    int deleteByPrimaryKey(Long id);

    int insert(Membertop record);

    Membertop selectByPrimaryKey(Long id);

    List<Membertop> selectAll();

    int updateByPrimaryKey(Membertop record);

    PageResult queryMemberByList(MembertopQueryObject qo);

}
