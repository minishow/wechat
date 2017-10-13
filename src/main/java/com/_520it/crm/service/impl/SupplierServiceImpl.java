package com._520it.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Supplier;
import com._520it.crm.mapper.SupplierMapper;
import com._520it.crm.service.ISupplierService;
@Service
public class SupplierServiceImpl implements ISupplierService {

	@Autowired
	private SupplierMapper supplierMapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		return supplierMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Supplier supplier) {
		return supplierMapper.insert(supplier);
	}

	@Override
	public Supplier selectByPrimaryKey(Long id) {
		return supplierMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Supplier> selectAll() {
		return supplierMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Supplier supplier) {
		return supplierMapper.updateByPrimaryKey(supplier);
	}

}
