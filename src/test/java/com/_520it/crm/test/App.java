package com._520it.crm.test;

import com._520it.crm.mapper.SpecificMapper;
import com._520it.crm.query.ProductStockQueryObject;
import com._520it.crm.query.StockIncomeRecordQueryObject;
import com._520it.crm.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/10/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class App {
   @Autowired
   private IProductStockService productStockService;
    @Autowired
   private IProductInfoService productInfoService;
    @Autowired
   private IStockOprationBillService stockOprationBillService;
    @Autowired
   private IStockIncomeRecordService stockIncomeRecordService;
    @Autowired
   private IStockOutRecordService stockOutRecordService;
    @Autowired
   private IProductTypeService productTypeService;
    @Autowired
   private SpecificMapper specificMapper;
    @Test
    public void myTest(){
           System.out.println(productStockService.queryForList(new ProductStockQueryObject()));
        System.out.println("......................");
        }

    @Test
    public void Other(){
        System.out.println(productTypeService.selectAll());
    }
}
