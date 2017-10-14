<%--<%@ taglib prefix="s" uri="/struts-tags" %>--%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/material/easyui.css"><!-- 样式包 -->
<link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/icon.css"><!-- 图标的样式 -->
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.min.js"></script><!-- jQuery核心包 -->
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.easyui.min.js"></script><!-- EaysUI核心包 -->
<script type="text/javascript" src="/static/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script><!-- 中文包 -->
<script type="text/javascript" src="/static/js/jquery-easyui/base.js"></script><!-- 补丁包 -->
<head>
    <meta charset="UTF-8">
    <title>库存管理</title>

</head>
<body class="easyui-layout">

    <div data-options="region:'south',border:false" style="height:100%" >
        <table id="datagrip_table">
            <div id="datagrip_tools" style="" align="center">
                <form id="search_form">
                    <input id="code_sn" type="text" class="easyui-textbox" data-options="label:'商品条码/库存编码;'" style="width: 20%"
                        name="keyword"    iconCls="icon-man" name="keyword" />
                    <input id="productName" type="text" class="easyui-textbox" data-options="label:'商品名称;'"  style="width: 20%"
                           name="productName"   iconCls="icon-man" name="keyword" />
                    <input id="productType" type="text" class="easyui-textbox" data-options="label:'商品类别;'"  style="width: 20%"
                           name="productType"   iconCls="icon-man" name="keyword" />
                    <input  id="productTypes" class="easyui-combobox" data-options="label:'商品类别:',
                    valueField:'id',textField:'name',
                      multiple:true,
                     url:'/productStock/productTypes'" style="width:150px;">
                    </input>
                    <a id="searchData" data-options="width:60,height:30,plain:true" iconCls="icon-search">查询</a>
                    <a id="reload" onclick="reload();" class="easyui-linkbutton"
                       data-options="width:60,height:30,plain:true" iconCls="icon-reload">刷新</a>
                </form>
            </div>
    </div>
<script type="text/javascript" src="/static/js/views/productStock.js"></script>

</body>
</html>