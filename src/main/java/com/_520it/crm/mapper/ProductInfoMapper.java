package com._520it.crm.mapper;

import com._520it.crm.domain.Brand;
import com._520it.crm.domain.ProductInfo;
import com._520it.crm.query.ProductInfoQueryObject;

import java.util.List;

public interface ProductInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductInfo productInfo);

    ProductInfo selectByPrimaryKey(Long id);

    List<ProductInfo> selectAll();

    int updateByPrimaryKey(ProductInfo productInfo);

	Long queryForCount(ProductInfoQueryObject qo);

	List<Brand> queryForList(ProductInfoQueryObject qo);

	void changeState(Long id);
}