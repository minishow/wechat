$(function () {
    //页面的数据表格
    $("#cashbillitem_datagrid").datagrid({
        rownumbers:true,
        pagination:true,
        striped:true,
        fitColumns:true,
        columns:[[
            {field:'code',title:'商品69条码',width:10,align:'center'},
            {field:'name',title:'商品名称',width:10,align:'center'},
            {field:'price',title:'原价格',width:10,align:'center'},
            {field:'memberPrice',title:'会员价格',width:10,align:'center'},
            {field:'number',title:'数量',width:10,align:'center',editor:{type:'numberbox'}},
            {field:'unit',title:'单位',width:10,align:'center'},
            {field:'costAmount',title:'原价总价格',width:10,align:'center'},
            {field:'memberAmount',title:'会员总价格',width:10,align:'center'},
            {field:'operation',title:'操作',width:10,align:'center'}
        ]]
    })

    //高级查询--查询商品,封装收银明细对象
    $("#searchbtn").textbox({
        width:250,
        buttonIcon:'icon-search',
        buttonAlign:"left",
        buttonText:"商品69条码:",
        onClickButton: function () {
            var Code = searchbtn.val();
            $.get("/productinfo/getProductinfoByCode?Code="+Code, function (data) {
                $("#cashbillitem_datagrid").datagrid("appendRow",data);
              /*  //设置明细的信息
                var currentTr = $("#cashbillitem_datagrid tr");
                currentTr.find("[tag=code]").html(data.code);
                currentTr.find("[tag=pid]").val(data.id);
                currentTr.find("[tag=name]").html(data.name);
                currentTr.find("[tag=price]").html(data.price);
                currentTr.find("[tag=memberPrice]").html(data.memberPrice);
                currentTr.find("[tag=number]").val("1");
                currentTr.find("[tag=unit]").html(data.costPrice);*/
            },"json");
        }


    })

    //计算原价总价和会员总价格
    $("[tag=price],[tag=memberPrice],[tag=number]").change(function () {
        var currentTr = $(this).closest("tr"); //获取上一级的tr

    })

})