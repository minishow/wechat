package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.ProductScale;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductScaleQueryObject;

public interface IProductScaleService {
    int deleteByPrimaryKey(Long id);

    int insert(ProductScale productScale);

    ProductScale selectByPrimaryKey(Long id);

    List<ProductScale> selectAll();

    int updateByPrimaryKey(ProductScale productScale);

	PageResult query(ProductScaleQueryObject qo);

	void changeState(Long id);
}
