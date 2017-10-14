<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>宠物服务</title>
	<%@include file="common.jsp" %>
	<script type="text/javascript" src="/static/js/views/petService.js"></script>
</head>
<body>
<div class="easyui-layout" fit="true">
	<div data-options="region:'west',border:false" style="width:12%;">
		<ul id="petServiceMenuTree"></ul>
	</div>
	<div data-options="region:'center'">
		<table id="petServiceRegister_datagrid"></table>
		<!-- 宠物登记对话框 -->
		<div id="petServiceRegister_dialog">
			<!--根据会员号搜索-->
			<div>
				<input id="memberNo" type="text" class="easyui-textbox" data-options="label:'会员号:', width:250">
			</div>
			<form id="petServiceRegister_form" method="post">
				<div align="center" style="margin-top: 10px;height:250px;" >
					<div id="petServiceRegister_tabs">
						<div title="宠物" style="padding:10px">
							<div>
								<select  name="itemFirst" id="topMenu"></select>
								<select  name="itemSecond" id="secondMenu"></select>
							</div>
							<div><input type="text" name="petName" class="easyui-textbox" data-options="label:'宠物名:', width:250">
								<input type="text" name="tel" class="easyui-textbox" data-options="label:'联系方式:', width:250"></div>
							<div>
								<input type="text" class="easyui-textbox" data-options="label:'预计开始时间:', width:250">
								<input type="text" class="easyui-textbox" data-options="label:'预计结束时间:', width:250">
							</div>
							<div><input type="text" name="petAge" class="easyui-textbox" data-options="label:'宠物年龄:', width:250"></div>
							<div>
								<input type="text" class="easyui-textbox" data-options="label:'上次驱虫时间:', width:250">
								<input type="text" class="easyui-textbox" data-options="label:'上次疫苗时间:', width:250">
							</div>
							<div>
								<input type="radio" name="petGender" value="0">弟弟</input>
								<input type="radio" name="petGender" value="1">妹妹</input>
								<input type="radio" name="petGender" value="2">不详</input>
								<input type="text" value="0" class="easyui-textbox" data-options="label:'预付款:', width:250">
							</div>
							<div>
								<input type="text" name="selfGood" class="easyui-textbox" data-options="multiline:true,label:'自带物品:', height:40,width:250">
								<input type="text" name="remark" class="easyui-textbox" data-options="multiline:true,label:'特殊备注:', height:40,width:250">
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<!-- 添加宠物服务菜单对话框 -->
		<div id="petServiceMenu_dialog">
			<form id="petServiceMenu_form" method="post">
				<div align="center" style="margin-top: 30px;" >
					<div><input type="text" name="text" class="easyui-textbox" data-options="label:'服务名称:', width:250"></div>
					<div>
						<select  name="parent.id" class="easyui-combobox"
								 data-options="
						 width:250,
						 label:'所属项目:',
						 valueField:'id',
						 textField:'text',
						 url:'/petServiceMenu/queryTopTree'
						">
						</select>
					</div>
					<div>
						<input type="text" name="minPrice" value="0" class="easyui-textbox" data-options="label:'价格(元)最低:', width:125">
						<input type="text" name="maxPrice" value="0" class="easyui-textbox" data-options="label:'最高:', width:125">
					</div>
					<div><input type="text" name="unit" value="1" class="easyui-textbox" data-options="label:'单位(次/天):', width:250"></div>
					<div><input type="text" name="remark" class="easyui-textbox" data-options="multiline:true,label:'备注:', height:70,width:250"></div>
					<div style="width: 250px;">是否享受折扣:
						<input type="radio" name="adminFlag" value="0">否</input>
						<input type="radio" name="adminFlag" value="1">是</input>
					</div>
					<div><input type="text" name="discount" class="easyui-textbox" data-options="label:'服务指定折扣:', width:250">%</div>
				</div>
			</form>
		</div>
		<!-- 定义顶部按钮 -->
		<div id="petServiceRegister_datagrid_tb">
			<div>
				<input id="nameSearchBtn" type="text">&nbsp;&nbsp;
				<input id="telSearchBtn" type="text">
			</div>
			<div>
				<a class="easyui-linkbutton" iconCls="" plain="" data-cmd="addService">添加项目</a>
				<a class="easyui-linkbutton" iconCls="" plain="" data-cmd="addPet">宠物登记</a>
				<a class="easyui-linkbutton" iconCls="" plain="" data-cmd="beginService">开始宠物服务</a>
				<a class="easyui-linkbutton" iconCls="" plain="" data-cmd="endService">结束宠物服务</a>
				<a class="easyui-linkbutton" iconCls="" plain="" data-cmd="payfor">付款</a>
			</div>
		</div>
		<!-- 对话框底部按钮 -->
		<div id="petServiceRegister_dialog_bt">
			<a class="easyui-linkbutton" iconCls="" plain="" data-cmd="saveRegister">保存</a>
			<a class="easyui-linkbutton" iconCls="" plain="" data-cmd="cancelRegister">取消</a>
		</div>
		<div id="petServiceMenu_dialog_bt">
			<a class="easyui-linkbutton" iconCls="" plain="" data-cmd="saveMenu">保存</a>
			<a class="easyui-linkbutton" iconCls="" plain="" data-cmd="cancelMenu">取消</a>
		</div>
	</div>
</div>
</body>
</html>