package com._520it.crm.web.controller;

import com._520it.crm.domain.StockOprationBill;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.StockOprationBillQueryObject;
import com._520it.crm.service.IStockOprationBillService;
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
@RequestMapping("/stockOprationBill")
public class StockOprationBillController {
    @Autowired
    private IStockOprationBillService stockOprationBillServiceImpl;
    @RequestMapping("")
    public String execute(StockOprationBillQueryObject qo) {
        return null;
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult json(StockOprationBillQueryObject qo) {
        return stockOprationBillServiceImpl.queryForList(qo);
    }


    @RequestMapping("/delete")
    @ResponseBody
    public AjaxObject delete(Long id,boolean state) {
        try {
            stockOprationBillServiceImpl.deleteByPrimaryKey(id);
            return new AjaxObject(true,"删除成功");
        } catch (RuntimeException e) {
            return new AjaxObject(false,"删除失败");
        }

    }

    @RequestMapping("/save")
    @ResponseBody
    @RequiresPermissions("StockOprationBill:list")
    public AjaxObject save(StockOprationBill StockOprationBill) {
        try {
            stockOprationBillServiceImpl.insert(StockOprationBill);
            return new AjaxObject(true,"保存成功");
        } catch (RuntimeException e) {
            return new AjaxObject(false,e.getMessage());
        }
    }

    @RequestMapping("/edit")
    @ResponseBody
    @RequiresPermissions("StockOprationBill:edit")
    public AjaxObject edit(StockOprationBill StockOprationBill) {
        try {
            stockOprationBillServiceImpl.updateByPrimaryKey(StockOprationBill);
            return new AjaxObject(true,"编辑成功");
        } catch (RuntimeException e) {
            return new AjaxObject(false,"编辑失败");
        }
    }
}
