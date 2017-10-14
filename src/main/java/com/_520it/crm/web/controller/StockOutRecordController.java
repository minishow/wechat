package com._520it.crm.web.controller;

import com._520it.crm.domain.StockOutRecord;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.StockOutRecordQueryObject;
import com._520it.crm.service.IStockOutRecordService;
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
@RequestMapping("/stockOutRecord")
public class StockOutRecordController {
    @Autowired
    private IStockOutRecordService stockOutRecordServiceImpl;
    @RequestMapping("")
    public String execute(StockOutRecordQueryObject qo) {
        return null;
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult json(StockOutRecordQueryObject qo) {
        return stockOutRecordServiceImpl.queryForList(qo);
    }


    @RequestMapping("/delete")
    @ResponseBody
    public AjaxObject delete(Long id,boolean state) {
        try {
            stockOutRecordServiceImpl.deleteByPrimaryKey(id);
            return new AjaxObject(true,"删除成功");
        } catch (RuntimeException e) {
            return new AjaxObject(false,"删除失败");
        }

    }

    @RequestMapping("/save")
    @ResponseBody
    @RequiresPermissions("StockOutRecord:list")
    public AjaxObject save(StockOutRecord StockOutRecord) {
        try {
            stockOutRecordServiceImpl.insert(StockOutRecord);
            return new AjaxObject(true,"保存成功");
        } catch (RuntimeException e) {
            return new AjaxObject(false,e.getMessage());
        }
    }

    @RequestMapping("/edit")
    @ResponseBody
    @RequiresPermissions("StockOutRecord:edit")
    public AjaxObject edit(StockOutRecord StockOutRecord) {
        try {
            stockOutRecordServiceImpl.updateByPrimaryKey(StockOutRecord);
            return new AjaxObject(true,"编辑成功");
        } catch (RuntimeException e) {
            return new AjaxObject(false,"编辑失败");
        }
    }
}
