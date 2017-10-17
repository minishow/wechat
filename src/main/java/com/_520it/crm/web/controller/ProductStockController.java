package com._520it.crm.web.controller;

import com._520it.crm.domain.Brand;
import com._520it.crm.domain.ProductInfo;
import com._520it.crm.domain.ProductStock;
import com._520it.crm.domain.ProductType;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductStockQueryObject;
import com._520it.crm.service.IBrandService;
import com._520it.crm.service.IProductInfoService;
import com._520it.crm.service.IProductStockService;
import com._520it.crm.service.IProductTypeService;
import com._520it.crm.util.AjaxObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/9/25.
 */
@Controller
@RequestMapping("/productStock")
public class ProductStockController {
    @Autowired
    private IProductStockService productStockServiceImpl;
    @Autowired
    private IProductTypeService productTypeService;
    @Autowired
    private IProductInfoService productInfoService;
    @Autowired
    private IBrandService brandService;
    @RequestMapping("")
    public String execute(ProductStockQueryObject qo) {

        return null;
    }
    @RequestMapping("productTypes")
    @ResponseBody
    public List<ProductType> productTypes() {
        return productTypeService.selectAll();
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(ProductStockQueryObject qo) {
        return productStockServiceImpl.queryForList(qo);
    }

    @RequestMapping("/listBrands")
    @ResponseBody
    public List<Brand> listBrands(ProductStockQueryObject qo) {
        return brandService.selectAll();
    }

    @RequestMapping("/listProductTypes")
    @ResponseBody
    public List<ProductType> listProductTypes(ProductStockQueryObject qo) {
        return productTypeService.selectAll();
    }

    @RequestMapping("/listProductInfos")
    @ResponseBody
    public List<ProductInfo> listProductInfos(ProductStockQueryObject qo) {
        return productInfoService.selectAll();
    }

    @RequestMapping("/json")
    @ResponseBody
    public PageResult json(ProductStockQueryObject qo) {
        return new PageResult(null,null);
    }


    @RequestMapping("/delete")
    @ResponseBody
    public AjaxObject delete(Long id,boolean state) {
        try {
            productStockServiceImpl.deleteByPrimaryKey(id);
            return new AjaxObject(true,"删除成功");
        } catch (RuntimeException e) {
            return new AjaxObject(false,"删除失败");
        }

    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public AjaxObject saveOrUpdate(ProductStock productStock) {
        try {
        if(productStock.getId()!=null){
            productStockServiceImpl.updateByPrimaryKey(productStock);
            return new AjaxObject(true,"编辑成功");
        }
            productStockServiceImpl.insert(productStock);
            return new AjaxObject(true,"保存成功");
        } catch (RuntimeException e) {
            return new AjaxObject(false,e.getMessage());
        }
    }

    //根据商品69条码查询 库存的商品记录
    @RequestMapping("/getProductStockByProductinfoCode")
    @ResponseBody
    public ProductStock getProductStockByProductinfoCode(String code){
        ProductStock result = productStockServiceImpl.getProductStockByProductinfoCode(code);
        return result;
    }


    @RequestMapping("/queryProductInfos")
    @ResponseBody
    public ProductInfo queryProductInfos(Long id) {
        return productInfoService.selectByPrimaryKey(id);
    }

}
