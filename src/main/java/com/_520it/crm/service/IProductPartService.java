package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.ProductPart;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductPartQueryObject;

public interface IProductPartService {
    int deleteByPrimaryKey(Long id);

    int insert(ProductPart productPart);

    ProductPart selectByPrimaryKey(Long id);

    List<ProductPart> selectAll();

    int updateByPrimaryKey(ProductPart productPart);

	PageResult query(ProductPartQueryObject qo);

	void changeState(Long id);
}
