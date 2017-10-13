package com._520it.crm.service;

import com._520it.crm.domain.PetServiceRegister;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PetServiceRegisterQueryObject;

import java.util.List;

public interface IPetServiceRegisterService {

    int deleteByPrimaryKey(Long id);

    int insert(PetServiceRegister record);

    PetServiceRegister selectByPrimaryKey(Long id);

    List<PetServiceRegister> selectAll();

    int updateByPrimaryKey(PetServiceRegister record);

    PageResult queryPage(PetServiceRegisterQueryObject qo);

    void startService(PetServiceRegister record);

    void endService(PetServiceRegister record);
}
