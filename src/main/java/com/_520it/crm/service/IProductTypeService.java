package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.ProductType;

public interface IProductTypeService {
    int deleteByPrimaryKey(Long id);

    int insert(ProductType productType);

    ProductType selectByPrimaryKey(Long id);

    List<ProductType> selectAll();

    int updateByPrimaryKey(ProductType productType);
}
