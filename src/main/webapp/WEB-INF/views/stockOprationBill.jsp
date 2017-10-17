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

        $(function () {

            $("#table_data2,#table_data3").hide();
            $("#product_details").click(function () {
                $("#table_data1").show();
                $("#table_data2,#table_data3").hide();
            });
            $("#specifics_setting").click(function () {
                $("#table_data2").show();
                $("#table_data1,#table_data3").hide();
            });

            $("#warn_setting").click(function () {
                $("#table_data3").show();
                $("#table_data1,#table_data2").hide();
            });

            $("operation_form").form('submit', {
                validate: function (data) {
                    alert(data);
                }

            });
            $("#form_reload").click(function () {
                $("#operation_form").form("clear");
            });


            $("#print_bill").click(function () {

            });

            $("#importExcel").click(function () {
                $("#file_form").dialog({
                    title: '编辑',
                    width: 600,
                    height: 400,
                    closed: false,
                    modal: true,
                    buttons: '#edit_info'
                });
            });
            var jsonData = function () {
            }

            function getDate(url) {
                $.post(url, function (data) {
                    jsonData.data1 = data;
                });
            }


            getDate("/stockOprationBill/queryOpenStocks");

            submitDate("/stockOprationBill/saveStockOprationBills", "all_inStock", "datagrip_table");
            submitDate("/stockOprationBill/printExcel", "print_bill", "datagrip_show");
        });

        function saveInput() {
            $("#file_form").form("submit", {
                url: "/stockOprationBill/importExcel",
                success: function (data) {
                    var dataJson = eval("(" + data + ")");
                    if (dataJson.success) {
                        $.messager.alert("温馨提示", dataJson.msg, "warning", function () {
                            if (param == 'print_bill') {
                                $("#file_img").prop("src", "/file/test.xls");

                            }
                        });
                    } else {
                        for (var i = 0; i < dataJson.length; i++) {
                            $('#datagrip_show').datagrid('appendRow', {
                                'productInfo.name': dataJson[i].productInfoId,
                                'productionPrice': dataJson[i].productionPrice,
                                'costPrice': dataJson[i].costPrice,
                                'memberPrice': dataJson[i].memberPrice,
                                'number': dataJson[i].number,
                                'stockIncome.id': dataJson[i].stockIncomeId,
                                'productStock.sn': dataJson[i].productStockSn,
                                'specific.number': dataJson[i].specificNumber,
                                'specific.id': dataJson[i].specificId,
                                'specific.stockSpecific': dataJson[i].openStockId,
                                'inputTime': dataJson[i].inputTime,
                                'survivalTime': dataJson[i].survivalTime,
                                'warnDate': dataJson[i].warnDate,
                                'warnNumber': dataJson[i].warnNumber,
                                'operation': dataJson[i].operation
                            });
                        }

                            $("#submit_btn").hide();
                            $.messager.alert("温馨提示", "导出成功", "warning", function () {

                        });
                        return;
                        $.messager.alert("温馨提示", dataJson.msg, "warning", function () {
                        });
                    }
                }
            })
            $("#file_form").dialog("close");
        }

        function closeInput() {
            $("#file_form").dialog("close");
        }






        function submitDate(url, param, table) {
            $("#" + param).click(function () {
                var  rowDates = $("#" + table).datagrid("getRows");
                var  showRos= $("#datagrip_show").datagrid("getRows");
                if (showRos.length == 0 && rowDates.length == 0) {
                    $.messager.alert("温馨提示", "亲数据位空哦", "warning", function () {
                    });
                } else {
                    var rowDates = $("#datagrip_table").datagrid("getRows");
                    /*  如果table数据为空*/
                    if (rowDates == 0 && param == 'all_inStock') {
                        var showRos = $("#datagrip_show").datagrid("getRows");
                        $("#jsonString_text").form("submit", {
                            url: "/stockOprationBill/saveExcelData",
                            onSubmit: function (param) {
                                console.log(showRos);
                                for (var i = 0; i < showRos.length; i++) {
                                    param["stockObjects[" + i + "].productInfoId"] = showRos[i]['productInfo.name'];
                                    param["stockObjects[" + i + "].productionPrice"] = showRos[i]['productionPrice'];
                                    param["stockObjects[" + i + "].costPrice"] = showRos[i].costPrice;
                                    param["stockObjects[" + i + "].memberPrice"] = showRos[i].memberPrice;
                                    param["stockObjects[" + i + "].number"] = showRos[i].number;
                                    param["stockObjects[" + i + "].stockIncomeId"] = showRos[i]['stockIncome.id'];
                                    param["stockObjects[" + i + "].productStockSn"] = showRos[i]['productStock.sn'];
                                    param["stockObjects[" + i + "].specificNumber"] = showRos[i]['specific.number'];
                                    param["stockObjects[" + i + "].specificId"] = showRos[i]['specific.id'];
                                    param["stockObjects[" + i + "].openStockId"] = showRos[i]['specific.stockSpecific'];
                                    param["stockObjects[" + i + "].inputTime"] = showRos[i].inputTime;
                                    param["stockObjects[" + i + "].survivalTime"] = showRos[i].survivalTime;
                                    param["stockObjects[" + i + "].warnDate"] = showRos[i].warnDate;
                                    param["stockObjects[" + i + "].warnNumber"] = showRos[i].warnNumber;
                                    param["stockObjects[" + i + "].operation"] = showRos[i].operation;
                                }

                                for (var index = showRos.length - 1; index >= 0; index--) {
                                    /*   $("#datagrip_table").datagrid("deleteRow", index);*/
                                    $("#datagrip_show").datagrid("deleteRow", index);
                                }
                            },
                            success: function (data) {
                                var dataJson = eval("(" + data + ")");
                                if (dataJson.success) {
                                    $("#submit_btn").show();
                                    $.messager.alert("温馨提示", dataJson.msg, "warning", function () {
                                    });
                                } else {
                                    $.messager.alert("温馨提示", dataJson.msg, "warning", function () {
                                    });
                                }
                            }
                        });
                        return;
                    }
                    var  rowDates = $("#" + table).datagrid("getRows");
                    $("#jsonString_text").form("submit", {
                        url: url,
                        onSubmit: function (para) {
                            console.log(rowDates);
                            for (var i = 0; i < rowDates.length; i++) {
                                para["stockObjects[" + i + "].productInfoId"] = rowDates[i]['productInfo.name'];
                                para["stockObjects[" + i + "].productionPrice"] = rowDates[i]['productionPrice'];
                                para["stockObjects[" + i + "].costPrice"] = rowDates[i].costPrice;
                                para["stockObjects[" + i + "].memberPrice"] = rowDates[i].memberPrice;
                                para["stockObjects[" + i + "].number"] = rowDates[i].number;
                                para["stockObjects[" + i + "].stockIncomeId"] = rowDates[i]['stockIncome.id'];
                                para["stockObjects[" + i + "].productStockSn"] = rowDates[i]['productStock.sn'];
                                para["stockObjects[" + i + "].specificNumber"] = rowDates[i]['specific.number'];
                                para["stockObjects[" + i + "].specificId"] = rowDates[i]['specific.id'];
                                para["stockObjects[" + i + "].openStockId"] = rowDates[i]['specific.stockSpecific'];
                                para["stockObjects[" + i + "].inputTime"] = rowDates[i].inputTime;
                                para["stockObjects[" + i + "].survivalTime"] = rowDates[i].survivalTime;
                                para["stockObjects[" + i + "].warnDate"] = rowDates[i].warnDate;
                                para["stockObjects[" + i + "].warnNumber"] = rowDates[i].warnNumber;
                                para["stockObjects[" + i + "].operation"] = rowDates[i].operation;

                            }
                            if (param == 'all_inStock') {
                                for (var index = rowDates.length - 1; index >= 0; index--) {
                                    $("#datagrip_table").datagrid("deleteRow", index);
                                    $("#datagrip_show").datagrid("deleteRow", index);
                                }
                            }
                        },
                        success: function (data) {
                            var dataJson = eval("(" + data + ")");
                            if (dataJson.success) {

                                $.messager.alert("温馨提示", dataJson.msg, "warning", function () {
                                    if (param == 'print_bill') {
                                        $("#file_img").prop("src", "/file/test.xls");
                                    }
                                });
                            } else {
                                $.messager.alert("温馨提示", dataJson.msg, "warning", function () {
                                });
                            }
                        }
                    });
                }


            });

        }


    </script>
