package com._520it.crm.service;

import com._520it.crm.domain.PetServiceCash;

import java.util.List;

public interface IPetServiceCashService {
    int deleteByPrimaryKey(Long id);

    int insert(PetServiceCash record);

    PetServiceCash selectByPrimaryKey(Long id);

    List<PetServiceCash> selectAll();

    int updateByPrimaryKey(PetServiceCash record);
}
