<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>密码修改</title>
<link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/icon.css">   
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.min.js"></script>  
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.easyui.min.js"></script> 
<script type="text/javascript">
	$(function(){
		$("#submitBtn").form({
			
		});
		$("#submitBtn").click(function(){
			var spanText=$("#span").text();
			if(spanText){
				$("#span").text("请输入正确的密码!");
				return;
			}else{
				var spanText=$("#span_confirm").text();
				if(spanText){
					$("#span_confirm").text("两次密码不一致,请修改密码!");
					return;
				}else{
					$("#form").form("submit",{
						url:"/employee/doChangePassword",
						success:function(myData){
							/* 修改成功之后跳转到主页面 */
							var data=$.parseJSON(myData);
							if(data.success){
								$.messager.alert("温馨提示",data.msg,"info",function(){
									window.location.href="/main";
								});
							}else{
								$.messager.alert("温馨提示",data.msg,"info",function(){
									window.location.href="/employee/changePassword";
								});
							}
						}
					});
				}
			}
		});
		$("#oldPassword").change(function(){
			//失去焦点之后进行ajax去后台判断是否密码一致
			var myVal=$(this).val();
			$.get("/employee/checkPassword?oldPassword="+myVal,function(data){
				$("#span").text("");
				if(!data.success){
					$("#span").text("密码错误");
				}
			},"json");
		});
		/* 给确认密码绑定change事件,来验证前后密码是否一致 */
		$("#confirmPassword").change(function(){
			var confirmPasswodr=$(this).val();
			var newPassowrd=$("#newPassword").val();
			$("#span_confirm").text("");
			if(newPassowrd!=confirmPasswodr){
				$("#span_confirm").text("两次密码不一致");
			}
		});
	});
</script>
</head>
<body>
	<div style="margin-left: 10%;margin-top: 10%;">
		<form  id="form" method="post">
			<table>
				<tr>
					<td><span>用户名:</span></td>
					<td><span>${name}</span></td>
				</tr>
				<tr>
					<td><span>旧密码:</span></td>
					<td><input type="password" name="oldPassword" id="oldPassword"></td>
					<td><span style="color: red" id="span"></span></td>
				</tr>
				<tr>
					<td><span>新密码:</span></td>
					<td><input type="password" name="newPassword" id="newPassword"></td>
				</tr>
				<tr>
					<td><span>确认密码:</span></td>
					<td><input type="password" name="confirmPassword" id="confirmPassword"></td>
					<td><span style="color: red" id="span_confirm"></span></td>
				</tr>
				<tr>
					<td><input type="button" value="确认修改" id="submitBtn"></td>
					<td><input type="reset" value="重置"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>