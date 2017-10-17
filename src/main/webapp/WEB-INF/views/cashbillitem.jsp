<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>收银管理</title>
    <jsp:include page="common.jsp"></jsp:include>
    <script type="text/javascript" src="/static/js/views/cashbillitem.js"></script>
    <script type="text/javascript" src="/static/js/jquery-easyui/datagrid-cellediting.js"></script>
</head>
<body>
<form id="cashBillForm">
    <%--顶部搜索查询--%>
    <div id="cashbillitem_datagrid_tb">
        <div style="float: left;">
            <input id="searchbtn" class="easyui-textbox"/>
        </div>
        <div style="float: right;">
            <a href="/cashbill" class="easyui-linkbutton"
               style="color: #fdfdfd; background-color: #3c8b3c ;">收银记录</a>
        </div>
    </div>
    <%--数据表格--%>
    <div style="height: 80%">
        <%--收银明细数据表格--%>
        <table id="cashbillitem_datagrid"></table>
    </div>
    <div style="height: 14%">
        <form id="memberForm" method="post">
            <table>
                <tr style="height: 25px">
                    <td>总计:<span id="totalAmount">0</span> <%--底部结账--%>
                        <span>元</span>
                    </td>
                </tr>
                <tr style="height: 25px">
                    <input type="hidden" id="MemberId" name="memberId.id">
                    <td style="width: 250px">会员卡号: <input type="text" id="MemberNumber" onblur="check()"></td>
                    <td style="width: 250px">会员姓名: <span id="name"></span></td>
                    <td style="width: 250px">卡内余额: <span id="balance"></span><span>元</span></td>
                    <td style="width: 250px">会员等级: <span id="vipClass"></span></td>
                </tr>

                <tr style="height: 25px">
                    <td style="width: 180px">应收金额: <input type="text" name="totalAmount" id="receivables">
                        <span>元</span></td>
                    <td>实收金额:<input id="reallyMoney" type="text"><span>元</span></td>
                    <td>
                        收款方式:
                        <select id="paymentTerm" name="paymentTerm"  style="width:80px;">
                            <option value="1">现金</option>
                            <option value="2">微信</option>
                            <option value="3">支付宝</option>
                            <option value="4">卡内消费</option>
                        </select>
                    </td>
                    <td><a id="accountsBtn" class="easyui-linkbutton"
                           style="color: #fdfdfd; background-color: #e68900 ; width: 150px;height: 30px"><h2>结账</h2> </a>
                    </td>
                    <td><a id="orderbill" class="easyui-linkbutton"
                           style="color: #fdfdfd; background-color: #e68900 ; width: 150px;height: 30px"><h2>挂单</h2> </a>
                    </td>
                    <td><a id="ordertime" class="easyui-linkbutton"
                           style="color: #fdfdfd; background-color: #e68900 ; width: 150px;height: 30px"><h2>取单</h2></a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</form>
<%--取单对话框--%>
<div id="orderbillitem_dialog">
    <table id="orderbillitem_datagrid"></table>
</div>

<%--对话框的下部按钮--%>
<div id="orderbillitem_dialog_bt">
   <a id="affirm" class="easyui-linkbutton" >确认</a>
   <a id="cancel" class="easyui-linkbutton" >取消</a>
</div>
</body>
</html>
