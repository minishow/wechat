<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>收银记录</title>
    <jsp:include page="common.jsp"></jsp:include>
    <script type="text/javascript" src="/static/js/views/cashbill.js"></script>
    <script type="text/javascript" src="/static/js/My97DatePicker/WdatePicker.js"></script>

    <script type="text/javascript">
        $(function () {
            //日期
            $("[name='qo.beginDate']").click(function () {
                WdatePicker({
                    maxDate:$("[name='qo.endDate']").val()
                });
            })
            $("[name='qo.endDate']").click(function () {
                WdatePicker({
                    minDate:$("[name='qo.beginDate']").val()
                });
            })
        })
    </script>
</head>
<body>
<form id="cashbillForm">
    <div>
        会员卡号: <input type="text" name="qo.keyword">
        收银时间: <input name="qo.beginDate" class="ui_input_txt02 Wdate" /> ~
                 <input name="qo.endDate"  class="ui_input_txt02 Wdate"/>
        收款方式:
        <select name="qo.way" style="width:80px;">
            <option value="-1">所有</option>
            <option value="1">现金</option>
            <option value="2">微信</option>
            <option value="3">支付宝</option>
            <option value="4">卡内消费</option>
        </select>
        <input id="queryBtn" type="button" value="查询">
    </div>
    <table id="cashBill_datagrid"></table>
</form>
</body>
</html>
