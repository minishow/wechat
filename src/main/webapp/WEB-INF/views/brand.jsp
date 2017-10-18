<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品品牌</title>
<link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/material/easyui.css">
<link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/icon.css">   
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.min.js"></script>  
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="/static/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/static/js/views/brand.js"></script>
</head>
<body>
	<table id="table_datagrid"></table>
	<div id="table_datagrid_tb">
		<table>
			<tr>
				<td><a class="easyui-linkbutton brand" data-options="text:'添加品牌'" data-cmd="myAdd"></a><td>
				<td><a class="easyui-linkbutton brand" data-options="text:'是否启用'" data-cmd="myDelete"></a><td>
				<td><input class="easyui-textbox brand" data-options="buttonText:'查询',prompt:'品牌名称',onClickButton:mySearch"><td>
			</tr>
		</table>
	</div>
	<div id="div_dialog">
		<form method="post" id="div_dialog_post">
			<table>
				<tr>
					<td><input class="easyui-textbox"  name="name"
							data-options="prompt:'请输入品牌信息'"></td>
				</tr>
				<tr>
					<td>
						<input id="input_combobox" name="location.id"/>
					</td>
				</tr>
				<tr>
					<td>
						<input id="input_combobox_state" name="state"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="div_dialog_tb">
		<a class="easyui-linkbutton brand" data-options="text:'保存'" data-cmd="mySave"></a>
		<a class="easyui-linkbutton brand" data-options="text:'取消'" data-cmd="myCancel"></a>
	</div>
</body>
</html>