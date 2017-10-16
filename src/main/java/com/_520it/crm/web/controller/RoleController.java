package com._520it.crm.web.controller;

import com._520it.crm.domain.Role;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.RoleQueryObject;
import com._520it.crm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @RequestMapping("")
    public String index(){
        return "role";
    }

    @RequestMapping("/selectListByRole")
    @ResponseBody
    public List<Role> selectListForRoleForm() {
        return roleService.selectAll();
    }

    @RequestMapping("/queryByPageList")
    @ResponseBody
    public PageResult queryByPageList(RoleQueryObject qo) {
        PageResult result = null;
        try {
            result = roleService.queryByPageList(qo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(Role role) {
        try {
            int insert = roleService.insert(role);
            return new AjaxResult(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("添加失败,请联系管理员!");
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public AjaxResult update(Role role) {
        try {
            roleService.updateByPrimaryKey(role);
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
            roleService.deleteByPrimaryKey(id);
            return new AjaxResult(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败");
        }
    }
}
