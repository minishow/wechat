package com._520it.crm.service;

import com._520it.crm.domain.PetServiceRegister;

import java.util.List;

public interface IPetServiceRegisterService {

    int deleteByPrimaryKey(Long id);

    int insert(PetServiceRegister record);

    PetServiceRegister selectByPrimaryKey(Long id);

    List<PetServiceRegister> selectAll();

    int updateByPrimaryKey(PetServiceRegister record);
}
