
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/static/js/views/addMemberAndPet/addMember.js"></script>
</head>
<body>
<div id="petInfo_addPet_dialog">

    <form method="post" id="petInfo_addPet_form">

        <input type="hidden" name="id">


        <div align="center" style="margin-top: 10px">
            <div>
                <input class="easyui-textbox" name="username" data-options="label:'用户名',labelPosition:'top'">
            </div>
            <div>
                <input class="easyui-textbox" name="realname" data-options="label:'真实姓名',labelPosition:'top'">
            </div>
            <div>
                <input class="easyui-textbox" name="tel" data-options="label:'电话',labelPosition:'top'">
            </div>
            <div>
                <input class="easyui-textbox" name="email" data-options="label:'邮件',labelPosition:'top'">
            </div>
            <div>
                <input class="easyui-combobox" name="dept.id" data-options="
                valueField:'id',
                textField:'name',
                url:'/deparment/queryDeparmentList',
                label:'所属部门:',
                labelPosition:'top'
                ">
            </div>
            <div>
                <input id="roleId" class="easyui-combobox"  data-options="
                valueField:'id',
                textField:'name',
                multiple:true,
                url:'/role/queryRoleList',
                label:'角色:',
                labelPosition:'top'
                ">
            </div>
        </div>
    </form>
</div>
</body>
</html>
