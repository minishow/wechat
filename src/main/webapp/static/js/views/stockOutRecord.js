/**
 * Created by Administrator on 2017/10/13.
 */
$(function () {

    $("#stockOutRecord_inputTime").datebox({
        label:'下单前时间',
        width:250,
    })



    $("#datagrip_table").datagrid({
        fit: true,
        fitColumns: true,
        pagination: true,
        rownumbers: true,
        url: '/stockOutRecord/list',
        striped: true,
        singleSelect: true,
        columns: [ [
            {field: 'id', title: '单号', width: '20%', align: 'center', sortable: true, formatter: idFormatter},
            {field: 'supplier', title: '商品名称', width: '20%', align: 'center', sortable: true, formatter: supplierFormatter},
            {field: 'inputTime', title: '下单时间', width: '17%', align: 'center', sortable: true, formatter: inputTimeFormatter},
            {
                field: 'state',
                title: '状态',
                width: '15%',
                align: 'right',
                align: 'center',
                sortable: true,formatter: stateFormatter
            },
            {field: 'auditor', title: '发货人', align: 'center', width: '13%'},
            {field: 'details', title: '详情', align: 'center', width: '16%'}
        ]],
        onClickRow: function () {
            var rowData = $("#datagrip_table").datagrid("getSelected");
            if (rowData.state == 1) {
                $("#del,#edit").linkbutton("disable");
            } else {
                $("#del,#edit").linkbutton("enable");
            }
        },
        toolbar: '#datagrip_tools'
    });

    $("#search_data").linkbutton({
        width:60,
        height:30,
        plain:true,
        iconCls:'icon-search',
        onClick:function(){
            var keyword= $("#stockOutRecord_keyword").textbox("getText");
            var inputTime= $("#stockOutRecord_inputTime").textbox("getText");
            $("#datagrip_table").datagrid("load",{keyword:keyword,inputTime:inputTime});

        }
    })

    $("#reload_data").linkbutton({
        width:60,
        height:30,
        plain:true,
        iconCls:'icon-search',
        onClick:function(){
            $("#stockOutRecord_keyword").textbox("clear");
            $("#stockOutRecord_inputTime").textbox("clear");
            $("#datagrip_table").datagrid("reload");

        }
    })



});

function idFormatter(value, rowData, index) {
    if (rowData.stockOprationBill) {
        return rowData.stockOprationBill.sn;
    }
}
function supplierFormatter(value, rowData, index) {
    if(rowData.stockOprationBill){
        if (rowData.stockOprationBill.productInfo) {
            return rowData.stockOprationBill.productInfo.name;
        }
    }

}
function inputTimeFormatter(value, rowData, index) {
    if (rowData.stockOprationBill) {
        return rowData.stockOprationBill.inputTime;
    }
}

function stateFormatter(value, rowData, index) {
    if (rowData.state) {
        return "<font style='color: red'>已审核</font>";
    } else {
        return "<font style='color: green'>待审核</font>";

    }
}



