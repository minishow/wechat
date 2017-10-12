$(function () {
    $("#main_menu").tree({
        url: '/systemMenu/indexMenu',
        onClick: function (node) {
            var mainTabs = $("#main_tabs");
            //判断当前点击的节点是否已经创建对应的面板了?
            if (mainTabs.tabs("exists", node.text)) {
                //选中选项卡
                mainTabs.tabs("select", node.text);
            } else {
                //新增选项卡
                //找到选项卡,往选项卡中添加面板
                mainTabs.tabs("add", {
                    title: node.text,
                    closable: true,
                    //href:node.attributes.url//只能加载远程页面中的body部分的内容
                    content: '<iframe src="' + node.attributes.url + '" style="width:100%;height:100%" frameborder="0"></iframe>'
                });
            }
        }
    });
    //
    $("#main_tabs").tabs({
        fit: true,
        pill: true
    });
});

$(function () {
    var height = document.documentElement.clientHeight - 92 + 'px';
    var frameindex = document.getElementsByClassName("frameindex")
    $(frameindex).css("height", height)
})
$(function () {
    setInterval(GetNews, 10000000000)
})
var Identity = "1";
var TisID = "0";
var Display = "0";
var TisRoleID = "0";
var UdID = "1008";

function GetNews() {
    $.ajax({
        url: "/Home/GetNews",
        type: "post",
        data: {UdID: UdID, TisRoleID: TisRoleID, Display: Display, TisID: TisID},
        success: function (Jdata) {
            if (Jdata > 0) {

            }
        }
    })
}

function Qiehuan() {
    $.ajax({
        url: "/Home/QieHuang",
        type: "post",
        data: {UdID: UdID, TisRoleID: TisRoleID},
        success: function (Jdata) {
            window.location.href = "http://guanli.byiaa.com/Home/Index?PD=" + Jdata.pwd + "&ud=" + Jdata.Uid;
        }
    })
}
