package com._520it.crm.mapper;

import com._520it.crm.domain.PetType;
import java.util.List;

public interface PetTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PetType petType);

    PetType selectByPrimaryKey(Long id);

    List<PetType> selectAll();

    int updateByPrimaryKey(PetType petType);
}