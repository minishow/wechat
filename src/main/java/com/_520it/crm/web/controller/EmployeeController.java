package com._520it.crm.web.controller;

import com._520it.crm.domain.Employee;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQueryObject;
import com._520it.crm.service.IEmployeeService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/employee")
@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("")
    public String index() {
        return "employee";
    }

    @RequestMapping("/skip")
    public String skip(){
        return "skip";
    }

    @RequestMapping("/queryByPageList")
    @ResponseBody
    public PageResult queryByPageList(EmployeeQueryObject qo) {
        PageResult result = null;
        try {
            result = employeeService.queryByPageList(qo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(Employee employee) {
        try {
            int insert = employeeService.insert(employee);
            return new AjaxResult(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("添加失败,请联系管理员!");
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public AjaxResult update(Employee employee) {
        try {
            employeeService.updateByPrimaryKey(employee);
            return new AjaxResult(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("修改失败!请联系管理员");
        }
    }

    @RequestMapping("/dimission")
    @ResponseBody
    public AjaxResult delete(Long id) {
        try {
            employeeService.dimissionByPrimaryKey(id);
            return new AjaxResult(true, "离职成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("离职失败");
        }
    }

    @RequestMapping("/selectListByLeaveRecord")
    @ResponseBody
    public List<Employee> selectListByLeaveRecord() {
        return employeeService.selectListByLeaveRecord();
    }

    @RequestMapping("/selectListByEmployee")
    @ResponseBody
    public List<Employee> selectListByEmployee() {
        return employeeService.selectListByEmployee();
    }


    /*添加修改密码的方法*/
    @RequestMapping("/checkPassword")
    @ResponseBody
    public AjaxResult checkPassword(String oldPassword){
    	Boolean flag=employeeService.checkPassword(oldPassword);
    	return new AjaxResult(flag,"");
    }
	@RequestMapping("/changePassword")
	public String changePassword(Model model){
		Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
		String name = employee.getName();
		model.addAttribute("name",name);
		return "changePassword";
	}
	@RequestMapping("/doChangePassword")
	@ResponseBody
	public AjaxResult doChangePassword(String newPassword){
		try {
			employeeService.changePassword(newPassword);
			return new AjaxResult(true,"修改成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult(false,"修改失败!");
		}
	}
}
