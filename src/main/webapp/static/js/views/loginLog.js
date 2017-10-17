$(function(){
	$("#table_datagrid").datagrid({
		url:"/loginLog/query",
		rownumbers:true,
		pagination:true,
		singleSelect:true,
		fit:true,
		fitColumns:true,
	    columns:[[    
	              {field:'employee',title:'登录用户',width:100,align:'center',formatter:function(value,row,index){
	            	  return value?value.name:"";
	              }},    
	              {field:'ip',title:'登录IP',width:100,align:'center'},    
	              {field:'mac',title:'登录MAC',width:100,align:'center'},    
	              {field:'loginTime',title:'登录时间',width:100,align:'center'},    
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
	$("#div_dialog_post").form({
		
	});
});

function mySearch(){
	/*获取输入框的文本信息,作为关键字去后台查询*/
	var keyword=$(this).val();
	$("#table_datagrid").datagrid("load",{
		keyword:keyword
	});
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
				$.get("/loginLog/delete?id="+mySelected.id,function(data){
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