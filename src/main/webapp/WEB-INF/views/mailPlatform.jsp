<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>邮件平台</title>
    <%@include file="common.jsp" %>
    <script type="text/javascript" src="/static/js/views/mailPlatform.js"></script>
</head>
<body>
    <table id="sendMail_datagrid"></table>
    <div id="sendMail_dialog">
        <form id="sendMail_form" method="post">
            <div align="center" style="margin-top: 30px;" >
                <div><input type="text" id="receiveName" name="receiveName" class="easyui-textbox" data-options="label:'会员昵称:', width:250"></div>
                <div style="margin-top: 10px"><input type="text" id="receiveMailAccount" name="receiveMailAccount" class="easyui-textbox" data-options="label:'会员邮箱:', width:250"></div>
                <div style="margin-top: 10px"><input type="text" name="fromName" class="easyui-textbox" data-options="label:'发送人昵称:', width:250"></div>
                <div style="margin-top: 10px"><input type="text" name="mailTitle" class="easyui-textbox" data-options="label:'邮件主题:', width:250"></div>
                <div style="margin-top: 10px"><input type="text" name="mailText" class="easyui-textbox" data-options="multiline:true,label:'邮件内容:', height:80,width:250"></div>
            </div>
        </form>
    </div>
    <!-- 定义顶部按钮 -->
    <div id="sendMail_datagrid_tb">
        <div style="align-content: center;margin-top: 5px">
            <a class="easyui-linkbutton" iconCls="" plain="" data-cmd="sendMail">发送邮件</a>
        </div>
    </div>
    <!-- 对话框底部按钮 -->
    <div id="sendMail_dialog_bt">
        <a class="easyui-linkbutton" iconCls="" plain="" data-cmd="send">确认发送</a>
        <a class="easyui-linkbutton" iconCls="" plain="" data-cmd="cancel">取消</a>
    </div>

</body>
</html>
