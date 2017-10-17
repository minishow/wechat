/**
 * Created by Administrator on 2017/10/13.
 */
$(function () {
    $("#datagrip_table").datagrid({
        fit:true,
        fitColumns: true,
        pagination: true,
        rownumbers: true,
        url: '/stockIncomeRecord/list',
        striped: true,
        singleSelect: true,
        columns: [ [
            {field: 'productName', title: '商品名称', align: 'center',width:'8%', sortable: true,formatter: productNameFormatter},
            {field: 'inputTime', title: '入库时间',  align: 'center',width:'10%', sortable: true,formatter: inputTimeFormatter},
            {field: 'productType', title: '商品类型',align: 'center',width:'10%', sortable: true,formatter: productTypeFormatter},
            {field: 'specificName', title: '商品规格',  align: 'center',width:'10%', sortable: true,formatter: specificFormatter},
            {field: 'costPrice', title: '进货价', align: 'center',width:'8%', sortable: true,formatter: costPriceFormatter},
            {field: 'productionPrice', title: '售价',  align: 'center',width:'8%', sortable: true,formatter: productionPriceFormatter},
            {field: 'memberPrice', title: '会员价（元）', align: 'center',width:'8%', sortable: true,formatter:memberPriceFormatter},
            {field: 'warnNumber', title: '预警日期',  align: 'center',width:'8%', sortable: true,formatter: warnNumberFormatter},
            {field: 'survivalTime', title: '保质期', align: 'center',width:'8%', sortable: true,formatter: survivalTimeFormatter},
            {   field: 'number',
                title: '入库数量',
                align: 'right',
                width:'8%',
                align: 'center',
                sortable: true
            },
            {
                field: 'amount',
                title: '进货总价（元）',
                align: 'right',
                width:'8%',
                align: 'center',
                sortable: true,
            },
            {field: 'auditor', title: '操作人',width:'8%', align: 'center'}
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
            var keyword= $("#productStock_keyword").textbox("getText");
            $("#datagrip_table").datagrid("load",{keyword:keyword});

        }
    })

    $("#reload_data").linkbutton({
        width:60,
        height:30,
        plain:true,
        iconCls:'icon-search',
        onClick:function(){
            $("#productStock_keyword").textbox("clear");
            $("#datagrip_table").datagrid("reload");

        }
    })

});




function productNameFormatter(value, rowData, index) {
    if(rowData.stockOprationBill){
        if(rowData.stockOprationBill.productInfo){
            return rowData.stockOprationBill.productInfo.name;
        }else{
            return "";
        }
    }
}
function inputTimeFormatter(value, rowData, index) {
    if(rowData.stockOprationBill){
        return rowData.stockOprationBill.inputTime;
    }
}
function productTypeFormatter(value, rowData, index) {
    if(rowData.stockOprationBill){
        if(rowData.stockOprationBill.productInfo){
            if(rowData.stockOprationBill.productInfo.productType){
                return rowData.stockOprationBill.productInfo.productType.name;
            }
        }else{
            return "";
        }

    }
}
function specificFormatter(value, rowData, index) {
    if(rowData.stockOprationBill.openStock){
        return rowData.stockOprationBill.openStock.name;
    }
}
function costPriceFormatter(value, rowData, index) {
    if(rowData.stockOprationBill){
        return rowData.stockOprationBill.costPrice;
    }
}
function productionPriceFormatter(value, rowData, index) {
    if(rowData.stockOprationBill){
        return rowData.stockOprationBill.productionPrice;
    }
}
function memberPriceFormatter(value, rowData, index) {
    if(rowData.stockOprationBill){
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

