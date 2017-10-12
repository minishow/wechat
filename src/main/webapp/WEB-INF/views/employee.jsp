<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="common.jsp"></script>
    <title>员工界面</title>
</head>
<body>
<div class="easyui-layout" style="width:400px;height:200px;">
    <div region="west" split="true" title="Navigator" style="width:150px;">
        <p style="padding:5px;margin:0;">Select language:</p>
        <ul>
            <li><a href="#" onclick="">Java</a></li>
            <li><a href="#" onclick="">C#</a></li>
            <li><a href="#" onclick="">VB</a></li>
            <li><a href="#" onclick="">Erlang</a></li>
        </ul>
    </div>
    <div id="content" region="center" title="Language" style="padding:5px;">
    </div>
</div>
</body>
</html>
