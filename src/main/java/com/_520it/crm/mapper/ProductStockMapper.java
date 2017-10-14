package com._520it.crm.mapper;

import com._520it.crm.domain.ProductStock;
import com._520it.crm.query.ProductStockQueryObject;

import java.util.List;

public interface ProductStockMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductStock record);

    ProductStock selectByPrimaryKey(Long id);

    List<ProductStock> selectAll();

    int updateByPrimaryKey(ProductStock record);

    List<ProductStock> queryForData(ProductStockQueryObject qo);

    Long queryForCount(ProductStockQueryObject qo);

    ProductStock getProductStockByProductinfoCode(String code);
}