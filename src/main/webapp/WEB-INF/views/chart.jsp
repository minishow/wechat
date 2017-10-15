<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
    <%@ include file="/WEB-INF/views/common.jsp"%>
    <script type="text/javascript" src="/static/js/views/main.js"></script>
    <script>

        $(document).ready(function () {
            $(".main_box div").click(function () {
                $(".main_box div").removeClass("now")
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
<body style="overflow-x:hidden">
<div class="main_box">
    <div class="imageButton now" onclick="show('/chart/serviceChartByPie')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/pics/sysicon/pie.png" /><p style="text-align: center; margin-top: 7px;">数据报表</p>
    </div>
    <div class="imageButton" onclick="show('')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/pics/sysicon/report.png" /><p style="text-align: center; margin-top: 7px;">分类销售比</p>
    </div>
    <div class="imageButton" onclick="show('')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/pics/sysicon/sales.png" /><p style="text-align: center; margin-top: 7px;">商品数据表</p>
    </div>
    <div class="imageButton" onclick="show('')">
        <img style="margin-left: 30px; width: 35px; height: 35px" src="/static/pics/sysicon/index.png" /><p style="text-align: center; margin-top: 7px;">位置报表</p>
    </div>
</div>
<div>
    <iframe id="index" style="width:100%;height:81%" frameborder="0" name="showmessage" src="/chart/serviceChartByPie"></iframe>
</div>
</body>
</html>