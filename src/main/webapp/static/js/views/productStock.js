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
        url: '/productStock/list',
        striped: true,
        singleSelect: true,
        columns: [ [
            {field: 'id', title: '库存编号', width: '10%', align: 'center', sortable: true},
            {field: 'productInfoId', title: '产品编号', width: '10%', align: 'center', sortable: true},
            {   field: 'supplierId',
                title: '供应商Id',
                width: '10%',
                align: 'right',
                align: 'center',
                sortable: true
            },
            {
                field: 'packageNumber',
                title: '整装数量',
                width: '10%',
                align: 'right',
                align: 'center',
                sortable: true,
            },
            {field: 'amount', title: '总价格', align: 'center', width: '10%'},
            {field: 'warnNumber', title: '预警数量', align: 'center', width: '10%'},
            {field: 'storeNumber', title: '仓库数量', align: 'center', width: '10%'},
            {field: 'incomeDate', title: '入库时间', align: 'center', width: '10%'},
            {field: 'outcomeDate', title: '出库时间', align: 'center', width: '10%'}

        ]],
        onClickRow: function () {
            var rowData = $("#myDatagrid").datagrid("getSelected");
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

function deptFormatter(value, rowData, index) {
    if (value) {
        return value.name;
    }
}
function stateFormatter(value, rowData, index) {
    if (value) {
        return "<font style='color: red'>离职</font>";
    } else {
        return "<font style='color: green'>在职</font>";

    }
}
function adminFormatter(value, rowData, index) {
    if (value) {
        return "是";
    } else {
        return "否";
    }
}


function del() {
    var rowData = $("#myDatagrid").datagrid("getSelected");
    if (rowData) {
        $.messager.confirm("温馨提示", "您确定需要删除这条记录吗？", function (yes) {
            if (yes) {
                var args = "id=" + rowData.id + "&state=1";
                $.get("/productStock/delete", args, function (data) {
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

    $("#myDatagrid").datagrid("reload");
}
function searchData() {
    var keyword = $("#productStock_keyword").textbox("getText");
    var url = "/productStock";
    var args = "keyword="+keyword;
    $.post(url, args, function (data) {
    }, "json");
    reload();
}
function edit() {
    var rowData = $("#myDatagrid").datagrid("getSelected");
    if (rowData) {
        $("#edit_form").dialog({
            title: '编辑',
            width: 300,
            height: 250,
            closed: false,
            modal: true
        });
        $("#edit_form").form("clear");
        rowData["dept.id"] = rowData.dept.id;
        $("#edit_form").form("load", rowData);
        $.get("/productStock/queryRoles?id="+rowData.id, function (data) {
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
        url = "/productStock/edit";
    } else {
        url = "/productStock/save";
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
                    $.get("/productStock/queryRoles?id="+eleId, function (param) {
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