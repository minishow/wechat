package com._520it.crm.service.impl;

import com._520it.crm.domain.ProductStock;
import com._520it.crm.mapper.ProductInfoMapper;
import com._520it.crm.mapper.ProductStockMapper;
import com._520it.crm.mapper.ProductTypeMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductStockQueryObject;
import com._520it.crm.service.IProductStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/10/13.
 */
@Service
public class ProductStockServiceImpl implements IProductStockService {
    /**
     *
     */
    @Autowired
    private ProductStockMapper productStockMapper;
    @Autowired
    private ProductInfoMapper productInfoMapper;
    @Autowired
    private ProductTypeMapper productTypeMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        productStockMapper.deleteByPrimaryKey(id);
        return 0;
    }

    @Override
    public int insert(ProductStock record) {
        productStockMapper.insert(record);
        return 0;
    }

    @Override
    public ProductStock selectByPrimaryKey(Long id) {
        return productStockMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ProductStock> selectAll() {
        return productStockMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(ProductStock record) {
        productStockMapper.updateByPrimaryKey(record);
        return 0;
    }

    @Override
    public PageResult queryForList(ProductStockQueryObject qo) {
        List<ProductStock> data=productStockMapper.queryForData(qo);
        Long count=productStockMapper.queryForCount(qo);
        return new PageResult(count,data);
    }

    @Override
    public ProductStock getProductStockByProductinfoCode(String code) {
        return productStockMapper.getProductStockByProductinfoCode(code);
    }
}
