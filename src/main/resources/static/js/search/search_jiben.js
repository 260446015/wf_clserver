
/*列表展示页面*/
var jobdata = JSON.parse(sessionStorage.getItem("jobinfo"));
var jobetype = jobdata.jobinfo.wordtype;

//gajgjls-公安监管拘留所警务工作平台
function setDatagajgjls(residdata) {
    var reaData = JSON.parse(residdata).data;
    //console.log(reaData);
    var swistdata = reaData[0].data.data[0];
    swillist = '<tr class="sl_firtr">' +
        '<td class="zhanwei"></td>' +
        '<td>' + swistdata[1] + '</td>' +
        '<td>' + swistdata[3] + '</td>' +
        '<td class="swillistclic">' + swistdata[5] + '</td>' +
        '<td>' + swistdata[4] + '</td>' +
        '<td>山东公安监管拘留所警务工作平台</td>' +
        '<td>' + swistdata[6] + '</td>' +
        '<td class="swillistclic">' + swistdata[10] + '</td>' +
        '<td class="swillistclic"></td>' +
        '<td class="zhanwei"></td>' +
        '</tr>';
    $(".sl_tbody").append(swillist);
}

//gajgkss-山东公安监看守所警务平台
function setDatagajgkss(residdata) {
    var reaData = JSON.parse(residdata).data;
    $.each(reaData, function (i, item) {
        var lisiisis = item.label;
        switch (lisiisis) {
            case "基本信息":
                qiandu_jiben(item.data);
                break;
            default:
                break;
        }
    });
    //基本信息
    function qiandu_jiben(data) {
        var swistdata = data.data[0];
        swillist = '<tr class="sl_firtr">' +
            '<td class="zhanwei"></td>' +
            '<td>' + (swistdata[data.column.indexOf("姓 名")]||"") + '</td>' +
            '<td>' + (swistdata[data.column.indexOf("性 别")]||"")+ '</td>' +
            '<td class="swillistclic">' + (swistdata[data.column.indexOf("证件号")]||"") + '</td>' +
            '<td>' + (swistdata[data.column.indexOf("出生日期")]||"")+ '</td>' +
            '<td>山东公安监看守所警务工作平台</td>' +
            '<td>' + (swistdata[data.column.indexOf("民 族")]||"")+ '</td>' +
            '<td class="swillistclic">' + (swistdata[data.column.indexOf("户籍地")]||"") + '</td>' +
            '<td class="swillistclic"></td>' +
            '<td class="zhanwei"></td>' +
            '</tr>';
        $(".sl_tbody").append(swillist);
    }
}

//jtlhy-"全国公安交通管理信息综合查询平台"
function setDatajtlhy(residdata) {
    var reaData = JSON.parse(residdata).data;
    console.log(reaData)
    $.each(reaData, function (i, item) {
        var lisiisis = item.label;
        switch (lisiisis) {
            case "公安部驾驶人详细信息":
                jiaotong_jiben(item.data);
                break;
            default:
                break;
        }
    });
    function jiaotong_jiben(odata) {
        var swistdata = odata.data[0];
        swillist = '<tr class="sl_firtr">' +
            '<td class="zhanwei"></td>' +
            '<td>' + (swistdata[odata.column.indexOf("姓名")]||"") + '</td>' +
            '<td>' + (swistdata[odata.column.indexOf("性别")]||"")+ '</td>' +
            '<td class="swillistclic">' + (swistdata[odata.column.indexOf("身份证明号码")]||"") + '</td>' +
            '<td>' + (swistdata[odata.column.indexOf("出生日期")]||"")+ '</td>' +
            '<td>全国公安交通管理信息综合查询系统</td>' +
            '<td>' + (swistdata[odata.column.indexOf("民族")]||"")+ '</td>' +
            '<td class="swillistclic">' + (swistdata[odata.column.indexOf("详细地址")]||"") + '</td>' +
            '<td class="swillistclic">'+(swistdata[odata.column.indexOf("联系电话")]||"")+'</td>' +
            '<td class="zhanwei"></td>' +
            '</tr>';
        $(".sl_tbody").append(swillist);
    }

}

