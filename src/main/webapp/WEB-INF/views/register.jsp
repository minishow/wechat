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
<!-- 引入数据校验的js库 --> 
<script type="text/javascript" src="/static/js/validate/jquery.validate.min.js"></script>  
<script type="text/javascript" src="/static/js/validate/messages_cn.js"></script>  
<script type="text/javascript">
	$(function(){
		 $("#form").form({
			
		}); 
		/* $("#passwordCheck").blur(function(){
			//失去焦点之后,进行校验
			var passwordVal=$("#password").val();
			var passwordCheckVal=$(this).val();
			if(passwordVal!=passwordCheckVal){
				$("#span").text("两次密码不一致!");
			}
		 }); */
		 /* 给按钮绑定点击事件 */
		 $("#submit_btn").click(function(){
			 /* 进行表单验证操作 */
			var myFlag=$("#form").valid();
			 /* 校验合格之后进行异步表单提交 */
			if(myFlag){
				$("#form").form("submit",{
					url:"/login/loginRegister",
					success:function(myData){
						var data=$.parseJSON(myData);
						$.messager.alert("温馨提示",data.msg,"info",function(){
							// 如果成功,跳转回登录页面 
							if(data.success){
								window.location.href="/login";
							}
						});
					}
				});
			}
		});  
		$("#form").validate({
			rules:{
				tel:{
					required:true,
					digits:true,
					minlength:11,
					maxlength:11
				},
				email:{
				required:true,
				email:true
			},
			checkCode:{
				required:true,
				equalTo:"#hiddenCode"
			},
			password:{
				required:true,
				minlength:6
			},
			passwordCheck:{
				required:true,
				minlength:6,
				equalTo:"#password"
			},
			name:{
				required:true
			}
			},
			messages:{
				tel:{
					required:"请输入手机号码",
					digits:"请输入数字",
					minlength:"请输入11位",
					maxlength:"请输入11位"
				},
				email:{
					required:"请输入邮箱地址",
					email:"请输入正确的邮箱格式"
				},
				checkCode:{
					required:"请输入验证码",
					equalTo:"验证码不正确"
				},
				password:{
					required:"请输入密码",
					minlength:"请输入大于等于6位"
				},
				passwordCheck:{
					required:"请输入确认密码",
					minlength:"请输入大于等于6位",
					equalTo:"两次密码不一致"
				},
				name:{
					required:"请输入用户名"
				}
			}
		});
		/* 点击获取验证码按钮进行请求,后台发送邮件到指定的邮箱,并返回指定的验证码 */
		$("#btnCheckBox").click(function(){
			/* 单独验证邮箱 */
			var myFlag=$("#form").validate().element($("#email"));
			if(!myFlag){
				/* 如果验证不通过则直接结束 */
				return;
			}
			/* 通过验证之后,获取邮箱的地址,并且把此参数发送到后台 */
			var myEmail=$("#email").val();
			$.get("/login/sendCodeByEmail?email="+myEmail,function(data){
				/* 把后台获取到数据显示在后面 */
				if(data.success){
					var arrayStr=data.msg.split("=");
					$("#spanMsg").text(arrayStr[0]);
					$("#hiddenCode").val(arrayStr[1]);
				}
			},"json");
		});
		/* 邮箱填写完毕之后,如果数据库已经存在,则邮箱已经存在,否则可以注册 */
		$("#email").blur(function(){
			var myFlag=$("#form").validate().element($("#email"));
			if(!myFlag){
				return;
			}
			/* 发送ajax请求去查询是否已经存在此邮箱 */
			var myEmail=$("#email").val();
			$.get("/login/checkEmailToDB?email="+myEmail,function(data){
				if(data.success){
					/* true表示已经注册,false表示可以注册 */
					$("#spanEmail").text(data.msg);
				}
			},"json");
		});
	});
</script>
	<style type="text/css">
		.mysec{
			height:100%;
			width:100%;
			background-image:url("/static/pics/serviceIcons/regist.jpg"); /*图片地址*/
			background-origin: content-box;   /*从content区域开始显示背景*/
			background-position:50% 50%; /*             图片上下左右居中  */
			background-size:contain;       /*           保持图像本身的宽高比例，将图片缩放到宽度或高度正好适应定义背景的区域  */
			background-repeat: repeat;     /*         图像不重复显示  */
		}
	</style>
</head>
<body>
<div class="mysec">
	<div style="position:fixed;bottom:50px;right:300px">
	<form method="post" id="form">
		<div>
			<table style="color: white">
				<tr>
					<td><span>手机号码:</span></td>
					<td><input type="text" name="tel" placeholder="请输入11位手机号码" id="tel"></td>
				</tr>
				<tr>
					<td><span>邮箱地址:</span></td>
					<td><input type="text" name="email" placeholder="请输入正确的邮箱格式" id="email"></td>
					<td><input type="hidden" name="emailBD" id="emailDB" value=""></td>
					<td><span style="color: red;" id="spanEmail"></span></td>
				</tr>
				<tr>
					<td><span>校验码:</span></td>
					<td><input type="text" name="checkCode" placeholder="请输入校验码" id="checkCode"></td>
					<td><input type="button" value="获取邮箱验证码" id="btnCheckBox"></td>
					<td><span style="color: red;" id="spanMsg"></span></td>
					<td><input type="hidden" value="" id="hiddenCode" name="hiddenCode"></td>
				</tr>
				<tr>
					<td><span>用户名:</span></td>
					<td><input type="text" name="name" placeholder="请输入用户名" id="name"></td>
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
			<table style="color: white">
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
			<table style="color: white">
				<tr>
					<td>
						<input type="button" value="提交" id="submit_btn">
					</td>
					<td>
						<input type="reset" value="重置">
					</td>
					<td>
						<span>已经有帐号,前往</span><a href="/login" style="text-decoration: none;color: blue;">登录</a>
					</td>
				</tr>
			</table>
		</div>
	</form>
	</div>
</div>
</body>
</html>