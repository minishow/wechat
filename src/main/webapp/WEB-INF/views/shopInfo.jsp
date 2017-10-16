<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	$(function(){
		$("#imgForm").form({
			
		});
		$("#img").click(function(){
			/* 点击input框 */
			$("#shopImg").click();
			$("#shopImg").change(function(){
				$("#imgForm").form("submit",{
					url:"/shopInfo/changeImg",
					success:function(myData){
						/* 保存图片,并且更改img src的属性内容 */
						var data=$.parseJSON(myData);
						if(data.success){
							$("img").prop("src","/static/img/shopInfo/"+data.msg);
						}else{
							$.messager.alert("温馨提示",data.msg,"info");
						}
					}
				});
			});
		});		
	});
</script>
</head>
<body>
	<div style="float: left;height: 40%;width: 40%;margin-left: 5%;margin-top: 1%;">
		<table>
			<tr>
				<td>
					<img style="height: 480;width: 380" src="/static/img/shopInfo/${shopInfo.img}" id="img">
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
	<div style="float: left;margin-left: 10px;margin-top: 1%;height: 40%;width: 40%;">
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