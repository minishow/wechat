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
<body>

<table id="datagrip_table">
    <div id="datagrip_tools" style="" align="center">
        <form id="search_form">
            <input id="code_sn" type="text" class="easyui-textbox" data-options="label:'商品/库存码;'" style="width: 20%"
                   name="keyword" iconCls="icon-man" name="keyword"/>
            <input id="productName" type="text" class="easyui-textbox" data-options="label:'商品名称;'" style="width: 20%"
                   name="productName" iconCls="icon-man" name="keyword"/>
            <input id="productTypes" class="easyui-combobox" data-options="label:'商品类别:',
                    valueField:'id',textField:'name',
                      multiple:true,
                     url:'/productStock/productTypes'" style="width:220px;">
            </input>
            <a id="searchData" data-options="width:60,height:30,plain:true" iconCls="icon-search">查询</a>
            <a id="edit" onclick="edit();" class="easyui-linkbutton"
               data-options="width:60,height:30,plain:true" iconCls="icon-edit">编辑</a>
            <a id="reload_data" data-options="width:60,height:30,plain:true" iconCls="icon-reload">刷新</a>
        </form>
    </div>
</table>
<script type="text/javascript" src="/static/js/views/productStock.js"></script>

</body>

<div>
    <form id="edit_form" method="post">
        <table align="center">
            <div align="center" style="margin-top: 15px">
                <tr align="center">
                    <th width="50%" align="center">
                        <input type="hidden" name="id"/>
                        <div>
                            <input id="productInfo_id" name="productInfo.id" class="easyui-combobox" data-options="label:'商品名称:',width:260,
                         valueField:'id',textField:'name',
                          url:'/productStock/listProductInfos'
                         " style="width:150px;">
                            </input></p>
                        </div>
                        <div align="center">
                            <input name="sn" class="easyui-textbox" data-options="label:'库存编码:',width:200"></p>
                        </div>
                        <div align="center">
                            <input name="packageNumber" class="easyui-textbox"
                                   data-options="label:'整装库存:',width:200"></p>
                        </div>
                        <div>
                            <input id="productInfo_code" name="productInfo.code" class="easyui-numberbox"
                                   data-options="label:'商品69码:',width:200"></p>
                        </div>
                        <div>
                            <input id="productPart_name" name="productInfo.productPart.name" class="easyui-textbox"
                                   data-options="label:'商品类型:',width:200"></p>
                        </div>



                    </th>
                    <th width="50%" align="center">


                        <div>
                            <input name="bulkNumber" class="easyui-textbox" data-options="label:'散装库存:',width:200"></p>
                        </div>
                        <div>
                            <input name="amount" class="easyui-textbox" data-options="label:'库存结余(元):',width:200"></p>
                        </div>
                        <div>
                            <input name="warnNumber" class="easyui-textbox" data-options="label:'预警数量:',width:200"></p>
                        </div>
                        <div>
                            <input id="productType_name" name="productInfo.productType.name" class="easyui-textbox"
                                   data-options="label:'主要成分:',width:200"></p>
                        </div>

                        <div id="edit_info" style="align-self:true">
                            <a onclick="saveInput();" class="easyui-linkbutton" iconCLs="icon-save"
                               data-options="width:80,height:30,plain:true">保存</a>
                            <a onclick="closeInput();" class="easyui-linkbutton" iconCLs="icon-reload"
                               data-options="width:80,height:30,plain:true">取消</a>
                        </div>
                        <div>
                            <input id="brand_name" name="productInfo.brand.name" class="easyui-textbox"
                                   data-options="label:'商品品牌:',width:200"></p>
                        </div>
                        </p>
                    </th>

                </tr>
                <div>

        </table>
    </form>
</div>
</html>