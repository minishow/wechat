package com._520it.crm.mapper;

import com._520it.crm.domain.Specific;
import java.util.List;

public interface SpecificMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Specific record);

    Specific selectByPrimaryKey(Long id);

    List<Specific> selectAll();

    int updateByPrimaryKey(Specific record);
}