package com._520it.crm.service;

import com._520it.crm.domain.PetServiceMenu;

import java.util.List;

public interface IPetServiceMenuService {

    int deleteByPrimaryKey(Long id);

    int insert(PetServiceMenu record);

    PetServiceMenu selectByPrimaryKey(Long id);

    List<PetServiceMenu> selectAll();

    int updateByPrimaryKey(PetServiceMenu record);

    List<PetServiceMenu> queryTree();

    List<PetServiceMenu> queryTopTree();
}
