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
        url: '/stockIncomeRecord/list',
        striped: true,
        singleSelect: true,
        columns: [ [
            {field: 'productName', title: '商品名称', width: '10%', align: 'center', sortable: true,formatter: productNameFormatter},
            {field: 'inputTime', title: '入库时间', width: '10%', align: 'center', sortable: true,formatter: inputTimeFormatter},
            {field: 'productType', title: '商品类型', width: '10%', align: 'center', sortable: true,formatter: productTypeFormatter},
            {field: 'specificName', title: '商品规格', width: '10%', align: 'center', sortable: true,formatter: specificFormatter},
            {field: 'costPrice', title: '进货价', width: '10%', align: 'center', sortable: true,formatter: costPriceFormatter},
            {field: 'productionPrice', title: '售价', width: '10%', align: 'center', sortable: true,formatter: productionPriceFormatter},
            {field: 'memberPrice', title: '会员价（元）', width: '10%', align: 'center', sortable: true,formatter:memberPriceFormatter},
            {field: 'warnNumber', title: '预警日期', width: '10%', align: 'center', sortable: true,formatter: warnNumberFormatter},
            {field: 'survivalTime', title: '保质期', width: '10%', align: 'center', sortable: true,formatter: survivalTimeFormatter},
            {   field: 'number',
                title: '入库数量',
                width: '10%',
                align: 'right',
                align: 'center',
                sortable: true
            },
            {
                field: 'amount',
                title: '进货总价（元）',
                width: '10%',
                align: 'right',
                align: 'center',
                sortable: true,
            },
            {field: 'auditor', title: '操作人', align: 'center', width: '10%'}
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




function productNameFormatter(value, rowData, index) {
    if(rowData.stockOprationBill){
        return rowData.stockOprationBill.productInfo.name;
    }
}
function inputTimeFormatter(value, rowData, index) {
    if(rowData.stockOprationBill){
        return rowData.stockOprationBill.inputTime;
    }
}
function productTypeFormatter(value, rowData, index) {
    if(rowData.stockOprationBill){
        return rowData.stockOprationBill.productInfo.productType.name;
    }
}
function specificFormatter(value, rowData, index) {
    if(rowData){
        return rowData.stockOprationBill.specific.stockSpecific;
    }
}
function costPriceFormatter(value, rowData, index) {
    if(rowData){
        return rowData.stockOprationBill.costPrice;
    }
}
function productionPriceFormatter(value, rowData, index) {
    if(rowData){
        return rowData.stockOprationBill.productionPrice;
    }
}
function memberPriceFormatter(value, rowData, index) {
    if(rowData){
        return rowData.stockOprationBill.memberPrice;
    }
}
costPriceFormatter
function warnNumberFormatter(value, rowData, index) {
    if(rowData.stockOprationBill){
        return rowData.stockOprationBill.warnNumber;
    }
}
function survivalTimeFormatter(value, rowData, index) {
    if(rowData.stockOprationBill){
        return rowData.stockOprationBill.survivalTime;
    }
}









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
    var rowData = $("#datagrip_table").datagrid("getSelected");
    if (rowData) {
        $.messager.confirm("温馨提示", "您确定需要删除这条记录吗？", function (yes) {
            if (yes) {
                var args = "id=" + rowData.id + "&state=1";
                $.get("/stockIncomeRecord/delete", args, function (data) {
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
    var keyword = $("#stockIncomeRecord_keyword").textbox("getText");
    var url = "/stockIncomeRecord";
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
        $.get("/stockIncomeRecord/queryRoles?id="+rowData.id, function (data) {
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
        url = "/stockIncomeRecord/edit";
    } else {
        url = "/stockIncomeRecord/save";
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
                    $.get("/stockIncomeRecord/queryRoles?id="+eleId, function (param) {
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