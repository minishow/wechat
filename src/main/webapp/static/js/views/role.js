$(function () {
    $("#role_datagrid").datagrid({
        url: '/role/queryByPageList',
        striped: true,
        pagination: true,
        rownumbers: true,
        singleSelect: true,
        fit: true,
        toolbar: "#role_datagrid_tb",
        columns: [[
            {field: 'userName', title: '登录账号', width: 100},
            {field: 'name', title: '真实名称', width: 100},
            {field: 'tel', title: '电话号码', width: 100},
            {field: 'loginTime', title: '上次登录时间', width: 100},
            {field: 'establishTime', title: '创建账号时间', width: 100},
            {field: 'roleName', title: '角色名称', width: 100},
            {field: 'resignationTime', title: '权限操作', width: 100, formatter: resignationTimeFunction},
        ]],
    });

    //对话框
    $("#role_dialog").dialog({
        width: 300,
        height: 350,
        buttons: '#role_dialog_bt',
        closed: true
    });
    //对按钮进行统一事件监听
    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });
    //新增加按钮
    var cmdObj = {
        add: function () {
            //1.清空表单数据
            $("#role_form").form("clear");
            //2.设置对话框的标题
            $("#role_dialog").dialog("setTitle", "新增员工");
            //3.打开对话框
            $("#role_dialog").dialog("open");
        },
        //保存
        save: function () {
            var url;
            var idVal = $("[name='id']").val();
            if (idVal) {
                url = "/role/update";
            } else {
                url = "/role/save";
            }
            $("#role_form").form("submit", {
                url: url,
                success: function (data) {
                    data = $.parseJSON(data);
                    if (data.success) {
                        //提示消息,当点确定的时候,关闭对话框,刷新数据表格
                        $.messager.alert("温馨提示", data.msg, "info", function () {
                            $("#role_dialog").dialog("close");
                            $("#role_datagrid").datagrid("reload");
                        });
                    } else {
                        $.messager.alert("温馨提示", data.msg, "error");
                    }
                }
            }, "json");
        },
        cancel: function () {
            $("#role_dialog").dialog("close");
        },
        quit: function () {
            var rowData = $("#role_datagrid").datagrid("getSelected");
            if (rowData) {
                $.messager.confirm("温馨提示", "您确定需要删除该员工吗?", function (yes) {
                    if (yes) {
                        $.get("/role/delete?id=" + rowData.id, function (data) {
                            if (data.success) {
                                $("#role_datagrid").datagrid("reload");
                                $.messager.alert("温馨提示", data.msg, "info");
                            } else {
                                $.messager.alert("温馨提示", data.msg, "error");
                            }
                        }, "json")
                    }
                });
            } else {
                $.messager.alert("温馨提示", "请选择需要删除的员工记录.", "warning");
            }
        },
    }
});


//性别判断
function genderFunction(value, record, index) {
    if (value == 1) {
        return "<font color='black'>男</font>";
    } else if (value == 0) {
        return "<font color='black'>女</font>";
    }
}

//职位
function roleFunction(value, row, index) {
    if (value) {
        return value.name;
    } else {
        return value;
    }
}

//角色按钮
function resignationTimeFunction(value, row, index) {
    var btn = "<a id='btn' class='easyui-linkbutton'  plain='true' onclick='compileBtn()'>设置角色</a>";
    return btn;
}
//角色按钮
function compileBtn() {
    var rowData = $("#role_datagrid").datagrid("getSelected");
    if (rowData) {
        //1.清空表单数据
        $("#role_form").form("clear");
        //2.设置对话框的标题
        $("#role_dialog").dialog("setTitle", "新增");
        //3.打开对话框
        $("#role_dialog").dialog("open");
        //特殊数据的处理
        if (rowData.role)
            rowData["role.id"] = rowData.role.id;
        //4.回显数据
        $("#role_form").form("load", rowData);//基于同名匹配规则
    }
}
