$(function () {
    /*
     * 抽取所有需要用得元素.
     */
    var petServiceMenuTree,petServiceRegisterDatagrid,petServiceRegisterDialog,petServiceMenuDialog,petServiceRegisterForm,petServiceMenuForm,petNameSearchBtn,petTelSearchBtn;
    petServiceMenuTree = $("#petServiceMenuTree");//菜单树
    petServiceRegisterDatagrid = $("#petServiceRegister_datagrid");//宠物登记表格
    petServiceRegisterDialog = $("#petServiceRegister_dialog");//宠物登记弹出框
    petServiceMenuDialog = $("#petServiceMenu_dialog");//宠物登记弹出框
    petServiceRegisterForm = $("#petServiceRegister_form");//宠物登记表单
    petServiceMenuForm = $("#petServiceMenu_form");//宠物登记表单
    petNameSearchBtn = $("#nameSearchBtn");//搜索按钮
    petTelSearchBtn = $("#telSearchBtn");//搜索按钮
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
                {field:'log',align:'center',width:'6%',title:'日志'}
            ]
        ],
        onClickRow:function(rowIndex,rowData){
        }
    });
    //对话框
    petServiceRegisterDialog.dialog({
        width:250,
        height:380,
        buttons:'#petServiceRegister_dialog_bt',
        closed:true
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
        width:200,
        label:"电话号码:",
        labelWidth:60,
        buttonText:'搜索',
        onClickButton:function(){
            var keyword_petName = petNameSearchBtn.val();
            var keyword_tel = $(this).val();
            petServiceRegisterDatagrid.datagrid("load",{
                keyword_petName:keyword_petName,
                keyword_tel:keyword_tel
            });
        }
    });
    /*
     * 初始化菜单树
     */
    petServiceMenuTree.tree({
        url: '/petServiceMenu/queryTree',
        lines:true,
        onClick: function (node) {
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
            petServiceRegisterDialog.dialog("setTitle","新增");
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
                                petServiceRegisterDatagrid.datagrid("reload");
                                $.messager.alert("温馨提示",data.msg,"info");
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
                                petServiceRegisterDatagrid.datagrid("reload");
                                $.messager.alert("温馨提示",data.msg,"info");
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
        },
        saveRegister:function(){

        },
        cancelRegister:function(){
            petServiceRegisterDialog.dialog("close");
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

































