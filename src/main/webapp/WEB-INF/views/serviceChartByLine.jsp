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

            var data;
            var axisData;
            $("#selectMenu").combobox({
                width:250,
                label:'服务选择:',
                valueField:'id',
                textField:'name',
                value:'1',
                url:'/static/js/data/selectMenu.json',
                onSelect:function (record) {
                    if (record.id == 1) {
                        $.get("/chart/serviceTopChartByLine",function(map){
                            data = map["datas"];
                            axisData = map["groupList"];
                            // 基于准备好的dom，初始化echarts图表
                            var myChart = echarts.init(document.getElementById('main'));

                            var links = data.map(function (item, i) {
                                return {
                                    source: i,
                                    target: i + 1
                                };
                            });
                            links.pop();
                            option = {
                                title: {
                                    text: '宠物服务项目折线图'
                                },
                                tooltip: {},
                                xAxis: {
                                    type : 'category',
                                    boundaryGap : false,
                                    data : axisData
                                },
                                yAxis: {
                                    type : 'value'
                                },
                                series: [
                                    {
                                        type: 'graph',
                                        layout: 'none',
                                        coordinateSystem: 'cartesian2d',
                                        symbolSize: 40,
                                        label: {
                                            normal: {
                                                show: true
                                            }
                                        },
                                        edgeSymbol: ['circle', 'arrow'],
                                        edgeSymbolSize: [4, 10],
                                        data: data,
                                        links: links,
                                        lineStyle: {
                                            normal: {
                                                color: '#2f4554'
                                            }
                                        }
                                    }
                                ]
                            };
                            // 为echarts对象加载数据
                            myChart.setOption(option);

                        },"json");
                    } else if(record.id == 2) {
                        $.get("/chart/serviceChartByLine",function(map){
                            data = map["datas"];
                            axisData = map["groupList"];

                            // 基于准备好的dom，初始化echarts图表
                            var myChart = echarts.init(document.getElementById('main'));

                            var links = data.map(function (item, i) {
                                return {
                                    source: i,
                                    target: i + 1
                                };
                            });
                            links.pop();
                            option = {
                                title: {
                                    text: '笛卡尔坐标系上的 Graph'
                                },
                                tooltip: {},
                                xAxis: {
                                    type : 'category',
                                    boundaryGap : false,
                                    data : axisData
                                },
                                yAxis: {
                                    type : 'value'
                                },
                                series: [
                                    {
                                        type: 'graph',
                                        layout: 'none',
                                        coordinateSystem: 'cartesian2d',
                                        symbolSize: 40,
                                        label: {
                                            normal: {
                                                show: true
                                            }
                                        },
                                        edgeSymbol: ['circle', 'arrow'],
                                        edgeSymbolSize: [4, 10],
                                        data: data,
                                        links: links,
                                        lineStyle: {
                                            normal: {
                                                color: '#2f4554'
                                            }
                                        }
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
