<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>
	<div style="float: left">
		<table>
			<tr>
				<td><img src="/static/img/shopInfo/${shopInfo.img}"></td>
			</tr>
			<tr>
				<td><a href="#">修改图片</a></td>
			</tr>
		</table>
	</div>
	<div>
		<table>
			<tr>
				<td>${shopInfo.name}</td>
				<td><span id="span" style="color: blue;">修改</span></td>
			</tr>
			<tr>
				<td>负责人:${shopInfo.employee.name}</td>
			</tr>
			<tr>
				<td>联系电话:${shopInfo.employee.tel}</td>
			</tr>
			<tr>
				<td>店铺地址:${shopInfo.location}</td>
			</tr>
			<tr>
				<td>成立时间:${shopInfo.time}</td>
			</tr>
		</table>
	</div>
	<div id="div_dialog">
		<form method="post" id="div_dialog_post">
			<input type="hidden" name="employee.id"/>
			<input type="hidden" name="id"/>
			<div style="float: left">
				<table>
					<tr>
						<td><input class="easyui-textbox"  name="name" data-options="label:'店铺名',labelPosition:'left'"></td>
					</tr>
					<tr>
						<td>
							<input class="easyui-textbox"  name="employee.name" data-options="label:'负责人',labelPosition:'left'">
						</td>
					</tr>
					<tr>
						<td>
							<input class="easyui-textbox"  name="fax" data-options="label:'店铺传真',labelPosition:'left'">
						</td>
					</tr>
				</table>
			</div>
			<div>
				<table>
					<tr>
						<td><input class="easyui-textbox"  name="employee.tel" data-options="label:'负责人联系方式',labelPosition:'left'"></td>
					</tr>
					<tr>
						<td>
							<input class="easyui-textbox"  name="location" data-options="label:'店铺地址',labelPosition:'left'">
						</td>
					</tr>
					<tr>
						<td>
							<input class="easyui-textbox"  name="time" data-options="label:'成立时间',labelPosition:'left'">
						</td>
					</tr>
				</table>
			</div>
			<div>
				<input class="easyui-textbox"  name="info" data-options="label:'备注信息',labelPosition:'left'">
			</div>
		</form>
	</div>
	<div id="div_dialog_tb">
		<a class="easyui-linkbutton" data-options="text:'保存',onClick:mySave"></a>
		<a class="easyui-linkbutton" data-options="text:'取消',onClick:myCancel"></a>
	</div>
</body>
</html>