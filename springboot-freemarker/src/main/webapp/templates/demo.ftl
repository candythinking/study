<html>
<head>
    <meta charset="UTF-8" />
    <title>Highcharts 教程 | 菜鸟教程(runoob.com)</title>
<#--<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>-->
<#--<script src="http://code.highcharts.com/highcharts.js"></script>-->
    <script type="text/javascript" src="js/jquery-2.2.3.js"></script>
    <script type="text/javascript" src="js/highcharts.js"></script>

</head>
<body>
<div id="container" style="width: 550px; height: 400px; margin: 0 auto"></div>
<script language="JavaScript">

    $(document).ready(function() {
        var chart = {
            type: 'column'
        };
        var title = {
            text: '数据异常情况检测'
        };
        var subtitle = {
            text: '数据总量统计'
        };
        var xAxis = {
            categories: ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'],
            crosshair: true
        };
        var yAxis = {
            min: 0,
            title: {
                text: 'count'
            },
//            tickPositions: [0, 200000, 500000, 2000000]  // 指定竖轴坐标点的值
        };
        var tooltip = {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.0f} 个</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        };
        var plotOptions = {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        };
        var credits = {
            enabled: false
        };

        var series= [{
            name: '数据总量',
            data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]
        }, {
            name: '不合格数据总量',
            data: [83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3]
        }];

        var json = {};
        $.ajax({
            url:'./json',
            type:'json',
            success:function(data){
                xAxis.categories = data.citys;
                series[0].data = data.dataSums;
                series[1].data = data.defaultValues;
                json.chart = chart;
                json.title = title;
                json.subtitle = subtitle;
                json.tooltip = tooltip;
                json.xAxis = xAxis;
                json.yAxis = yAxis;
                json.series = series;
                json.plotOptions = plotOptions;
                json.credits = credits;
                $('#container').highcharts(json);
            }

        })


    });
</script>
</body>
</html>