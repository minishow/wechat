$(function () {
    /*
     * 抽取所有需要用得元素.
     */
    var petServiceMenuTree,petServiceRegisterDatagrid,petServiceRegisterDialog,petServiceRegisterForm,petServiceRegisterSearchBtn;
    petServiceMenuTree = $("#petServiceMenuTree");//菜单树
    petServiceRegisterDatagrid = $("#petServiceRegister_datagrid");//宠物登记表格
    petServiceRegisterDialog = $("#petServiceRegister_dialog");//宠物登记弹出框
    petServiceRegisterForm = $("#petServiceRegister_form");//宠物登记表单
    petServiceRegisterSearchBtn = $("#searchBtn");//搜索按钮
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
                {field:'petName',align:'center',width:10,title:'宠物名'},
                {field:'realname',align:'center',width:10,title:'真实姓名'},
                {field:'tel',align:'center',width:10,title:'联系方式'},
                {field:'email',align:'center',width:10,title:'邮箱'},
                {field:'inputtime',align:'center',width:10,title:'入职时间'},
                {field:'dept',align:'center',width:10,formatter:deptFormatter,title:'所属部门'},
                {field:'state',align:'center',width:10,formatter:stateFormatter,title:'状态'},
                {field:'admin',align:'center',width:10,formatter:adminFormatter,title:'是否管理员'}
            ]
        ],
        onClickRow:function(rowIndex,rowData){
            //判断当前记录中的状态的值.
            if(rowData.state==1){
                //员工已经离职了,编辑和离职按钮应该变灰.
                petServiceRegisterEditBtnAndQuitBtn.linkbutton("disable");
            }else{
                //启用按钮
                petServiceRegisterEditBtnAndQuitBtn.linkbutton("enable");
            }
        }
    });
    //对话框
    petServiceRegisterDialog.dialog({
        width:250,
        height:380,
        buttons:'#petServiceRegister_dialog_bt',
        closed:true
    });
    petServiceRegisterSearchBtn.textbox({
        width:230,
        label:"关键字:",
        labelWidth:50,
        prompt:"请输入搜索关键字",
        buttonText:'搜索',
        buttonIcon:'icon-search',
        onClickButton:function(){
            var keyword = $(this).val();
            petServiceRegisterDatagrid.datagrid("load",{
                keyword:keyword
            });
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
            if(idVal){
                url = "/petServiceRegister/update";
            }else{
                url = "/petServiceRegister/save";
            }
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