//qgwffzry-"全国违法犯罪人员信息资源库"
function setDataqgwffzry(residdata) {
    var reaData = JSON.parse(residdata).data;
    //console.log(reaData);
    //人员核查业务
    var swistdata = reaData[0].data.data[0];
    swillist = '<tr class="sl_firtr">' +
        '<td class="zhanwei"></td>' +
        '<td>' + swistdata[0] + '</td>' +
        '<td>' + swistdata[1] + '</td>' +
        '<td class="swillistclic">' + swistdata[5] + '</td>' +
        '<td>' + swistdata[4] + '</td>' +
        '<td>全国违法犯罪人员信息资源库</td>' +
        '<td>' + swistdata[3] + '</td>' +
        '<td class="swillistclic">' + swistdata[14] + '</td>' +
        '<td class="swillistclic"></td>' +
        '<td class="zhanwei"></td>' +
        '</tr>';
    $(".sl_tbody").append(swillist);
}

//qgxdry-"全国吸毒人员"
function setDataqgxdry(residdata) {
    var reaData = JSON.parse(residdata).data;
    $.each(reaData, function (i, item) {
        var lisiisis = item.label;
        switch (lisiisis) {
            case "基本信息":
                qiandu_jiben(item.data);
                break;
            default:
                break;
        }
    });
    //基本信息
    function qiandu_jiben(data) {
        var swistdata = data.data[0];
        swillist = '<tr class="sl_firtr">' +
            '<td class="zhanwei"></td>' +
            '<td>' + (swistdata[data.column.indexOf("姓名")]||"") + '</td>' +
            '<td>' + (swistdata[data.column.indexOf("性别")]||"")+ '</td>' +
            '<td class="swillistclic">' + (swistdata[data.column.indexOf("证件号码")]||"") + '</td>' +
            '<td>' + (swistdata[data.column.indexOf("出生日期")]||"")+ '</td>' +
            '<td>全国吸毒人员查证系统</td>' +
            '<td>' + (swistdata[data.column.indexOf("民族")]||"")+ '</td>' +
            '<td class="swillistclic">' + (swistdata[data.column.indexOf("户籍地")]||"") + '</td>' +
            '<td class="swillistclic"></td>' +
            '<td class="zhanwei"></td>' +
            '</tr>';
        $(".sl_tbody").append(swillist);
    }
}

//qgztry-"全国在逃人员"
function setDataqgztry(residdata) {
    var reaData = JSON.parse(residdata).data;
    $.each(reaData, function (i, item) {
        var lisiisis = item.label;
        switch (lisiisis) {
            case "在逃查询":
                zaitaojiben(item.data);
                break;
            default:
                break;
        }
    });
    function zaitaojiben(odata) {
        var swistdata = odata.data[0];
        swillist = '<tr class="sl_firtr">' +
            '<td class="zhanwei"></td>' +
            '<td>' +  (swistdata[odata.column.indexOf("姓名")]||"") + '</td>' +
            '<td>' +  (swistdata[odata.column.indexOf("性别")]||"") + '</td>' +
            '<td class="swillistclic">' + (swistdata[odata.column.indexOf("证件")]||"") + '</td>' +
            '<td>' +  (swistdata[odata.column.indexOf("出生日期")]||"") + '</td>' +
            '<td>全国在逃人员资源信息库</td>' +
            '<td>' +  (swistdata[odata.column.indexOf("民族")]||"") + '</td>' +
            '<td class="swillistclic">' +  (swistdata[odata.column.indexOf("户籍地址")]||"") + '</td>' +
            '<td class="swillistclic"></td>' +
            '<td class="zhanwei"></td>' +
            '</tr>';
        $(".sl_tbody").append(swillist);
    }

}

