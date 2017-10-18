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
            border-radius: 22px;
        }
    </style>
</head>
<body>
<div class="main_box">
    <div class="imageButton" onclick="show('/productScale')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/pics/navIcons/1.png" /><p style="text-align: center; margin-top: 7px;">商品规格</p>
    </div>
    <div class="imageButton" onclick="show('/brand')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/pics/navIcons/2.png" /><p style="text-align: center; margin-top: 7px;">商品品牌</p>
    </div>
    <div class="imageButton" onclick="show('/productType')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/pics/navIcons/3.png" /><p style="text-align: center; margin-top: 7px;">商品类型</p>
    </div>
    <div class="imageButton" onclick="show('/location')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/pics/navIcons/4.png" /><p style="text-align: center; margin-top: 7px;">产地信息</p>
    </div>
    <div class="imageButton" onclick="show('/loginLog')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/pics/navIcons/5.png" /><p style="text-align: center; margin-top: 7px;">登录日志</p>
    </div>
    <div class="imageButton" onclick="show('/productPart')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/pics/navIcons/6.png" /><p style="text-align: center; margin-top: 7px;">商品成分</p>
    </div>
    <div class="imageButton" onclick="show('/productInfo')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/pics/navIcons/7.png" /><p style="text-align: center; margin-top: 7px;">商品信息</p>
    </div>
    <div class="imageButton" onclick="show('/petKind')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/pics/navIcons/8.png" /><p style="text-align: center; margin-top: 7px;">宠物种类</p>
    </div>
    <div class="imageButton" onclick="show('/petType')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/pics/navIcons/9.png" /><p style="text-align: center; margin-top: 7px;">宠物类别</p>
    </div>
    <div class="imageButton" onclick="show('/supplier')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/pics/navIcons/10.png" /><p style="text-align: center; margin-top: 7px;">供应商管理</p>
    </div>
    <div class="imageButton" onclick="show('/stockOutType')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/pics/navIcons/11.png" /><p style="text-align: center; margin-top: 7px;">出入库管理</p>
    </div>
</div>
<div>
    <iframe id="index" style="width:100%;height:81%" frameborder="0" name="showmessage" src="/loginLog"></iframe>
</div>
</body>
</html>