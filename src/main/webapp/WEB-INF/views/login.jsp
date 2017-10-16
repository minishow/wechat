<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/icon.css">   
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.min.js"></script>  
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.easyui.min.js"></script>  
<title>登录页面</title>
<script type="text/javascript">
	/* 登录之后,不能再次登录,再次访问登录页面进行跳转/main方法 */
	<shiro:authenticated>
		window.location.href="/main";
	</shiro:authenticated>
</script>
<!-- 使用ajax请求进行登录请求,控制登录成功之后只跳转到main.jsp -->
<script type="text/javascript">
	$(function(){
		$("#form").form({
			
		});
		$("#loginBtn").click(function(){
			$("#form").form("submit",{
				url:"/login",
				success:function(myData){
					var data=$.parseJSON(myData);
					console.log(data);
					if(data.success){
						window.location.href="/main"; 
					}else{
						 $.messager.alert("温馨提示",data.msg,"info",function(){
							window.location.href="/login";
						}); 
					}
				}
			});
		});
	});
</script>
</head>
<body>
	<div style="margin-top: 20px;margin-left: 20px;">
		<form method="post" id="form">
			<table>
				<tr><td><span style="font-size: 10px;font-style: italic;">白牙宠物店云管理系统平台</span></td></tr>
				<tr><td><input type="text" placeholder="用户名" name="username" value="李白"/></td></tr>
				<tr><td><input type="password" placeholder="密码" name="password" value="libai"/></td></tr>
				<tr>
					<td><span><img src="/static/img/loginCheck/CheckCode.aspx.gif"></span></td>
					<td><input type="text" placeholder="请输入算式表达式结果"></td>
				</tr>
				<tr>
					<td><input type="button" value="安全登录" id="loginBtn"></td>
					<td><input type="reset" value="重置"></td>
					<td></td>
				</tr>
				<tr>
					<td><a>马上注册</a></td>
					<td><a>忘记密码</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>