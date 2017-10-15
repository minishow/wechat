$(function () {
    $("#position_datagrid").datagrid({
        url: '/position/queryByPageList',
        striped: true,
        pagination: true,
        rownumbers: true,
        singleSelect: true,
        fit: true,
        toolbar: "#position_datagrid_tb",
        columns: [[
            {field: 'name', title: '职位名称', width: 100},
            {field: 'jobSubsidys', title: '岗位津贴', width: 100},
            {field: 'travelAllowance', title: '交通补贴', width: 100},
            {field: 'airtimeSubsidy', title: '话费补贴', width: 100},
            {field: 'meaSubsidy', title: '餐补', width: 100},
            {field: 'attendanceBonus', title: '全勤', width: 100},
            {field: 'commissionRate', title: '提成', width: 100},
        ]]
    });

    //对话框
    $("#position_dialog").dialog({
        width: 300,
        height: 350,
        buttons: '#position_dialog_bt',
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
            $("#position_form").form("clear");
            //2.设置对话框的标题
            $("#position_dialog").dialog("setTitle", "新增职位");
            //3.打开对话框
            $("#position_dialog").dialog("open");
        },
        //编辑
        edit: function () {
            var rowData = $("#position_datagrid").datagrid("getSelected");
            if (rowData) {
                //1.清空表单数据
                $("#position_form").form("clear");
                //2.设置对话框的标题
                $("#position_dialog").dialog("setTitle", "新增");
                //3.打开对话框
                $("#position_dialog").dialog("open");
                //特殊数据的处理
                if (rowData.dept)
                    rowData["dept.id"] = rowData.dept.id;
                //4.回显数据
                $("#position_form").form("load", rowData);//基于同名匹配规则

            } else {
                $.messager.alert("温馨提示", "请选择一条需要修改的数据.", "warning");
            }

        },
        //保存
        save: function () {
            var url;
            var idVal = $("[name='id']").val();
            if (idVal) {
                url = "/position/update";
            } else {
                url = "/position/save";
            }
            $("#position_form").form("submit", {
                url: url,
                success: function (data) {
                    data = $.parseJSON(data);
                    if (data.success) {
                        //提示消息,当点确定的时候,关闭对话框,刷新数据表格
                        $.messager.alert("温馨提示", data.msg, "info", function () {
                            $("#position_dialog").dialog("close");
                            $("#position_datagrid").datagrid("reload");
                        });
                    } else {
                        $.messager.alert("温馨提示", data.msg, "error");
                    }
                }
            }, "json");
        },
        cancel: function () {
            $("#position_dialog").dialog("close");
        },
        delete: function () {
            var rowData = $("#position_datagrid").datagrid("getSelected");
            if (rowData) {
                $.messager.confirm("温馨提示", "您确定需要删除该职位吗?", function (yes) {
                    if (yes) {
                        $.get("/position/delete?id=" + rowData.id, function (data) {
                            if (data.success) {
                                $("#position_datagrid").datagrid("reload");
                                $.messager.alert("温馨提示", data.msg, "info");
                            } else {
                                $.messager.alert("温馨提示", data.msg, "error");
                            }
                        }, "json")
                    }
                });
            } else {
                $.messager.alert("温馨提示", "请选择需要删除的职位.", "warning");
            }
        },
    }
});
