<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <%@ include file="/WEB-INF/views/common.jsp"%>
    <script type="text/javascript" src="/static/js/views/main.js"></script>
    <script type="text/javascript" src="/static/js/echarts/echarts.min.js"></script>
    <script type="text/javascript">
        $(function () {

            var datas;
            var groupList;
            $("#selectMenu").combobox({
                width:250,
                label:'服务选择:',
                valueField:'id',
                textField:'name',
                value:'1',
                url:'/static/js/data/selectMenu.json',
                onSelect:function (record) {
                    if (record.id == 1) {
                        $.get("/chart/serviceTopChartByPie",function(map){
                            datas = map["datas"];
                            groupList = map["groupList"];

                            // 基于准备好的dom，初始化echarts图表
                            var myChart = echarts.init(document.getElementById('main'));

                            var option = {
                                title : {
                                    text: '宠物服务项目饼图',
                                    subtext: '服务',
                                    x:'center'
                                },
                                tooltip : {
                                    trigger: 'item',
                                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                                },
                                legend: {
                                    orient : 'vertical',
                                    x : 'left',
                                    data:groupList
                                },
                                toolbox: {
                                    show : true,
                                    feature : {
                                        mark : {show: true},
                                        dataView : {show: true, readOnly: false},
                                        magicType : {
                                            show: true,
                                            type: ['pie', 'funnel'],
                                            option: {
                                                funnel: {
                                                    x: '25%',
                                                    width: '50%',
                                                    funnelAlign: 'left',
                                                    max: 999
                                                }
                                            }
                                        },
                                        restore : {show: true},
                                        saveAsImage : {show: true}
                                    }
                                },
                                calculable : true,
                                series : [
                                    {
                                        name:'',
                                        type:'pie',
                                        radius : '55%',
                                        center: ['50%', '60%'],
                                        data:datas
                                    }
                                ]
                            };
                            // 为echarts对象加载数据
                            myChart.setOption(option);

                        },"json");
                    } else if(record.id == 2) {
                        $.get("/chart/serviceChartByPie",function(map){
                            datas = map["datas"];
                            groupList = map["groupList"];

                            // 基于准备好的dom，初始化echarts图表
                            var myChart = echarts.init(document.getElementById('main'));

                            var option = {
                                title : {
                                    text: '服务项目统计',
                                    subtext: '服务',
                                    x:'center'
                                },
                                tooltip : {
                                    trigger: 'item',
                                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                                },
                                legend: {
                                    orient : 'vertical',
                                    x : 'left',
                                    data:groupList
                                },
                                toolbox: {
                                    show : true,
                                    feature : {
                                        mark : {show: true},
                                        dataView : {show: true, readOnly: false},
                                        magicType : {
                                            show: true,
                                            type: ['pie', 'funnel'],
                                            option: {
                                                funnel: {
                                                    x: '25%',
                                                    width: '50%',
                                                    funnelAlign: 'left',
                                                    max: 999
                                                }
                                            }
                                        },
                                        restore : {show: true},
                                        saveAsImage : {show: true}
                                    }
                                },
                                calculable : true,
                                series : [
                                    {
                                        name:'',
                                        type:'pie',
                                        radius : '55%',
                                        center: ['50%', '60%'],
                                        data:datas
                                    }
                                ]
                            };
                            // 为echarts对象加载数据
                            myChart.setOption(option);

                        },"json");
                    }
                }
            });
        })
    </script>
</head>
<body>

    <div><select  name="selectMenu" id="selectMenu"></select></div>

    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div style="height: 100%;width: 100%;margin-top: 30px">
        <div id="main" style="height:550px; width:100%"></div>
    </div>

</body>
</html>
