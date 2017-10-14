package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.Brand;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.BrandQueryObject;

public interface IBrandService {
    int deleteByPrimaryKey(Long id);

    int insert(Brand brand);

    Brand selectByPrimaryKey(Long id);

    List<Brand> selectAll();

    int updateByPrimaryKey(Brand brand);

	PageResult query(BrandQueryObject qo);
	/**
	 * 修改状态为否的方法
	 * @param id
	 */
	void changeState(Long id);
}
