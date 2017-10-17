<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>店铺首页</title>
    <link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/icon.css">
    <script type="text/javascript" src="/static/js/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/static/js/jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/static/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="/static/js/views/shopInfo.js"></script>
    <script type="text/javascript">
        /* 点击图片的实现进行js点击input,然后判断input的value变化,绑定onchange事件 */
        $(function () {
            $("#imgForm").form({});
            $("#img").click(function () {
                /* 点击input框 */
                $("#shopImg").click();
                $("#shopImg").change(function () {
                    $("#imgForm").form("submit", {
                        url: "/shopInfo/changeImg",
                        success: function (myData) {
                            /* 保存图片,并且更改img src的属性内容 */
                            var data = $.parseJSON(myData);
                            if (data.success) {
                                $("img").prop("src", "/static/img/shopInfo/" + data.msg);
                            } else {
                                $.messager.alert("温馨提示", data.msg, "info");
                            }
                        }
                    });
                });
            });
        });
    </script>
    <style type="text/css">
        .mysec {
            background-image: url("/static/pics/serviceIcons/shoppic.png"); /*图片地址*/
            background-origin: content-box; /*从content区域开始显示背景*/
            background-position: 50% 50%; /*             图片上下左右居中  */
            background-size: contain; /*           保持图像本身的宽高比例，将图片缩放到宽度或高度正好适应定义背景的区域  */
            background-repeat: no-repeat; /*         图像不重复显示  */
        }

        .mysec2 {
            height: 200px;
            width: 400px;
            background-image: url("/static/pics/serviceIcons/shopinfo.png"); /*图片地址*/
            background-origin: content-box; /*从content区域开始显示背景*/
            background-position: 50% 50%; /*             图片上下左右居中  */
            background-size: auto; /*           保持图像本身的宽高比例，将图片缩放到宽度或高度正好适应定义背景的区域  */
            background-repeat: round; /*         图像拉伸  */
        }
    </style>
</head>
<body>
<div style="float: left;height: 40%;width: 40%;margin-left: 5%;margin-top: 1%;">
    <table>
        <tr>
            <td>
                <div style="height: 450px;width: 450px" class="mysec">
                    <img style="height: 70%;width: 70%;margin-top: 67px;margin-left: 67px"
                         src="/static/img/shopInfo/${shopInfo.img}" id="img">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <form method="post" id="imgForm" enctype="multipart/form-data">
                    <input type="hidden" name="id" value="${shopInfo.id}">
                    <input type="file" name="file" id="shopImg" style="display: none;">
                </form>
            </td>
        </tr>
    </table>
</div>
<div class="mysec2" style="position:fixed;bottom:90px;right:80px">
    <div style="width: 50%;height: 50%;margin-left: 23%;margin-top: 8%">
        <table>
            <tr>
                <th>
                    <span>${shopInfo.name}</span>
                    <span id="span" style="color: blue;margin-left: 1px;">修改</span>
                </th>
            </tr>
            <tr>
                <td>负责人 : ${shopInfo.employee.name}</td>
            </tr>
            <tr>
                <td>联系电话 : ${shopInfo.employee.tel}</td>
            </tr>
            <tr>
                <td>店铺地址 : ${shopInfo.location}</td>
            </tr>
            <tr>
                <td>成立时间 : <fmt:formatDate value="${shopInfo.time}" pattern="yyyy年MM月dd日"/></td>
            </tr>
        </table>
    </div>
</div>
<div id="div_dialog">
    <form method="post" id="div_dialog_post">
        <input type="hidden" name="employee.id"/>
        <input type="hidden" name="id"/>
        <div style="float: left">
            <table>
                <tr>
                    <td><input class="easyui-textbox" name="name" data-options="label:'店铺名',labelPosition:'left'"></td>
                </tr>
                <tr>
                    <td>
                        <input class="easyui-textbox" name="employee.name"
                               data-options="label:'负责人',labelPosition:'left'">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input class="easyui-textbox" name="fax" data-options="label:'店铺传真',labelPosition:'left'">
                    </td>
                </tr>
            </table>
        </div>
        <div>
            <table>
                <tr>
                    <td><input class="easyui-textbox" name="employee.tel"
                               data-options="label:'负责人联系方式',labelPosition:'left'"></td>
                </tr>
                <tr>
                    <td>
                        <input class="easyui-textbox" name="location" data-options="label:'店铺地址',labelPosition:'left'">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input class="easyui-textbox" name="time" data-options="label:'成立时间',labelPosition:'left'">
                    </td>
                </tr>
            </table>
        </div>
        <div>
            <input class="easyui-textbox" name="info" data-options="label:'备注信息',labelPosition:'left'">
        </div>
    </form>
</div>
<div id="div_dialog_tb">
    <a class="easyui-linkbutton" data-options="text:'保存',onClick:mySave"></a>
    <a class="easyui-linkbutton" data-options="text:'取消',onClick:myCancel"></a>
</div>
</body>
</html>