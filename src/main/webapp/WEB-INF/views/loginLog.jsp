<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日志管理</title>
<link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/material/easyui.css">
<link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/icon.css">   
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.min.js"></script>  
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="/static/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/static/js/views/loginLog.js"></script>
</head>
<body>
	<table id="table_datagrid"></table>
	<div id="table_datagrid_tb">
		<table>
			<tr>
				<td><a class="easyui-linkbutton" data-options="text:'是否启用',onClick:myDelete"></a><td>
				<td><input class="easyui-textbox" data-options="buttonText:'查询',onClickButton:mySearch,prompt:'登录帐号'"><td>
			</tr>
		</table>
	</div>
</body>
</html>