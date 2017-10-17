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
        <select class="easyui-combobox" id="petKindBtns" name="petTypeBtn"
                data-options="
                   width:150,
                     valueField:'id',
                    textField:'name',
                     url:'/petInfo/addPetTypeList',
                    label:'宠物类别:'
                   "></select>

        <select class="easyui-combobox" id="petTypeBtns" name="petKindBtn"
                data-options="
                   width:150,
                    valueField:'id',
                    textField:'name',
                    label:'宠物品种:'
                    "></select>

        <input class="easyui-textbox" name="petNameBtn"
               data-options=" 'prompt':'请输入关键字','width':'200','label':'宠物名称:','labelWidth':'50',">

        <input class="easyui-textbox" name="memberTelBtn"
               data-options="'prompt':'请输入关键字','width':'200','label':'手机号码:','labelWidth':'50',">

        <input class="easyui-textbox" name="memRemarkBtn"
               data-options="'prompt':'请输入关键字','width':'200','label':'备注:','labelWidth':'50',">

        <a class="easyui-linkbutton" data-cmd="query">查询</a>
    </form>
    <div>
        <a class="easyui-linkbutton" iconCls="icon-add" data-cmd="addMoney">充值</a>
        <a class="easyui-linkbutton" iconCls="icon-edit" data-cmd="addMember">增加会员</a>
        <a class="easyui-linkbutton" id="deleBtn" iconCls="icon-remove" data-cmd="addPet">增加宠物</a>
        <a class="easyui-linkbutton" id="editBtn" iconCls="icon-reload" data-cmd="refrech">退卡</a>
        <a class="easyui-linkbutton" iconCls="icon-reload">导入会员</a>


        <a class="easyui-linkbutton" href="/memberTop" id="topBtn" iconCls="icon-reload"
           style="float:right;margin-right: 60px">充值记录</a>
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
                <select class="easyui-combobox" id="vipClassMember" name="vipClass.id" data-options="
                    width:150,
                valueField:'id',
                textField:'level',
                url:'/memberLevel/queryAll',
                label:'会员等级:'

                "></select>
                服务折扣:<span id="servicememberID" name="serviceDiscounts"></span>
                商品折扣:<span id="productmemberID" name="productDiscounts"></span>
            </div>

            <div>
                性别:
                <label><input name="gender" type="radio" value="1"/>男 </label>
                <label><input name="gender" type="radio" value="0"/>女 </label>
                <label><input name="gender" type="radio" value="-1"/>不祥 </label>
                <input class="easyui-datebox" name="birthday" data-options="label:'生日:'">
                <input class="easyui-textbox" name="adress" data-options="label:'住址:'">
            </div>
            <div>
                宠物信息:
            </div>
            <div>

                <input class="easyui-textbox" name="petName" data-options="label:'宠物名:'">
                <input class="easyui-datebox" name="petBirthday" data-options="label:'宠物生日:'">
                宠物性别:
                <label><input name="petGender" type="radio" value="1"/>公 </label>
                <label><input name="petGender" type="radio" value="0"/>母 </label>
                <label><input name="petGender" type="radio" value="-1"/>阉割版 </label>
                <input class="easyui-textbox" name="petFeature" data-options="label:'特征:'">
            </div>
            <div>

                <select class="easyui-combobox" id="petTyoeList" name="petType.id" data-options="
                width:150,
                valueField:'id',
                textField:'name',
                url:'/petInfo/addPetTypeList',
                label:'宠物类别:'

                "></select>
                <select class="easyui-combobox" id="petKindList" name="petKind.id" data-options="
               width:150,
                valueField:'id',
                textField:'name',
                label:'宠物品种:'

                "></select>
                <select class="easyui-combobox" name="petAllergyThing.id" data-options="
                width:150,
                valueField:'id',
                textField:'name',
                url:'/petInfo/addHarmList',
                label:'过敏物:'

                "></select>

                <input class="easyui-textbox" name="petColour" data-options="label:'颜色:'">
            </div>
            <div>
                <input class="easyui-textbox" name="petAncestryMark" data-options="label:'血统登记号:'">
                <input class="easyui-textbox" name="petAncestryRegister" data-options="label:'血统登记处:'">
                宠物状态:
                <label><input name="petState" type="radio" value=""/>正常 </label>
                <label><input name="petState" type="radio" value=""/>生病 </label>
                <label><input name="petState" type="radio" value=""/>已逝 </label>
                <label><input name="petState" type="radio" value=""/>配种 </label>
                <label><input name="petState" type="radio" value=""/>绝育 </label>
            </div>
        </div>
    </form>
</div>
<div id="petinfo_addMember_dialog_bt">
    <a class="easyui-linkbutton" iconCls="icon-save" data-cmd="save">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-cancel" data-cmd="cencalMember">取消</a>
