package com._520it.crm.mapper;

import com._520it.crm.domain.Petservicemenu;
import java.util.List;

public interface PetServiceMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Petservicemenu record);

    Petservicemenu selectByPrimaryKey(Long id);

    List<Petservicemenu> selectAll();

    int updateByPrimaryKey(Petservicemenu record);
}