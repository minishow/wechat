package com._520it.crm.mapper;

import com._520it.crm.domain.ProductPart;
import java.util.List;

public interface ProductPartMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductPart productPart);

    ProductPart selectByPrimaryKey(Long id);

    List<ProductPart> selectAll();

    int updateByPrimaryKey(ProductPart productPart);
}