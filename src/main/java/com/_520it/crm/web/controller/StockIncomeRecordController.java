package com._520it.crm.web.controller;

import com._520it.crm.domain.StockIncomeRecord;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.StockIncomeRecordQueryObject;
import com._520it.crm.service.IStockIncomeRecordService;
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
@RequestMapping("/stockIncomeRecord")
public class StockIncomeRecordController {
    @Autowired
    private IStockIncomeRecordService stockIncomeRecordServiceImpl;
    @RequestMapping("")
    public String execute(StockIncomeRecordQueryObject qo) {
        return null;
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult json(StockIncomeRecordQueryObject qo) {
        return stockIncomeRecordServiceImpl.queryForList(qo);
    }


    @RequestMapping("/delete")
    @ResponseBody
    public AjaxObject delete(Long id,boolean state) {
        try {
            stockIncomeRecordServiceImpl.deleteByPrimaryKey(id);
            return new AjaxObject(true,"删除成功");
        } catch (RuntimeException e) {
            return new AjaxObject(false,"删除失败");
        }

    }

    @RequestMapping("/save")
    @ResponseBody
    @RequiresPermissions("StockIncomeRecord:list")
    public AjaxObject save(StockIncomeRecord StockIncomeRecord) {
        try {
            stockIncomeRecordServiceImpl.insert(StockIncomeRecord);
            return new AjaxObject(true,"保存成功");
        } catch (RuntimeException e) {
            return new AjaxObject(false,e.getMessage());
        }
    }

    @RequestMapping("/edit")
    @ResponseBody
    @RequiresPermissions("StockIncomeRecord:edit")
    public AjaxObject edit(StockIncomeRecord StockIncomeRecord) {
        try {
            stockIncomeRecordServiceImpl.updateByPrimaryKey(StockIncomeRecord);
            return new AjaxObject(true,"编辑成功");
        } catch (RuntimeException e) {
            return new AjaxObject(false,"编辑失败");
        }
    }
}
