<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品类型</title>
<link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/icon.css">   
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.min.js"></script>  
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="/static/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/static/js/views/productType.js"></script>
</head>
<body>
	<table id="table_datagrid"></table>
	<div id="table_datagrid_tb">
		<table>
			<tr>
				<td><a class="easyui-linkbutton" data-options="text:'添加商品类别',onClick:myAdd"></a><td>
				<td><a class="easyui-linkbutton" data-options="text:'是否启用',onClick:myDelete"></a><td>
				<td><input class="easyui-textbox" data-options="buttonText:'查询',onClickButton:mySearch,prompt:'类别名称'"><td>
			</tr>
		</table>
	</div>
	<div id="div_dialog">
		<form method="post" id="div_dialog_post">
			<table>
				<tr>
					<td><input class="easyui-textbox"  name="name"
							data-options="prompt:'请输入此次添加类别信息'"></td>
				</tr>
				<tr>
					<td>
						<input id="input_combobox" name="parent.id"/>
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
		<a class="easyui-linkbutton" data-options="text:'保存',onClick:mySave"></a>
		<a class="easyui-linkbutton" data-options="text:'取消',onClick:myCancel"></a>
	</div>
</body>
</html>