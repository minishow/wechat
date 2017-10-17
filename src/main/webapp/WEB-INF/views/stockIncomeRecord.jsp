<%--<%@ taglib prefix="s" uri="/struts-tags" %>--%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<link href="/static/js/jquery-easyui/themes/default/easyui.css" rel="stylesheet" type="text/css"/>
<link href="/static/js/jquery-easyui/themes/icon.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="/static/js/jquery/jquery.js"></script>
<script type="text/javascript" src="/static/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.easyui.min.js"></script>
<head>
    <meta charset="UTF-8">


</head>
<body >


<table id="datagrip_table">
    <div id="datagrip_tools">
        <form id="search_form">
            <input id="productStock_keyword" align="center" data-options="label:'商品名称:',width:250"
                   type="text" class="easyui-textbox" iconCls="icon-man" name="keyword" />
            <a id="search_data" data-options="width:60,height:30,plain:true" iconCls="icon-search">搜索</a>
            <a id="reload_data" data-options="width:60,height:30,plain:true" iconCls="icon-reload">刷新</a>
        </form>
    </div>
</table>
<script type="text/javascript" src="/static/js/views/stockIncomeRecord.js"></script>

</body>
</html>