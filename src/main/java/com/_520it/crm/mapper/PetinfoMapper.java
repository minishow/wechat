package com._520it.crm.mapper;

import com._520it.crm.domain.Petinfo;
import java.util.List;

public interface PetinfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Petinfo record);

    Petinfo selectByPrimaryKey(Long id);

    List<Petinfo> selectAll();

    int updateByPrimaryKey(Petinfo record);
}