package com._520it.crm.mapper;

import com._520it.crm.domain.Brand;
import com._520it.crm.domain.Supplier;
import com._520it.crm.query.SupplierQueryObject;

import java.util.List;

public interface SupplierMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Supplier supplier);

    Supplier selectByPrimaryKey(Long id);

    List<Supplier> selectAll();

    int updateByPrimaryKey(Supplier supplier);

	Long queryForCount(SupplierQueryObject qo);

	List<Brand> queryForList(SupplierQueryObject qo);

	void changeState(Long id);
}