
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/views/common.jsp"></jsp:include>
    <script>
        $(document).ready(function () {
            $(".main_box div").click(function () {
                $(".main_box div").removeClass("now")
                $(this).addClass("now")
            })
        })
//        设置index的src属性为obj参数
        function show(obj) {
            $("#index").attr("src", obj)
        }
    </script>
    <style>
        .l-text-wrapper {
            position: relative;
            float: left;
            margin: 10px;
        }
        .main_box {
            height: 90px;
            min-width: 1100px;
            overflow: hidden;
            width: 100%;
            margin: 5px auto 0 10px;
            padding-top: 5px;
        }
        .now {
            border: 2px solid #ccc;
            box-shadow: none;
        }
        .imageButton {
            background: #fafbfb none repeat scroll 0 0;
            box-shadow: 1px 2px 5px 0 rgba(111, 111, 111, 0.7);
            float: left;
            height: 70px;
            margin-right: 27px;
            padding-top: 10px;
            width: 90px;
        }
    </style>
</head>
<body>
<div class="main_box">
    <div class="imageButton" onclick="show('/employee')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/picture/1.png" /><p style="text-align: center; margin-top: 7px;">基本信息</p>
    </div>
    <div class="imageButton" onclick="show('/position')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/picture/2.png" /><p style="text-align: center; margin-top: 7px;">职位设置</p>
    </div>
    <div class="imageButton" onclick="show('/leaveRecord')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/picture/3.png" /><p style="text-align: center; margin-top: 7px;">请假记录</p>
    </div>
    <div class="imageButton" onclick="show('/pay')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/picture/3.png" /><p style="text-align: center; margin-top: 7px;">薪资计算</p>
    </div>
    <div class="imageButton" onclick="show('/role')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/picture/3.png" /><p style="text-align: center; margin-top: 7px;">角色管理</p>
    </div>
</div>
<div>
        <%--跳转--%>
    <iframe id="index" style="width:100%;height:81%" frameborder="0" name="showmessage" src="/employee"></iframe>
</div>
</body>
</html>
