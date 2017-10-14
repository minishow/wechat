<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>收银管理</title>
    <jsp:include page="common.jsp"></jsp:include>
    <script type="text/javascript" src="/static/js/views/cashbillitem.js"></script>
    <script type="text/javascript" src="/static/js/jquery-easyui/datagrid-cellediting.js"></script>
</head>
<body>
    <table>
        <%--顶部搜索查询--%>
        <div style="height: 35px">
            <input id="searchbtn" class="easyui-textbox" />
        </div>
        <%--数据表格--%>
        <div>
            <%--收银明细数据表格--%>
            <table id="cashbillitem_datagrid" style="height: 400px"></table>
        </div>


        <%--底部结账--%>
        <div id="totalAmount">
            <div>
               总计:4
            </div>
        </div>

         <div>
             <table >
                 <tr>
                    <td>会员卡号:<input type="text" id="MemberNumber" name="MemberNumber" onblur="check()"></td>
                    <td>会员姓名: </td>
                    <td>现有金额: </td>
                    <td>会员等级: </td>
                    <td>商品折扣: </td>
                    <td>服务折扣: </td>
                 </tr>
             </table>
         </div>

         <div>
                <tr>
                    <td>应收金额: </td>
                    <td>实收金额: </td>
                    <td>收款方式: </td>
                </tr>
         </div>
            <div>
                现金结账:
            </div>


    </table>
</body>
</html>
