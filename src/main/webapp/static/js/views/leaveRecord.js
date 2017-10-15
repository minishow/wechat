$(function () {
    $("#leaveRecord_datagrid").datagrid({
        url: '/leaveRecord/queryByPageList',
        striped: true,
        pagination: true,
        rownumbers: true,
        singleSelect: true,
        fit: true,
        toolbar: "#leaveRecord_datagrid_tb",
        columns: [[
            {field: 'employeeId', title: '工号', width: 100, formatter: employeeIdFunction},
            {field: 'employeeName', title: '姓名', width: 100, formatter: employeeNameFunction},
            {field: 'leavecategory', title: '请假类别', width: 100},
            {field: 'reason', title: '请假事由', width: 100},
            {field: 'begintime', title: '请假开始时间', width: 100},
            {field: 'finishtime', title: '请假结束时间', width: 100},
            {field: 'days', title: '请假时长', width: 100},
            {field: 'view', title: '领导意见', width: 100, align: 'right'},
            {field: 'normal', title: '是否正常请假', width: 100, align: 'right', formatter: normalFunction},
            {field: 'state', title: '状态', width: 100, align: 'right', formatter: stateFunction},
            {field: 'cancelreason', title: '取消原因', width: 100, align: 'right'},
        ]]
    });

    $("#selectName").textbox({
        width: 180,
        labelWidth: 60,
        prompt: "请输入姓名或工号查询",
        buttonText: '查询',
        onClickButton: function () {
            var keyword = $(this).val();
            $("#leaveRecord_datagrid").datagrid("load", {
                keyword: keyword,
            });
        }
    });

    //对话框
    $("#leaveRecord_dialog").dialog({
        width: 700,
        height: 400,
        buttons: '#leaveRecord_dialog_bt',
        closed: true
    });
    //取消请假框
    $("#cancelreason_datagrid").dialog({
        width: 200,
        height: 150,
        buttons: '#leaveRecord_dialog_deselect',
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
            $("#leaveRecord_form").form("clear");
            //2.设置对话框的标题
            $("#leaveRecord_dialog").dialog("setTitle", "新增员工");
            //3.打开对话框
            $("#leaveRecord_dialog").dialog("open");
        },
        //编辑
        edit: function () {
            var rowData = $("#leaveRecord_datagrid").datagrid("getSelected");
            if (rowData) {
                //1.清空表单数据
                $("#leaveRecord_form").form("clear");
                //2.设置对话框的标题
                $("#leaveRecord_dialog").dialog("setTitle", "新增");
                //3.打开对话框
                $("#leaveRecord_dialog").dialog("open");
                //特殊数据的处理
                if (rowData.employeeId)
                    rowData["employeeId.id"] = rowData.employeeId.id;
                //4.回显数据
                $("#leaveRecord_form").form("load", rowData);//基于同名匹配规则

            } else {
                $.messager.alert("温馨提示", "请选择一条需要修改的数据.", "warning");
            }

        },
        //保存
        save: function () {
            var url;
            var idVal = $("[name='id']").val();
            if (idVal) {
                url = "/leaveRecord/update";
            } else {
                url = "/leaveRecord/save";
            }
            $("#leaveRecord_form").form("submit", {
                url: url,
                success: function (data) {
                    data = $.parseJSON(data);
                    if (data.success) {
                        //提示消息,当点确定的时候,关闭对话框,刷新数据表格
                        $.messager.alert("温馨提示", data.msg, "info", function () {
                            $("#leaveRecord_dialog").dialog("close");
                            $("#leaveRecord_datagrid").datagrid("reload");
                        });
                    } else {
                        $.messager.alert("温馨提示", data.msg, "error");
                    }
                }
            }, "json");
        },
        cancel: function () {
            $("#leaveRecord_dialog").dialog("close");
        },
        cancels: function () {
            $("#cancelreason_datagrid").dialog("close");
        },
        deselect: function () {
            var rowData = $("#leaveRecord_datagrid").datagrid("getSelected");
            if (rowData) {
                //1.清空表单数据
                $("#cancelreason_form").form("clear");
                //2.设置对话框的标题
                $("#cancelreason_datagrid").dialog("setTitle", "取消原因");
                //3.打开对话框
                $("#cancelreason_datagrid").dialog("open");
                //特殊数据的处理
                if (rowData.dept)
                    rowData["dept.id"] = rowData.dept.id;
                //4.回显数据
                $("#cancelreason_form").form("load", rowData);//基于同名匹配规则

            } else {
                $.messager.alert("温馨提示", "请选择一条需要取消的数据.", "warning");
            }

        },

        ensure: function () {

            var idVal = $("[name='id']").val();
            var url = "/leaveRecord/saveByCancelReason";
            $("#cancelreason_form").form("submit", {
                url: url,
                success: function (data) {
                    data = $.parseJSON(data);
                    if (data.success) {
                        //提示消息,当点确定的时候,关闭对话框,刷新数据表格
                        $.messager.alert("温馨提示", data.msg, "info", function () {
                            $("#cancelreason_datagrid").dialog("close");
                            $("#leaveRecord_datagrid").datagrid("reload");
                        });
                    } else {
                        $.messager.alert("温馨提示", data.msg, "error");
                    }
                }
            }, "json");

            // var rowData = $("#leaveRecord_datagrid").datagrid("getSelected");
            // if (rowData) {
            //     $.messager.confirm("温馨提示", "您确定?", function (yes) {
            //         if (yes) {
            //             $.get("/leaveRecord/saveByCancelReason?id=" + rowData.id, function (data) {
            //                 if (data.success) {
            //                     $("#leaveRecord_datagrid").datagrid("reload");
            //                     $.messager.alert("温馨提示", data.msg, "info");
            //                 } else {
            //                     $.messager.alert("温馨提示", data.msg, "error");
            //                 }
            //             }, "json")
            //         }
            //     });
            // } else {
            //     $.messager.alert("温馨提示", "请选择需要取消的请假记录?.", "warning");
            // }
        },
    }
});


//请假
function normalFunction(value, record, index) {
    if (value == 1) {
        return "<font color='black'>请假</font>";
    } else if (value == 0) {
        return "<font color='black'>旷工</font>";
    }
}

//状态
function stateFunction(value, record, index) {
    if (value == 0) {
        return "<font color='black'>请假</font>";
    } else if (value == 1) {
        return "<font color='black'>已取消</font>";
    }
}

//处理显示员工编号
function employeeIdFunction(value, row, index) {
    if (value) {
        return value.jobNumber;
    } else {
        return value;
    }
}

//显示处理员工姓名
function employeeNameFunction(value, row, index) {
    if (value) {
        return value.name;
    } else {
        return value;
    }
}
