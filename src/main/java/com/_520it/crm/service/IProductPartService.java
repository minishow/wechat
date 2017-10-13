package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.ProductPart;

public interface IProductPartService {
    int deleteByPrimaryKey(Long id);

    int insert(ProductPart productPart);

    ProductPart selectByPrimaryKey(Long id);

    List<ProductPart> selectAll();

    int updateByPrimaryKey(ProductPart productPart);
}
