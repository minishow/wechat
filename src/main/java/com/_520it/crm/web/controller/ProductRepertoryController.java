package com._520it.crm.web.controller;

import com._520it.crm.query.ProductStockQueryObject;
import com._520it.crm.service.IProductStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/9/25.
 */
@Controller
@RequestMapping("/productRepertory")
public class ProductRepertoryController {
    @Autowired
    private IProductStockService productStockServiceImpl;
    @RequestMapping("")
    public String execute(ProductStockQueryObject qo) {
        return null;
    }
}
