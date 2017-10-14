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
                $("#action_address").prop("src","/productStock");
            });
            $("#import_data").click(function(){
                $("#action_address").prop("src","/import_data");
            });
            $("#operation_stock").click(function(){
                $("#action_address").prop("src","/stockOprationBill");
            });
            $("#income_record").click(function(){
                $("#action_address").prop("src","/stockIncomeRecord");
            });
            $("#outcome_record").click(function(){
                $("#action_address").prop("src","/stockOutRecord");
            });
        })

    </script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',border:false" align="center" style="height:6%;padding-top: 8;background-color: dimgray">
    <a id="product_stock" class="easyui-linkbutton" data-options="region:'north',plain:true" style="width:18%;"
       href="javascript:;">库存主页</a>
    <a id="import_data" class="easyui-linkbutton" data-options="region:'north',plain:true" style="width:18%;"
       href="javascript:;">导入数据</a>
    <a id="operation_stock" class="easyui-linkbutton" data-options="region:'north',plain:true" style="width:18%;"
       href="javascript:;">入库/发货/制单</a>
    <a id="income_record" class="easyui-linkbutton" data-options="region:'north',plain:true" style="width:18%;"
       href="javascript:;">入库记录</a>
    <a id="outcome_record" class="easyui-linkbutton" data-options="region:'north',plain:true" style="width:18%;"
       href="javascript:;">出货记录</a>
</div>
<div data-options="region:'south',border:false" style="height:94%" >
    <iframe id="action_address" src="/stockOprationBill" style="width: 100%;height: 100%"/>
</div>

</body>
</html>

<script>


/*    <div id="tools_btn">
            <a id="product_stock" class="easyui-linkbutton" data-options="region:'north',plain:true" style="width:18%;"
    onclick="productStock();">库存主页</a>
            <a id="import_data" class="easyui-linkbutton" data-options="region:'north',plain:true" style="width:18%;"
    onclick="importData();">导入数据</a>
            <a id="operation_stock" class="easyui-linkbutton" data-options="region:'north',plain:true" style="width:18%;"
    onclick="stockOprationBill();">入库/发货/制单</a>
            <a id="income_record" class="easyui-linkbutton" data-options="region:'north',plain:true" style="width:18%;"
    onclick="stockIncomeRecord();">入库记录</a>
            <a id="outcome_record" class="easyui-linkbutton" data-options="region:'north',plain:true" style="width:18%;"
    onclick="stockIncomeRecord();">发货记录</a>
            </div>*/
    /*  $(function () {
     $("#product_stock").click(function () {
     showPage("库存主页","productStock");
     });
     $("#import_data").click(function () {
     $("#main_page").tabs({
     title:"导入数据",
     fit:true,
     content:"<iframe src='/import_data' width='100%' height='100%' frameborder='0'/>"
     });
     });
     $("#operation_stock").click(function () {
     $("#main_page").tabs({
     title:"导入数据",
     fit:true,
     content:"<iframe src='/stockOprationBill' width='100%' height='100%' frameborder='0'/>"
     });
     /!* $("#action_address").prop("src", "/stockOprationBill");*!/
     });

     $("#income_record").click(function () {
     $("#action_address").prop("src", "/stockIncomeRecord");
     });
     $("#outcome_record").click(function () {
     $("#action_address").prop("src", "/stockOutRecord");
     });*/
</script>


<%--
</body>--%>