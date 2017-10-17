$(function () {
    /*
     * 抽取所有需要用得元素.
     */
    var sendMailDatagrid,sendMailDialog,sendMailForm;
    sendMailDatagrid = $("#sendMail_datagrid");
    sendMailDialog = $("#sendMail_dialog");
    sendMailForm = $("#sendMail_form");
    //宠物登记表格
    sendMailDatagrid.datagrid({
        fit:true,
        rownumbers:true,
        singleSelect:true,
        pagination:true,
        url:'/mailPlatform/queryMemberInfo',
        fitColumns:true,
        toolbar:'#sendMail_datagrid_tb',
        columns:[
            [
                {field:'number',align:'center',width:100,title:'会员号'},
                {field:'name',align:'center',width:100,title:'会员昵称'},
                {field:'tel',align:'center',width:100,title:'联系方式'},
                {field:'birthday',align:'center',width:100,title:'会员生日'},
                {field:'adress',align:'center',width:100,title:'会员地址'},
                {field:'email',align:'center',width:100,title:'会员邮箱'}
            ]
        ],
        onClickRow:function(rowIndex,rowData){
        }
    });
    sendMailDialog.dialog({
        width:400,
        height:350,
        title:"发送邮件",
        closed:true,
        buttons:'#sendMail_dialog_bt'
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
        sendMail:function () {
            var rowData = sendMailDatagrid.datagrid("getSelected");
            if(rowData){
                //1.清空表单数据
                sendMailForm.form("clear");
                //2.设置对话框的标题
                sendMailDialog.dialog("setTitle","发送短信");
                //3.打开对话框
                sendMailDialog.dialog("open");
                $("#receiveName").textbox('initValue',rowData.name);
                $("#receiveMailAccount").textbox('initValue',rowData.email);
            }else{
                $.messager.alert("温馨提示","请选择需要发送邮件的会员!","warning");
            }
        },
        send:function () {
            sendMailForm.form("submit",{
                url:'/mailPlatform/sendEmail',
                success:function(data){
                    data = $.parseJSON(data);
                    if(data.success){
                        //提示消息,当点确定的时候,关闭对话框,刷新数据表格
                        $.messager.alert("温馨提示",data.msg,"info",function(){
                            sendMailDialog.dialog("close");
                        });
                    }else{
                        $.messager.alert("温馨提示",data.msg,"error");
                    }
                }
            });
        },
        cancel:function(){
            sendMailDialog.dialog("close");
        }
    }
});