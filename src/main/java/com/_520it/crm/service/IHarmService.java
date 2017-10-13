package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.Harm;

public interface IHarmService {
    int deleteByPrimaryKey(Long id);

    int insert(Harm harm);

    Harm selectByPrimaryKey(Long id);

    List<Harm> selectAll();

    int updateByPrimaryKey(Harm harm);
}
