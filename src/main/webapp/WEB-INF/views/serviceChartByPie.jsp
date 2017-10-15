<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript" src="/static/js/echarts/echarts-all.js"></script>
</head>
<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="height:550px; width:100%"></div>
    <!-- ECharts单文件引入 -->
    <script type="text/javascript">
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
                data:<s:property escape="false" value="#groupList"/>
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
                    data:<s:property escape="false" value="#datas"/>
                }
            ]
        };

        // 为echarts对象加载数据
        myChart.setOption(option);
    </script>
</body>
</html>
