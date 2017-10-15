<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/icon.css">   
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.min.js"></script>  
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.easyui.min.js"></script>  
<script type="text/javascript">
	$(function(){
		$("#form").form({
			
		}); 
		$("#passwordCheck").blur(function(){
			//失去焦点之后,进行校验
			var passwordVal=$("#password").val();
			var passwordCheckVal=$(this).val();
			if(passwordVal!=passwordCheckVal){
				$("#span").text("两次密码不一致!");
			}
		 });
		$("#submit_btn").click(function(){
			$("#form").form("submit",{
				url:"/login/loginRegister",
				success:function(myData){
					var data=$.parseJSON(myData);
					$.messager.alert("温馨提示",data.msg,"info",function(){
						/* 如果成功,跳转回登录页面 */
						if(data.success){
							window.location.href="/login";
						}
					});
				}
			});
		}); 
	});
</script>
</head>
<body>
	<form method="post" id="form">
		<div style="float: left">
			<table>
				<tr>
					<td><span>手机号码:</span></td>
					<td><input type="text" name="tel" placeholder="请输入11位手机号码"></td>
				</tr>
				<tr>
					<td><span>校验码:</span></td>
					<td><input type="text" name="checkCode" placeholder="请输入校验码"></td>
					<td><input type="button" value="获取验证码"></td>
				</tr>
				<tr>
					<td><span>用户名:</span></td>
					<td><input type="text" name="name" placeholder="请输入用户名"></td>
				</tr>
				<tr>
					<td><span>密码:</span></td>
					<td><input type="password" name="password" placeholder="请输入密码" id="password"></td>
				</tr>
				<tr>
					<td><span>确认密码:</span></td>
					<td><input type="password" name="passwordCheck" placeholder="请输入密码" id="passwordCheck"></td>
					<td><span id="span" style="color: red;"></span></td>
				</tr>
			</table>
		</div>
		<div style="float: left">
			<table>
				<tr>
					<td><span>性别:</span></td>
					<td>
						<input type="radio" name="gender" value="1" checked="checked">男
						<input type="radio" name="gender" value="0">女
					</td>
				</tr>
			</table>
		</div>
		<div style="clear: both;">
			<table>
				<tr>
					<td>
						<input type="button" value="提交" id="submit_btn">
					</td>
					<td>
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>