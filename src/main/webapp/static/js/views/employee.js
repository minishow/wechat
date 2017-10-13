$(function () {
    $("#employee_datagrid").datagrid({
        url:'/employee/queryByPageList',
        striped:true,
        pagination:true,
        fit:true,
        columns:[[
            {field:'jobNumber',title:'工号',width:100},
            {field:'position',title:'职位',width:100},
            {field:'name',title:'姓名',width:100},
            {field:'gender',title:'性别',width:100},
            {field:'tel',title:'联系电话',width:100},
            {field:'entryTime',title:'入职时间',width:100},
            {field:'resignationTime',title:'名称',width:100},
            {field:'basePay',title:'价格',width:100,align:'right'},
            {field:'idCard',title:'价格',width:100,align:'right'}
        ]]


    })
});