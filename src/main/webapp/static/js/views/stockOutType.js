$(function(){
	$("#table_datagrid").datagrid({
		url:"/stockOutType/query",
		rownumbers:true,
		pagination:true,
		singleSelect:true,
		fit:true,
		fitColumns:true,
	    columns:[[       
	              {field:'name',title:'出入库方式',width:100,align:'center'},    
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
		title:"添加出入库方式",
		width:170,
		height:180,
		closed:true,
		buttons:"#div_dialog_tb"
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
});

function myAdd(){
	/*点击添加的时候,给表格添加1行,并全部设置为空,地点信息从stockOutType查询出来*/
	$("#div_dialog_post").form("clear");
	$("#div_dialog").dialog("open");
}
function mySearch(){
	/*获取输入框的文本信息,作为关键字去后台查询*/
	var keyword=$(this).val();
	$("#table_datagrid").datagrid("load",{
		keyword:keyword
	});
}
function mySave(){
	//提交表单,进行数据保存
	$("#div_dialog_post").form("submit",{
		url:"/stockOutType/save",
		success:function(myData){
			var data=$.parseJSON(myData);
			$("#div_dialog").dialog("close");
			if(data.success){
				$("#table_datagrid").datagrid("reload");
			}
			$.messager.alert("温馨提示",data.msg,"info");
		}
	});
}
function myCancel(){
	//关闭对话框
	$("#div_dialog").dialog("close");
}
function myDelete(){
	/*
	 * 先判断是否已经选择,未选择,提示需要先选择一条
	 * 如果已经,则进行在此确认提醒,然后把状态进行更改
	 */
	var mySelected=$("#table_datagrid").datagrid("getSelected");
	if(mySelected){
		$.messager.confirm("温馨提示","确定要修改这条数据的状态吗?",function(flag){
			if(flag){
				$.get("/stockOutType/delete?id="+mySelected.id,function(data){
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