package com._520it.crm.web.controller;

import com._520it.crm.domain.ProductStock;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ProductStockQueryObject;
import com._520it.crm.service.IProductStockService;
import com._520it.crm.util.AjaxObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/9/25.
 */
@Controller
@RequestMapping("/productStock")
public class ProductStockController {
    @Autowired
    private IProductStockService productStockServiceImpl;
    @RequestMapping("")
    public String execute(ProductStockQueryObject qo) {
        return null;
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult json(ProductStockQueryObject qo) {
        return productStockServiceImpl.queryForList(qo);
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

    @RequestMapping("/save")
    @ResponseBody
    @RequiresPermissions("productStock:list")
    public AjaxObject save(ProductStock productStock) {
        try {
            productStockServiceImpl.insert(productStock);
            return new AjaxObject(true,"保存成功");
        } catch (RuntimeException e) {
            return new AjaxObject(false,e.getMessage());
        }
    }

    @RequestMapping("/edit")
    @ResponseBody
    @RequiresPermissions("productStock:edit")
    public AjaxObject edit(ProductStock productStock) {
        try {
            productStockServiceImpl.updateByPrimaryKey(productStock);
            return new AjaxObject(true,"编辑成功");
        } catch (RuntimeException e) {
            return new AjaxObject(false,"编辑失败");
        }
    }
}
