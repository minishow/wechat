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
    <script>
        $(function(){
            $("#product_stock").click(function(){
                $("#product_stock").css("backgroundColor",'dimgray');
                $("#action_address").prop("src","/productStock");
            }).mouseenter(function(){
                $("#product_stock").css("backgroundColor",'dimgray');
            });;
            $("#operation_stock").click(function(){
                $("#operation_stock").css("backgroundColor",'dimgray');
                $("#action_address").prop("src","/stockOprationBill");
            }).mouseenter(function(){
                $("#operation_stock").css("backgroundColor",'dimgray');
            });;
            $("#income_record").click(function(){
                $("#income_record").css("backgroundColor",'dimgray');
                $("#action_address").prop("src","/stockIncomeRecord");
            }).mouseenter(function(){
                $("#income_record").css("backgroundColor",'dimgray');
            });;
            $("#outcome_record").mouseenter(function(){
                $("#outcome_record").css("backgroundColor",'dimgray');
            }).click(function(){
                $("#outcome_record").css("backgroundColor",'dimgray');
                $("#action_address").prop("src","/stockOutRecord");
            });;
        })

    </script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',border:false" align="center" style="height:6%;padding-top: 8;background-color: dimgray">
    <a id="product_stock" class="easyui-linkbutton" data-options="region:'north',plain:true"
       style="width:18%;color: aliceblue;"
       href="javascript:;">库存主页</a>
    <a id="operation_stock" class="easyui-linkbutton" data-options="region:'north',plain:true" style="width:18%;;color: aliceblue"
       href="javascript:;">入库/发货/制单</a>
    <a id="income_record" class="easyui-linkbutton" data-options="region:'north',plain:true" style="width:18%;;color: aliceblue"
       href="javascript:;">入库记录</a>
    <a id="outcome_record" class="easyui-linkbutton" data-options="region:'north',plain:true" style="width:18%;;color: aliceblue"
       href="javascript:;">出货记录</a>
</div>
<div data-options="region:'south',border:false" style="height:94%" >
    <iframe id="action_address" src="/productStock" style="width: 100%;height: 100%" frameborder="0"/>
</div>


</body>
</html>

