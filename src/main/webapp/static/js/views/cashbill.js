$(function () {
    $("#cashBill_datagrid").datagrid({
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
                return row.MemberInfo?row.MemberInfo.number:"";
            }},
            {field:'shopName',title:'店铺名称',width:10,align:'center'},
            {field:'orderTime',title:'订单时间',width:10,align:'center'},
            {field:'totalNumber',title:'商品总数',width:10,align:'center'},
            {field:'totalAmount',title:'消费金额(元)',width:10,align:'center'},
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
    })
})



//点击查看
function checkItems(billId){

}