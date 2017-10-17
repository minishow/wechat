<%-- <%@ taglib prefix="s" uri="/struts-tags" %> --%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<link href="/static/js/jquery-easyui/themes/default/easyui.css" rel="stylesheet" type="text/css"/>
<link href="/static/js/jquery-easyui/themes/icon.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="/static/js/jquery/jquery.js"></script>
<script type="text/javascript" src="/static/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.easyui.min.js"></script>
<head>
    <meta charset="UTF-8">
    <title>库存管理</title>

</head>
<body>
<table id="datagrip_table">
    <div id="myTools">
        <form id="searchForm">
            <a id="add" onclick="add();" class="easyui-linkbutton" data-options="width:60,height:30,plain:true"
               iconCls="icon-add">新增</a>
            <a id="delData" onclick="del();" class="easyui-linkbutton" data-options="width:60,height:30,plain:true"
               iconCls="icon-remove">删除</a>
            <a id="editData" onclick="edit();" class="easyui-linkbutton"
               data-options="width:60,height:30,plain:true"
               iconCls="icon-edit">编辑</a>
            <a id="reloadData" onclick="reload();" class="easyui-linkbutton"
               data-options="width:60,height:30,plain:true" iconCls="icon-reload">刷新</a>
            <input id="employee_keyword" type="text" class="easyui-textbox" iconCls="icon-man" name="keyword" />
            <a id="searchData" onclick="search();" class="easyui-linkbutton"
               data-options="width:60,height:30,plain:true" iconCls="icon-search">搜索</a>
        </form>
    </div>
</table>
<div >
    <form id="edit_form" method="post">
        <input type="hidden" name="id"/>
        <div align="center" style="margin-top: 15px">
            <div>
                <input name="username" class="easyui-textbox" data-options="label:'用户名:'">
            </div>
            <div>
                <input name="realname" class="easyui-textbox" data-options="label:'真正名:'">
            </div>
            <div>
                <input name="tel" class="easyui-numberbox" data-options="label:'联系电话:'">
            </div>
            <div>
                <input name="dept.id" class="easyui-combobox" data-options="label:'部门:',
                valueField:'id',textField:'name',
                url:'/employee/getDepts'
                " style="width:150px;">
                </input>
            </div>
            <div>
                <input name="email" class="easyui-textbox" data-options="label:'Email:'">
            </div>
            <div>
                <input name="password" class="easyui-textbox" data-options="label:'密码:'">
            </div>
            <input  id="multiple_role" class="easyui-combobox" data-options="label:'角色:',
                valueField:'id',textField:'name',
                multiple:true,
                url:'/role/listRoles'
                " style="width:150px;">
            </input>
            <div>
                超级用户:  <input name="admin"  type="checkbox" label="超级用户">
            </div>
            <div id="myInfo" style="align-self:true">
                <a onclick="saveInput();" class="easyui-linkbutton" iconCLs="icon-save"
                   data-options="width:80,height:30,plain:true">保存</a>
                <a onclick="closeInput();" class="easyui-linkbutton" iconCLs="icon-reload"
                   data-options="width:80,height:30,plain:true">取消</a>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="/static/js/views/employee/list.js"></script>

</body>
</html>