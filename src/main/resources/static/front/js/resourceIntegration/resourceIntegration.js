
setlizi();
function setlizi() {
    var cols = ['#247aa8', '#4462F7', '#1c51ee', '#0073ed', '#ecf0f1', '#a2ded0'];
    var stars = 300;

    for (var i = 0; i <= stars; i++) {

        var size = Math.random() * 4;
        var color = cols[parseInt(Math.random() * 6)];

        $('#starsBox').prepend('<span style=" width: ' + size + 'px; height: ' + size + 'px; top: ' + Math.random() * 100 + '%; left: ' + Math.random() * 100 + '%; background: ' + color + '; box-shadow: 0 0 ' + Math.random() * 10 + 'px' + color + ';"></span>');
    };

    setTimeout(function() {
        $('#starsBox span').each(function() {
            $(this).css('top', Math.random() * 100 + '%').css('left', Math.random() * 100 + '%');
        });
    }, 1);

    setInterval(function() {
        $('#starsBox span').each(function() {
            $(this).css('top', Math.random() * 100 + '%').css('left', Math.random() * 100 + '%');
        });
    }, 1000);
}
//柱形图
setzhuxing(Math.random()*300)
function setzhuxing(res) {
    var chart = Highcharts.chart('container', {
        chart: {
            type: 'column',
            backgroundColor: 'transparent',

        },
        title: {
            text: ''//大标题
        },
        subtitle: {
            text: ''//小标题
        },
        xAxis: {
            categories: [
                '5月', '6月', '7月', '8月', '9月'
            ],
            crosshair: true,
            tickColor: '#08324d',
            labels: {
                style: {
                    color: '#fff',
                }
            },
            lineColor: '#08324d'
        },
        yAxis: {
            min: 0,
            title: {
                text: '数据量（万）'
            },
            gridLineColor: '#08324d',
            gridLineWidth: '1px',
            tickColor: 'red',
            labels: {
                style: {
                    color: '#fff'
                }
            }
        },
        legend: {
            backgroundColor: 'transparent',
            x: 100,
            verticalAlign: 'top',
            y: -30,
            itemStyle: {
                color: '#01b9d6'
            }
        },
        tooltip: {
            // head + 每个 point + footer 拼接成完整的 table
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f} 万</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                borderWidth: 0
            },
        },
        series: [
            {
                name: '宽带',
                data: [res, 71.5, 106.4, 129.2, 144.0],
                color: '#6c68ff'
            }, {
                name: 'QQ',
                data: [83.6, 78.8, 98.5, 93.4, 106.0],
                color: '#0084ff'
            }, {
                name: '微信',
                data: [48.9, 38.8, 39.3, 41.4, 47.0],
                color: '#00c6ff'
            }, {
                name: '微博',
                data: [42.4, 33.2, 34.5, 39.7, 52.6],
                color: '#00ffd2'
            }, {
                name: '论坛',
                data: [42.4, 33.2, 34.5, 39.7, 52.6],
                color: '#e4ff66'
            }
        ]
    });
}

//折线图
setzhuxingzhexian(Math.random() * 300)

function setzhuxingzhexian(res) {
    var chart = Highcharts.chart('container1', {
        chart: {
            backgroundColor: 'transparent',
        },
        title: {
            text: ''//大标题
        },
        subtitle: {
            text: ''//小标题
        },
        xAxis: {
            categories: [
                '5月', '6月', '7月', '8月', '9月'
            ],
            crosshair: true,
            tickColor: '#08324d',
            labels: {
                style: {
                    color: '#fff',
                }
            },
            lineColor: '#08324d'
        },
        yAxis: {
            min: 0,
            title: {
                text: '数据量（万）'
            },
            gridLineColor: '#08324d',
            gridLineWidth: '1px',
            tickColor: 'red',
            labels: {
                style: {
                    color: '#fff',
                }
            }
        },
        legend: {
            backgroundColor: 'transparent',
            x: 100,
            verticalAlign: 'top',
            y: -30,
            itemStyle: {
                color: '#01b9d6'
            }
        },
        plotOptions: {
            column: {
                borderWidth: 0
            },
        },
        series: [
            {
                name: '银行账号',
                data: [res, 233, 345, 567, 123],
                color: '#8b88ff'
            }, {
                name: '职工',
                data: [123, 234, 231, 256, 279],
                color: '#0084ff'
            }, {
                name: '医保',
                data: [112, 189, 234, 123, 80],
                color: '#00c6ff'
            }, {
                name: '人设',
                data: [12, 23, 123, 234, 213],
                color: '#00ffd2'
            }, {
                name: '公积金',
                data: [56, 90, 200, 234, 312],
                color: '#e4ff66'
            }, {
                name: '纳税人',
                data: [20, 23, 34, 67, 100],
                color: '#ff924a'
            }, {
                name: '水电气',
                data: [12, 233, 231, 111, 211],
                color: '#87ff87'
            }]
    });
}