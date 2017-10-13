package com._520it.crm.mapper;

import com._520it.crm.domain.PetKind;
import java.util.List;

public interface PetKindMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PetKind petKind);

    PetKind selectByPrimaryKey(Long id);

    List<PetKind> selectAll();

    int updateByPrimaryKey(PetKind petKind);
}