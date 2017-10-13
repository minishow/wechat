package com._520it.crm.service;

import com._520it.crm.domain.ProductStock;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductStockQueryObject;

import java.util.List;

/**
 * Created by Administrator on 2017/10/13.
 */
public interface IProductStockService {
    int deleteByPrimaryKey(Long id);

    int insert(ProductStock record);

    ProductStock selectByPrimaryKey(Long id);

    List<ProductStock> selectAll();

    int updateByPrimaryKey(ProductStock record);

    PageResult queryForList(ProductStockQueryObject qo);
}
