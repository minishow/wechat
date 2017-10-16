package com._520it.crm.service;

import com._520it.crm.domain.Harm;
import com._520it.crm.domain.PetKind;

import java.util.List;

public interface IPetKindService {
    int deleteByPrimaryKey(Long id);

    int insert(PetKind petKind);

    PetKind selectByPrimaryKey(Long id);

    List<PetKind> selectAll();

    int updateByPrimaryKey(PetKind petKind);

    List<PetKind> selectKindAll(Long kindID);

    List<Harm> addHarmList();
}

