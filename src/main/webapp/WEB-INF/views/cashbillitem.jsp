<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>收银管理</title>
    <jsp:include page="common.jsp"></jsp:include>
    <script type="text/javascript" src="/static/js/views/cashbillitem.js"></script>
</head>
<body>
    <table>
        <%--顶部搜索查询--%>
        <div>
            <input class="easyui-textbox" data-options="iconCls:'icon-search',label:'商品69条码:',labelPosition:'before'">
        </div>
        <%--数据表格--%>
        <div>
            <%--收银明细数据表格--%>
            <table id="cashbillitem_datagrid" style="height: 400px"></table>
        </div>
        <%--底部结账--%>
        <div>

        </div>
    </table>
</body>
</html>
