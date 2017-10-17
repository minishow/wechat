<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>收银报表</title>
    <%@ include file="/WEB-INF/views/common.jsp"%>
    <script type="text/javascript" src="/static/js/views/cashBillChart.js"></script>
</head>
<body>
    <div><select name="selectMenu" id="selectCash"></select></div>
    <div style="margin-top: 10px"></div>
    <table id="cashBillChart_datagrid"></table>
</body>
</html>
