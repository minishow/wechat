package com._520it.crm.web.controller;

import com._520it.crm.domain.Position;
import com._520it.crm.domain.Position;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PositionQueryObject;
import com._520it.crm.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private IPositionService positionService;

    @RequestMapping("")
    public String index(){
        return "position";
    }

    @RequestMapping("/selectListByPosition")
    @ResponseBody
    public List<Position> selectListForPositionForm() {
        return positionService.selectAll();
    }

    @RequestMapping("/queryByPageList")
    @ResponseBody
    public PageResult queryByPageList(PositionQueryObject qo) {
        PageResult result = null;
        try {
            result = positionService.queryByPageList(qo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(Position position) {
        try {
            int insert = positionService.insert(position);
            return new AjaxResult(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("添加失败,请联系管理员!");
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public AjaxResult update(Position position) {
        try {
            positionService.updateByPrimaryKey(position);
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
            positionService.deleteByPrimaryKey(id);
            return new AjaxResult(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败");
        }
    }
}
