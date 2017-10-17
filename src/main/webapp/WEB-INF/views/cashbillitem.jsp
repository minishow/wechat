<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>收银管理</title>
    <jsp:include page="common.jsp"></jsp:include>
    <script type="text/javascript" src="/static/js/views/cashbillitem.js"></script>
    <script type="text/javascript" src="/static/js/jquery-easyui/datagrid-cellediting.js"></script>
</head>
<body>
<form id="cashBillForm">
    <table>
        <%--顶部搜索查询--%>
        <div style="height: 35px">
            <input id="searchbtn" class="easyui-textbox" />
            <a href="../cashbill" class="easyui-linkbutton"  style="color: #fdfdfd; background-color: #3c8b3c ; width: 150px;height: 30px;margin-left: 900px "  ><h2>收银记录</h2></a>
        </div>
        <%--数据表格--%>
        <div>
            <%--收银明细数据表格--%>
            <table id="cashbillitem_datagrid" style="height: 370px"></table>
        </div>
         <div>
             <form id="memberForm" method="post">
                 <table>
                     <tr style="height: 50px">
                        <td>总计:<span id="totalAmount">0</span> <%--底部结账--%>
                                 <span>元</span>
                        </td>
                     </tr>
                     <tr style="height: 50px">
                        <input type="hidden" id="MemberId" name="memberId.id">
                        <td style="width: 250px">会员卡号:<input type="text" id="MemberNumber" onblur="check()"></td>
                        <td style="width: 250px">会员姓名:<span id="name"></span></td>
                        <td style="width: 250px">卡内余额:<span id="balance"></span><span>元</span></td>
                        <td style="width: 250px">会员等级:<span id="vipClass"></span></td>
                     </tr>

                     <tr style="height: 50px">
                        <td style="width: 180px">应收金额: <input type="text" name="totalAmount" id="receivables"> <span>元</span></td>
                        <td >实收金额:<input id="reallyMoney" type="text"><span>元</span></td>
                        <td>
                            收款方式:
                                <select id="paymentTerm" name="paymentTerm" style="width:80px;">
                                    <option value="1">现金</option>
                                    <option value="2">微信</option>
                                    <option value="3">支付宝</option>
                                    <option value="4">卡内消费</option>
                                </select>
                         </td>
                         <td><a id="accountsBtn"  class="easyui-linkbutton"  style="color: #fdfdfd; background-color: #e68900 ; width: 150px;height: 30px"><h2>结账</h2></a></td>
                     </tr>
                 </table>
             </form>
         </div>
    </table>
</form>
</body>
</html>
