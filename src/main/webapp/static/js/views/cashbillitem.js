$(function () {
    //页面的数据表格
    var dg = $("#cashbillitem_datagrid").datagrid({
        singleSelect:true, /*只选择一个*/
        striped:true, /*斑马线*/
        rownumbers:true, /*行号列*/
        pagination:true, /*分页*/
        fitColumns:true,
        columns:[[
            {field:'id',title:'库存编号',width:10,align:'center'},
            {field:'code',title:'商品69条码',width:10,align:'center' ,formatter: function (value,row,index) {
                return row.productInfoId?row.productInfoId.code:"";
            }},
            {field:'name',title:'商品名称',width:10,align:'center',
                formatter: function (value,row,index) {
                    return row.productInfoId?row.productInfoId.name:"";
                } },
            {field:'price',title:'原价格',width:10,align:'center',
                formatter: function (value,row,index) {
                    return row.productInfoId?row.productInfoId.price:"";
                } },
            {field:'memberPrice',title:'会员价格',width:10,align:'center',
                formatter: function (value,row,index) {
                    return row.productInfoId?row.productInfoId.memberPrice:"";
                } },
            {field:'number',title:'数量',width:10,align:'center',
                editor:'text',
                formatter:function(value,row,index){
                    if(value!=null) {
                        return "<span id='number' >"+value+"</span>";
                    }
                    else {
                        return  "<span id='number'>"+1+"</span>";
                    }
                }},
            {field:'costAmount',title:'原价总价格',width:10,align:'center',
                formatter:function(value,row,index){
                    if(!value){
                        value = row.productInfoId.price;
                    }
                    return "<span id='costAmountId'>"+value +"</span>";
                }
            },
            {field:'memberAmount',title:'会员总价格',width:10,align:'center',
                formatter:function(value,row,index){
                    if(!value){
                        value = row.productInfoId.memberPrice;
                    }
                    return "<span id='memberAmountId'>"+value+"</span>";
                }
            },
            {field:'ID',title:'操作',width:10,align:'center',
                formatter:function (value,row,index) {
                    var h = "";
                    h += "<a href='javascript:deleteRow(" + index + ")'>删除</a> ";
                    return h
            }}
        ]],
         onAfterEdit: function (index, row, changes) {  //编辑完数量单元格触发事件
             row.costAmount = changes.number * row.productInfoId.price;
             row.memberAmount = changes.number * row.productInfoId.memberPrice;
             $('#cashbillitem_datagrid').datagrid("deleteRow",index);
             $('#cashbillitem_datagrid').datagrid('appendRow',row)

        }

    });
    /*开启编辑器*/
    dg.datagrid('enableCellEditing');

    //高级查询--查询库存
    $("#searchbtn").textbox({
        width:250,
        buttonIcon:'icon-search',
        buttonAlign:"left",
        buttonText:"商品69条码:",
        onClickButton: function () {
            var code =  $("#searchbtn").val();
            $.get("/productStock/getProductStockByProductinfoCode?code="+code, function (data) {
                if(data.id != null){
                     var rows = $("#cashbillitem_datagrid").datagrid("getRows");
                     var ids = $.map(rows, function (item) {
                        return item.id;
                     });
                    //判断数据表格是否已经有  :
                    if($.inArray(data.id,ids) >= 0 ){
                        $.messager.alert("温馨提示","已经添加,请点击数量进行操作","info");
                    }
                    else{
                        //没有:追加新行
                        $("#cashbillitem_datagrid").datagrid("appendRow",data);
                     }
                }
                else{
                    $.messager.alert("温馨提示","没有查询到该库存信息","info");
                }
            });
        }
    });

});

//删除该行
function deleteRow(rowid) {
    $.messager.confirm("温馨提示","确认移除吗?", function (yes) {
        if(yes){
             $("#cashbillitem_datagrid").datagrid("deleteRow",rowid);
             $("#cashbillitem_datagrid").datagrid("reload")
            $.messager.alert("温馨提示","移除成功","info")
        }
    })
}

