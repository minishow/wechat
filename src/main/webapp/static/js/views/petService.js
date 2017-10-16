$(function () {
    /*
     * 抽取所有需要用得元素.
     */
    var petServiceMenuTree,petServiceRegisterDatagrid,petServiceRegisterDialog,petServiceMenuDialog,petServiceRegisterForm,petServiceMenuForm,petNameSearchBtn,petTelSearchBtn,stateSearch,
        petServiceRegisterTabs,topMenu,secondMenu,petKindMenu,petTypeMenu,menuTime,memberNo,petServiceLogDialog,petServiceCashDialog,
        petServiceCashLogDialog,petServiceCashLogDatagrid;
    petServiceMenuTree = $("#petServiceMenuTree");//菜单树
    petServiceRegisterDatagrid = $("#petServiceRegister_datagrid");//宠物登记表格
    petServiceRegisterDialog = $("#petServiceRegister_dialog");//宠物登记弹出框
    petServiceMenuDialog = $("#petServiceMenu_dialog");//宠物登记弹出框
    petServiceCashDialog = $("#petServiceCash_dialog");//宠物服务收银弹出框
    petServiceRegisterForm = $("#petServiceRegister_form");//宠物登记表单
    petServiceMenuForm = $("#petServiceMenu_form");//宠物登记表单
    petNameSearchBtn = $("#nameSearchBtn");//搜索按钮
    petTelSearchBtn = $("#telSearchBtn");//搜索按钮
    stateSearch = $("#stateSearch");//搜索状态
    petServiceRegisterTabs = $("#petServiceRegister_tabs");//宠物登记弹出窗内的选项卡
    topMenu = $("#topMenu");//弹出窗一级菜单
    secondMenu = $("#secondMenu");//弹出窗二级菜单
    menuTime = $("#menuTime");//菜单次数
    petKindMenu = $("#petKindMenu");//宠物种类
    petTypeMenu = $("#petTypeMenu");//宠物类别
    memberNo = $("#memberNo");//会员ID
    petServiceLogDialog = $("#petServiceLog_dialog");//宠物服务日志
    petServiceCashLogDialog = $("#petServiceCashLog_dialog");//宠物服务收费记录
    petServiceCashLogDatagrid = $("#petServiceCashLog_datagrid");//宠物服务收费记录
    //宠物登记表格
    petServiceRegisterDatagrid.datagrid({
        fit:true,
        rownumbers:true,
        singleSelect:true,
        pagination:true,
        url:'/petServiceRegister/list',
        fitColumns:true,
        toolbar:'#petServiceRegister_datagrid_tb',
        columns:[
            [
                {field:'petName',align:'center',width:'8%',title:'宠物名'},
                {field:'masterName',align:'center',width:'8%',title:'主人名'},
                {field:'tel',align:'center',width:'11%',title:'联系方式'},
                {field:'itemSecond',align:'center',width:'10%',title:'服务项目'},
                {field:'state',align:'center',formatter:stateFormatter,width:'9%',title:'当前状态'},
                {field:'payment',align:'center',formatter:paymentFormatter,width:'9%',title:'是否付款'},
                {field:'startTime',align:'center',width:'10%',title:'实际开始时间'},
                {field:'endTime',align:'center',width:'10%',title:'实际结束时间'},
                {field:'times',align:'center',width:'12%',title:'寄养时间/剩余次数'},
                {field:'sevPrice',align:'center',width:'8%',title:'服务价格'},
                {field:'log',align:'center',width:'6%',title:'日志',
                    formatter:function(value,row,index){
                        return '<img onclick="serviceLogFun();" src="/static/pics/serviceIcons/serviceLog.bmp"/>'
                }}
            ]
        ],
        onClickRow:function(rowIndex,rowData){
        }
    });
    //宠物服务日志
    petServiceCashLogDatagrid.datagrid({
        fit:true,
        rownumbers:true,
        singleSelect:true,
        pagination:true,
        url:'/petServiceRegister/selectPayEnd',
        fitColumns:true,
        columns:[
            [
                {field:'petName',align:'center',width:'8%',title:'宠物名'},
                {field:'masterName',align:'center',width:'8%',title:'主人名'},
                {field:'tel',align:'center',width:'11%',title:'联系方式'},
                {field:'itemSecond',align:'center',width:'10%',title:'服务项目'},
                {field:'state',align:'center',formatter:stateFormatter,width:'9%',title:'当前状态'},
                {field:'payment',align:'center',formatter:paymentFormatter,width:'9%',title:'是否付款'},
                {field:'startTime',align:'center',width:'13%',title:'实际开始时间'},
                {field:'endTime',align:'center',width:'13%',title:'实际结束时间'},
                {field:'times',align:'center',width:'12%',title:'寄养时间/剩余次数'},
                {field:'sevPrice',align:'center',width:'8%',title:'服务价格'}
            ]
        ],
        onClickRow:function(rowIndex,rowData){
        }
    });
    /**
     * 初始化弹出窗的一二级菜单
     */
    topMenu.combobox({
        width:250,
        label:'服务项目:',
        valueField:'text',
        textField:'text',
        url:'/petServiceMenu/queryTopTree',
        onSelect:function (record) {
            secondMenu.combobox('reload','/petServiceMenu/queryChildrenByParentId?id='+record.id);
        }
    });
    secondMenu.combobox({
        width:200,
        valueField:'text',
        textField:'text',
        onSelect:function (record) {
            menuTime.textbox('initValue',record.unit);
            $("#servicePrice").val(record.maxPrice);
        }
    });
    menuTime.textbox({
        width:50,
        readonly:true
    });
    /**
     * 初始化弹出窗的宠物类别下拉框
     */
    petKindMenu.combobox({
        width:165,
        label:'宠物品种:',
        valueField:'id',
        textField:'name',
        url:'/petService/queryPetKind'
    });
    petTypeMenu.combobox({
        width:80,
        valueField:'id',
        textField:'name',
        url:'/petService/queryPetType'
    });
    /**
     * 监听会员号的改变事件
     */
    var memberInfo;
    memberNo.textbox({
        onChange:function () {
            $.get("/petService/queryInfoByMemberId?memberId="+memberNo.val(),function(member){
                if (member.petinfos) {
                    memberInfo = member;
                    for(var i=0;i<member.petinfos.length;i++) {
                        if (i == 0) {
                            $("#petBtn1").linkbutton({
                                text : member.petinfos[0].petName
                            });
                        } else if (i == 1) {
                            $("#petBtn2").linkbutton({
                                text : member.petinfos[1].petName
                            });
                        } else if (i == 2) {
                            $("#petBtn3").linkbutton({
                                text : member.petinfos[2].petName
                            });
                        }
                    }
                }
            },"json")
        }
    });
    /**
     * 初始化宠物登记弹出窗内的选项卡
     */
    petServiceRegisterTabs.tabs({
        fit:true
    });
    petServiceLogDialog.dialog({
        width:400,
        height:300,
        title:"服务日志",
        closed:true
    });
    petServiceCashDialog.dialog({
        width:400,
        height:280,
        title:"服务付款",
        closed:true,
        buttons:'#petServiceCash_dialog_bt'
    });
    //对话框
    petServiceRegisterDialog.dialog({
        width:750,
        height:410,
        buttons:'#petServiceRegister_dialog_bt',
        closed:true,
        onOpen:function () {
        }
    });
    petServiceCashLogDialog.dialog({
        width:800,
        height:410,
        closed:true,
        title:"服务付款记录",
        onOpen:function () {

        }
    });
    petServiceMenuDialog.dialog({
        width:380,
        height:380,
        buttons:'#petServiceMenu_dialog_bt',
        closed:true
    });
    petNameSearchBtn.textbox({
        width:150,
        label:"宠物名:",
        labelWidth:50
    });
    petTelSearchBtn.textbox({
        width:180,
        label:"电话号码:",
        labelWidth:80
    });
    /*
     * 初始化菜单树
     */
    petServiceMenuTree.tree({
        url: '/petServiceMenu/queryTree',
        lines:true,
        onClick: function (node) {
            petServiceRegisterDatagrid.datagrid('reload');
            petServiceRegisterDatagrid.datagrid("load",{
                menuText:node.text
            });
        },
        onLoadSuccess: function (node, data) {
        }
    });
    /*
     * 对页面按钮进行统一监听
     */
    $("a[data-cmd]").on("click", function () {
        var cmd = $(this).data("cmd");
        if (cmd) {
            cmdObj[cmd]();
        }
    });
    /*
     * 所有的操作封装到cmdObj对象中,方便管理
     */
    var cmdObj = {
        search:function () {
            petServiceMenuTree.tree('reload');
            var keyword_petName = petNameSearchBtn.val();
            var keyword_tel = petTelSearchBtn.val();
            petServiceRegisterDatagrid.datagrid("load",{
                keyword_petName:keyword_petName,
                keyword_tel:keyword_tel,
                state:stateSearch.val()
            });
        },
        addService:function(){
            //1.清空表单数据
            petServiceMenuForm.form("clear");
            //2.设置对话框的标题
            petServiceMenuDialog.dialog("setTitle","添加项目");
            //3.打开对话框
            petServiceMenuDialog.dialog("open");
        },
        addPet:function(){
            //1.清空表单数据
            petServiceRegisterForm.form("clear");
            //2.设置对话框的标题
            petServiceRegisterDialog.dialog("setTitle","宠物登记");
            //3.打开对话框
            petServiceRegisterDialog.dialog("open");
        },
        beginService:function(){
            var rowData = petServiceRegisterDatagrid.datagrid("getSelected");
            if(rowData){
                $.messager.confirm("温馨提示","您确定要开始本次服务吗?",function(yes){
                    if(yes){
                        $.get("/petServiceRegister/startService?id="+rowData.id,function(data){
                            if(data.success){
                                $.messager.alert("温馨提示",data.msg,"info",function () {
                                    petServiceRegisterDatagrid.datagrid("reload");
                                });
                            }else{
                                $.messager.alert("温馨提示",data.msg,"error");
                            }
                        },"json")
                    }
                });
            }else{
                $.messager.alert("温馨提示","请选择需要开始的服务记录.","warning");
            }
        },
        endService:function(){
            var rowData = petServiceRegisterDatagrid.datagrid("getSelected");
            if(rowData){
                $.messager.confirm("温馨提示","您确定要结束本次服务吗?",function(yes){
                    if(yes){
                        $.get("/petServiceRegister/endService?id="+rowData.id,function(data){
                            if(data.success){
                                $.messager.alert("温馨提示",data.msg,"info",function () {
                                    petServiceRegisterDatagrid.datagrid("reload");
                                });
                            }else{
                                $.messager.alert("温馨提示",data.msg,"error");
                            }
                        },"json")
                    }
                });
            }else{
                $.messager.alert("温馨提示","请选择需要开始的服务记录.","warning");
            }
        },
        payfor:function(){
            var rowData = petServiceRegisterDatagrid.datagrid("getSelected");
            $("#cashPetName").text("宠物名:"+rowData.petName);
            $("#cashPetAge").text("宠物年龄:"+rowData.petAge);
            $("#cashPetService").text("服务名称:"+rowData.itemSecond);
            $("#cashPetServicePrice").text("应付金额:"+rowData.sevPrice);
            petServiceCashDialog.dialog('open')
        },
        saveRegister:function(){
            var url = "/petServiceRegister/save";
            petServiceRegisterForm.form("submit",{
                url:url,
                success:function(data){
                    data = $.parseJSON(data);
                    if(data.success){
                        //提示消息,当点确定的时候,关闭对话框,刷新数据表格
                        $.messager.alert("温馨提示",data.msg,"info",function(){
                            petServiceRegisterDialog.dialog("close");
                            petServiceRegisterDatagrid.datagrid("reload");
                        });
                    }else{
                        $.messager.alert("温馨提示",data.msg,"error");
                    }
                }
            });
        },
        cancelRegister:function(){
            petServiceRegisterDialog.dialog("close");
        },
        sureCash:function () {
            var rowData = petServiceRegisterDatagrid.datagrid('getSelected');
            $.get("/petServiceRegister/sevCash?id="+rowData.id,function (data) {
                if(data.success){
                    $.messager.alert("温馨提示",data.msg,"info",function(){
                        petServiceCashDialog.dialog('close');
                        petServiceRegisterDatagrid.datagrid("reload");
                    });
                }else{
                    $.messager.alert("温馨提示",data.msg,"error");
                }
            },"json")
        },
        cancelCash:function(){
            petServiceCashDialog.dialog("close");
        },
        saveMenu:function(){
            var url = "/petServiceMenu/save";
            petServiceMenuForm.form("submit",{
                url:url,
                success:function(data){
                    data = $.parseJSON(data);
                    if(data.success){
                        //提示消息,当点确定的时候,关闭对话框,刷新数据表格
                        $.messager.alert("温馨提示",data.msg,"info",function(){
                            petServiceMenuDialog.dialog("close");
                            petServiceMenuTree.tree("reload");
                        });
                    }else{
                        $.messager.alert("温馨提示",data.msg,"error");
                    }
                }
            });
        },
        cancelMenu:function(){
            petServiceMenuDialog.dialog("close");
        },
        addPet1:function () {
            $("#petServiceName").textbox('initValue',memberInfo.petinfos[0].petName);
            $("#petServiceMasterName").textbox('initValue',memberInfo.name);
            $("#petServiceTel").textbox('initValue',memberInfo.tel);
        },
        addPet2:function () {
            $("#petServiceName").textbox('initValue',memberInfo.petinfos[1].petName);
            $("#petServiceMasterName").textbox('initValue',memberInfo.name);
            $("#petServiceTel").textbox('initValue',memberInfo.tel);
        },
        addPet3:function () {
            $("#petServiceName").textbox('initValue',memberInfo.petinfos[2].petName);
            $("#petServiceMasterName").textbox('initValue',memberInfo.name);
            $("#petServiceTel").textbox('initValue',memberInfo.tel);
        },
        payforLog:function () {

            petServiceCashLogDialog.dialog('open')
        }
    }
});
function stateFormatter(value,record,index){
    if(value==0){
        return "<font color='#87ceeb'>等待中</font>";
    }else if(value==1){
        return "<font color='#db7093'>进行中</font>";
    }else if(value==2){
        return "已完成";
    }
}
function paymentFormatter(value,record,index){
    if(value==0){
        return "<font color='#ff7f50'>未付款</font>";
    }else if(value==1){
        return "<font color='#7cfc00'>已付款</font>";
    }
}
function serviceLogFun() {
    var rowData = $("#petServiceRegister_datagrid").datagrid('getSelected');
    if (rowData == null) {
        $.messager.alert("温馨提示","请先选择一行数据!","info");
    } else {
        $.get("/petServiceRegister/searchById?id="+rowData.id,function(petInfo){
            $("#logPetName").text("宠物名:"+petInfo.petName);
            $("#logPetAge").text("宠物年龄:"+petInfo.petAge);
            $("#logPetService").text("服务名称:"+petInfo.itemSecond);
            $("#logPetSelfGood").text("自带物品:"+petInfo.selfGood);
            $("#logPetRemark").text("服务备注:"+petInfo.remark);
            $("#petServiceLog_dialog").dialog('open')
        },"json")
    }
}
































