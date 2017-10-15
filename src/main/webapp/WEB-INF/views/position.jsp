<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="common.jsp"></jsp:include>
    <script type="text/javascript" src="/static/js/views/position.js"></script>
    <title>职位界面</title>
</head>
<body>
<table id="position_datagrid"></table>
<div id="position_dialog">
    <form id="position_form" method="post">
        <input type="hidden" name="id">
        <div align="center" style="margin-top: 10px;">
            <div>
                <input type="text" name="name" class="easyui-textbox"
                       data-options="label:'职位名称:',labelPosition:'top', width:150">
            </div>
            <div>
                <input type="text" name="jobSubsidys" class="easyui-textbox"
                       data-options="label:'岗位津贴:',labelPosition:'top', width:150">
            </div>
            <div>
                <input type="text" name="travelAllowance" class="easyui-textbox"
                       data-options="label:'交通补贴:',labelPosition:'top', width:150">
            </div>
            <div>
                <input type="text" name="airtimeSubsidy" class="easyui-textbox"
                       data-options="label:'话费补贴:',labelPosition:'top', width:150">
            </div>
            <div>
                <input type="text" name="meaSubsidy" class="easyui-textbox"
                       data-options="label:'餐费补贴:',labelPosition:'top', width:150">
            </div>
            <div>
                <input type="text" name="attendanceBonus" class="easyui-textbox"
                       data-options="label:'全勤奖励:',labelPosition:'top', width:150">
            </div>
            <div>
                <input type="text" name="commissionRate" class="easyui-textbox"
                       data-options="label:'提成比例(%):',labelPosition:'top', width:150">
            </div>

        </div>
    </form>
</div>
<!-- 定义顶部按钮 -->
<div id="position_datagrid_tb">
    <div>
        <a class="easyui-linkbutton" plain="true" data-cmd="add">添加职位</a>
        <a class="easyui-linkbutton" plain="true" data-cmd="edit">编辑</a>
        <a class="easyui-linkbutton" plain="true" data-cmd="delete">删除</a>
    </div>
</div>

<div id="position_dialog_bt">
    <a class="easyui-linkbutton" plain="true" data-cmd="save">保存</a>
    <a class="easyui-linkbutton" plain="true" data-cmd="cancel">取消</a>
</div>

</body>
</html>
