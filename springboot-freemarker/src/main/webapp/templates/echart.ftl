<!DOCTYPE html>
<html>
<head>
    <title>图表</title>
    <script type="text/javascript" src="js/jquery-2.2.3.js"></script>
    <script type="text/javascript" src="js/echarts.min.js"></script>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1>图表</h1>

        <p>Echarts 图表</p>

        <p><a class="btn btn-primary btn-lg" id="get_data">显示</a></p>
    </div>
    <div id="chart"></div>
</div>
<#--<script type="text/javascript" src="js/app.js"></script>-->
<script language="JavaScript">

    $('#get_data').click(
            function () {

        $.ajax({
            type: 'POST',
            url: '/json-echart',
            success: function (result) {
                // 基于准备好的dom，初始化echarts实例
                alert(result.xAxis);
                var myChart = echarts.init(document.getElementById('chart'));

                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: 'ECharts 入门示例'
                    },
                    tooltip: {},
                    legend: {
                        data: result.legend
                    },
                    xAxis: {
                        data: result.xAxis
                    },
                    yAxis: {},
                    series: [{
                        name: '销量',
                        type: 'bar',
                        data: result.series.data
                    }]
                };

                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
//                $('#chart').echarts.setOptions(option);
            }

    })
    });
</script>
</body>
</html>