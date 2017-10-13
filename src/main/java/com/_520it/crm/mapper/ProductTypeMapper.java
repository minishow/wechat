package com._520it.crm.mapper;

import com._520it.crm.domain.ProductType;
import java.util.List;

public interface ProductTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductType productType);

    ProductType selectByPrimaryKey(Long id);

    List<ProductType> selectAll();

    int updateByPrimaryKey(ProductType productType);
}