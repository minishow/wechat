<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/material/easyui.css"><!-- 样式包 -->
    <link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/icon.css"><!-- 图标的样式 -->
    <script type="text/javascript" src="/static/js/jquery-easyui/jquery.min.js"></script><!-- jQuery核心包 -->
    <script type="text/javascript" src="/static/js/jquery-easyui/jquery.easyui.min.js"></script><!-- EaysUI核心包 -->
    <script type="text/javascript" src="/static/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script><!-- 中文包 -->
    <script type="text/javascript" src="/static/js/jquery-easyui/base.js"></script><!-- 补丁包 -->
    <script type="text/javascript" src="/static/js/views/main.js"></script>
    <script>

        $(document).ready(function () {
            $(".main_box div").click(function () {
                $(".main_box div").removeClass("now");
                $(this).addClass("now")
            })
        });
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
    <div class="imageButton" onclick="show('/chart/lineJsp')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/pics/sysicon/pie.png" /><p style="text-align: center; margin-top: 7px;">服务折线图</p>
    </div>
    <div class="imageButton" onclick="show('/chart/pieJsp')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/pics/sysicon/index.png" /><p style="text-align: center; margin-top: 7px;">服务饼图</p>
    </div>
    <div class="imageButton" onclick="show('')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/pics/sysicon/sales.png" /><p style="text-align: center; margin-top: 7px;">消费方式表</p>
    </div>
    <div class="imageButton" onclick="show('')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/pics/sysicon/report.png" /><p style="text-align: center; margin-top: 7px;">位置报表</p>
    </div>
</div>
<div>
    <iframe id="index" style="width:100%;height:81%" frameborder="0" name="showmessage" src="/chart/lineJsp"></iframe>
</div>
</body>
</html>