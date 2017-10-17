$(function () {
    $("#pay_datagrid").datagrid({
        url: '/pay/list',
        striped: true,
        pagination: true,
        rownumbers: true,
        singleSelect: true,
        fit: true,
        toolbar: "#pay_datagrid_tb",
        columns: [[
            {field: 'jobNumber', title: '工号', width: 100},
            {field: 'name', title: '姓名', width: 100},
            {field: 'basePay', title: '基本工资', width: 100},
            {field: 'jobSubsidys', title: '岗位津贴', width: 100,},
            {field: 'travelAllowance', title: '交通补贴', width: 100},
            {field: 'airtimeSubsidy', title: '话费补贴', width: 100},
            {field: 'meaSubsidy', title: '餐补', width: 100},
            {field: 'attendanceBonus', title: '全勤', width: 100, align: 'right'},
            {field: 'commissionRate', title: '提成', width: 100, align: 'right'},
            {field: 'days', title: '请假', width: 100, align: 'right',formatter:daysFunction},
            {field: 'idCard', title: '总计', width: 100, align: 'right',formatter:idCardFunction}
        ]]
    });

    $("#selectName").textbox({
        width: 180,
        labelWidth: 60,
        prompt: "请输入姓名查询",
        buttonText: '查询',
        onClickButton: function () {
            var keyword = $(this).val();
            $("#pay_datagrid").datagrid("load", {
                keyword: keyword,
            });
        }
    });
});


//工资计算
function daysFunction(value, record, index) {
    if(record.days){
        return ((record.basePay / 30) * record.days).toFixed(2);
    }else{
        return 0;
    }
}
//总工资
function idCardFunction(value, record, index) {
    if(record){
       var sum = record.basePay + record.jobSubsidys + record.travelAllowance + record.airtimeSubsidy
                 +record.meaSubsidy + record.attendanceBonus-((record.basePay / 30) * record.days);
        return sum.toFixed(2);
    }else{
        return 0;
    }
}

//职位
function positionFunction(value, row, index) {
    if (value) {
        return value.name;
    } else {
        return value;
    }
}
