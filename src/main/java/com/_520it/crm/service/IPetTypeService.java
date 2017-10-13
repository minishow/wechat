package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.PetType;

public interface IPetTypeService {
    int deleteByPrimaryKey(Long id);

    int insert(PetType petType);

    PetType selectByPrimaryKey(Long id);

    List<PetType> selectAll();

    int updateByPrimaryKey(PetType petType);
}
