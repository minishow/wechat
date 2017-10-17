$(function () {
    var cashBillChartDatagird;
    cashBillChartDatagird = $("#cashBillChart_datagrid");
    cashBillChartDatagird.datagrid({
        fit:true,
        fitColumns: true,
        url:"/cashBillChart/list",
        toolbar: "#cashBillChart_datagrid_tb",
        pagination: true,
        rownumbers: true,
        singleSelect: true,
        columns: [
            [
                {field: "name", title: "权限名称", width: "45%", align: "center"},
                {field: "resource", title: "权限表达式", width: "55%", align: "center"}
            ]
        ]
    });
    //同一管理方法
    var cmdObj = {
        reload : function() {
            $.messager.confirm("温馨提示","确定要加载权限吗?",function (yes) {
                if (yes) {
                    $.get("/cashBillChart/reload",function (data) {
                        if (data.success) {
                            $.messager.alert("温馨提示",data.msg,"info",function () {
                                cashBillChartDatagird.datagrid('reload');
                            });
                        } else {
                            $.messager.alert("温馨提示",data.msg,"error");
                        }
                    },"json");
                }
            });
        }
    };
    $("a[data-cmd]").on('click',function () {
        var cmd = $(this).data('cmd');
        cmdObj[cmd]();
    });
});