<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <jsp:include page="common.jsp"></jsp:include>
    <script type="text/javascript" src="/static/js/views/petInfo.js"></script>
</head>
<body>
    <div id="memberInfo_datagrid"></div>

<%--顶部按钮和高级查询--%>
    <div id="SDUS_BTN">
        <form id="searchBtn" method="post">
            <input class="easyui-combobox"id="petTypeBtns" name="petTypeBtn"
                   data-options=" 'prompt':'请输入关键字','width':'100px','label':'宠物类别:','labelWidth':'50px',">

            <input class="easyui-combobox" id="petKindBtns" name="petKindBtn"
                   data-options=" 'prompt':'请输入关键字','width':'120px','label':'宠物品种:','labelWidth':'50px',">

            <input  class="easyui-textbox" name="petNameBtn"
                   data-options=" 'prompt':'请输入关键字','width':'200px','label':'宠物名称:','labelWidth':'50px',">

            <input class="easyui-textbox" name="memberTelBtn"
                   data-options="'prompt':'请输入关键字','width':'200px','label':'手机号码:','labelWidth':'50px',">

            <input class="easyui-textbox" name="memRemarkBtn"
                   data-options="'prompt':'请输入关键字','width':'200px','label':'备注:','labelWidth':'50px',">
            <a class="easyui-linkbutton"  data-cmd="query">查询</a>
        </form>
        <div>
            <a class="easyui-linkbutton" iconCls="icon-add"  data-cmd="addMoney">充值</a>
            <a class="easyui-linkbutton" id="editBtn" iconCls="icon-edit"  data-cmd="addMember">增加会员</a>
            <a class="easyui-linkbutton" id="deleBtn" iconCls="icon-remove"  data-cmd="addPet">增加宠物</a>
            <a class="easyui-linkbutton" iconCls="icon-reload"  data-cmd="refrech">退卡</a>
            <a class="easyui-linkbutton" iconCls="icon-reload"  >导入会员</a>
        </div>
    </div>
    <%--增加会员--%>
    <div id="petInfo_addMember_dialog">

        <form method="post" id="petInfo_addMember_form">

            <input type="hidden" name="id">


            <div align="left" style="margin-top: 10px">

                <div>
                    主人信息:
                </div>
                <div>
                    <input class="easyui-textbox" name="tel" data-options="label:'手机号码:'">
                    <input class="easyui-textbox" name="name" data-options="label:'会员姓名:'">
                    <input class="easyui-textbox" name="balance" data-options="label:'首冲金额:'">
                    <input class="easyui-combobox" name="dept.id" data-options="
                valueField:'id',
                textField:'name',
                <%--url:'/deparment/queryDeparmentList',--%>
                label:'会员等级:'

                ">
                    商品折扣:100% 服务折扣:100%
                </div>

                <div>
                    性别:
                    <label><input name="Fruit" type="radio" value="" />男 </label>
                    <label><input name="Fruit" type="radio" value="" />女 </label>
                    <label><input name="Fruit" type="radio" value="" />不祥 </label>
                    <input class="easyui-textbox" name="tel" data-options="label:'生日:'">
                    <input class="easyui-textbox" name="tel" data-options="label:'住址:'">
                </div>
                <div>
                    <input class="easyui-textbox" name="email" data-options="label:'备注:'">
                </div>
                <div>
                    宠物信息:
                </div>
                <div>
                    <input class="easyui-textbox" name="email" data-options="label:'宠物生日:'">
                    宠物性别:
                    <label><input name="Fruit" type="radio" value="" />公 </label>
                    <label><input name="Fruit" type="radio" value="" />母 </label>
                    <label><input name="Fruit" type="radio" value="" />阉割版 </label>
                    <input class="easyui-textbox" name="email" data-options="label:'特征:'">
                </div>
                <div>

                    <input class="easyui-combobox" name="dept.id" data-options="
                valueField:'id',
                textField:'name',
                <%--url:'/deparment/queryDeparmentList',--%>
                label:'宠物类别:'

                ">
                    <input class="easyui-combobox" name="dept.id" data-options="
                valueField:'id',
                textField:'name',
                <%--url:'/deparment/queryDeparmentList',--%>
                label:'宠物品种:'

                ">
                    <input class="easyui-combobox" name="dept.id" data-options="
                valueField:'id',
                textField:'name',
                <%--url:'/deparment/queryDeparmentList',--%>
                label:'过敏物:'

                ">

                    <input class="easyui-textbox" name="email" data-options="label:'颜色:'">
                </div>
                <div>
                    <input class="easyui-textbox" name="email" data-options="label:'血统登记号:'">
                    <input class="easyui-textbox" name="email" data-options="label:'血统登记处:'">
                    宠物状态:
                    <label><input name="Fruit" type="radio" value="" />正常 </label>
                    <label><input name="Fruit" type="radio" value="" />生病 </label>
                    <label><input name="Fruit" type="radio" value="" />已逝 </label>
                    <label><input name="Fruit" type="radio" value="" />配种 </label>
                    <label><input name="Fruit" type="radio" value="" />绝育 </label>
                </div>
            </div>
        </form>
    </div>
    <%--增加宠物--%>
    <div id="petInfo_addPet_dialog">

        <form method="post" id="petInfo_addPet_form">

            <input type="hidden" name="id">


            <div align="center" style="margin-top: 10px">
                <div>
                    <input class="easyui-textbox" name="username" data-options="label:'用户名',labelPosition:'top'">
                </div>
                <div>
                    <input class="easyui-textbox" name="realname" data-options="label:'真实姓名',labelPosition:'top'">
                </div>
                <div>
                    <input class="easyui-textbox" name="tel" data-options="label:'电话',labelPosition:'top'">
                </div>
                <div>
                    <input class="easyui-textbox" name="email" data-options="label:'邮件',labelPosition:'top'">
                </div>
                <div>
                    <input class="easyui-combobox" name="dept.id" data-options="
                valueField:'id',
                textField:'name',
                <%--url:'/deparment/queryDeparmentList',--%>
                label:'所属部门:',
                labelPosition:'top'
                ">
                </div>

            </div>
        </form>
    </div>

    <%--充值--%>
    <div id="petInfo_addMoney_dialog">

        <form method="post" id="petInfo_addMoney_form">

            <input type="hidden" name="id">


            <div align="center" style="margin-top: 10px">
                <div>
                    <input class="easyui-textbox" name="username" data-options="label:'用户名',labelPosition:'top'">
                </div>
                <div>
                    <input class="easyui-textbox" name="realname" data-options="label:'真实姓名',labelPosition:'top'">
                </div>
                <div>
                    <input class="easyui-textbox" name="tel" data-options="label:'电话',labelPosition:'top'">
                </div>
                <div>
                    <input class="easyui-textbox" name="email" data-options="label:'邮件',labelPosition:'top'">
                </div>
                <div>
                    <input class="easyui-combobox" name="dept.id" data-options="
                valueField:'id',
                textField:'name',
                <%--url:'/deparment/queryDeparmentList',--%>
                label:'所属部门:',
                labelPosition:'top'
                ">
                </div>

            </div>
        </form>
    </div>

    <%--保存和取消按钮--%>
    <div id="pet_info_dialog_bt">
        <a class="easyui-linkbutton" iconCls="icon-save" data-cmd="save">保存</a>
        <a class="easyui-linkbutton" iconCls="icon-cancel" data-cmd="cencal">取消</a>
    </div>
    <div id="petinfo_addMember_dialog_bt">
        <a class="easyui-linkbutton" iconCls="icon-save" data-cmd="save">保存</a>
        <a class="easyui-linkbutton" iconCls="icon-cancel" data-cmd="cencal">取消</a>
    </div>
    <div id="petinfo_addMoney_dialog_bt">
        <a class="easyui-linkbutton" iconCls="icon-save" data-cmd="save">保存</a>
        <a class="easyui-linkbutton" iconCls="icon-cancel" data-cmd="cencal">取消</a>
    </div>
</body>
</html>
