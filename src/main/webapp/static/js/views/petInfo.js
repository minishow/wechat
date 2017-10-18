$(function(){


    memberInfoDatagrid=$("#memberInfo_datagrid");//表格ID
    petInfoMonryDialog=$("#petInfo_addMoney_dialog");//充值ID
    petInfoMemberDialog=$("#petInfo_addMember_dialog");//增加会员ID
    petInfoPetDialog=$("#petInfo_addPet_dialog");//增加宠物ID
    memberPetDialog=$("#member_addremark_dialog");//增加退卡ID

    searchBtn=$("#searchBtn");//高级搜索

    petInfoForm=$("#petInfo_addMoney_form");//充值Form
    petInfo_addMember=$("#petInfo_addMember_form");//增加会员Form
    petInfo_addPet=$("#petInfo_addPet_form");//增加宠物Form

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
            {field:'petKind',title:'宠物品种',width:100,align:'centre',formatter:adminType},
            {field:'petAncestryRegister',title:'血统',width:100,align:'centre'},
            {field:'petColour',title:'毛色',width:100,align:'centre'},
            {field:'balance',title:'余额',width:100,align:'centre',formatter:adminDalance},
            {field:'adress',title:'地址',width:100,align:'centre',formatter:adminAdress},
            {field:'remark',title:'备注',width:100,align:'centre',formatter:adminRemark}
        ]],

        onClickRow:function (index,row){
            if(row.member.remark==1){
                editBtnANDdeleBtn.linkbutton("disable");
            }else {
                editBtnANDdeleBtn.linkbutton("enable");
            }
        }
    })
    $("#petKindBtns").combobox({

            onChange:function(){
                $("#petTypeBtns").combobox({
                    url:'petInfo/addPetKindList?kindID='+$("#petKindBtns").combobox("getValues")
                })
            }
        }
    )

    //充值对话框初始化
    petInfoMonryDialog.dialog({
        width:500,
        height:400,
        //增加保存和取消按钮
        buttons:"#petinfo_addMoney_dialog_bt",
        //默认关闭对话框
        closed:true

    })
    //退卡操作
    memberPetDialog.dialog({
        width:700,
        height:500,
        //增加保存和取消按钮
        buttons:"#petinfo_addremark_dialog_bt",
        //默认关闭对话框
        closed:true

    });

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
        buttons:"#petInfo_pet_bt",
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


    var i=0;//用于总消费金额变量
    var cmdObj={
        //充值
        addMoney:function(){
            //判断用户是否选中数据
            var rowData = memberInfoDatagrid.datagrid("getSelected");
            if (rowData && rowData.member.remark!=1) {
                //打开对话框
                petInfoMonryDialog.dialog("open");
                //修改对话框的标题
                petInfoMonryDialog.dialog("setTitle", "增加宠物");
                //清空对话框
                petInfoMonryDialog.form("clear");
                var randomstr=randomString();
                //特殊数据处理(对象类的数据)
                if(rowData){

                    rowData["member.tel"]=rowData.member.tel;
                    rowData["member.balances"]=rowData.member.balance;
                    $("[name='balance']").val(rowData.member.balance)
                    $("[name='topnumber']").val(randomstr)
                }
                $("#vipClasses").combobox({
                    //相当于html >> select >> onChange事件

                    onChange:function(){
                        if($("#vipClasses").combobox("getValues")==1){
                            ////服务折扣
                            $("#serviceDiscountID").text('100%');
                            ////商品折扣
                            $("#productDiscountID").text('100%');
                        }else if ($("#vipClasses").combobox("getValues")==2){
                            ////服务折扣
                            $("#serviceDiscountID").text('90%');
                            ////商品折扣
                            $("#productDiscountID").text('90%');
                        }else if ($("#vipClasses").combobox("getValues")==3){
                            ////服务折扣
                            $("#serviceDiscountID").text('80%');
                            ////商品折扣
                            $("#productDiscountID").text('80%');
                        }else if ($("#vipClasses").combobox("getValues")==4){
                            ////服务折扣
                            $("#serviceDiscountID").text('70%');
                            ////商品折扣
                            $("#productDiscountID").text('70%');
                        }
                    }
                })
                //4.回显数据
               // petInfoForm.form("load",rowData);//基于同名匹配规则
               $("#moneySn").textbox('initValue',rowData.member.tel);
                $("#moneyDalance").text(rowData.member.balance);

                $("#topUpNumber").text(randomstr);
            }else {

                if(rowData!=null&&rowData.member.remark==1){
                    //退卡会员
                    $.messager.alert("温馨提示","退卡会员不能充值","warning");
                }else {
                    //没有选中数据提示
                    $.messager.alert("温馨提示","请选择一行需要编辑的数据","warning");
                }

            }
        },
        //增加会员
        addMember:function(){
            //清空对话框
            petInfoMemberDialog.form("clear");
            //打开对话框
            petInfoMemberDialog.dialog("open");
            //设置对话框标题
            petInfoMemberDialog.dialog("setTitle","增加会员");
            $("#petTyoeList").combobox({

                    onChange:function(){
                        $("#petKindList").combobox({
                                url:'petInfo/addPetKindList?kindID='+$("#petTyoeList").combobox("getValues")
                        })
                    }
            }
            );
            $("#vipClassMember").combobox({
                //相当于html >> select >> onChange事件

                onChange:function(){

                    if($("#vipClassMember").combobox("getValues")==1){
                        ////服务折扣
                        $("#servicememberID").text('100%');
                        ////商品折扣
                        $("#productmemberID").text('100%');
                    }else if ($("#vipClassMember").combobox("getValues")==2){
                        ////服务折扣
                        $("#servicememberID").text('90%');
                        ////商品折扣
                        $("#productmemberID").text('90%');
                    }else if ($("#vipClassMember").combobox("getValues")==3){
                        ////服务折扣
                        $("#servicememberID").text('80%');
                        ////商品折扣
                        $("#productmemberID").text('80%');
                    }else if ($("#vipClassMember").combobox("getValues")==4){
                        ////服务折扣
                        $("#servicememberID").text('70%');
                        ////商品折扣
                        $("#productmemberID").text('70%');
                    }
                }
            })
        },
        //保存
        save: function (){

            //从表单中获取ID数据判断ID是否有值
            var Idvar = $("#petMemberid").val();
            console.log(Idvar);
            var url;
            if(Idvar){
                //获取form表单调用submit提交
                petInfo_addPet.form("submit",{
                    url:"/petInfo/addPet",

                    success:function(data){

                        data = $.parseJSON(data);
                        if(data.success){
                            $.messager.alert("温馨提示",data.msg,"info",function(){
                                //关闭对话框

                                    petInfoPetDialog.dialog("close");

                                //刷新数据
                                memberInfoDatagrid.datagrid("reload");
                            })
                        }else {
                            $.messager.alert("温馨提示",data.msg,"error");
                            //关闭对话框
                            petInfoMemberDialog.dialog("close");
                            //刷新数据
                            memberInfoDatagrid.datagrid("reload");
                        }
                    }
                })
            }else {

                //获取form表单调用submit提交
                petInfo_addMember.form("submit",{
                    url:"/memberInfo/addMemberAndPet",

                    success:function(data){

                        data = $.parseJSON(data);
                        if(data.success){
                            $.messager.alert("温馨提示",data.msg,"info",function(){

                                    petInfoMemberDialog.dialog("close");

                                //刷新数据
                                memberInfoDatagrid.datagrid("reload");
                            })
                        }else {
                            $.messager.alert("温馨提示",data.msg,"error");
                            //关闭对话框
                            petInfoMemberDialog.dialog("close");
                            //刷新数据
                            memberInfoDatagrid.datagrid("reload");
                        }
                    }
                })

            }


        },
        //保存充值
        saveMoney: function (){
            //获取form表单调用submit提交
            var url="/memberInfo/addMomberMoney";
            petInfoForm.form("submit",{
                url:url,

                success:function(data){
                    data = $.parseJSON(data);
                    if(data.success){
                        $.messager.alert("温馨提示",data.msg,"info",function(){
                            //关闭对话框

                            petInfoMonryDialog.dialog("close");

                            //刷新数据
                            memberInfoDatagrid.datagrid("reload");
                        })
                    }else {
                        $.messager.alert("温馨提示",data.msg,"error");
                        //关闭对话框
                        petInfoMemberDialog.dialog("close");
                        //刷新数据
                        memberInfoDatagrid.datagrid("reload");
                    }
                }
            })
        },
        //增加宠物
        addPet:function (){
            //判断用户是否选中数据
            var rowData = memberInfoDatagrid.datagrid("getSelected");
            if (rowData) {
                //打开对话框
                petInfoPetDialog.dialog("open");
                //修改对话框的标题
                petInfoPetDialog.dialog("setTitle", "增加宠物");
                //清空对话框
                petInfo_addPet.form("clear");
                //宠物品种处理
                $("#petTyoeLists").combobox({

                        onChange:function(){
                            $("#petKindLists").combobox({
                                url:'petInfo/addPetKindList?kindID='+$("#petTyoeLists").combobox("getValues")
                            })
                        }
                    }
                )
                //特殊数据处理(对象类的数据)
                if(rowData){

                   rowData["member.tel"]=rowData.member.tel;
                    $("#petMemberid").val(rowData.member.id);
                }
                //回显数据
                $("#memberSn").textbox('initValue',rowData.member.tel);

            }else {
                //没有选中数据提示
                $.messager.alert("温馨提示","请选择一行需要编辑的数据","warning");
            }
        },
        //退卡操作
        refrech:function (){

            ////判断用户是否选中数据
            //var rowData = memberInfoDatagrid.datagrid("getSelected");
            //console.log(rowData);
            //判断用户是否选中数据
            var rowData = memberInfoDatagrid.datagrid("getSelected");
            if (rowData && rowData.member.remark!=1) {

                //退卡dataGrid
                $("#member_addremark_datagrid").datagrid({

                    fit:true,
                    fitColumns:true,  //按界面自动布局
                    singleSelect:true,//单选
                    //pagination:true, //翻页
                    rownumbers:true, //显示行序列号
                    url:"/memberInfo/returnMember?returnId="+rowData.member.id,
                    columns:[[
                        {field:'snnumber',title:'商品条码',width:100,align:'centre'},
                        {field:'name',title:'商品名称',width:100,align:'centre'},
                        {field:'totalAmount',title:'金额',width:100,align:'centr'},
                        {field:'orderTime',title:'消费时间',width:100,align:'centre'},

                    ]],
                    onLoadSuccess:function(data){

                        for(var j=0;j<data.rows.length;j++){
                            i+=data.rows[j].totalAmount;
                        }
                        $("#consumeID").text(i);
                    }
                });


                //打开对话框
                memberPetDialog.dialog("open");
                //修改对话框的标题
                memberPetDialog.dialog("setTitle", "退卡");
                //清空对话框
                memberPetDialog.form("clear");
                //特殊数据处理(对象类的数据)
                $("#memberID").val(rowData.member.id);

                if (rowData) {
                    $("#memberBal").text(rowData.member.balance);



                }
            }else {

                if(rowData!=null&&rowData.member.remark==1){
                    //退卡会员
                    $.messager.alert("温馨提示","退卡会员不能充值","warning");
                }else {
                    //没有选中数据提示
                    $.messager.alert("温馨提示","请选择一行需要编辑的数据","warning");
                }
            }
        },

        //退卡保存
        saveremark:function(){

                $.messager.confirm("温馨提示","你确定需要给该会员退卡吗?",function(yes){

                    if(yes){
                        //发送请求删除数据
                        var memberId=$("#memberID").val();
                        $.get("/memberInfo/updateRemark?memberID="+memberId,function(data){
                            if(data.success){
                                $.messager.alert("温馨提示",data.msg,"info",function(){

                                    memberPetDialog.dialog("close")
                                    //刷新数据表格
                                    memberInfoDatagrid.datagrid("reload");

                                })
                            }else {
                                $.messager.alert("温馨提示",data.msg,"error");
                            }
                        },"json")
                    }
                })


        },

//刷新
//        refrech:function (){
//            petInfoDatagird.datagrid("reload");
//        },



//取消充值
        cencalMoney:function (){
            //关闭对话框,刷新数据表格
            petInfoMonryDialog.dialog("close");

            memberInfoDatagrid.datagrid("reload");
        },
        cencalBlock:function(){
            //关闭退卡dialog
            memberPetDialog.dialog("close");
            memberInfoDatagrid.datagrid("reload");
        },
        //取消增加宠物
        cencalPet:function (){
            //关闭对话框,刷新数据表格
            petInfoPetDialog.dialog("close");

            memberInfoDatagrid.datagrid("reload");
        },
        //取消增加会员
        cencalMember:function (){
            //关闭对话框,刷新数据表格
            petInfoMemberDialog.dialog("close");
            //刷新数据
            memberInfoDatagrid.datagrid("reload");
        },
        //高级查询
            query:function (){
                searchBtn.form("submit",{
                    //高级搜索
                    url:"/petInfo/list",
                    success:function(data){
                        var datas = $.parseJSON(data);
                        memberInfoDatagrid.datagrid("loadData",datas);
                    }
                })
            },

    }


    $("a[data-cmd]").on("click",function(){
        var cmd=$(this).data("cmd");
        cmdObj[cmd]();
    })




})
//生成流水号
function randomString(len) {
    len = len || 32;
    var $chars = '0123456789';
    var maxPos = $chars.length;
    var pwd = '';
    for (i = 0; i < len; i++) {
        //0~32的整数
        if(i<11){

        pwd += $chars.charAt(Math.floor(Math.random() * (maxPos+1)));

        }
    }
    return "GZ"+pwd;
}
//document.write(randomString(32));





//会员号
function adminNumber(value,record,index){
    if(record.member){
        return record.member.tel
    }else {
        return ""
    }
}

//退卡消费金额
//function adminPrice(value,record,index){
//    if(record.totalAmount){
//        i+=record.totalAmount
//        //return record.infoPrice;
//        alert(111)
//        console.log(record)
//        return record.totalAmount.value;
//    }else {
//        return "";
//    }
//}
//宠物品种
function adminType(value,record,index){
    if(record.petKind){
        return record.petKind.name
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
        return record.member.balance
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

}
//备注
function adminRemark(value,record,index){
   if(record.member){
       if(record.member.remark==1){
           return "已退卡"
       }else {
           return ""
       }


   }

}