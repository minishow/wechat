<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>收银记录</title>
    <jsp:include page="common.jsp"></jsp:include>
    <script type="text/javascript" src="/static/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="/static/js/views/cashbill.js"></script>

    <script type="text/javascript">
        $(function () {
            //日期
            $("[id='beginDate']").click(function () {
                WdatePicker({
                    maxDate:$("[id='endDate']").val()
                });
            })
            $("[id='endDate']").click(function () {
                WdatePicker({
                    minDate:$("[id='beginDate']").val()
                });
            })
        })
    </script>
</head>
<body>
    <div>
        会员卡号: <input id="keyword" type="text" >
        收银时间: <input id="beginDate" type="date" class="ui_input_txt02 Wdate" /> ~
                 <input id="endDate" type="date" class="ui_input_txt02 Wdate"/>
        收款方式:
        <select id="way" style="width:80px;">
            <option value="-1">所有</option>
            <option value="1">现金</option>
            <option value="2">微信</option>
            <option value="3">支付宝</option>
            <option value="4">卡内消费</option>
        </select>
        <input id="DoSearch" type="button" value="查询" onclick="check()" >
    </div>
    <table id="cashBill_datagrid" ></table>

    <div id="cashbill_dialog">
        <form id="cashbill_form">
           <table align="center">
               <input name="id" type="hidden">
               <tr>
                   <td>商品名称:<input id="productName">
                        <input type="button" value="查询" onclick="checkItem()"/>
                   </td>
               </tr>
               <tr>
                   <td><table id="product_datagrid"></table></table></td>
               </tr>
           </table>
        </form>
    </div>
</body>
</html>
