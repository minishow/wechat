<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应商管理</title>
<link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/icon.css">   
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.min.js"></script>  
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="/static/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/static/js/views/supplier.js"></script>
</head>
<body>
	<table id="table_datagrid"></table>
	<div id="table_datagrid_tb">
		<table>
			<tr>
				<td><a class="easyui-linkbutton" data-options="text:'添加供应商信息',onClick:myAdd"></a><td>
				<td><a class="easyui-linkbutton" data-options="text:'是否启用',onClick:myDelete"></a><td>
				<td><input class="easyui-textbox" data-options="buttonText:'查询',onClickButton:mySearch,prompt:'供应商名称'"><td>
			</tr>
		</table>
	</div>
	<div id="div_dialog">
		<form method="post" id="div_dialog_post">
			<div style="float: left">
				<table>
					<tr>
						<!-- 供应商编码 -->
						<td><input class="easyui-textbox"  name="sn"
								data-options="prompt:'请输入供应商编号',label:'供应商编号',labelPosition:'left'"></td>
					</tr>
					<tr>
						<td>
							<input class="easyui-textbox"  name="person"
								data-options="prompt:'请输入联系人名字',label:'联系人',labelPosition:'left'">
						</td>
					</tr>
					<tr>
						<td>
							<!--主要供应商品 -->
							<input id="input_combobox_product_info" name="product.id"/>
						</td>
					</tr>
					<tr>
						<td>
							<!-- 优势 -->
							<input class="easyui-textbox"  name="info"
								data-options="prompt:'请输入供应商优势',label:'优势',labelPosition:'left'">
						</td>
					</tr>
				</table>
			</div>
			<div style="float: right">
				<table>
					<tr>
						<td><input class="easyui-textbox"  name="name"
								data-options="prompt:'请输入供应商名称信息',label:'供应商名称',labelPosition:'left'"></td>
					</tr>
					<tr>
							<td><input class="easyui-textbox"  name="tel"
								data-options="prompt:'请输入联系电话信息',label:'联系电话',labelPosition:'left'"></td>
					</tr>
					<tr>
							<td><input class="easyui-textbox"  name="day"
								data-options="prompt:'首次合作时间',label:'首次合作时间',labelPosition:'left'"></td>
					</tr>
					<tr>
						<td>
							<input id="input_combobox_state" name="state"/>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<div id="div_dialog_tb">
		<a class="easyui-linkbutton" data-options="text:'保存',onClick:mySave"></a>
		<a class="easyui-linkbutton" data-options="text:'取消',onClick:myCancel"></a>
	</div>
</body>
</html>