</div>
<%--增加宠物--%>
<div id="petInfo_addPet_dialog">

    <form method="post" id="petInfo_addPet_form">

        <input type="hidden" id="petMemberid" name="member.id">


        <div align="left" style="margin-top: 10px">
            <div>
                <input class="easyui-textbox" id="memberSn" name="member.tel" data-options="label:'会员编号'">
                <input class="easyui-textbox" name="petName" data-options="label:'宠物名'">
            </div>
            <div>
                <input class="easyui-datebox" name="petBirthday" data-options="label:'宠物生日'"/>
                宠物性别:
                <label><input name="petGender" type="radio" value="1"/>公</label>
                <label><input name="petGender" type="radio" value="0"/>母</label>
                <label><input name="petGender" type="radio" value="-1"/>不详</label>
            </div>
            <div>
                <select class="easyui-combobox" id="petTyoeLists" name="petType.id" data-options="
                width:150,
                valueField:'id',
                textField:'name',
                url:'/petInfo/addPetTypeList',
                label:'宠物类别:'
                "></select>
                <select class="easyui-combobox" id="petKindLists" name="petKind.id" data-options="
               width:150,
                valueField:'id',
                textField:'name',
                label:'宠物品种:'
                "></select>
            </div>
            <div>
                <select class="easyui-combobox" name="petAllergyThing.id" data-options="
                width:150,
                valueField:'id',
                textField:'name',
                url:'/petInfo/addHarmList',
                label:'过敏物:'

                "></select>
                <input class="easyui-textbox" name="petColour" data-options="label:'颜色'">
            </div>
            <div>
                <input class="easyui-textbox" name="petAncestryMark" data-options="label:'血统登记号'">
                <input class="easyui-textbox" name="petAncestryRegister" data-options="label:'血统登记处'">

            </div>
            <div>
                宠物状态:
                <label><input name="petState" type="radio" value="正常"/>正常</label>
                <label><input name="petState" type="radio" value="生病"/>生病</label>
                <label><input name="petState" type="radio" value="jj思密达"/>已逝</label>
                <label><input name="petState" type="radio" value="交流"/>配种</label>
                <label><input name="petState" type="radio" value="太监"/>绝育</label>

                <input class="easyui-textbox" name="petFeature" data-options="label:'特征'">
            </div>

        </div>
    </form>
</div>
<%--保存和取消按钮--%>
<div id="petInfo_pet_bt">
    <a class="easyui-linkbutton" iconCls="icon-save" data-cmd="save">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-cancel" data-cmd="cencalPet">取消</a>
</div>
<%--充值--%>
<div id="petInfo_addMoney_dialog">

    <form method="post" id="petInfo_addMoney_form">

        <input type="hidden" name="balance">
        <input type="hidden" name="topnumber">

        <div align="left" style="margin-top: 10px">
            <div>
                充值单编号: <span id="topUpNumber" name="topnumber"></span>
            </div>
            <div>
                <input class="easyui-textbox" id="moneySn" name="number" data-options="label:'会员卡号'">

                卡内余额:
                <spen name="balances" id="moneyDalance" style="color: red"></spen>
                <%--历史消费总额:xxx元--%>
            </div>
            <div>
                <input class="easyui-textbox" name="topbalance" data-options="label:'充值金额'">
            </div>
            <div>
                <select class="easyui-combobox" id="vipClasses" name="vipClass.id" data-options="

                width:150,
                valueField:'id',
                textField:'level',
                url:'/memberLevel/queryAll',
                label:'会员等级:'

                "></select>
                <%--<select class="easyui-combobox" id="vipClasses" name="vipClass" ></select>--%>
                商品折扣:<span id="serviceDiscountID" name="serviceDiscounts"></span>
                服务折扣:<span id="productDiscountID" name="productDiscounts"></span>
            </div>
            <div>
                <input class="easyui-textbox" name="topremark"
                       data-options="multiline:true,label:'备注:', height:70,width:250"/>

            </div>
        </div>
    </form>
</div>


<%--充值按钮--%>
<div id="petinfo_addMoney_dialog_bt">
    <a class="easyui-linkbutton" iconCls="icon-save" data-cmd="saveMoney">充值</a>
    <a class="easyui-linkbutton" iconCls="icon-cancel" data-cmd="cencalMoney">取消</a>
</div>
<%--退卡--%>
<div id="member_addremark_dialog">

    <form method="post" id="petInfo_addremark_form">
        <input type="hidden" id="memberID"  name="memberID">
        <div align="left" style="margin-top: 10px">
            <div>
                该会员共消费: <span id="consumeID" name="consume" style="color: red"></span>元,
                共享受折扣: <span id="discountID" name="discount"></span>元,
                卡内余额: <span id="memberBal" name="memberBalance" style="color: red"></span>元,
                请该对后退卡
            </div>
        </div>
    </form>
    <table id="member_addremark_datagrid"></table>
</div>
<%--退卡按钮--%>
<div id="petinfo_addremark_dialog_bt">
    <a class="easyui-linkbutton" iconCls="icon-save" data-cmd="saveremark">确认退卡</a>
    <a class="easyui-linkbutton" iconCls="icon-cancel" data-cmd="cencalBlock">取消</a>
</div>
</body>
</html>
