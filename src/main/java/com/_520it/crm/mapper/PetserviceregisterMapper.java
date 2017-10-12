package com._520it.crm.mapper;

import com._520it.crm.domain.PetServiceRegister;
import java.util.List;

public interface PetserviceregisterMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PetServiceRegister record);

    PetServiceRegister selectByPrimaryKey(Long id);

    List<PetServiceRegister> selectAll();

    int updateByPrimaryKey(PetServiceRegister record);
}