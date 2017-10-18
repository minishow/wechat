$(function () {
    $("#main_tabs").tabs({
        fit:true
    });
});

function addtab(name,idNo,url) {

    $("#navDiv").each(function (index,item) {
        //把所有元素恢复到最原始的状态
        $(item).find("div").attr("style","backgroundColor :#393939;margin-top: 30px");
    });

    var selectDiv = document.getElementById(idNo);
    selectDiv.style.backgroundColor = "skyblue";
    //判断tabs中是否已经有该面板
    if ($("#main_tabs").tabs("exists",name)) {
        //如果有就选中
        $("#main_tabs").tabs("select",name);
    } else {
        //如果没有就添加
        $("#main_tabs").tabs("add",{
            title:name,
            closable:true,
            content:'<iframe src="'+url+'" style="width:100%;height:100%" frameborder="0"></iframe>'
        });
    }
}