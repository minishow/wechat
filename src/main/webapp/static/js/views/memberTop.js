$(function () {


    memberInfoDatagrid = $("#membertop_datagrid");//表格ID

    memberInfoDatagrid.datagrid({
        fit: true,
        fitColumns: true,  //按界面自动布局
        singleSelect: true,//单选
        pagination: true, //翻页
        rownumbers: true, //显示行序列号
        url: "/memberTop/list",
        toolbar: "#SDUS_BTN",
        columns: [[
            {field: 'topnumber', title: '会员编号', width: 100, align: 'centre'},
            {field: 'topmembernumber', title: '会员卡号', width: 100, align: 'centre'},
            {field: 'topmembername', title: '会员名称', width: 100, align: 'centre'},
            {field: 'topshopnumber', title: '充值门店编号', width: 100, align: 'centre'},
            {field: 'topshopname', title: '充值门店名称', width: 100, align: 'centre'},
            {field: 'topdate', title: '充值时间', width: 100, align: 'centre'},
            {field: 'topbalance', title: '充值金额', width: 100, align: 'centre'},
            {field: 'topremark', title: '备注', width: 100, align: 'centre'},
        ]],
    })


})

//高级查询
function query(){
    $("#searchBtn").form("submit",
    {
        url:'/memberTop/list',
        success:function(data){
            var data = $.parseJSON(data);
            memberInfoDatagrid.datagrid("loadData",data);
        }
    }
    )
}