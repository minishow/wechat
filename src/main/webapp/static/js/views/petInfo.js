$(function(){

    alert(111);

    memberInfoDatagrid=$("#memberInfo_datagrid");
    memberInfoDatagrid.datagrid({
        fit:true,
        fitColumns:true,  //
        singleSelect:true,//单选
        pagination:true, //翻页
        rownumbers:true, //显示行序列号
        url:"/petInfo/list",
        toolbar:"#SDUS_BTN",
        columns:[[
            {field:'number',title:'会员号',width:100,align:'centre',formatter:adminNumber},
            {field:'petName',title:'宠物姓名',width:100,align:'centre'},
            {field:'petGender',title:'性别',width:100,align:'centre'},
            {field:'petType',title:'宠物品种',width:100,align:'centre'},
            {field:'petAncestry',title:'血统',width:100,align:'centre'},
            {field:'petColour',title:'毛色',width:100,align:'centre'},
            {field:'balance',title:'余额',width:100,align:'centre',formatter:adminDalance},
            {field:'adress',title:'地址',width:100,align:'centre',formatter:adminAdress},
            {field:'remark',title:'备注',width:100,align:'centre',formatter:adminRemark}
        ]],
    })


})
function adminNumber(value,record,index){
    if(record.member){
        return record.member.name
    }else {
        return ""
    }
}
function adminDalance(value,record,index){
    if(record.member){
        return record.member.dalance
    }else {
        return ""
    }

}function adminAdress(value,record,index){
    if(record.member){
        return record.member.adress
    }else {
        return ""
    }

}function adminRemark(value,record,index){
    if(record.member){
        return record.member.remark
    }else {
        return ""
    }

}