$(function(){
	$("#table_datagrid").datagrid({
		url:"/productInfo/query",
		rownumbers:true,
		pagination:true,
		singleSelect:true,
		fit:true,
		fitColumns:true,
	    columns:[[    
	              {field:'code',title:'商品编码',width:100,align:'center'},    
	              {field:'name',title:'商品名称',width:100,align:'center'},    
	              {field:'productType',title:'商品类别',width:100,align:'center',formatter:function(value,row,index){
	            	  return value?value.name:"";
	              }},    
	              {field:'brandName',title:'商品品牌',width:100,align:'center',formatter:function(value,row,index){
	            	  if(row){
	            		  return row.brand?row.brand.name:"";
	            	  }else{
	            		  return "";
	            	  }
	              }},        
	              {field:'brandLocation',title:'商品场地',width:100,align:'center',formatter:function(value,row,index){
	            	  if(row){
	            		  if(row.brand){
	            			  return row.brand.location?row.brand.location.name:"";
	            		  }
	            	  }else{
	            		  return "";
	            	  }
	              }},        
	              {field:'productPart',title:'商品成分',width:100,align:'center',formatter:function(value,row,index){
	            	  return value?value.name:"";
	              }},    
	              {field:'harm',title:'过敏原',width:100,align:'center',formatter:function(value,row,index){
	            	  return value?value.name:"";
	              }},    
	              {field:'price',title:'售价',width:100,align:'center'},    
	              {field:'state',title:'是否启用',width:100,align:'center',formatter:function(value,row,index){
	            	  if(value){
	            		  return "是";
	            	  }else{
	            		  return "<span style='color:red'>否</span>";
	            	  }
	              }},   
	              {field:'img',title:'图片',width:100,align:'center',formatter:function(value,row,index){
	            	  return "<img src="+value+"/>";
	              }}   
	          ]] ,
	    toolbar:"#table_datagrid_tb"
	});
	$("#div_dialog").dialog({
		title:"添加品牌",
		width:800,
		height:400,
		closed:true,
		buttons:"#div_dialog_tb"
	});
	$("#input_combobox_product_type").combobox({
		/*查询全部商品类型信息*/
		url:"/productType/list",
		valueField:"id",
		textField:"name",
		editable:false,
		multiple:false,
		prompt:"请选择商品类型信息",
		label:"商品类型",
		labelPosion:"left"
	});
	$("#input_combobox_brand").combobox({
		/*查询全部商品品牌信息*/
		url:"/brand/list",
		valueField:"id",
		textField:"name",
		editable:false,
		multiple:false,
		prompt:"请选择商品品牌信息",
		label:"商品品牌",
		labelPosion:"left"
	});
	$("#input_combobox_product_part").combobox({
		/*查询全部商品主要成分信息*/
		url:"/productPart/list",
		valueField:"id",
		textField:"name",
		editable:false,
		multiple:false,
		prompt:"请选择商品成分信息",
		label:"商品成分",
		labelPosion:"left"
	});
	$("#input_combobox_harm").combobox({
		/*查询全部商品主要成分信息*/
		url:"/harm/list",
		valueField:"id",
		textField:"name",
		editable:false,
		multiple:false,
		prompt:"请选择商品过敏物信息",
		label:"过敏物",
		labelPosion:"left"
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
		prompt:"请选择是否启用",
		label:"是否启用",
		labelPosion:"left"
	});
	$("#div_dialog_post").form({
		
	});
});

function myAdd(){
	/*点击添加的时候,给表格添加1行,并全部设置为空,地点信息从location查询出来*/
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
		url:"/productInfo/save",
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
				$.get("/productInfo/delete?id="+mySelected.id,function(data){
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