package com._520it.crm.mapper;

import com._520it.crm.domain.Memberinfo;
import java.util.List;

public interface MemberinfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Memberinfo record);

    Memberinfo selectByPrimaryKey(Long id);

    List<Memberinfo> selectAll();

    int updateByPrimaryKey(Memberinfo record);
}