$(function(){


    memberInfoDatagrid=$("#memberInfo_datagrid");//表格ID
    petInfoMonryDialog=$("#petInfo_addMoney_dialog");//充值ID
    petInfoMemberDialog=$("#petInfo_addMember_dialog");//增加会员ID
    petInfoPetDialog=$("#petInfo_addPet_dialog");//增加宠物ID
    searchBtn=$("#searchBtn");//增加按钮
    petInfoForm=$("#petInfo_form");//
    editBtnANDdeleBtn=$("#editBtn,#deleBtn");
    roleId =$("#roleId");

    petTypeBtn =$("#petTypeBtn");
    petKindBtn =$("#petKindBtn");

    memberInfoDatagrid.datagrid({
        fit:true,
        fitColumns:true,  //按界面自动布局
        singleSelect:true,//单选
        pagination:true, //翻页
        rownumbers:true, //显示行序列号
        url:"/petInfo/list",
        toolbar:"#SDUS_BTN",
        columns:[[
            {field:'number',title:'会员号',width:100,align:'centre',formatter:adminNumber},
            {field:'petName',title:'宠物姓名',width:100,align:'centre'},
            {field:'petGender',title:'性别',width:100,align:'centre',formatter:adminGenber},
            {field:'petBirthday',title:'生日',width:100,align:'centre'},
            {field:'petType',title:'宠物品种',width:100,align:'centre'},
            {field:'petAncestry',title:'血统',width:100,align:'centre'},
            {field:'petColour',title:'毛色',width:100,align:'centre'},
            {field:'balance',title:'余额',width:100,align:'centre',formatter:adminDalance},
            {field:'adress',title:'地址',width:100,align:'centre',formatter:adminAdress},
            {field:'remark',title:'备注',width:100,align:'centre',formatter:adminRemark}
        ]],

        onClickRow:function (index,row){
            if(row.state==1){
                editBtnANDdeleBtn.linkbutton("disable");
            }else {
                editBtnANDdeleBtn.linkbutton("enable");
            }
        }
    })

    //充值对话框初始化
    petInfoMonryDialog.dialog({
        width:500,
        height:400,
        //增加保存和取消按钮
        buttons:"#petinfo_addMoney_dialog_bt",
        //默认关闭对话框
        closed:true

    })
    //增加会员对话框初始化
    petInfoMemberDialog.dialog({
        width:800,
        height:400,
        //增加保存和取消按钮
        buttons:"#petinfo_addMember_dialog_bt",
        //默认关闭对话框
        closed:true

    })
    //增加宠物对话框初始化
    petInfoPetDialog.dialog({
        width:700,
        height:400,
        //增加保存和取消按钮
        buttons:"#pet_info_dialog_bt",
        //默认关闭对话框
        closed:true

    })
    //监听搜索按钮
    petTypeBtn.combobox({
        width:125,
        valueField:'id',
        textField:'name',
       // url:'/petService/queryPetType'
    });
    petKindBtn.combobox({
        width:125,
        valueField:'id',
        textField:'name',
        //url:'/petService/queryPetType'
    });


    var cmdObj={
        //充值
        addMoney:function(){
            //清空对话框
            petInfoMonryDialog.form("clear");
            //打开对话框
            petInfoMonryDialog.dialog("open");
            //设置对话框标题
            petInfoMonryDialog.dialog("setTitle","充值");
        },
        //增加会员
        addMember:function(){
            //清空对话框
            petInfoMemberDialog.form("clear");
            //打开对话框
            petInfoMemberDialog.dialog("open");
            //设置对话框标题
            petInfoMemberDialog.dialog("setTitle","增加会员");
        },
        //增加宠物
        addPet:function(){
            //清空对话框
            petInfoPetDialog.form("clear");
            //打开对话框
            petInfoPetDialog.dialog("open");
            //设置对话框标题
            petInfoPetDialog.dialog("setTitle","增加宠物");
        },
        //保存
        save: function (){
            //从表单中获取ID数据判断ID是否有值
            var Idvar = $("[name=id]").val();
            console.log(Idvar);
            var url;
            if(Idvar){
                //url="/petInfo/addMoney"
            }else {
            }
            //获取form表单调用submit提交
            petInfoForm.form("submit",{
                url:url,
                onSubmit:function(param){
                    var ids = roleId.combobox("getValues");
                    for(var i=0;i<ids.length;i++){
                        param["roles["+i+"].id"]=ids[i];
                    }
                    return true;
                },
                success:function(data){
                    data = $.parseJSON(data);
                    console.log(data)
                    if(data.success){
                        $.messager.alert("温馨提示",data.msg,"info",function(){
                            //关闭对话框
                            petInfoDialog.dialog("close");
                            //刷新数据
                            petInfoDatagird.datagrid("reload");
                        })
                    }else {
                        $.messager.alert("温馨提示",data.msg,"error");
                        //关闭对话框
                        petInfoDialog.dialog("close");
                        //刷新数据
                        petInfoDatagird.datagrid("reload");
                    }
                }
            })
        },
//修改
        edit:function (){
            //判断用户是否选中数据
            var rowData = petInfoDatagird.datagrid("getSelected");
            if (rowData) {
                //打开对话框
                petInfoDialog.dialog("open");
                //修改对话框的标题
                petInfoDialog.dialog("setTitle", "编辑");
                //清空对话框
                petInfoForm.form("clear");

                //特殊数据处理(对象类的数据)
                if(rowData.dept){
                    rowData["dept.id"]=rowData.dept.id;
                }
                //自动同名匹配数据
                petInfoForm.form("load",rowData);
                $.get("",function(data){

                    roleId.combobox("setValues",data);
                },"json")
            }else {
                //没有选中数据提示
                $.messager.alert("温馨提示","请选择一行需要编辑的数据","warning");
            }
        },
        dele:function dele(){
            //判断用户是否选中数据
            var rowData = petInfoDatagird.datagrid("getSelected");
            if(rowData){
                $.messager.confirm("温馨提示","你确定需要删除这条数据吗?",function(yes){
                    if(yes){
                        //发送请求删除数据
                        $.get("",function(data){
                            if(data.success){
                                $.messager.alert("温馨提示",data.msg,"info",function(){
                                    //刷新数据表格
                                    petInfoDatagird.datagrid("reload");
                                })
                            }else {
                                $.messager.alert("温馨提示",data.msg,"error");
                            }
                        },"json")
                    }
                })
            }else {
                //没有数据提示
                $.messager.alert("温馨提示","请选着一行需要删除的数据","warning");
            }
        },
//刷新
        refrech:function (){
            petInfoDatagird.datagrid("reload");
        },
//取消
        cencal:function (){
            //关闭对话框,刷新数据表格
            petInfoDialog.dialog("close");

            petInfoDatagird.datagrid("reload");
        },
            query:function (){
                searchBtn.form("submit",{
                    //高级搜索
                    //url:"/petInfo/list"

                })
            }
    }


    $("a[data-cmd]").on("click",function(){
        var cmd=$(this).data("cmd");
        cmdObj[cmd]();
    })

})
//会员号
function adminNumber(value,record,index){
    if(record.member){
        return record.member.name
    }else {
        return ""
    }
}
//性别
function adminGenber(value,record,index){

    if(record.petGender==1){
        return "公";
    }else {
        return "母";
    }
}
//余额
function adminDalance(value,record,index){
    if(record.member){
        return record.member.dalance
    }else {
        return ""
    }

    //地址
}function adminAdress(value,record,index){
    if(record.member){
        return record.member.adress
    }else {
        return ""
    }
//备注
}function adminRemark(value,record,index){
    if(record.member){
        return record.member.remark
    }else {
        return ""
    }

}