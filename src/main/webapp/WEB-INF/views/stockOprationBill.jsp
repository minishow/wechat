<%--<%@ taglib prefix="s" uri="/struts-tags" %>--%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <script>
        $(function(){
            $("#table_data2,#table_data3").hide();
            $("#product_details").click(function(){
                $("#table_data1").show();
                $("#table_data2,#table_data3").hide();
             });
            $("#specifics_setting").click(function(){
                $("#table_data2").show();
                $("#table_data1,#table_data3").hide();
            });

            $("#warn_setting").click(function(){
                $("#table_data3").show();
                $("#table_data1,#table_data2").hide();
            });
        })
    </script>
</head>
<body>
<body class="easyui-layout">
<div data-options="region:'west',border:false" style="width:15%;background-color:dimgray ">
    <div align="center">
        <div align="center" style="padding-top: 5;width: 96%">
            <a id="product_details" class="easyui-linkbutton" data-options="region:'north',plain:true" style="width:50%;"
               href="javascript:;">商品详细信息</a><p>
            <a id="specifics_setting" class="easyui-linkbutton" data-options="region:'north',plain:true" style="width:50%;"
               href="javascript:;">拆零参数设置</a><p>
            <a id="warn_setting" class="easyui-linkbutton" data-options="region:'north',plain:true" style="width:50%;"
               href="javascript:;">预警设置</a><br>
        </div>
    </div>
</div>

<div data-options="region:'center',buttons:'#operation_btn'" style="height:100px;">
        <form id="operation_form" class="">
            <div id="table_data1">
                <table id="" width="100%">
                    <div></tr>
                        <th>
                            <input class="easyui-textbox" data-options="label:'商品名称',width:250"/></br>
                            <input class="easyui-textbox" data-options="label:'商品价格',width:250"/></br>
                            <input class="easyui-textbox" data-options="label:'商品条码',width:250"/></br>
                        </th>
                        <th>
                            <input class="easyui-textbox" data-options="label:'数量',width:250"/></br>
                            <input class="easyui-textbox" data-options="label:'进/发价',width:250"/></br>
                            <input class="easyui-textbox" data-options="label:'启用折扣',width:250"/></br>
                        </th>
                        <th>
                            <select class="easyui-combobox" data-options="label:'生产地',width:250"></select></br>
                            <select class="easyui-combobox" data-options="label:'商品品牌',width:250"></select></br>
                            <select class="easyui-combobox" data-options="label:'商品类型',width:250"></select></br>
                        </th>
                        <th>
                            <select class="easyui-combobox" data-options="label:'主要成分',width:250"></select></br>
                            <select class="easyui-combobox" data-options="label:'入库方式',width:250"></select></br>
                            <input class="easyui-textbox" data-options="label:'商品条码',width:250"/></br>
                        </th>
                        </tr>
                    </div>
                </table>
            </div>
            <div id="table_data2">
                <table width="100%">
                    <div></tr>
                        <th>
                            <select class="easyui-combobox" data-options="label:'原有规格',width:250"></select></br>
                        </th>
                        <th>
                            <select class="easyui-combobox" data-options="label:'拆零规格',width:250"></select></br>
                        </th>
                        <th>
                            <input class="easyui-textbox" data-options="label:'拆零份数',width:250"/></br>
                        </th>
                        <th>

                            <input class="easyui-textbox" data-options="label:'拆零单价',width:250"/></br>
                        </th>
                        </tr>
                    </div>
                </table>
            </div>
            <div id="table_data3">
                <table width="100%">
                    <div></tr>
                        <th>
                            <input class="easyui-textbox" data-options="label:'生产日期',width:250"/></br>
                        </th>
                        <th>
                            <input class="easyui-textbox" data-options="label:'保 质  期',width:250"/></br>
                        </th>
                        <th>
                            <input class="easyui-textbox" data-options="label:'预警日期',width:250"/></br>
                        </th>
                        <th>

                            <input class="easyui-textbox" data-options="label:'预警数量',width:250"/></br>
                        </th>
                        </tr>
                    </div>
                </table>
            </div>
            <div id="operation_btn" align="center" style="margin-bottom: 5">
                <a href="javascript:;" style="width: 100px" class="easyui-linkbutton"> 下一步</a>
                <a href="javascript:;" style="width: 100px" class="easyui-linkbutton"> 重置</a>
            </div>
        </form>
</div>


<div data-options="region:'south',border:false" style="height:76%">
    <table id="datagrip_table">
        <div id="myTools">
            <form id="searchForm">
                <a id="reload" onclick="reload();" class="easyui-linkbutton"
                   data-options="width:60,height:30,plain:true" iconCls="icon-reload">刷新</a>
                <input id="productStock_keyword" type="text" class="easyui-textbox" iconCls="icon-man" name="keyword"/>
                <a id="searchData" onclick="search();" class="easyui-linkbutton"
                   data-options="width:60,height:30,plain:true" iconCls="icon-search">搜索</a>
            </form>
        </div>
    </table>
</div>








</body>
</html>