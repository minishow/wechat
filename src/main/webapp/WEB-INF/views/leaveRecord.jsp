<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="common.jsp"></jsp:include>
    <script type="text/javascript" src="/static/js/views/leaveRecord.js"></script>
    <title>请假记录</title>
</head>
<body>
<table id="leaveRecord_datagrid"></table>
<div id="leaveRecord_dialog">
    <form id="leaveRecord_form" method="post">
        <input type="hidden" name="id">
        <div align="center" style="margin-top: 10px;">
            <div>
                <select name="employeeId.id" class="easyui-combobox"
                        data-options="
						 width:150,
						 label:'请假员工:',
						 labelPosition:'top',
						 valueField:'id',
						 textField:'name',
						 url:'/employee/selectListByLeaveRecord'
						">
                </select>
            </div>
            <div>
                <select class="easyui-combobox" name="leavecategory" style="width:150px;" label="请假类别"
                        labelPosition="top">
                    <option value="婚假">婚假</option>
                    <option value="事假">事假</option>
                    <option value="病假">病假</option>
                    <option value="产假">产假</option>
                    <option value="其他">其他</option>
                </select>
            </div>
            <div>
                <input type="text" name="reason" class="easyui-textbox"
                       data-options="label:'请假原因:',labelPosition:'top', width:150,">
            </div>
            <div>
                <input name="begintime" data-options="label:'开始时间:',labelPosition:'top', width:150"
                       type="text" class="easyui-datebox" required="required"> </input>
            </div>
            <div>
                <input  name="finishtime" data-options="label:'结束时间:',labelPosition:'top',width:150"
                       type="text" class="easyui-datebox" required="required"> </input>
            </div>
            <div>
                <input type="text" name="days" class="easyui-textbox"
                       data-options="label:'请假时长:',labelPosition:'top', width:150">
            </div>
            <div>
                是否请假:<label><input  name="normal" type="radio" value="1"/>请假</label>
                       <label><input name="normal" type="radio" value="0"/>旷工</label>
            </div>
            <div>
                <input type="text" name="view" class="easyui-textbox"
                       data-options="label:'领导意见:',labelPosition:'top', width:150,">
            </div>
        </div>
    </form>
</div>
<%--取消框--%>
<div id="cancelreason_datagrid">
    <form id="cancelreason_form" method="post">
        <input type="hidden" name="id">
        <div>
            <input type="text" name="cancelreason" class="easyui-textbox"
                   data-options="labelPosition:'top',editable:'true'">
        </div>
    </form>
</div>
<!-- 定义顶部按钮 -->
<div id="leaveRecord_datagrid_tb">
    <div>
        <a class="easyui-linkbutton" plain="true" data-cmd="add">添加记录</a>
        <a class="easyui-linkbutton" plain="true" data-cmd="edit">编辑</a>
        <a class="easyui-linkbutton" plain="true" data-cmd="deselect">取消请假</a>
        <input id="selectName" type="text">
    </div>
</div>

<div id="leaveRecord_dialog_deselect">
    <a class="easyui-linkbutton" plain="true" data-cmd="ensure">确定</a>
    <a class="easyui-linkbutton" plain="true" data-cmd="cancels">取消</a>
</div>
<div id="leaveRecord_dialog_bt">
    <a class="easyui-linkbutton" plain="true" data-cmd="save">保存</a>
    <a class="easyui-linkbutton" plain="true" data-cmd="cancel">取消</a>
</div>

</body>
</html>
