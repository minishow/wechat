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
            {field: 'e_name', title: '登录账号', width: 100},
            {field: 'e_realName', title: '真实名称', width: 100},
            {field: 'e_tel', title: '电话号码', width: 100},
            {field: 'e_loginTime', title: '创建账号时间', width: 100},
            {field: 'r_roleName', title: '角色名称', width: 100, formatter: roleNameFunction},
            {field: ' ', title: '权限操作', width: 100, formatter: resignationTimeFunction}
        ]],
    })

    //下拉
    $("#selectId").combobox({
        width: 150,
        label: '选择员工:',
        labelPosition: 'top',
        valueField: 'id',
        textField: 'name',
        url: '/employee/selectListByEmployee',
        onSelect: function (rows) {
            var hiddenId = document.getElementById("hiddenId");
            hiddenId.value = rows.id;
        }
    })

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
            $("#role_dialog").dialog("setTitle", "添加账号");
            //3.打开对话框
            $("#role_dialog").dialog("open");
        },
        //保存
        save: function () {
            var url;
            var idVal = $("[name='e_id']").val();
            console.log(idVal);
            if (idVal) {
                url = "/role/inputRoleByEmployee";
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
                },
            }, "json");
        },
        cancel: function () {
            $("#role_dialog").dialog("close");
        },
    }

});
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
        $("#role_dialog").dialog("setTitle", "编辑角色");
        //3.打开对话框
        $("#role_dialog").dialog("open");
        //特殊数据的处理
        if (rowData) {
            rowData["id"] = rowData.id;
        }
        //4.回显数据
        $("#role_form").form("load", rowData);//基于同名匹配规则
        //下拉带id发请求
        $.post("/role/selectRoleByEmployeeId?employeeId="+rowData.e_id,function(data){

        }),"json";
    } else {
        $.messager.alert("温馨提示", "请选择一条需要修改的数据.", "warning");
    }
}

//角色
function roleNameFunction(value, record, index) {

    if (record.r_id == 1) {
        return "<font color='black'>收银员</font>";
    } else if (record.r_id == 2) {
        return "<font color='black'>店长</font>";
    }
}
