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
            {field: 'sn', title: '库存编码', align: 'center', width: '10%',color:'red'},
            {field: "code", title: '商品69码', width: '10%', align: 'center', sortable: true,formatter: productCodeFormatter},
            {field: "name", title: '商品名称', width: '10%', align: 'center', sortable: true,formatter: productNameFormatter},
            {field: "productType", title: '商品类型', width: '10%', align: 'center', sortable: true,formatter: productTypeFormatter},
            {field: "brand", title: '商品品牌', width: '10%', align: 'center', sortable: true,formatter: brandFormatter},
            {   field: 'productPart',
                title: '主要成分',
                width: '10%',
                align: 'right',
                align: 'center',
                sortable: true,
                formatter: productPartFormatter
            },
            {
                field: 'packageNumber',
                title: '整装库存',
                width: '10%',
                align: 'right',
                align: 'center',
                sortable: true,
            },
            {field: 'bulkNumber', title: '散装库存', align: 'center', width: '10%'},
            {field: 'amount', title: '库存结余（元）', align: 'center', width: '10%'},
            {field: 'warnNumber', title: '预警数量', align: 'center', width: '10%',color:'red',styler:stylerFormatter},

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



});

function productCodeFormatter(value, rowData, index) {
     if(rowData.productInfo){
        return rowData.productInfo.code;
    }
}
function productNameFormatter(value, rowData, index) {
    if(rowData.productInfo){
        return rowData.productInfo.name;
    }
}
function productTypeFormatter(value, rowData, index) {
    if(rowData.productInfo){
       return rowData.productInfo.productType.name;
    }
}

function brandFormatter(value, rowData, index) {
    if(rowData.productInfo){
       return rowData.productInfo.brand.name;
    }
}function productPartFormatter(value, rowData, index) {
    if(value){
       return value.name;
    }
}

function stylerFormatter(value, rowData, index) {
    if(value>0){
        return  'background-color:#ffee00;color:red;';
    }

}

$(function(){
    $("#searchData").linkbutton({
        width:60,
        height:30,
        plain:true,
        iconCls:'icon-search',
        onClick:function(){
            var url="/productStock/json";
            var keyword= $("#code_sn").textbox("getText");
            var productName=$("#productName").textbox("getText");
            var productType=$("#productType").textbox("getText");
            alert(keyword);
            var data="keyword="+keyword+"&productName="+productName+"&productType="+productType;
            $("#datagrip_table").datagrid("load",{keyword:keyword,productName:productName,productType:productType});
          /*  $.post(url, data, function (data) {
                console.log(data);
              /!*  $("#datagrip_table").datagrid("clear");*!/

                alert(123);
            }, "json");*/
        }
    })
})



