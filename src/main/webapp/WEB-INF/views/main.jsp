<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>白牙宠物管理系统</title>
    <%@ include file="/WEB-INF/views/common.jsp"%>
    <script type="text/javascript" src="/static/js/views/main.js"></script>
    <style type="text/css">
        .tip {
            position: absolute;
            top: 25px;
            left: -13px;
            z-index: 10000;
            border: 1px solid #FFC340;
            width: 150px;
            height: 20px;
            line-height: 20px;
            padding-left: 5px;
            background-color: #FFFCC7;
            border-radius: 5px;
            display: none;
            text-align: center;
            color: red;
        }
        .tip1 {
            position: absolute;
            z-index: 10000;
            border: 1px solid #FFC340;
            line-height: 20px;
            padding: 8px;
            background-color: #FFFCC7;
            border-radius: 5px;
            display: none;
            color: #F00;
            right: 115px;
        }
        .pageBottom {
            height: 30px;
            color: #dadada;
            line-height: 30px;
            text-align: center;
            color: #dadada;
            background: #393939;
            font-size: 12px;
            width: 100%;
        }
        .aStyle {
            color:white;
            text-decoration:none;
        }

    </style>
</head>
<body>
    <div class="easyui-layout" fit="true">
        <div data-options="region:'north'" style="background-color: #393939;height: 47px;border: 0px">
            <img style="float: left;margin-left: 20px" src="/static/pics/sysicon/logo_gl.png" />
            <div style="float: right;margin-top: 20px;margin-right: 15px;color: white">
                <a class="aStyle" href="/employee/changePassword" onclick="">唐笑笑</a>
                <span>|</span>&nbsp;&nbsp;
                <span style="position: relative"><a id="warning" onclick="">库存预警</a><span id="tip" class="tip"></span><span id="tipone" class="tip"></span></span>&nbsp;&nbsp;
                <span>|</span>&nbsp;&nbsp;
                <a class="aStyle" href="/logout" onclick="return confirm('确定退出系统吗？');">退出</a>&nbsp;&nbsp;
                <span class="wc">|</span>&nbsp;&nbsp;
                <span id="weixin" style="cursor: pointer">微信二维码</span><span id="tip1" class="tip1">
                    <img style="position: absolute; top: -8px; left: 60px; width: 15px;" src="/static/pics/sysicon/jj.png">
                    <img src="/static/pics/sysicon/wechat.png" width="130" /></span>&nbsp;&nbsp;
            </div>
        </div>
        <div data-options="region:'west',width:80" style="background-color: #393939;border: 0px;">
            <div id="navDiv" style="margin-left: 15px;margin-right: 15px;margin-top: 30px">
                <shiro:hasRole name="shoper">
	                <div id="memberNav" onclick="addtab('会员管理','memberNav','petInfo');">
	                    <img src="/static/pics/sysicon/cwgl.png" />
	                    <a class="aStyle" style="float:left;" href="#">会员管理</a>
	                </div>
                </shiro:hasRole>
                <shiro:hasRole name="pay">
	                <div id="payNav" onclick="addtab('收银管理','payNav','cashbillitem');" style="margin-top: 30px">
	                    <img src="/static/pics/sysicon/sygl.png" />
	                    <a class="aStyle" style="float:left;" href="#">收银管理</a>
	                </div>
                </shiro:hasRole>
                <shiro:hasRole name="shoper">
	                <div id="serviceNav" onclick="addtab('宠物服务','serviceNav','/petService');" style="margin-top: 30px">
	                    <img src="/static/pics/sysicon/fw.png" />
	                    <a class="aStyle" style="float:left;" href="#">宠物服务</a>
	                </div>
	                <div id="repertoryNav" onclick="addtab('库存管理','repertoryNav','');" style="margin-top: 30px">
	                    <img src="/static/pics/sysicon/kcgl.png" />
	                    <a class="aStyle" style="float:left;" href="#">库存管理</a>
	                </div>
	                <div id="mailNav" onclick="addtab('邮件平台','mailNav','/mailPlatform');" style="margin-top: 30px">
	                    <img src="/static/pics/sysicon/weixin.png" />
	                    <a class="aStyle" style="float:left;" href="#">邮件平台</a>
	                </div>
	                <div id="statementNav" onclick="addtab('报表分析','statementNav','/chart');" style="margin-top: 30px">
	                    <img src="/static/pics/sysicon/bbgl.png" />
	                    <a class="aStyle" style="float:left;" href="#">报表分析</a>
	                </div>
	                <div id="employeeNav" onclick="addtab('员工管理','employeeNav','/employee/skip');" style="margin-top: 30px">
	                    <img src="/static/pics/sysicon/yggl.png" />
	                    <a class="aStyle" style="float:left;" href="#">员工管理</a>
	                </div>
	                <div id="sysNav" onclick="addtab('系统设置','sysNav','/systemMenu');" style="margin-top: 30px">
	                    <img src="/static/pics/sysicon/xtsz.png" />
	                    <a class="aStyle" style="float:left;" href="#">系统设置</a>
	                </div>
                </shiro:hasRole>
            </div>
        </div>
        <div data-options="region:'center'">
            <div id="main_tabs">
                <div title="我的主页">
                    <iframe src='/shopInfo' style='width:100%;height:100%' frameborder='0'></iframe>
                </div>
            </div>
        </div>
        <div data-options="region:'south',height:30" style="background-color: #393939;border: 0px">
            <div class="pageBottom">白牙宠物 伴你一路</div>
        </div>
    </div>
</body>
</html>
