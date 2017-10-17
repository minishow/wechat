$(function () {
    $("#cashBill_datagrid").datagrid({
        fit:true,
        singleSelect:true, /*只选择一个*/
        striped:true, /*斑马线*/
        rownumbers:true, /*行号列*/
        pagination:true, /*分页*/
        fitColumns:true,
        url:"/cashbill/list",
        columns:[[
            {field:'sn',title:'订单编号',width:10,align:'center'},
            {field:'memberNumber',title:'会员卡号',width:10,align:'center',
                formatter: function (value,row,index) {
                return row.memberId?row.memberId.number:"非会员";
            }},
            {field:'shopName',title:'店铺名称',width:10,align:'center'},
            {field:'orderTime',title:'订单时间',width:10,align:'center'},
            {field:'totalNumber',title:'商品总数',width:10,align:'center'},
            {field:'totalAmount',title:'总消费金额(元)',width:10,align:'center'},
            {field:'employeeName',title:'操作人',width:10,align:'center'},
            {field:'paymentTerm',title:'收款方式',width:10,align:'center',
                formatter: function (value,row,index) {
                    if(value == 1){
                        return "现金"
                    }
                    else if(value == 2){
                        return "微信"
                    }
                    else if(value == 3){
                        return "支付宝"
                    }
                    else{
                        return "卡内消费";
                    }
                }},
            {field:'check',title:'查看',width:10,align:'center',
                formatter:function (value,row,index) {
                var h = "";
                h += "<a href='javascript:checkItems(" + row.id + ")'>查看</a> ";
                return h
            }}
        ]]
    });

    //对话框
    $("#cashbill_dialog").dialog({
        width:1200,
        height:500,
        closed:true
    });

    $("#product_datagrid").datagrid({
        title:"商品明细",
        width:1200,
        height:400,
        singleSelect:true, /*只选择一个*/
        striped:true, /*斑马线*/
        rownumbers:true, /*行号列*/
        pagination:true, /*分页*/
        fitColumns:true,
        columns:[[
            {field:'productInfoIdCode',title:'商品条码',width:10,align:'center',
                formatter: function (value,row,index) {
                    console.log(row);
                    return row.productInfoId?row.productInfoId.code:"";
                }},
            {field:'productInfoIdName',title:'商品名称',width:10,align:'center',
                formatter: function (value,row,index) {
                  return row.productInfoId?row.productInfoId.name:"";
                }},
            {field:'productInfoIdPrice',title:'原价(元)',width:10,align:'center',
                formatter: function (value,row,index) {
                    return row.productInfoId?row.productInfoId.price:"";
                }},
            {field:'productInfoIdMemberPrice',title:'会员价(元)',width:10,align:'center',
                formatter: function (value,row,index) {
                    return row.productInfoId?row.productInfoId.memberPrice:"";
                }},
            {field:'number',title:'销售数量',width:10,align:'center'},
            {field:'costAmount',title:'原价总价格(元)',width:10,align:'center'},
            {field:'memberAmount',title:'会员总价格(元)',width:10,align:'center'}
        ]]
    })
});
//点击查看
function checkItems(billId){
    $("#cashbill_dialog").dialog("open");
    $("#cashbill_dialog").dialog("setTitle","商品详情");
    $("#productName").val("");

    var options = $("#product_datagrid").datagrid("options");
    options.url = "/cashbillitem/queryAllByBillId?billId="+billId;
    $("#product_datagrid").datagrid("load",{
        "productName":""
    });

}

//高级查询 按钮
function check(){
    var keyword = $("#keyword").val();
    var beginDate = $("#beginDate").val();
    var endDate = $("#endDate").val();
    var way = $('#way option:selected').val();//选中的值

    $("#cashBill_datagrid").datagrid("load",{
        keyword:keyword,
        beginDate:beginDate,
        endDate:endDate,
        way:way
    })

}

//明细的高级查询
function checkItem(){
    var productName = $("#productName").val();
    $("#product_datagrid").datagrid("load",{
        productName:productName
    })

}

