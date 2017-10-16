
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="common.jsp"></jsp:include>
    <script type="text/javascript" src="/static/js/views/memberTop.js"></script>
</head>
<body>
<div id="membertop_datagrid"></div>

<%--顶部按钮和高级查询--%>
<div id="SDUS_BTN">
    <form id="searchBtn" method="post">
        <input  class="easyui-textbox" name="topUpNumber"
                data-options=" 'prompt':'请输入关键字','width':'200','label':'充值编号:','labelWidth':'50',">

        <input class="easyui-textbox" name="topMemNumber"
               data-options="'prompt':'请输入关键字','width':'200','label':'充值卡号:','labelWidth':'50',">

        <input class="easyui-textbox" name="topMemName"
               data-options="'prompt':'请输入关键字','width':'200','label':'会员名称:','labelWidth':'50',">
        <a class="easyui-linkbutton"  onclick="query()">查询</a>
    </form>
    </div>
</body>
</html>
