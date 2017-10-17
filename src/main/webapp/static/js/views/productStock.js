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


    $("#productInfo_code").textbox("disable");
    $("#productType_name").textbox("disable");
    $("#productPart_name").textbox("disable");
    $("#brand_name").textbox("disable");
    $("#productInfo_id").combobox({
        onSelect:function(data){
            console.log(data.id);
            $.get('/productStock/queryProductInfos?id='+data.id,function(rowData){
                $("#productInfo_code").textbox("setText",rowData.code);
                $("#productType_name").textbox("setText",rowData.productPart.name);
                $("#productPart_name").textbox("setText",rowData.brand.name);
                $("#brand_name").textbox("setText",rowData.productType.name);
            })
        }
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
    if(rowData){
       return rowData.productInfo.productPart.name;
    }
}

function stylerFormatter(value, rowData, index) {
    if(value>0){
        return  'background-color:#ffee00;color:red;';
    }

}

$(function(){
    loadData("#searchData");
    $("#reload_data").linkbutton({
        width:60,
        height:30,
        plain:true,
        iconCls:'icon-search',
        onClick:function(){
            $("#code_sn").textbox("clear");
            $("#productName").textbox("clear");
            $("#productTypes").textbox("clear");
            $("#datagrip_table").datagrid("reload");

        }
    })
})

function edit() {
    var rowData = $("#datagrip_table").datagrid("getSelected");
    if (rowData) {
        $("#edit_form").dialog({
            title: '编辑',
            width: 600,
            height: 400,
            closed: false,
            modal: true,
            buttons: '#edit_info'
        });
        rowData["productInfo.name"] = rowData.productInfo.name;
        rowData["productInfo.code"] = rowData.productInfo.code;
        rowData["productInfo.productPart.name"] = rowData.productInfo.productPart.name;
        rowData["productInfo.brand.name"] = rowData.productInfo.brand.name;
      rowData["productInfo.productType.id"] = rowData.productInfo.productType.name;
        rowData["productInfo.id"] = rowData.productInfo.id;
        $("#edit_form").form("clear");
        $("#edit_form").form("load", rowData);
    } else {
        $.messager.alert("温馨提示", "亲，请选择需要编辑的项", "warning");
    }
}


function saveInput() {
    var url;
    var eleId = $("[name='id']").val();
    url = "/productStock/saveOrUpdate";
    $("#edit_form").form("submit", {
        url:url,
        success: function (data) {
            var dataJson = eval("(" + data + ")");
            if (dataJson.success) {
                $("#datagrip_table").datagrid("reload");
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


function closeInput(){
    $("#edit_form").dialog("close");
}


function loadData(param){
    $(param).linkbutton({
        width:60,
        height:30,
        plain:true,
        iconCls:'icon-search',
        onClick:function(){
            var keyword= $("#code_sn").textbox("getText");
            var productName=$("#productName").textbox("getText");
            var productType=$("#productTypes").combobox("getValues");
            $("#datagrip_table").datagrid("load",{keyword:keyword,productName:productName,'productType':productType[0]});

        }
    })
}














/*

if (eleId) {
    $.get("/employee/queryRoles?id="+eleId, function (param) {
        /!*  $('#multiple_role').combobox('setValues', newParam);*!/
    });
}
*/

/*   url: url,onSubmit:function (param){
 var ids=$("#multiple_role").combobox("getValues");
 for(var i= 0;i<ids.length;i++){
 param["roles["+i+"].id"]=ids[i];
 }
 },*/