//sdgayjs-"山东公安云计算平台（警务千度）"
function setDatasdgayjs(residdata) {
    var reaData = JSON.parse(residdata).data;
    $.each(reaData, function (i, item) {
        var lisiisis = item.label;
        switch (lisiisis) {
            case "基本信息":
                qiandu_jiben(item.data);
                break;
            default:
                break;
        }
    });
    //基本信息
    function qiandu_jiben(data) {
        $.each(data.data,function (i,item) {
            if(i<20){
                var swistdata = item;
                swillist = '<tr class="sl_firtr">' +
                    '<td class="zhanwei"></td>' +
                    '<td>' + (swistdata[data.column.indexOf("姓名")]||"") + '</td>' +
                    '<td>' + (swistdata[data.column.indexOf("性别")]||"")+ '</td>' +
                    '<td class="swillistclic">' + (swistdata[data.column.indexOf("身份证号")]||"") + '</td>' +
                    '<td>' + (swistdata[data.column.indexOf("出生日期")]||"")+ '</td>' +
                    '<td>山东公安云计算平台（警务千度）</td>' +
                    '<td>' + (swistdata[data.column.indexOf("民族")]||"")+ '</td>' +
                    '<td class="swillistclic">' + (swistdata[data.column.indexOf("籍贯")]||"") + '</td>' +
                    '<td class="swillistclic"></td>' +
                    '<td class="zhanwei"></td>' +
                    '</tr>';
                $(".sl_tbody").append(swillist);
            }
        })
    }
}

//yunsou-""云搜""
function setDatayunsou(residdata) {
    //人员核查业务
    var reaData = JSON.parse(residdata).data;
    $.each(reaData, function (i, item) {
        var lisiisis = item.label;
        switch (lisiisis) {
            case "全国人口基本信息":
                qiandu_jiben(item.data);
                break;
            default:
                break;
        }
    });
    //基本信息
    function qiandu_jiben(data) {
        $.each(data.data,function (i,item) {
            var swistdata = item;
            if(i<20){
                swillist = '<tr class="sl_firtr">' +
                    '<td class="zhanwei"></td>' +
                    '<td>' + (swistdata[data.column.indexOf("姓名")]||"") + '</td>' +
                    '<td>' + (swistdata[data.column.indexOf("性别")]||"")+ '</td>' +
                    '<td class="swillistclic">' + (swistdata[data.column.indexOf("公民身份证号")]||"") + '</td>' +
                    '<td>' + (swistdata[data.column.indexOf("出生日期")]||"")+ '</td>' +
                    '<td>公安部云搜索</td>' +
                    '<td>' + (swistdata[data.column.indexOf("民族")]||"")+ '</td>' +
                    '<td class="swillistclic">' + (swistdata[data.column.indexOf("户籍地")]||"") + '</td>' +
                    '<td class="swillistclic"></td>' +
                    '<td class="zhanwei"></td>' +
                    '</tr>';
                $(".sl_tbody").append(swillist);
            }
        });
    }
}

//山东执法办案平台
function setDatasdzfpt(residdata) {
    //人员核查业务
    var reaData = JSON.parse(residdata).data;
    $.each(reaData, function (i, item) {
        var lisiisis = item.label;
        switch (lisiisis) {
            case "全国人口基本信息":
                qiandu_jiben(item.data);
                break;
            default:
                break;
        }
    });
    //基本信息
    function qiandu_jiben(data) {
        var swistdata = data.data[0];
        var gonganimg = "";
        console.log(data)
        swillist = '<tr class="sl_firtr">' +
            '<td class="zhanwei"></td>' +
            '<td>' + (swistdata[data.column.indexOf("姓名")]||"") + '</td>' +
            '<td>' + (swistdata[data.column.indexOf("性别")]||"")+ '</td>' +
            '<td class="swillistclic">' + (swistdata[data.column.indexOf("公民身份证号")]||"") + '</td>' +
            '<td>' + (swistdata[data.column.indexOf("出生日期")]||"")+ '</td>' +
            '<td>山东省公安机关执法办案闭环管理系统</td>' +
            '<td>' + (swistdata[data.column.indexOf("民族")]||"")+ '</td>' +
            '<td class="swillistclic">' + (swistdata[data.column.indexOf("户籍地")]||"") + '</td>' +
            '<td class="swillistclic"></td>' +
            '<td class="zhanwei"></td>' +
            '</tr>';
        $(".sl_tbody").append(swillist);
    }
}

