package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.ProductType;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductTypeQueryObject;

public interface IProductTypeService {
    int deleteByPrimaryKey(Long id);

    int insert(ProductType productType);

    ProductType selectByPrimaryKey(Long id);

    List<ProductType> selectAll();

    int updateByPrimaryKey(ProductType productType);

	PageResult query(ProductTypeQueryObject qo);

	void changeState(Long id);
}
