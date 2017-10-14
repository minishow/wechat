package com._520it.crm.mapper;

import com._520it.crm.domain.Location;
import com._520it.crm.domain.ProductPart;
import com._520it.crm.query.ProductPartQueryObject;

import java.util.List;

public interface ProductPartMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductPart productPart);

    ProductPart selectByPrimaryKey(Long id);

    List<ProductPart> selectAll();

    int updateByPrimaryKey(ProductPart productPart);

	Long queryForCount(ProductPartQueryObject qo);

	List<Location> queryForList(ProductPartQueryObject qo);

	void changeState(Long id);
}