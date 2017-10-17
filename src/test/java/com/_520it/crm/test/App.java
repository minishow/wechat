package com._520it.crm.test;

import com._520it.crm.mapper.*;
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
    private static boolean flag = true;
    @Autowired
    private IStockOprationBillService stockOprationBillServiceImpl;
    @Autowired
    private ILocationService locationService;
    @Autowired
    private IProductInfoService productInfoService;
    @Autowired
    private IBrandService brandService;
    @Autowired
    private IProductTypeService productTypeService;
    @Autowired
    private IProductPartService productPartService;
    @Autowired
    private StockIncomeMapper stockIncomeMapper;
    @Autowired
    public StockIncomeRecordMapper stockIncomeRecordMapper;
    @Autowired
    private SpecificMapper specificMapper;
    @Autowired
    private OpenStockMapper openStockMapper;
    @Autowired
    private SupplierMapper SupplierMapper;
    @Autowired
    public PetTypeMapper PetTypeMapper;
    @Autowired
    private ShopInfoMapper ShopInfoMapper;
    @Autowired
    private ProductStockMapper ProductStockMapper;
    @Autowired
    public StockOutRecordMapper stockOutRecordMapper;
    public ProductScaleMapper ProductScaleMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private ProductPartMapper ProductPartMapper;
    @Autowired
    public BrandMapper LocationMapper;
    @Test
    public void Test(){
        System.out.println(LocationMapper.selectByPrimaryKey(1l));
    }
}
