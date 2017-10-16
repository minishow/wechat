<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <%@ include file="/WEB-INF/views/common.jsp"%>
    <script type="text/javascript" src="/static/js/views/main.js"></script>
    <script type="text/javascript" src="/static/js/echarts/echarts-all.js"></script>
</head>
<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div style="height: 100%;width: 100%">
        <div id="main" style="height:600px; width:100%"></div>
    </div>
    <!-- ECharts单文件引入 -->
    <script type="text/javascript">

        var datas;
        var groupList;

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

    </script>
</body>
</html>
