package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.ProductInfo;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductInfoQueryObject;

public interface IProductInfoService {
    int deleteByPrimaryKey(Long id);

    int insert(ProductInfo productInfo);

    ProductInfo selectByPrimaryKey(Long id);

    List<ProductInfo> selectAll();

    int updateByPrimaryKey(ProductInfo productInfo);

	PageResult query(ProductInfoQueryObject qo);

	void changeState(Long id);
}