</head>
<body>
<body class="easyui-layout">
<div data-options="region:'east',buttons:'#operation_btn',border:false" style="width:100%;">

    <form id="operation_form">
        <div id="table_data1">
            <table id="" width="100%">
                <div></tr>
                    <th>

                        <select id="product_name" name="productInfo.id" class="easyui-combobox" iconCls="icon-man"
                                data-options="label:'商品名称',width:250,required:true,prompt:'输入商品名称',
                            valueField:'id',textField:'name',
                            url:'/stockOprationBill/queryProductInfos'"></select></br>
                        <input id="productionPrice" class="easyui-numberbox" iconCls="icon-man"
                               data-options="label:'商品价格',width:250,prompt:'输入价格'"/></br>
                        <input id="code" name="code" class="easyui-textbox" iconCls="icon-man"
                               data-options="label:'商品条码',width:250,prompt:'输入正确的条码号'"/></br>
                    </th>
                    <th>
                        <input id="number" name="number" class="easyui-numberbox" iconCls="icon-man"
                               data-options="label:'数量',width:250,prompt:'输入正确的数量',required:true"/></br>
                        <input id="costPrice" name="costPrice" class="easyui-numberbox" iconCls="icon-man"
                               data-options="label:'进/发价',width:250,prompt:'入库进价/发货售价',required:true"/></br>
                        <input id="memberPrice" name="memberPrice" class="easyui-numberbox" iconCls="icon-man"
                               data-options="label:'启用折扣',width:250,prompt:'输入库存单号'"/></br>
                    </th>


                    <th>
                        <select id="productInfo_location" class="easyui-combobox" iconCls="icon-man" data-options="label:'生产地',width:250,prompt:'商品的生产地',
                            valueField:'id',textField:'name',
                          url:'/stockOprationBill/queryLocations'
                         "></select></br>


                        <select id="productInfo_brand" class="easyui-combobox" iconCls="icon-man" data-options="label:'商品品牌',width:250,prompt:'商品的品牌',
                            valueField:'id',textField:'name',
                          url:'/stockOprationBill/queryBrands'"></select></br>


                        <select id="productInfo_productType" class="easyui-combobox" iconCls="icon-man" data-options="label:'商品类型',width:250,prompt:'商品所属的类型',
                            valueField:'id',textField:'name',
                          url:'/stockOprationBill/queryProductTypes'"></select></br>
                    </th>


                    <th>
                        <select id="productInfo_productPart" class="easyui-combobox" iconCls="icon-man" data-options="label:'主要成分',width:250,prompt:'商品都有组成的成分',
                            valueField:'id',textField:'name',
                          url:'/stockOprationBill/queryProductParts'"></select></br>


                        <select id="stockIncome" name="stockIncome.id" class="easyui-combobox" iconCls="icon-man"
                                data-options="label:'入库方式',width:250,required:true,prompt:'入库方式有三种',
                            valueField:'id',textField:'name',
                          url:'/stockOprationBill/queryStockIncomes'"></select></br>


                        <input id="sn" name="productStock.sn" class="easyui-textbox" iconCls="icon-man"
                               data-options="label:'库存编码',width:250,required:true,prompt:'输入库存编码'"/></br>
                    </th>
                    </tr>
                </div>
            </table>
        </div>


        <div id="table_data2">
            <table width="100%">
                <div></tr>

                    <th>
                        <select id="before_specific" name="specific.id" class="easyui-combobox" iconCls="icon-man"
                                data-options="label:'原有规格',width:250,required:true,prompt:'原本的规格',
                            valueField:'id',textField:'beforeSpecific',
                          url:'/stockOprationBill/querySpecifics'"></select></br>
                    </th>


                    <th>
                        <select id="stock_specific" name="specific.stockSpecific" class="easyui-combobox"
                                iconCls="icon-man" data-options="label:'拆零规格',required:true,width:250,prompt:'需要拆分规格类型',
                            valueField:'id',textField:'name',
                          url:'/stockOprationBill/queryOpenStocks'"></select></br>
                    </th>


                    <th>
                        <input id="specific_number" name="specific.number" class="easyui-numberbox" iconCls="icon-man"
                               data-options="label:'拆零份数',required:true,width:250,prompt:'拆分份数'"/></br>
                    </th>
                    <th>
                        <input id="specific_price" class="easyui-numberbox" iconCls="icon-man"
                               data-options="label:'拆零单价',required:true,width:250,prompt:'拆分后的份的价格'"/></br>
                    </th>
                    </tr>
                </div>
            </table>
        </div>


        <div id="table_data3">
            <table width="100%">
                <div></tr>
                    <th>
                        <input id="product_date" name="inputTime" class="easyui-datebox" iconCls="icon-man"
                               data-options="label:'生产日期',width:250,required:true,prompt:'产品的生产日期'"/></br>
                    </th>
                    <th>
                        <input id="survival_time" name="survivalTime" class="easyui-datebox" iconCls="icon-man"
                               data-options="label:'保质期',width:250,required:true,prompt:'保质期保安全'"/></br>
                    </th>
                    <th>
                        <input id="input_survival" name="warnDate" class="easyui-datebox" iconCls="icon-man"
                               data-options="label:'预警日期',width:250,required:true,prompt:'距离保质期一定时间便开始预警'"/></br>
                    </th>
                    <th>

                        <input id="warn_operation" name="warnNumber" class="easyui-textbox" iconCls="icon-man"
                               data-options="label:'预警后操作',width:250,prompt:'预警后的处理措施'"/></br>
                    </th>
                    </tr>
                    <tr>
                        <th >
                            </p>
                            <input id="warn_number" name="warnNumber" class="easyui-numberbox" iconCls="icon-man"
                                   data-options="label:'预警数量',width:250,prompt:'设置预警数量'"/></br>
                        </th>
                    </tr>
                </div>
            </table>
        </div>
    </form>
    <div id="next_btn" align="center" style="position:absolute; bottom:10px; right:450px;">
        <HR>
        <inupt type="submit" id="product_details" class="easyui-linkbutton" data-options="region:'north',plain:true"
               style="width:180;background-color: #919191"
               href="javascript:;">商品详细信息>>>>
        </inupt>
        <inupt type="submit" id="specifics_setting" class="easyui-linkbutton"
               data-options="region:'north',plain:true" style="width:180;background-color: #919191"
               href="javascript:;">拆零参数设置>>>>
        </inupt>
        <inupt type="submit" id="warn_setting" class="easyui-linkbutton" data-options="region:'north',plain:true"
               style="width:180;background-color: #919191"
               href="javascript:;">预警设置
        </inupt>
    </div>
    <div id="operation_btn" align="center" style="position:absolute; bottom:10px; right:52px;">
        <a href="javascript:;" id="submit_btn" data-options="plain:true"
           style="width: 100;background-color: #919191" class="easyui-linkbutton" iconCls="icon-ok"> 下一步</a>
        <a href="javascript:;" id="form_reload" data-options="plain:true"
           style="width:100;background-color: #919191" class="easyui-linkbutton" iconCls="icon-reload"> 重置</a>
    </div>

