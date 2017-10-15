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
            <table id="cashbillitem_datagrid" style="height: 450px"></table>
        </div>


        <%--底部结账--%>
        <div >
            <div>
                总计:<span id="totalAmount">0</span>
                                <span>元</span>
            </div>
        </div>

         <div>
             <table >
                 <tr>
                    <td>会员卡号:<input type="text" id="MemberNumber" name="Memberinfo" onblur="check()"></td>
                    <td style="width: 150px">会员姓名:<span id="name">55</span></td>
                    <td style="width: 150px">现有金额:<span id="memberAmount">456</span></td>
                    <td style="width: 150px">会员等级:<span id="grade"></span>356</td>
                    <td style="width: 150px">商品折扣:<span id="Productdiscount">252</span></td>
                    <td style="width: 150px">服务折扣:<span id="Servicediscount">78</span></td>
                 </tr>
             </table>
         </div>

         <div>
             <table>
                <tr>
                    <td style="width: 120px">应收金额:<span id="receivables"></span></td>
                    <td >实收金额:<input type="text"></td>
                    <td >收款方式:</td>
                </tr>
             </table>
         </div>
         <div>
             现金结账
         </div>
    </table>
</body>
</html>
