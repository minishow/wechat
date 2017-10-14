package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.Supplier;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.SupplierQueryObject;

public interface ISupplierService {
    int deleteByPrimaryKey(Long id);

    int insert(Supplier supplier);

    Supplier selectByPrimaryKey(Long id);

    List<Supplier> selectAll();

    int updateByPrimaryKey(Supplier supplier);

	PageResult query(SupplierQueryObject qo);

	void changeState(Long id);
}
