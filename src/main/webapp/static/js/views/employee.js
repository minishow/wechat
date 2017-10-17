$(function () {
    $("#employee_datagrid").datagrid({
        url: '/employee/queryByPageList',
        striped: true,
        pagination: true,
        rownumbers: true,
        singleSelect: true,
        fit: true,
        toolbar: "#employee_datagrid_tb",
        columns: [[
            {field: 'jobNumber', title: '工号', width: 100},
            {field: 'position', title: '职位', width: 100, formatter: positionFunction},
            {field: 'name', title: '姓名', width: 100},
            {field: 'gender', title: '性别', width: 100, formatter: genderFunction},
            {field: 'tel', title: '联系电话', width: 100},
            {field: 'entryTime', title: '入职时间', width: 100},
            {field: 'resignationTime', title: '离职时间', width: 100},
            {field: 'basePay', title: '基本工资', width: 100, align: 'right'},
            {field: 'state'},
            {field: 'idCard', title: '身份证号码', width: 100, align: 'right'},
        ]],
        onClickRow:function(rowIndex,rowData){
            //判断当前记录中的状态的值.
            if(rowData.state==1){
                console.log(rowData.state);
                //员工已经离职了,编辑和离职按钮应该变灰.
                $("#employee_dimissionBtn,#employee_editBtn").linkbutton("disable");
            }else{
                //启用按钮
                $("#employee_dimissionBtn,#employee_editBtn").linkbutton("enable");
            }
        }
    });

    $("#selectName").textbox({
        width: 180,
        labelWidth: 60,
        prompt: "请输入姓名或工号查询",
        buttonText: '查询',
        onClickButton: function () {
            var keyword = $(this).val();
            $("#employee_datagrid").datagrid("load", {
                keyword: keyword,
            });
        }
    });

    //对话框
    $("#employee_dialog").dialog({
        width: 300,
        height: 350,
        buttons: '#employee_dialog_bt',
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
            $("#employee_form").form("clear");
            //2.设置对话框的标题
            $("#employee_dialog").dialog("setTitle", "新增员工");
            //3.打开对话框
            $("#employee_dialog").dialog("open");
        },
        //编辑
        edit: function () {
            var rowData = $("#employee_datagrid").datagrid("getSelected");
            if (rowData) {
                //1.清空表单数据
                $("#employee_form").form("clear");
                //2.设置对话框的标题
                $("#employee_dialog").dialog("setTitle", "新增");
                //3.打开对话框
                $("#employee_dialog").dialog("open");
                //特殊数据的处理
                if (rowData.position)
                    rowData["position.id"] = rowData.position.id;
                //4.回显数据
                $("#employee_form").form("load", rowData);//基于同名匹配规则

            } else {
                $.messager.alert("温馨提示", "请选择一条需要修改的数据.", "warning");
            }

        },
        //保存
        save: function () {
            var url;
            var idVal = $("[name='id']").val();
            if (idVal) {
                url = "/employee/update";
            } else {
                url = "/employee/save";
            }
            $("#employee_form").form("submit", {
                url: url,
                success: function (data) {
                    data = $.parseJSON(data);
                    if (data.success) {
                        //提示消息,当点确定的时候,关闭对话框,刷新数据表格
                        $.messager.alert("温馨提示", data.msg, "info", function () {
                            $("#employee_dialog").dialog("close");
                            $("#employee_datagrid").datagrid("reload");
                        });
                    } else {
                        $.messager.alert("温馨提示", data.msg, "error");
                    }
                }
            }, "json");
        },
        cancel: function () {
            $("#employee_dialog").dialog("close");
        },
        dimission: function () {
            var rowData = $("#employee_datagrid").datagrid("getSelected");
            if (rowData) {
                $.messager.confirm("温馨提示", "您确定需要离职该员工吗?", function (yes) {
                    if (yes) {
                        $.get("/employee/dimission?id=" + rowData.id, function (data) {
                            if (data.success) {
                                $("#employee_datagrid").datagrid("reload");
                                $.messager.alert("温馨提示", data.msg, "info");
                            } else {
                                $.messager.alert("温馨提示", data.msg, "error");
                            }
                        }, "json")
                    }
                });
            } else {
                $.messager.alert("温馨提示", "请选择需要离职的员工记录.", "warning");
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
function positionFunction(value, row, index) {
    if (value) {
        return value.name;
    } else {
        return value;
    }
}
