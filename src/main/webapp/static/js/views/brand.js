$(function(){
	$("#table_datagrid").datagrid({
		url:"/brand/query",
		rownumbers:true,
		pagination:true,
		singleSelect:true,
		fit:true,
		fitColumns:true,
	    columns:[[    
	              {field:'location',title:'品牌产地信息',width:100,align:'center',formatter:function(value,row,index){
	            	  return value.name;
	              }},    
	              {field:'name',title:'品牌信息',width:100,align:'center'},    
	              {field:'state',title:'是否启用',width:100,align:'center',formatter:function(value,row,index){
	            	  if(value){
	            		  return "是";
	            	  }else{
	            		  return "<span style='color:red'>否</span>";
	            	  }
	              }}    
	          ]] ,
	    toolbar:"#table_datagrid_tb"
	});
	$("#div_dialog").dialog({
		title:"添加品牌",
		width:170,
		height:180,
		closed:true,
		buttons:"#div_dialog_tb"
	});
	$("#input_combobox").combobox({
		/*查询全部地址信息*/
		url:"/location/list",
		valueField:"id",
		textField:"name",
		editable:false,
		multiple:false,
		prompt:"请选择地址信息"
	});
	$("#input_combobox_state").combobox({
		valueField:"id",
		textField:"text",
		data:[
		      {
		    	id:0,
		    	text:"否"
		      },{
		    	  id:1,
		    	  text:"是" 
		      }
		      ],
		editable:false,
		multiple:false,
		prompt:"请选择是否启用"
	});
	$("#div_dialog_post").form({
		
	});
	var objBrand={
	myAdd:function (){
		/*点击添加的时候,给表格添加1行,并全部设置为空,地点信息从location查询出来*/
		$("#div_dialog_post").form("clear");
		$("#div_dialog").dialog("open");
	},
	mySearch:function (){
		/*获取输入框的文本信息,作为关键字去后台查询*/
		var keyword=$(this).val();
		$("#table_datagrid").datagrid("load",{
			keyword:keyword
		});
	},
	mySave:function (){
		//提交表单,进行数据保存
		$("#div_dialog_post").form("submit",{
			url:"/brand/save",
			success:function(myData){
				var data=$.parseJSON(myData);
				$("#div_dialog").dialog("close");
				if(data.success){
					$("#table_datagrid").datagrid("reload");
				}
				$.messager.alert("温馨提示",data.msg,"info");
			}
		});
	},
	myCancel:function (){
		//关闭对话框
		$("#div_dialog").dialog("close");
	},
	myDelete:function (){
		
		 /** 先判断是否已经选择,未选择,提示需要先选择一条
		 * 如果已经,则进行在此确认提醒,然后把状态进行更改*/
		 
		var mySelected=$("#table_datagrid").datagrid("getSelected");
		if(mySelected){
			$.messager.confirm("温馨提示","确定要修改这条数据的状态吗?",function(flag){
				if(flag){
					$.get("/brand/delete?id="+mySelected.id,function(data){
						if(data.success){
							//刷新表格
							$("#table_datagrid").datagrid("reload");
						}
						$.messager.alert("温馨提示",data.msg,"info");
					},"json");
				}
			});
		}else{
			$.messager.alert("温馨提示","请先选择一条需要操作的数据!","info");
		}
	}
};
	$(".brand").click(function(){
		var myCmd=$(this).data("cmd");
		console.log(myCmd);
		objBrand[myCmd]();
	});
});
function mySearch (){
	/*获取输入框的文本信息,作为关键字去后台查询*/
	var keyword=$(this).val();
	$("#table_datagrid").datagrid("load",{
		keyword:keyword
	});
}
