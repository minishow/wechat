package com._520it.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Brand;
import com._520it.crm.domain.Supplier;
import com._520it.crm.mapper.SupplierMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.SupplierQueryObject;
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

	@Override
	public PageResult query(SupplierQueryObject qo) {
		Long total=supplierMapper.queryForCount(qo);
		if(total==0){
			return new PageResult(new Long(0),new ArrayList<Brand>());
		}
		List<Brand> rows=supplierMapper.queryForList(qo);
		return new PageResult(total,rows);
	}

	@Override
	public void changeState(Long id) {
		supplierMapper.changeState(id);
	}

}
