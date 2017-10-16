<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
