package com._520it.crm.service.impl;

import com._520it.crm.mapper.OpenStockMapper;
import com._520it.crm.mapper.SpecificMapper;
import com._520it.crm.mapper.StockIncomeMapper;
import com._520it.crm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/17.
 */

@Service
public class ListDomainService {
    private  Map objects = new HashMap();
    @Autowired
    private  ILocationService locationService;
    @Autowired
    private   IProductInfoService productInfoService;
    @Autowired
    private  IBrandService brandService;
    @Autowired
    private  IProductTypeService productTypeService;
    @Autowired
    private  IProductPartService productPartService;
    @Autowired
    private  StockIncomeMapper stockIncomeMapper;
    @Autowired
    private  SpecificMapper specificMapper;
    @Autowired
    private  OpenStockMapper openStockMapper;
     {

    }
    public  Map  getDomainObject(){
        return objects;
    }
}
