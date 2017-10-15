<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
<link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/icon.css">   
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.min.js"></script>  
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="/static/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/static/js/views/productInfo.js"></script>
</head>
<body>
	<table id="table_datagrid"></table>
	<div id="table_datagrid_tb">
		<table>
			<tr>
				<td><a class="easyui-linkbutton" data-options="text:'添加商品信息',onClick:myAdd"></a><td>
				<td><a class="easyui-linkbutton" data-options="text:'是否启用',onClick:myDelete"></a><td>
				<td><input class="easyui-textbox" data-options="buttonText:'查询',onClickButton:mySearch,prompt:'商品名称'"><td>
			</tr>
		</table>
	</div>
	<div id="div_dialog">
		<form method="post" id="div_dialog_post">
			<div style="float: left">
				<table>
					<tr>
						<!-- 商品编码 -->
						<td><input class="easyui-textbox"  name="code"
								data-options="prompt:'请输入商品编码',label:'商品编码',labelPosition:'left'"></td>
					</tr>
					<tr>
						<td>
							<!-- 商品类别 -->
							<input id="input_combobox_product_type" name="productType.id"/>
						</td>
					</tr>
					<tr>
						<td>
							<!-- 商品品牌 -->
							<input id="input_combobox_brand" name="brand.id"/>
						</td>
					</tr>
					<tr>
						<td>
							<!-- 商品主要成分 -->
							<input id="input_combobox_product_part" name="productPart.id"/>
						</td>
					</tr>
					<tr>
						<td>
							<!-- 商品照片 -->
							<input  class="easyui-textbox"  name="img" data-options="prompt:'请输入商品图片',label:'商品图片',labelPosition:'left'">
						</td>
					</tr>
				</table>
			</div>
			<div style="float: right">
				<table>
					<tr>
						<td><input class="easyui-textbox"  name="name"
								data-options="prompt:'请输入商品名称信息',label:'商品名称',labelPosition:'left'"></td>
					</tr>
					<tr>
						<td>
						<td>
							<!-- 过敏物 -->
							<input id="input_combobox_harm" name="harm.id"/>
						</td>
					</tr>
					<tr>
							<td><input class="easyui-textbox"  name="info"
								data-options="prompt:'请输入商品备注信息',label:'备注',labelPosition:'left'"></td>
					</tr>
					<tr>
							<td><input class="easyui-textbox"  name="price"
								data-options="prompt:'请输入商品价格信息',label:'价格',labelPosition:'left'"></td>
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