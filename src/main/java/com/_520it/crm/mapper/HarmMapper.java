package com._520it.crm.mapper;

import com._520it.crm.domain.Harm;
import java.util.List;

public interface HarmMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Harm harm);

    Harm selectByPrimaryKey(Long id);

    List<Harm> selectAll();

    int updateByPrimaryKey(Harm harm);
}