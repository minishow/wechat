package com._520it.crm.mapper;

import com._520it.crm.domain.Location;
import com._520it.crm.domain.ProductScale;
import com._520it.crm.query.ProductScaleQueryObject;

import java.util.List;

public interface ProductScaleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductScale productScale);

    ProductScale selectByPrimaryKey(Long id);

    List<ProductScale> selectAll();

    int updateByPrimaryKey(ProductScale productScale);

	Long queryForCount(ProductScaleQueryObject qo);

	List<Location> queryForList(ProductScaleQueryObject qo);

	void changeState(Long id);
}