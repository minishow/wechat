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
				onSubmit:function(){
					/* 提交之前先判断使用验证正确,如果错误,则返回false不进行提交 */
					var myFlag=$("#codeSpan").data("flag");
					if(myFlag=="true"){
						return true;
					}else{
						$("#codeSpan").text("请输入正确的验证码,点击图片切换");
						return false;
					}
				},
				success:function(myData){
					var data=$.parseJSON(myData);
					if(data.success){
						/* 发送异步请求去删除本次的验证码图片 */
						var myName=$("img").data("name");
						$.get("/login/deleteValidateImg?imgName="+myName);
						/* 成功之后跳转到主页面 */
						window.location.href="/main";
					}else{
						 $.messager.alert("温馨提示",data.msg,"info",function(){
							window.location.href="/login";
						}); 
					}
				}
			});
		});
		/* 给验证码图片绑定点击事件,点击的时候切换另外一张图片 */
		$("img").click(function(){
			/* 访问后台生成图片,并切换img的src的值 */
			var imgName=$(this).data("name");
			var imgObj=$(this);
			$.get("/login/clickChangeValidateImg?imgName="+imgName,function(data){
				if(data.success){
					var arrayStr=data.msg.split("=");
					/* 给src更新路径 */
					imgObj.prop("src",arrayStr[0]);
					/* 把验证码保存起来 */
					$("#codeInput").data("code",arrayStr[1]);
					/* 拿到图片的名字并把名字存起来 */
					var arrayStrName=arrayStr[0].split("/");
					$("img").data("name",arrayStrName[4]);
				}
			},"json");
		});
		/* 给验证码输入框添加验证事件 */
		$("#codeInput").blur(function(){
			$("#codeSpan").text("");
			var codeServer=($(this).data("code")).toLowerCase();
			var codeClient=($(this).val()).toLowerCase();
			if(codeServer!=codeClient){
				$("#codeSpan").data("flag","false");
				$("#codeSpan").text("验证码不正确");
			}else{
				$("#codeSpan").data("flag","true");
			}
		});
	});
</script>
</head>
<body>
	<div style="margin-top: 20px;margin-left: 20px;">
		<form method="post" id="form">
			<table>
				<tr><td><span style="font-size: 20px;font-style: italic;">白牙宠物店云管理系统平台</span></td></tr>
				<tr><td><input type="text" placeholder="用户名" name="username" value="李白"/></td></tr>
				<tr><td><input type="password" placeholder="密码" name="password" value="libai"/></td></tr>
				<tr>
					<td><span><img src="/static/img/loginCheck/${codeImgName}" data-name="${codeImgName}"></span></td>
					<td><input type="text" placeholder="请输入验证码" id="codeInput" data-code="${randomCode}"></td>
					<td><span style="color: red;" id="codeSpan" data-flag="false"></span></td>
				</tr>
				<tr>
					<td><input type="button" value="安全登录" id="loginBtn"></td>
					<td><input type="reset" value="重置"></td>
					<td></td>
				</tr>
				<tr>
					<td><a href="/login/register">马上注册</a></td>
					<td><a>忘记密码</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>