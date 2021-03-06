<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
<link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/material/easyui.css">
<link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/icon.css">   
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.min.js"></script>  
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="/static/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/static/js/views/productInfo.js"></script>
</head>
<body>
	<table id="table_datagrid"></table>
	<div id="table_datagrid_tb">
		<form id="searchForm" method="post">
		<table>
			<tr>
				<td><a class="easyui-linkbutton" data-options="text:'添加商品信息',onClick:myAdd"></a><td>
				<td><a class="easyui-linkbutton" data-options="text:'是否启用',onClick:myDelete"></a><td>
				<td>
						<input class="easyui-textbox" data-options="label:'商品名称:',labelPosition:'left',
							width:200,height:22" name="productName">
						<input class="easyui-textbox" data-options="label:'商品成分:',labelPosition:'left',
							width:200,height:22" name="productPartName">
						<input id="input_combobox_form_productType" name="productTypeId"/>
						<input id="input_combobox_form_brand" name="brandId"/>
				<td>
				<td>
					<a class="easyui-linkbutton" data-options="text:'查询',onClick:mySearch"></a>
				</td>
			</tr>
		</table>
		</form>
	</div>
	<div id="div_dialog">
		<form method="post" id="div_dialog_post" enctype="multipart/form-data">
			<div style="float: left">
				<table style="margin-left: 20px;margin-right: 20px;margin-top: 30px">
					<tr>
						<!-- 商品编码 -->
						<td><input class="easyui-textbox"  name="code"
								data-options="width:250,prompt:'请输入商品编码',label:'商品编码',labelPosition:'left'"></td>
					</tr>
					<tr>
						<td>
							<!-- 商品类别 -->
							<input id="input_combobox_product_type" name="productType.id" data-options="width:250"/>
						</td>
					</tr>
					<tr>
						<td>
							<!-- 商品品牌 -->
							<input id="input_combobox_brand" name="brand.id" data-options="width:250"/>
						</td>
					</tr>
					<tr>
						<td>
							<!-- 商品主要成分 -->
							<input id="input_combobox_product_part" name="productPart.id" data-options="width:250"/>
						</td>
					</tr>
					<tr>
						<td>
							<!-- 商品照片 -->
							<input class="easyui-filebox"  name="imgFile" data-options="width:250,prompt:'请输入商品图片',label:'商品图片',labelPosition:'left',
							width:300,buttonText:'请选择要上传的图片'">
						</td>
					</tr>
				</table>
			</div>
			<div style="float: right">
				<table style="margin-left: 20px;margin-right: 20px;margin-top: 30px">
					<tr>
						<td><input class="easyui-textbox"  name="name"
								data-options="width:250,prompt:'请输入商品名称信息',label:'商品名称',labelPosition:'left'"></td>
					</tr>
					<tr>
						<td>
							<!-- 过敏物 -->
							<input id="input_combobox_harm" name="harm.id" data-options="width:250"/>
						</td>
					</tr>
					<tr>
							<td><input class="easyui-textbox"  name="info"
								data-options="width:250,prompt:'请输入商品备注信息',label:'备注',labelPosition:'left'"></td>
					</tr>
					<tr>
							<td><input class="easyui-textbox"  name="price"
								data-options="width:250,prompt:'请输入商品价格信息',label:'价格',labelPosition:'left'"></td>
					</tr>
					<tr>
						<td>
							<input id="input_combobox_state" name="state" data-options="width:200"/>
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