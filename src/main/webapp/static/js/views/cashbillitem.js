$(function () {
    //页面的数据表格
    var dg = $("#cashbillitem_datagrid").datagrid({
        fit:true,
        singleSelect:true, /*只选择一个*/
        striped:true, /*斑马线*/
        rownumbers:true, /*行号列*/
        pagination:true, /*分页*/
        fitColumns:true,
        toolbar:'#cashbillitem_datagrid_tb',
        columns:[[
            {field:'id',title:'库存编号',width:10,align:'center'},
            {field:'code',title:'商品69条码',width:10,align:'center' ,formatter: function (value,row,index) {
                return row.productInfoId?row.productInfoId.code:"";
            }},
            {field:'name',title:'商品名称',width:10,align:'center',
                formatter: function (value,row,index) {
                    return row.productInfoId?row.productInfoId.name:"";
                } },
            {field:'price',title:'原价格(元)',width:10,align:'center',
                formatter: function (value,row,index) {
                    return row.productInfoId?row.productInfoId.price:"";
                } },
            {field:'memberPrice',title:'会员价格(元)',width:10,align:'center',
                formatter: function (value,row,index) {
                    return row.productInfoId?row.productInfoId.memberPrice:"";
                } },
            {field:'number',title:'数量',width:10,align:'center',
                editor:'text',
                formatter:function(value,row,index){
                    if(!value) {
                        value = 1;
                    }
                    return "<span data-number='"+row.id+"'>"+value+"</span>";
                }},
            {field:'costAmount',title:'原价总价格(元)',width:10,align:'center',
                formatter:function(value,row,index){
                    if(!value){
                        value = row.productInfoId.price;
                    }
                    return "<span data-costAmount='"+row.id+"'>"+value +"</span>";
                }
            },
            {field:'memberAmount',title:'会员总价格(元)',width:10,align:'center',
                formatter:function(value,row,index){
                    if(!value){
                        value = row.productInfoId.memberPrice;
                    }
                    return "<span data-memberAmount='"+row.id+"'>"+value+"</span>";
                }
            },
            {field:'ID',title:'操作',width:10,align:'center',
                formatter:function (value,row,index) {
                    var h = "";
                    h += "<a href='javascript:deleteRow(" + index + ")'>删除</a> ";
                    return h
            }}
        ]],
         onAfterEdit: function (index, row, changes) {  //编辑完数量单元格触发事件
            //判断库存数量是否足够
             var storeNumber = row.packageNumber; //库存数量
             var editNumber = changes.number; //填入的数量

             if(editNumber <= storeNumber){  //库存数量 大于等于  填入的数量
                 $('#cashbillitem_datagrid').datagrid('updateRow',{  //更新指定行数据
                        index:index,
                        row:{
                            costAmount:changes.number * row.productInfoId.price,
                            memberAmount:changes.number * row.productInfoId.memberPrice
                        }
                 });
                 //设置统计价格和应收价格
                 var totalAmount = 0;//计算全部商品的原价的总价格
                 var memberAmount = 0;//计算全部商品的会员价的总价格
                 var costAmountObj = $("span[data-costAmount]");  //多个原价总价格的对象
                 var memberAmountObj = $("span[data-memberAmount]");  //多个会员总价格的对象
                 for(var i = 0 ; i < costAmountObj.length ; i++){
                     totalAmount = totalAmount + parseInt(costAmountObj[i].innerHTML,10);
                     memberAmount = memberAmount + parseInt(memberAmountObj[i].innerHTML,10);
                 }
                 $("#totalAmount").html(totalAmount); //统计  设置全部商品原价总价格
                 //判断有没会员id
                 if($("#MemberId").val() != null && $("#MemberId").val() != ""){
                     $("#receivables").val(memberAmount); //应收价格  设置会员的总价格
                 }
                 else{
                     $("#receivables").val(totalAmount); //应收价格 设置原价的总价格
                 }
             }
             else{
                 $('#cashbillitem_datagrid').datagrid('updateRow',{  //更新指定行数据
                     index:index,
                     row:{
                         costAmount:row.productInfoId.price,
                         memberAmount:row.productInfoId.memberPrice,
                         number:1
                     }
                 });
                 //设置统计价格和应收价格
                 var totalAmount = 0;//计算全部商品的原价的总价格
                 var memberAmount = 0;//计算全部商品的会员价的总价格
                 var costAmountObj = $("span[data-costAmount]");  //多个原价总价格的对象
                 var memberAmountObj = $("span[data-memberAmount]");  //多个会员总价格的对象
                 for(var i = 0 ; i < costAmountObj.length ; i++){
                     totalAmount = totalAmount + parseInt(costAmountObj[i].innerHTML,10);
                     memberAmount = memberAmount + parseInt(memberAmountObj[i].innerHTML,10);
                 }
                 $("#totalAmount").html(totalAmount); //统计  设置全部商品原价总价格
                 //判断有没会员id
                 if($("#MemberId").val() != null && $("#MemberId").val() != ""){
                     $("#receivables").val(memberAmount); //应收价格  设置会员的总价格
                 }
                 else{
                     $("#receivables").val(totalAmount); //应收价格 设置原价的总价格
                 }
                 $.messager.alert("温馨提示","当前库存数量不足,现有当前商品库存数量为:"+storeNumber,"info");
             }
         }

    });
    /*开启编辑器*/
    dg.datagrid('enableCellEditing');

    //高级查询--查询库存
    $("#searchbtn").textbox({
        width:250,
        buttonIcon:'icon-search',
        buttonAlign:"left",
        buttonText:"商品69条码:",
        onClickButton: function () {
            var code =  $("#searchbtn").val();
            $.get("/productStock/getProductStockByProductinfoCode?code="+code, function (data) {
                if(data.id != null){
                     var rows = $("#cashbillitem_datagrid").datagrid("getRows");
                     var ids = $.map(rows, function (item) {
                        return item.id;
                     });
                    //判断数据表格是否已经有  :
                    if($.inArray(data.id,ids) >= 0 ){
                        $.messager.alert("温馨提示","已经添加,请点击数量进行操作","info");
                    }
                    else{
                        //没有:追加新行
                        $("#cashbillitem_datagrid").datagrid("appendRow",data);

                        $("#cashbillitem_datagrid").datagrid("reload");

                        var totalAmount = 0;//计算全部商品的原价的总价格
                        var memberAmount = 0;//计算全部商品的会员价的总价格
                        var costAmountObj = $("span[data-costAmount]");  //多个原价总价格的对象
                        var memberAmountObj = $("span[data-memberAmount]");  //多个会员总价格的对象
                        for(var i = 0 ; i < costAmountObj.length ; i++){
                            totalAmount = totalAmount + parseInt(costAmountObj[i].innerHTML,10);
                            memberAmount = memberAmount + parseInt(memberAmountObj[i].innerHTML,10);
                        }

                        $("#totalAmount").html(totalAmount); //设置全部商品原价总价格

                        //判断有没会员姓名
                        if($("#MemberId").val() != null && $("#MemberId").val() != ""){
                            $("#receivables").val(memberAmount); //设置会员的总价格
                        }
                        else{
                            $("#receivables").val(totalAmount); //设置原价的总价格
                        }
                    }
                }
                else{
                    $.messager.alert("温馨提示","没有查询到该库存信息","info");
                }
            });
        }
    });

    //结账 提交表单
    $("#accountsBtn").click(function () {
        var memberMoneyVal = $("#balance").html();    //会员余额
        var reallyMoneyVal = $("#reallyMoney").val(); //实收金额
        var receivablesVal = $("#receivables").val(); //应收金额
        var memberId = $("#MemberId").val();

        if(reallyMoneyVal != null && reallyMoneyVal !="") {  //实收金额不为null和空
            if ((receivablesVal*1) <= (reallyMoneyVal*1)) { //应收金额小于 实收金额

                if(memberId !=null && memberId != ""){ //有会员
                     if((receivablesVal*1) <= (memberMoneyVal*1) ){  //应收金额小于 会员余额
                            $("#cashBillForm").form("submit", {
                                url: "/cashbill/save",
                                onSubmit: function (param) {
                                    var rows = $("#cashbillitem_datagrid").datagrid("getRows"); //获取所有表格数据
                                    for (var i = 0; i < rows.length; i++) {
                                        if (rows[i].number != null && rows[i].number != '') {
                                            param["items["+i+"].number"] = rows[i].number;
                                            param["items["+i+"].costAmount"] = rows[i].costAmount;
                                            param["items["+i+"].memberAmount"] = rows[i].memberAmount;
                                            param["items["+i+"].productInfoId.id"] = rows[i].productInfoId.id;
                                        }
                                        else {
                                            param["items["+i+"].number"] = 1;
                                            param["items["+i+"].costAmount"] = rows[i].productInfoId.price;
                                            param["items["+i+"].memberAmount"] = rows[i].productInfoId.memberPrice;
                                            param["items["+i+"].productInfoId.id"] = rows[i].productInfoId.id;
                                        }
                                    }
                                },
                                success: function (data) {
                                    data = $.parseJSON(data);
                                    if(data.success){
                                        $.messager.alert("温馨提示",data.msg,"info", function (yes) {
                                            //结账成功重新刷新页面
                                            window.location.href = "/cashbillitem";
                                        });
                                    }
                                    else{
                                        $.messager.alert("温馨提示", data.msg,"info", function (yes) {
                                        });
                                    }
                                }
                            },"json");
                     }
                    else{
                         $.messager.alert("温馨提示", "当前卡内余额不足,请使用其他方式付款", "info")
                    }
                }
                else{  //没有会员
                    $("#cashBillForm").form("submit", {
                        url: "/cashbill/save",
                        onSubmit: function (param) {
                            var rows = $("#cashbillitem_datagrid").datagrid("getRows"); //获取所有表格数据
                            for (var i = 0; i < rows.length; i++) {
                                if (rows[i].number != null && rows[i].number != '') {
                                    param["items["+i+"].number"] = rows[i].number;
                                    param["items["+i+"].costAmount"] = rows[i].costAmount;
                                    param["items["+i+"].memberAmount"] = rows[i].memberAmount;
                                    param["items["+i+"].productInfoId.id"] = rows[i].productInfoId.id;
                                }
                                else {
                                    param["items["+i+"].number"] = 1;
                                    param["items["+i+"].costAmount"] = rows[i].productInfoId.price;
                                    param["items["+i+"].memberAmount"] = rows[i].productInfoId.memberPrice;
                                    param["items["+i+"].productInfoId.id"] = rows[i].productInfoId.id;
                                }
                            }
                        },
                        success: function (data) {
                            data = $.parseJSON(data);
                            if(data.success){ //结账成功
                                //结账成功
                                var selected = $('#paymentTerm option:selected').val(); //现金结账的方式
                                var reallyMoney = $("#reallyMoney").val(); //实收金额
                                var receivables = $("#receivables").val(); //应收金额

                                if(selected == 1){ //现金结账的找回零钱
                                    $.messager.alert("温馨提示", data.msg+",应找回"+(reallyMoney-receivables)+"元","info", function (yes) {
                                        //结账成功重新刷新页面
                                        window.location.href = "/cashbillitem";
                                    });
                                }
                                else {
                                    $.messager.alert("温馨提示", data.msg,"info", function (yes) {
                                        //结账成功重新刷新页面
                                        window.location.href = "/cashbillitem";
                                    });
                                }
                            }
                            else{
                                $.messager.alert("温馨提示", data.msg,"info", function (yes) {
                                });
                            }
                        }
                    },"json");
                }

            }
            else {
                $.messager.alert("温馨提示", "当前实收金额不足", "info")
            }

        }
        else{
            $.messager.alert("温馨提示","请输入实收金额","info")
        }
    })

    //挂单保存
    $("#orderbill").click(function () {
        var rows = $("#cashbillitem_datagrid").datagrid("getRows"); //获取所有表格数据
        if(rows.length > 0){
            $("#cashBillForm").form("submit", {
                url: "/orderbill/save",
                onSubmit: function (param) {
                    //判断当前是否有数据
                        for (var i = 0; i < rows.length; i++) {
                            if (rows[i].number != null && rows[i].number != '') {
                                param["items["+i+"].number"] = rows[i].number;
                                param["items["+i+"].costAmount"] = rows[i].costAmount;
                                param["items["+i+"].memberAmount"] = rows[i].memberAmount;
                                param["items["+i+"].productInfoId.id"] = rows[i].productInfoId.id;
                            }
                            else {
                                param["items["+i+"].number"] = 1;
                                param["items["+i+"].costAmount"] = rows[i].productInfoId.price;
                                param["items["+i+"].memberAmount"] = rows[i].productInfoId.memberPrice;
                                param["items["+i+"].productInfoId.id"] = rows[i].productInfoId.id;
                            }
                        }
                },
                success: function (data) {
                    data = $.parseJSON(data);
                    if(data.success){
                        $.messager.alert("温馨提示", data.msg,"info", function (yes) {
                            //结账成功重新刷新页面
                            window.location.href = "/cashbillitem";
                        });
                    }
                    else{
                        $.messager.alert("温馨提示", data.msg,"info", function (yes) {
                        });
                    }
                }
            },"json");
        }
        else{
            $.messager.alert("温馨提示","请添加商品再进行挂单","info");
        }
    });

    //取单对话框
    $("#orderbillitem_dialog").dialog({
        width:300,
        height:450,
        buttons:"#orderbillitem_dialog_bt",
        closed:true

    });

    //取单数据表格
    $("#orderbillitem_datagrid").datagrid({
        height:376,
        singleSelect:true, /*只选择一个*/
        striped:true, /*斑马线*/
        pagination:true, /*分页*/
        fitColumns:true,
        columns:[[
            {field:'orderTime',title:'挂单时间',width:10,align:'center'}
        ]]
    });

    //取单按钮 点击事件
    $("#ordertime").click(function () {
        $("#orderbillitem_dialog").dialog("open");
        $("#orderbillitem_dialog").dialog("setTitle","挂单列表");

        var options = $("#orderbillitem_datagrid").datagrid("options");
        options.url = "/orderbill/list";
        $("#orderbillitem_datagrid").datagrid("load");
    })

    //确认取单按钮
    $("#affirm").click(function () {
        //获取选中的一行:id
        var selected = $("#orderbillitem_datagrid").datagrid("getSelected");
        //发送请求: 根据billId查询所有的明细
        $.get("/orderbillitem/quertAllByBillId?billId="+selected.id, function (data) {
             //加载数据表格
            $("#cashbillitem_datagrid").datagrid("loadData",data);
            $("#orderbillitem_dialog").dialog("close");

            //统计的计算
            var totalAmount = 0;//计算全部商品的原价的总价格
            var memberAmount = 0;//计算全部商品的会员价的总价格
            var costAmountObj = $("span[data-costAmount]");  //多个原价总价格的对象
            var memberAmountObj = $("span[data-memberAmount]");  //多个会员总价格的对象
            for(var i = 0 ; i < costAmountObj.length ; i++){
                totalAmount = totalAmount + parseInt(costAmountObj[i].innerHTML,10);
                memberAmount = memberAmount + parseInt(memberAmountObj[i].innerHTML,10);
            }

            $("#totalAmount").html(totalAmount); //设置全部商品原价总价格

            //判断有没会员姓名
            if($("#MemberId").val() != null && $("#MemberId").val() != ""){
                $("#receivables").val(memberAmount); //设置会员的总价格
            }
            else{
                $("#receivables").val(totalAmount); //设置原价的总价格
            }
        });
    })

});


