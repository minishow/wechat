package com._520it.crm.mapper;

import com._520it.crm.domain.Brand;
import com._520it.crm.query.BrandQueryObject;

import java.util.List;

public interface BrandMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Brand brand);

    Brand selectByPrimaryKey(Long id);

    List<Brand> selectAll();

    int updateByPrimaryKey(Brand brand);

	Long queryForCount(BrandQueryObject qo);

	List<Brand> queryForList(BrandQueryObject qo);

	void changeState(Long id);
}