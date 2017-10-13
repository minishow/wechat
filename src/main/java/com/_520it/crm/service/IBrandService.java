package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.Brand;

public interface IBrandService {
    int deleteByPrimaryKey(Long id);

    int insert(Brand brand);

    Brand selectByPrimaryKey(Long id);

    List<Brand> selectAll();

    int updateByPrimaryKey(Brand brand);
}
