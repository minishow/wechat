package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.Supplier;

public interface ISupplierService {
    int deleteByPrimaryKey(Long id);

    int insert(Supplier supplier);

    Supplier selectByPrimaryKey(Long id);

    List<Supplier> selectAll();

    int updateByPrimaryKey(Supplier supplier);
}
