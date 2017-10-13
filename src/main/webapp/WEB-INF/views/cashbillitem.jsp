<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>收银管理</title>
    <jsp:include page="common.jsp"></jsp:include>
    <script type="text/javascript" src="/static/js/views/cashbillitem.js"></script>
</head>
<body>
    <table>
        <%--顶部搜索查询--%>
        <div>
            <input id="searchbtn" name="keyword" class="easyui-textbox" onclick="search()" />
        </div>
        <%--数据表格--%>
        <div>
            <%--收银明细数据表格--%>
            <table id="cashbillitem_datagrid" style="height: 400px">
                <tr>
                    <td><span tag="code">code</span></td><%--商品69条码--%>
                    <td>
                        <span tag="name">name</span></td><%-- 商品名称--%>
                        <input type="hidden"name="cashBillItem.productinfo.id" tag="pid"/>
                    </td>
                    <td><span tag="price">price</span></td><%--原价--%>
                    <td><span tag="memberPrice">memberPrice</span></td><%--会员价--%>
                    <td><span tag="memberPrice">number</span></td><%--数量--%>
                    <td><span tag="unit">unit</span></td><%--单位--%>
                    <td><span tag="costAmount">costAmount</span></td><%--原价总价--%>
                    <td><span tag="memberAmount">memberAmount</span></td><%--会员总价--%>
                    <td>
                        <a href="javascript:;" class="removeItem">删除</a>
                    </td>
                </tr>
            </table>
        </div>
        <%--底部结账--%>
        <div>

        </div>
    </table>
</body>
</html>
