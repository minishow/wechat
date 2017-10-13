$(function(){
	$("#table_datagrid").datagrid({
		url:"/brand/list",
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
	              {field:'state',title:'是否启用',width:100,align:'center'}    
	          ]] 
	});
});