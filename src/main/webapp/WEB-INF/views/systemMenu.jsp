<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统管理</title>
<link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="/static/js/jquery-easyui/themes/icon.css">   
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.min.js"></script>  
<script type="text/javascript" src="/static/js/jquery-easyui/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="/static/js/views/systemMenu.js"></script>
<style type="text/css">
	iframe{
		width:100%;
		height:100%;	
	}
</style>
</head>
<body>
	<div id="div_tabs">
		<div id="productScale" data-options="title:'商品规格'"></div>
		<div id="brand" data-options="title:'商品品牌'"></div>
		<div id="productType" data-options="title:'商品类型'"></div>
		<div id="location" data-options="title:'产地信息'"></div>
		<div id="loginLog" data-options="title:'登录日志'"></div>
		<div id="productPart" data-options="title:'商品成分'"></div>
		<div id="productInfo" data-options="title:'商品信息'"></div>
		<div id="petKind" data-options="title:'宠物种类'"></div>
		<div id="supplier" data-options="title:'供应商管理'"></div>
		<div id="stockOutType" data-options="title:'出入库管理'"></div>
	</div>
</body>
</html>