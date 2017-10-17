/**
 * Created by Administrator on 2016.7/6.7/13.
 */
function datagridTable(param) {
    $("#" + param).datagrid({
        fit: true,
        fitColumns: true,
        pagination: true,
        rownumbers: true,
        striped: true,
        singleSelect: true,
        columns: [[
            {field: 'productInfo.name', title: '商品名称', align: 'center', width: '6.7%', color: 'red'},
            {field: "productionPrice", title: '商品价格', width: '6.7%', align: 'center', sortable: true},
            {field: "costPrice", title: '进货价/发货价', width: '6.7%', align: 'center', sortable: true},
            {field: "memberPrice", title: '会员价', width: '6.7%', align: 'center', sortable: true},
            {field: "number", title: '数量', width: '6.7%', align: 'center', sortable: true},
            {
                field: 'stockIncome.id',
                title: '入库方式',
                width: '6.7%',
                align: 'right',
                align: 'center',
                sortable: true,
            },
            {
                field: 'productStock.sn',
                title: '库存单号',
                width: '6.7%',
                align: 'right',
                align: 'center',
                sortable: true,
            },
            {field: 'specific.id', title: '原有规格', align: 'center', width: '6.7%'},
            {field: 'specific.number', title: '数量', align: 'center', width: '6.7%'},
            {field: 'specific.stockSpecific', title: '拆零规格', align: 'center', width: '6.7%', color: 'red',},
            {field: 'inputTime', title: '生产日期', align: 'center', width: '6.7%'},
            {field: 'survivalTime', title: '保质期', align: 'center', width: '6.7%'},
            {field: 'warnDate', title: '预警日期', align: 'center', width: '6.7%', color: 'red'},
            {field: 'warnNumber', title: '预警数量', align: 'center', width: '6.7%'},
            {field: 'operation', title: '操作', align: 'center', width: '6.7%', color: 'red',}

        ]],
        onClickRow: function () {
            var rowData = $("#datagrip_table").datagrid("getSelected");
            if (rowData.state == 1) {
                $("#del,#edit").linkbutton("disable");
            } else {
                $("#del,#edit").linkbutton("enable");
            }
        }, onDblClickRow: function (data) {
            $("#" + param).datagrid("deleteRow", data);
            $("#datagrip_table").datagrid("deleteRow", data);
        },
        toolbar: '#datagrip_tools'
    });
}


$(function () {
    datagridTable("datagrip_table");
    datagridTable("datagrip_show");
    $("#submit_btn").click(function () {
        var form1 = $('#operation_form').form('validate');
        if (form1) {
            $('#datagrip_table').datagrid('appendRow', {
                'productInfo.name': $("#product_name").combobox("getValue"),
                'productionPrice': $("#code").textbox("getText"),
                'costPrice': $("#costPrice").numberbox("getText"),
                'memberPrice': $("#memberPrice").numberbox("getValue"),
                'number': $("#number").numberbox("getValue"),
                'stockIncome.id': $("#stockIncome").combobox("getValue"),
                'productStock.sn': $("#sn").textbox("getText"),
                'specific.number': $("#specific_number").numberbox("getValue"),
                'specific.id': $("#before_specific").combobox("getValue"),
                'specific.stockSpecific': $("#stock_specific").combobox("getValue"),
                'inputTime': $("#product_date").datebox("getValue"),
                'survivalTime': $("#survival_time").datebox("getValue"),
                'warnDate': $("#input_survival").datebox("getValue"),
                'warnNumber': $("#warn_number").numberbox("getValue"),
                'operation': $("#warn_operation").textbox("getText")
            });
            $('#datagrip_show').datagrid('appendRow', {
                'productInfo.name': $("#product_name").combobox("getText"),
                'productionPrice': $("#code").textbox("getText"),
                'costPrice': $("#costPrice").numberbox("getText"),
                'memberPrice': $("#memberPrice").numberbox("getValue"),
                'number': $("#number").numberbox("getValue"),
                'stockIncome.id': $("#stockIncome").combobox("getText"),
                'productStock.sn': $("#sn").textbox("getText"),
                'specific.number': $("#specific_number").numberbox("getValue"),
                'specific.id': $("#before_specific").combobox("getText"),
                'specific.stockSpecific': $("#stock_specific").combobox("getText"),
                'inputTime': $("#product_date").datebox("getValue"),
                'survivalTime': $("#survival_time").datebox("getValue"),
                'warnDate': $("#input_survival").datebox("getValue"),
                'warnNumber': $("#warn_number").numberbox("getValue"),
                'operation': $("#warn_operation").textbox("getText")
            });
        } else {
            $.messager.alert("温馨提示", "亲，必填框必须填写内容哦！", "warning");

        }
    });


    $("#productionPrice").numberbox("disable");
    $("#code").textbox("disable");
    $("#productInfo_location").combobox("disable");
    $("#productInfo_brand").combobox("disable");
    $("#productInfo_productType").combobox("disable");
    $("#productInfo_productPart").combobox("disable");
    $("#product_name").combobox({
        onSelect: function (data) {
            console.log(data.id);
            $.get('/productStock/queryProductInfos?id=' + data.id, function (rowData) {
                $("#code").textbox("setText", rowData.code);
                $("#productInfo_productType").textbox("setText", rowData.productPart.name);
                $("#productInfo_productPart").textbox("setText", rowData.brand.name);
                $("#productInfo_brand").textbox("setText", rowData.productType.name);
                $("#productionPrice").textbox("setText", rowData.price);
                $("#productInfo_location").textbox("setText", rowData.brand.location.name);
            })
        }
    });

    $("#operation_form").form("validate", function (data) {
        alert(data);
    });


});


/* $('#operation_form').form('submit', {
 url:"#",
 onSubmit: function(data){
 console.log(data);
 return data;	// 返回false终止表单提交
 },
 success: function(){
 $.messager.progress('close');	// 如果提交成功则隐藏进度条
 }
 });*/




/*
 function productCodeFormatter(value, rowData, index) {
 if(rowData.productInfo){
 return rowData.productInfo.code;
 }
 }
 */