//删除该行
function deleteRow(rowid) {
    $.messager.confirm("温馨提示","确认移除吗?", function (yes) {
        if(yes){
             $("#cashbillitem_datagrid").datagrid("deleteRow",rowid);
             $("#cashbillitem_datagrid").datagrid("reload");
            $.messager.alert("温馨提示","移除成功","info", function (yes) {
                var totalAmount = 0;//计算全部商品的原价的总价格
                var memberAmount = 0;//计算全部商品的会员价的总价格
                var costAmountObj = $("span[data-costAmount]");  //多个原价总价格的对象
                var memberAmountObj = $("span[data-memberAmount]");  //多个会员总价格的对象
                for(var i = 0 ; i < costAmountObj.length ; i++){
                    totalAmount = totalAmount + parseInt(costAmountObj[i].innerHTML,10);
                    memberAmount = memberAmount + parseInt(memberAmountObj[i].innerHTML,10);
                }

                $("#totalAmount").html(totalAmount); //设置全部商品原价总价格

                //判断有没会员姓名
                if($("#MemberId").val() != null && $("#MemberId").val() != ""){
                    $("#receivables").val(memberAmount); //设置会员的总价格
                }
                else{
                    $("#receivables").val(totalAmount); //设置原价的总价格
                }
            })
        }
    })
};

//根据会员号码查询会员信息
function check(){
    var memberNumber = $("#MemberNumber").val();
    $.get("/memberInfo/queryMemberByNumber?number="+memberNumber, function (data) {
        if(data.id!=null){
            $("input[id=MemberId]").val(data.id);
            $("#name").html(data.name);
            $("#balance").html(data.balance);
            $("#vipClass").html(data.vipClass);

            var memberAmount = 0;//计算全部商品的会员价的总价格
            var memberAmountObj = $("span[data-memberAmount]");  //多个会员总价格的对象
            for(var i = 0 ; i < memberAmountObj.length ; i++){
                memberAmount = memberAmount + parseInt(memberAmountObj[i].innerHTML,10);
            }
            $("#receivables").val(memberAmount); //设置会员的总价格
        }
        else{
            var totalAmount = $("#totalAmount").html();

            $("input[id=MemberId]").val("");
            $("#name").html("");
            $("#balance").html("");
            $("#vipClass").html("");
            $("#receivables").val(totalAmount);

            $.messager.alert("温馨提示","没有该会员信息","info")
        }
    })
}

