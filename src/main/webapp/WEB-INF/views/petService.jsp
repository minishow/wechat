<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>宠物服务</title>
	<%@include file="common.jsp" %>
	<script type="text/javascript" src="/static/js/views/petService.js"></script>
</head>
<body>
<div class="easyui-layout" fit="true">
	<div data-options="region:'west',border:false" style="width:12%;">
		<ul id="petServiceMenuTree"></ul>
	</div>
	<div data-options="region:'center'">
		<table id="petServiceRegister_datagrid"></table>
		<!-- 定义对话框 -->
		<div id="petServiceRegister_dialog">
			<form id="petServiceRegister_form" method="post">
				<input type="hidden" name="id">
				<div align="center" style="margin-top: 10px;" >
				</div>
			</form>
		</div>
		<!-- 定义顶部按钮 -->
		<div id="petServiceRegister_datagrid_tb">
			<div>
				<a class="easyui-linkbutton" iconCls="" plain="" data-cmd="add">新增</a>
			</div>
			<div>
				<input id="nameSearchBtn" type="text">
				<input id="telSearchBtn" type="text">
			</div>
		</div>
		<!-- 对话框底部按钮 -->
		<div id="petServiceRegister_dialog_bt">
			<a class="easyui-linkbutton" iconCls="" plain="" data-cmd="save">保存</a>
			<a class="easyui-linkbutton" iconCls="" plain="" data-cmd="cancel">取消</a>
		</div>
	</div>
</div>
</body>
</html>