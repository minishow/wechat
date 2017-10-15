package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.PetKind;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PetKindQueryObject;

public interface IPetKindService {
    int deleteByPrimaryKey(Long id);

    int insert(PetKind petKind);

    PetKind selectByPrimaryKey(Long id);

    List<PetKind> selectAll();

    int updateByPrimaryKey(PetKind petKind);

	PageResult query(PetKindQueryObject qo);

	void changeState(Long id);
}
