package com._520it.crm.web.controller;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.LeaveRecord;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.LeaveRecordQueryObject;
import com._520it.crm.service.ILeaveRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/leaveRecord")
@Controller
public class LeaveRecordController {

    @Autowired
    private ILeaveRecordService leaveRecordService;

    @RequestMapping("")
    public String index() {
        return "leaveRecord";
    }

    @RequestMapping("/queryByPageList")
    @ResponseBody
    public PageResult queryByPageList(LeaveRecordQueryObject qo) {
        PageResult result = null;
        try {
            result = leaveRecordService.queryByPageList(qo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(LeaveRecord leaveRecord) {
        try {
            int insert = leaveRecordService.insert(leaveRecord);
            return new AjaxResult(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("添加失败,请联系管理员!");
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public AjaxResult update(LeaveRecord employee) {
        try {
            leaveRecordService.updateByPrimaryKey(employee);
            return new AjaxResult(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("修改失败!请联系管理员");
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(Long id) {
        try {
            leaveRecordService.deleteByPrimaryKey(id);
            return new AjaxResult(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败");
        }
    }

    @RequestMapping("/saveByCancelReason")
    @ResponseBody
    public AjaxResult saveByCancelReason(LeaveRecord leaveRecord) {
        try {
            leaveRecordService.saveByCancelReason(leaveRecord);
            return new AjaxResult(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("修改失败!请联系管理员");
        }
    }

}
