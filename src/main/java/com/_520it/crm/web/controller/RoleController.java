package com._520it.crm.web.controller;

import com._520it.crm.page.AjaxResult;
import com._520it.crm.service.IRoleService;
import com._520it.crm.util.EmployeeRoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @RequestMapping("")
    public String index() {
        return "role";
    }

    @RequestMapping("/queryByPageList")
    @ResponseBody
    public List<Map> queryByPageList() {
        List<Map> result= roleService.queryByPageList();
        System.out.println(result);
        return result;
    }

    @RequestMapping("/inputRoleByEmployee")
    @ResponseBody
    public AjaxResult inputRoleByEmployee(EmployeeRoleVO employee) {
        try {
            System.out.println(employee.toString());
            roleService.inputRoleByEmployee(employee);
            return new AjaxResult(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("添加失败,请联系管理员!");
        }
    }

    @RequestMapping("/selectRoleByEmployeeId")
    @ResponseBody
    public List<Long> selectByRoleId(Long employeeId) {
        return roleService.selectRoleByEmployeeId(employeeId);
    }
}
