$(function () {
    var cashBillChartDatagird;
    cashBillChartDatagird = $("#cashBillChart_datagrid");
    cashBillChartDatagird.datagrid({
        fit:true,
        fitColumns: true,
        url:"/chart/queryCashBillList",
        pagination: true,
        rownumbers: true,
        singleSelect: true,
        columns: [
            [
                {field: "sn", title: "订单编号", width: 100, align: "center"},
                {field: "totalNumber", title: "消费总数量", width: 100, align: "center"},
                {field: "totalAmount", title: "消费总金额(RMB)", width: 100, align: "center"},
                {field: "paymentTerm", title: "消费方式", width: 100, align: "center",formatter:paymentFormatter}
            ]
        ]
    });
    $("#selectCash").combobox({
        width: 190,
        label: '消费方式:',
        valueField: 'id',
        textField: 'name',
        value:'0',
        url: '/static/js/data/selectCash.json',
        onSelect: function (record) {
            $.get("/chart/queryCashType?typeId="+record.id,function (data) {
                cashBillChartDatagird.datagrid('loadData',data);
            })
        }
    })
});
function paymentFormatter(value,record,index) {
    if (value == 1) {
        return "现金消费";
    } else if (value == 2) {
        return "微信付款";
    } else if (value == 3) {
        return "支付宝付款";
    } else {
        return "会员卡内消费";
    }
}