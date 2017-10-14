package com._520it.crm.mapper;

import com._520it.crm.domain.Brand;
import com._520it.crm.domain.ProductType;
import com._520it.crm.query.ProductTypeQueryObject;

import java.util.List;

public interface ProductTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductType productType);

    ProductType selectByPrimaryKey(Long id);

    List<ProductType> selectAll();

    int updateByPrimaryKey(ProductType productType);

	Long queryForCount(ProductTypeQueryObject qo);

	List<Brand> queryForList(ProductTypeQueryObject qo);

	void changeState(Long id);
}