//山东省人口信息管理系统
function setDatasdsrkxx(residdata) {
    //人员核查业务
    var reaData = JSON.parse(residdata).data;
    $.each(reaData, function (i, item) {
        var lisiisis = item.label;
        switch (lisiisis) {
            case "人口全项信息":
                qiandu_jiben(item.data);
                break;
            default:
                break;
        }
    });
    //基本信息
    function qiandu_jiben(data) {
        var swistdata = data.data[0];
        var gender = "";
        if((swistdata[data.column.indexOf("性别")]||"")=="01"){
            gender = "女"
        }else{
            gender = "男"
        }
        swillist = '<tr class="sl_firtr">' +
            '<td class="zhanwei"></td>' +
            '<td>' + (swistdata[data.column.indexOf("姓名")]||"") + '</td>' +
            '<td>' + gender+ '</td>' +
            '<td class="swillistclic">' + (swistdata[data.column.indexOf("公民身份号码")]||"") + '</td>' +
            '<td>' + (swistdata[data.column.indexOf("出生日期")]||"")+ '</td>' +
            '<td>山东省人口信息管理系统</td>' +
            '<td>' + (swistdata[data.column.indexOf("民族")]||"")+ '</td>' +
            '<td class="swillistclic">' + (swistdata[data.column.indexOf("户籍地")]||"") + '</td>' +
            '<td class="swillistclic">' + (swistdata[data.column.indexOf("联系电话")]||"") + '</td>' +
            '<td class="zhanwei"></td>' +
            '</tr>';
        $(".sl_tbody").append(swillist);
    }
}

//潍坊城市基础数据管控平台（三实平台）wfjcsj
function setDatawfjcsj(residdata) {
    //人员核查业务
    var reaData = JSON.parse(residdata).data;
    $.each(reaData, function (i, item) {
        var lisiisis = item.label;
        switch (lisiisis) {
            case "人口信息":
                qiandu_jiben(item.data);
                break;
            default:
                break;
        }
    });
    //基本信息
    function qiandu_jiben(data) {
        var swistdata = data.data[0];
        swillist = '<tr class="sl_firtr">' +
            '<td class="zhanwei"></td>' +
            '<td>' + (swistdata[data.column.indexOf("姓名")]||"") + '</td>' +
            '<td>' + (swistdata[data.column.indexOf("性别")]||"")+ '</td>' +
            '<td class="swillistclic">' + (swistdata[data.column.indexOf("证件号码")]||"") + '</td>' +
            '<td>' + (swistdata[data.column.indexOf("出生日期")]||"")+ '</td>' +
            '<td>山东省人口信息管理系统</td>' +
            '<td>' + (swistdata[data.column.indexOf("民族")]||"")+ '</td>' +
            '<td class="swillistclic">' + (swistdata[data.column.indexOf("户籍地")]||"") + '</td>' +
            '<td class="swillistclic">' + (swistdata[data.column.indexOf("联系电话")]||"") + '</td>' +
            '<td class="zhanwei"></td>' +
            '</tr>';
        $(".sl_tbody").append(swillist);
    }
}

//电信诈骗
function setDatagabdxzp(residdata) {
    //人员核查业务
    var reaData = JSON.parse(residdata).data;
    console.log(reaData)
    $.each(reaData, function (i, item) {
        var lisiisis = item.label;
        switch (lisiisis) {
            case "人员详细信息":
                qiandu_jiben(item.data);
                break;
            default:
                break;
        }
    });
    //基本信息
    function qiandu_jiben(data) {
        var swistdata = data.data[0];
        swillist = '<tr class="sl_firtr">' +
            '<td class="zhanwei"></td>' +
            '<td>' + (swistdata[data.column.indexOf("姓名")]||"") + '</td>' +
            '<td>' + (swistdata[data.column.indexOf("性别")]||"")+ '</td>' +
            '<td class="swillistclic">' + (swistdata[data.column.indexOf("证件号码")]||"") + '</td>' +
            '<td>' + (swistdata[data.column.indexOf("出生日期")]||"")+ '</td>' +
            '<td>山东省人口信息管理系统</td>' +
            '<td>' + (swistdata[data.column.indexOf("民族")]||"")+ '</td>' +
            '<td class="swillistclic">' + (swistdata[data.column.indexOf("户籍区划")]||"") + '</td>' +
            '<td class="swillistclic">' + (swistdata[data.column.indexOf("联系电话")]||"") + '</td>' +
            '<td class="zhanwei"></td>' +
            '</tr>';
        $(".sl_tbody").append(swillist);
    }
}

//潍坊智能终端分析系统（蛛网系统）wfsznzd
function setDatawfsznzd(residdata) {

}

//全国被盗抢机动车信息资源库qgbdqqc
function setDataqgbdqqc(residdata) {
    var reaData = JSON.parse(residdata).data;
    console.log(reaData)
}
