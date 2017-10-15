<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="common.jsp"></jsp:include>
    <script type="text/javascript" src="/static/js/views/employee.js"></script>
    <title>员工界面</title>
</head>
<body>
<table id="employee_datagrid"></table>
<div id="employee_dialog">
    <form id="employee_form" method="post">
        <input type="hidden" name="id">
        <div align="center" style="margin-top: 10px;">
            <div>
                <input type="text" name="jobNumber" class="easyui-textbox"
                       data-options="label:'工号:',labelPosition:'top', width:150">
            </div>
            <div>
                <input type="text" name="name" class="easyui-textbox"
                       data-options="label:'姓名:',labelPosition:'top', width:150">
            </div>
            <div>
                <input type="text" name="tel" class="easyui-textbox"
                       data-options="label:'联系电话:',labelPosition:'top', width:150">
            </div>
            <div>
                <input type="text" name="idCard" class="easyui-textbox"
                       data-options="label:'身份证:',labelPosition:'top', width:150">
            </div>
            <div>
                <input type="text" name="basePay" class="easyui-textbox"
                       data-options="label:'基本工资:',labelPosition:'top', width:150">
            </div>
            <div>
                <select class="easyui-combobox" name="gender" style="width:150px;" label="性别"
                        labelPosition="top">
                    <option value="1">男</option>
                    <option value="0">女</option>
                </select>
            </div>
            <div>
                <input id="dd" name="entryTime" data-options="label:'入职时间:',labelPosition:'top', width:150"
                       type="text" class="easyui-datebox" required="required"> </input>
            </div>

            <div>
                <select name="position.id" class="easyui-combobox"
                        data-options="
						 width:150,
						 label:'职位:',
						 labelPosition:'top',
						 valueField:'id',
						 textField:'name',
						 url:'/position/selectListByPosition'
						">
                </select>
            </div>

        </div>
    </form>
</div>
<!-- 定义顶部按钮 -->
<div id="employee_datagrid_tb">

    <div>
        <a class="easyui-linkbutton" plain="true" data-cmd="add">添加员工</a>
        <a id="employee_editBtn" class="easyui-linkbutton" plain="true" data-cmd="edit">编辑</a>
        <a id="employee_dimissionBtn" class="easyui-linkbutton" plain="true" data-cmd="dimission">离职</a>
        <input id="selectName" type="text">
    </div>
</div>

<div id="employee_dialog_bt">
    <a class="easyui-linkbutton" plain="true" data-cmd="save">保存</a>
    <a class="easyui-linkbutton" plain="true" data-cmd="cancel">取消</a>
</div>

</body>
</html>
