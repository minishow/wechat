$(function () {
    $("#employee_datagrid").datagrid({
        url:'',
        striped:true,
        pagination:true,
        fit:true,
        columns:[[
            {field:'code',title:'代码',width:100},
            {field:'name',title:'名称',width:100},
            {field:'price',title:'价格',width:100,align:'right'}
        ]]


    })
});