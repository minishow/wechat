package com._520it.crm.service;

import com._520it.crm.domain.PetType;

import java.util.List;

public interface IPetTypeService {
    int deleteByPrimaryKey(Long id);

    int insert(PetType petType);

    PetType selectByPrimaryKey(Long id);

    List<PetType> selectAll();

    int updateByPrimaryKey(PetType petType);


}
