$(function(){
	$("#div_dialog").dialog({
		title:"修改信息",
		width:400,
		height:210,
		closed:true,
		buttons:"#div_dialog_tb"
	});
	$("#div_dialog_post").form({
		
	});
	$("#span").click(function(){
		/*
		 * 把数据填充到表达数据,并且打开对话框
		 */
		$.get("/shopInfo/queryForEdit",function(data){
			data["employee.id"]=data.employee.id;
			data["employee.name"]=data.employee.name;
			data["employee.tel"]=data.employee.tel;
			/**
			 * 给表达填充数据
			 */
			$("#div_dialog_post").form("load",data);
			$("#div_dialog").dialog("open");
		},"json");
		/*
		 * 数据格式进行变更,是的form表达可以加载
		 */
	});
});

function mySave(){
	//提交表单,进行数据保存
	$("#div_dialog_post").form("submit",{
		url:"/shopInfo/update",
		success:function(myData){
			var data=$.parseJSON(myData);
			$("#div_dialog").dialog("close");
			if(data.success){
				//重新加载页面
				$.messager.alert("温馨提示",data.msg,"info");
				window.location.href="/shopInfo";
			}
		}
	});
}
function myCancel(){
	//关闭对话框
	$("#div_dialog").dialog("close");
}
