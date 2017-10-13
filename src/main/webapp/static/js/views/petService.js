$(function () {
    /*
     * 抽取所有需要用得元素.
     */
    var petServiceMenuTree,petServiceRegisterDatagrid,petServiceRegisterDialog,petServiceRegisterForm,petNameSearchBtn,petTelSearchBtn;
    petServiceMenuTree = $("#petServiceMenuTree");//菜单树
    petServiceRegisterDatagrid = $("#petServiceRegister_datagrid");//宠物登记表格
    petServiceRegisterDialog = $("#petServiceRegister_dialog");//宠物登记弹出框
    petServiceRegisterForm = $("#petServiceRegister_form");//宠物登记表单
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
                {field:'petName',align:'center',width:'7%',title:'宠物名'},
                {field:'masterName',align:'center',width:'8%',title:'主人名'},
                {field:'tel',align:'center',width:'12%',title:'联系方式'},
                {field:'itemSecond',align:'center',width:'8%',title:'服务项目'},
                {field:'state',align:'center',formatter:stateFormatter,width:'8%',title:'当前状态'},
                {field:'payment',align:'center',formatter:paymentFormatter,width:'8%',title:'是否付款'},
                {field:'startTime',align:'center',width:'10%',title:'实际开始时间'},
                {field:'endTime',align:'center',width:'10%',title:'实际结束时间'},
                {field:'times',align:'center',width:'12%',title:'寄养时间/剩余次数'},
                {field:'sevPrice',align:'center',width:'8%',title:'服务价格'},
                {align:'center',width:'9%',title:'日志'}
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
    petNameSearchBtn.textbox({
        width:230,
        label:"宠物名称:",
        labelWidth:50,
        prompt:"请输入搜索关键字",
        buttonText:'搜索',
        buttonIcon:'icon-search',
        onClickButton:function(){
            var keyword = $(this).val();
            petServiceRegisterDatagrid.datagrid("load",{
                keyword_petName:keyword
            });
        }
    });
    petTelSearchBtn.textbox({
        width:230,
        label:"手机号码:",
        labelWidth:50,
        prompt:"请输入搜索关键字",
        buttonText:'搜索',
        buttonIcon:'icon-search',
        onClickButton:function(){
            var keyword = $(this).val();
            petServiceRegisterDatagrid.datagrid("load",{
                keyword_tel:keyword
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
        add:function(){
            //1.清空表单数据
            petServiceRegisterForm.form("clear");
            //2.设置对话框的标题
            petServiceRegisterDialog.dialog("setTitle","新增");
            //3.打开对话框
            petServiceRegisterDialog.dialog("open");
        },
        save:function(){
            var url;
            var idVal = $("[name='id']").val();
            url = "/petServiceRegister/save";
            petServiceRegisterForm.form("submit",{
                url:url,
                onSubmit:function(param){
                    //获取所有的角色信息
                    var roleIds = $("#roleId").combobox("getValues");
                    //把角色信息放入到表单中
                    for(var i=0;i<roleIds.length;i++){
                        param["roles["+i+"].id"] = roleIds[i];
                    }
                    return true;
                },
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
        cancel:function(){
            petServiceRegisterDialog.dialog("close");
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

































