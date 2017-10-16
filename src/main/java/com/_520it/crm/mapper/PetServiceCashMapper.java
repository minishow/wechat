package com._520it.crm.mapper;

import com._520it.crm.domain.PetServiceCash;
import java.util.List;

public interface PetServiceCashMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PetServiceCash record);

    PetServiceCash selectByPrimaryKey(Long id);

    List<PetServiceCash> selectAll();

    int updateByPrimaryKey(PetServiceCash record);
}