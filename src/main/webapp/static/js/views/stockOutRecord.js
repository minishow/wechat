/**
 * Created by Administrator on 2017/10/13.
 */
$(function () {
    $("#datagrip_table").datagrid({
        fit: true,
        fitColumns: true,
        pagination: true,
        rownumbers: true,
        rownumbers: true,
        url: '/stockOutRecord/list',
        striped: true,
        singleSelect: true,
        columns: [ [
            {field: 'id', title: '单号', width: '10%', align: 'center', sortable: true, formatter: idFormatter},
            {field: 'supplier', title: '进货店铺', width: '10%', align: 'center', sortable: true, formatter: supplierFormatter},
            {field: 'inputTime', title: '下单时间', width: '10%', align: 'center', sortable: true, formatter: inputTimeFormatter},
            {
                field: 'state',
                title: '总价格',
                width: '10%',
                align: 'right',
                align: 'center',
                sortable: true,formatter: stateFormatter
            },
            {field: 'auditor', title: '发货人', align: 'center', width: '10%'},
            {field: 'details', title: '详情', align: 'center', width: '10%'}
        ]],
        onClickRow: function () {
            var rowData = $("#datagrip_table").datagrid("getSelected");
            if (rowData.state == 1) {
                $("#del,#edit").linkbutton("disable");
            } else {
                $("#del,#edit").linkbutton("enable");
            }
        },
        toolbar: '#myTools'
    });



});

function add() {
    $('#edit_form').dialog({
        title: '新增',
        width: 300,
        height: 250,
        closed: false,
        modal: true
    });
    $("#edit_form").form("clear");
}






function idFormatter(value, rowData, index) {
    if (rowData.stockOprationBill) {
        return rowData.stockOprationBill.id;
    }
}
function supplierFormatter(value, rowData, index) {
    if (rowData.stockOprationBill) {
        return rowData.stockOprationBill.supplier.name;
    }
}
function inputTimeFormatter(value, rowData, index) {
    if (rowData.stockOprationBill) {
        return rowData.stockOprationBill.inputTime;
    }
}

function stateFormatter(value, rowData, index) {
    if (value) {
        return "<font style='color: red'>已审核</font>";
    } else {
        return "<font style='color: green'>待审核</font>";

    }
}





function del() {
    var rowData = $("#datagrip_table").datagrid("getSelected");
    if (rowData) {
        $.messager.confirm("温馨提示", "您确定需要删除这条记录吗？", function (yes) {
            if (yes) {
                var args = "id=" + rowData.id + "&state=1";
                $.get("/stockOutRecord/delete", args, function (data) {
                    if (data.success) {
                        reload();
                        $.messager.alert("温馨提示", data.msg, "warning", function () {
                            $("#edit_form").dialog("close");
                        });
                    } else {
                        $.messager.alert("温馨提示", data.msg, "warning", function () {
                            $("#edit_form").dialog("close");
                        });
                    }
                }, "json");
            } else {
                $.messager.alert("温馨提示", data.msg, "warning", function () {
                    $("#edit_form").dialog("close");
                });
            }
        });

    } else {
        $.messager.alert("温馨提示", "亲，请选择需要编辑的项", "warning");
    }
}
function reload() {

    $("#datagrip_table").datagrid("reload");
}
function searchData() {
    var keyword = $("#stockOutRecord_keyword").textbox("getText");
    var url = "/stockOutRecord";
    var args = "keyword="+keyword;
    $.post(url, args, function (data) {
    }, "json");
    reload();
}
function edit() {
    var rowData = $("#datagrip_table").datagrid("getSelected");
    if (rowData) {
        $("#edit_form").dialog({
            title: '编辑',
            width: 300,
            height: 250,
            closed: false,
            modal: true
        });
        $("#edit_form").form("clear");
        $("#edit_form").form("load", rowData);
        $.get("/stockOutRecord/queryRoles?id="+rowData.id, function (data) {
            var param=$.map(data,function(item){
                var arr=new Array(2);
                arr.add(item.name);
                arr.add(item.id);
                return arr;
            })
            $('#multiple_role').combobox('setValues', param);
        });
    } else {
        $.messager.alert("温馨提示", "亲，请选择需要编辑的项", "warning");
    }
}

function saveInput() {
    var url;
    var eleId = $("[name='id']").val();
    if (eleId) {
        url = "/stockOutRecord/edit";
    } else {
        url = "/stockOutRecord/save";
    }
    $("#edit_form").form("submit", {
        url: url,onSubmit:function (param){
            var ids=$("#multiple_role").combobox("getValues");
            for(var i= 0;i<ids.length;i++){
                param["roles["+i+"].id"]=ids[i];
            }
        },
        success: function (data) {
            var dataJson = eval("(" + data + ")");
            if (dataJson.success) {
                reload();
                if (eleId) {
                    $.get("/stockOutRecord/queryRoles?id="+eleId, function (param) {
                        var newParam=$.map(param,function(item){
                            var arr=new Array(2);
                            arr.add(item.name);
                            arr.add(item.id);
                            return arr;
                        })
                        $('#multiple_role').combobox('setValues', newParam);
                    });
                }
                $.messager.alert("温馨提示", dataJson.msg, "warning", function () {
                    $("#edit_form").dialog("close");
                });
            } else {
                $.messager.alert("温馨提示", dataJson.msg, "warning", function () {
                    $("#edit_form").dialog("close");
                });
            }
        }
    }, "json");
}
function closeInput() {
    $("#edit_form").dialog("close");
}