</div>

<div data-options="region:'south',border:false" style="height:70%">
    <table id="datagrip_show" style="color:red">

    </table>
</div>
<table id="datagrip_table" style="color:red">
    <div id="datagrip_tools" align="center">
        <form id="search_form">
            <a id="all_inStock" class="easyui-linkbutton"
               data-options="width:120,height:30,plain:true" iconCls="icon-ok">全部入库</a>
            <a id="importExcel" class="easyui-linkbutton"
               data-options="width:120,height:30,plain:true" iconCls="icon-ok">导入数据</a>
            <a id="print_bill" class="easyui-linkbutton"
               data-options="width:120,height:30,plain:true" iconCls="icon-ok">打印制单</a>
        </form>
    </div>
</table>
<script type="text/javascript" src="/static/js/views/stockOprationBill.js"></script>

<form id="jsonString_text" method="post">

</form>
<div>
    <form id="file_form" method="post" enctype="multipart/form-data">
        <input type="file" name="file"/>
    </form>
</div>
<div id="edit_info" style="align-self:true">
    <a onclick="saveInput();" class="easyui-linkbutton" iconCLs="icon-save"
       data-options="width:80,height:30,plain:true">保存</a>
    <a onclick="closeInput();" class="easyui-linkbutton" iconCLs="icon-reload"
       data-options="width:80,height:30,plain:true">取消</a>
</div>
<div id="inputText_dialog">Dialog Content.</div>
<iframe id="file_img" src=""/>

</body>
</body>
</html>