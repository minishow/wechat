<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="common.jsp"></jsp:include>
    <script type="text/javascript" src="/static/js/views/role.js"></script>
    <title>角色界面</title>
</head>
<body>

<table id="role_datagrid"></table>
<div id="role_dialog">
    <form id="role_form" method="post">
        <input id="hiddenId" type="hidden" name="e_id">
        <div align="center" style="margin-top: 10px;">
            <div>
                <select id="selectId" name="e_name"></select>
            </div>
                <div>
                    <input type="password" name="e_password" class="easyui-textbox"
                           data-options="label:'登录密码:',labelPosition:'top', width:150">
                </div>
            <div>
                <input type="text" name="e_realName" class="easyui-textbox"
                       data-options="label:'真实姓名:',labelPosition:'top', width:150">
            </div>
            <div>
                <input type="text" name="e_tel" class="easyui-textbox"
                       data-options="label:'电话号码:',labelPosition:'top', width:150">
            </div>

            <div>
                <select id="rolesSelect" class="easyui-combobox" name="r_id" style="width:150px;" label="账号角色"
                        labelPosition="top">
                    <option value="1">收银员</option>
                    <option value="2">店长</option>
                </select>
            </div>
        </div>
    </form>
</div>
<!-- 定义顶部按钮 -->
<div id="role_datagrid_tb">

    <div>
        <a class="easyui-linkbutton" plain="true" data-cmd="add">添加角色</a>
    </div>

</div>

<div id="role_dialog_bt">
    <a class="easyui-linkbutton" plain="true" data-cmd="save">确定</a>
    <a class="easyui-linkbutton" plain="true" data-cmd="cancel">取消</a>
</div>

</body>
</html>
