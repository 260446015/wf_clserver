$(function () {
    var jinduA = false;
    var jinduB = false;
    var searchresourceArr = JSON.parse(sessionStorage.getItem("clgapingtai"));
    var jobdata1 = JSON.parse(sessionStorage.getItem("jobinfo1"));
    var jobdata2 = JSON.parse(sessionStorage.getItem("jobinfo2"));
    chaxunA();

    chaxunB();

    function chaxunA() {
        var _data_version = {};
        //接收查询任务创建返回的信息
        console.log(searchresourceArr)
        var _job = jobdata1.jobinfo;
        //进度条控制
        layui.use('element');
        var element = layui.element;
        var elementn = 0;
        var residziyuan = [];
        var timekey = false;

        //开始数据爬去
        retrieveData();
        //计算查询时间
        var numbtime = 0;
        var chaxuntimeer = setInterval(function () {
            if(timekey){
                element.progress('jindutiao1', '100%')
                clearInterval(chaxuntimeer);
            }
            numbtime++;
            $(".chaxuntime1").html(numbtime);
        },1000);
        //调用爬虫
        function retrieveData() {
            var keynum = 0;
            var isfinish = true;
            for (var i = 0; i < _job.resources.length; i++) {
                $.postJsonSyn(ctx + 'retrieveData', {
                    'jobid': _job.jobid,
                    'resid': _job.resources[i],
                    'version': _data_version[_job.resources[i]]
                }, function (result) {
                    if (result.data != null) {
                        keynum++;
                        //判断是否被加载在过
                        var key = $.inArray(_job.resources[i],residziyuan);
                        if(key=="-1"){
                            residziyuan.push(_job.resources[i]);
                            elementn+=parseInt(100/_job.resources.length);
                            element.progress('jindutiao1', elementn+'%');
                        }
                    }
                });
                isfinish = false;
            }
            if (_job.resources.length == keynum) {
                element.progress('jindutiao1', '100%');
                timekey = true;
                jinduA = true;
                if(jinduB){
                    getjobid();
                }
                $(".sd_jindu2").click(function () {
                    $(".shadow").hide();
                });
            }else{
                setTimeout(function () {
                    retrieveData();
                },3000);
            }
        }
    }

    function chaxunB() {
        var _data_version = {};
        //接收查询任务创建返回的信息
        console.log(searchresourceArr)
        var _job = jobdata2.jobinfo;
        //进度条控制
        layui.use('element');
        var element = layui.element;
        var elementn = 0;
        var residziyuan = [];
        var timekey = false;

        //开始数据爬去
        retrieveData();
        //计算查询时间
        var numbtime = 0;
        var chaxuntimeer = setInterval(function () {
            if(timekey){
                element.progress('jindutiao2', '100%')
                clearInterval(chaxuntimeer);
            }
            numbtime++;
            $(".chaxuntime2").html(numbtime);
        },1000);
        //调用爬虫
        function retrieveData() {
            var keynum = 0;
            var isfinish = true;
            for (var i = 0; i < _job.resources.length; i++) {
                $.postJsonSyn(ctx + 'retrieveData', {
                    'jobid': _job.jobid,
                    'resid': _job.resources[i],
                    'version': _data_version[_job.resources[i]]
                }, function (result) {
                    if (result.data != null) {
                        keynum++;
                        //判断是否被加载在过
                        var key = $.inArray(_job.resources[i],residziyuan);
                        if(key=="-1"){
                            residziyuan.push(_job.resources[i]);
                            elementn+=parseInt(100/_job.resources.length);
                            element.progress('jindutiao2', elementn+'%');
                        }
                    }
                });
                isfinish = false;
            }
            if (_job.resources.length == keynum) {
                element.progress('jindutiao2', '100%');
                timekey = true;
                jinduB = true;
                if(jinduA){
                    getjobid();
                }
                $(".sd_jindu2").click(function () {
                    $(".shadow").hide();
                });
            }else{
                setTimeout(function () {
                    retrieveData();
                },3000);
            }
        }
    }

    function getjobid() {
        var jobdata = JSON.parse(sessionStorage.getItem("jobinfo2"));
        console.log(jobdata)
        console.log(searchresourceArr)
        var _job = jobdata.jobinfo;

        $.ajax({
            url: ctx + "/analysis",
            type: "get",
            xhrFields: {
                withCredentials: true
            },
            data: {
                word1: jobdata1.jobinfo.jobid,
                word2: jobdata2.jobinfo.jobid,
            },
            dataType: "json",
            success: function (res) {
                console.log(res);
                $(".sd_jindu2").show().addClass("bounce");
                $.each(res.data,function (i,item) {
                    var data = JSON.stringify(item)
                    if(item){
                        switch (i){
                            case "sameAccount":
                                tys_th(data);
                                break;
                            case "sameAddress":
                                tys_zz(data);
                                break;
                            case "sameCase":
                                tys_aj(data);
                                break;
                            case "sameInet":
                                tys_sw(data);
                                break;
                            case "sameMember":
                                tys_hy(data);
                                break;
                            case "samePhone":
                                tys_dh(data);
                                break;
                            case "sameRoom":
                                tys_fj(data);
                                break;
                            case "sameViolation":
                                tys_tcwz(data);
                                break;
                            case "sameWork":
                                tys_dw(data);
                                break;
                            default:
                                break
                        }
                    }
                });
            }
        });
    }

    //同户
    function tys_th(data) {
        var tysdata = JSON.parse(data)
        $.each(tysdata,function (i,item) {
            var inform = item.label;
            var odata = item.column
            if(item.source=="yunsou"){
                $.each(item.data, function (i, item) {
                    var img = item[1].split("'")[1];
                    var olist = '<span>信息来源：'+inform+'</span>';
                    $.each(item,function (i,item) {
                        olist+='<span>'+odata[i]+'：'+item+'</span>'
                    });
                    $(".tonghu_num").html(item[7]);
                    var yun_weizhang = '<li class="sw_li">' +
                        '<ul  class="sw_ul2">' +
                        '    <li><img class="imgfangda" src="'+img+'" style="height: 30px;margin: 6px;" onerror="clga.whenoerron(this)"></li>' +
                        '    <li style="margin: 0;" class="smalltips"  data-href="'+olist+'">'+item[3]+'</li>' +
                        '    <li>无</li>' +
                        '    <li>'+item[6]+'</li>' +
                        '    <li>'+item[4]+'</li>' +
                        '    <li>'+item[5]+'</li>' +
                        '    <li style="width: 22%;">'+item[0]+'</li>' +
                        '</ul>' +
                        '</li>';
                    $(".tysdt_thgx").append(yun_weizhang);
                })
            }else if(item.source=="sdgayjs"){
                $.each(item.data, function (i, item) {
                    var colomdata = item;
                    var olist = '<span>信息来源：'+inform+'</span>';
                    $.each(item,function (i,item) {
                        olist+='<span>'+odata[i]+'：'+item+'</span>'
                    });
                    var yun_weizhang = '<li class="sw_li">' +
                        '<ul  class="sw_ul2">' +
                        '    <li><img class="imgfangda" src="http://ys.zyfw.ga/photo/renkou/photoSearch.do?method=allPhoto1&searchword=SFZHM:'+(colomdata[odata.indexOf("身份证号")]||"")+'&order=0" style="height: 30px;margin: 6px;" onerror="clga.whenoerron(this)"></li>' +
                        '    <li class="smalltips" data-href="'+olist+'" style="margin: 0;">'+(colomdata[odata.indexOf("名字")]||"")+'</li>' +
                        '    <li>'+(colomdata[odata.indexOf("关系")]||"")+'</li>' +
                        '    <li>无</li>' +
                        '    <li>无</li>' +
                        '    <li>无</li>' +
                        '    <li style="width: 22%;">'+(colomdata[odata.indexOf("身份证号")]||"")+'</li>' +
                        '</ul>' +
                        '</li>';
                    $(".tysdt_thgx").append(yun_weizhang);
                });
            }
            $(".tystit_th").fadeIn();
        });
    }

    //同住址
    function tys_zz(data) {
        var tysdata = JSON.parse(data)
        console.log(tysdata);
        $.each(tysdata,function (i,item) {
            var inform = item.label;
            var odata = item.column
            var olist = '<span>信息来源：'+inform+'</span>';
            $.each(item,function (i,item) {
                olist+='<span>'+odata[i]+'：'+item+'</span>'
            });
            $(".tysdt_tzh").append('<p class="sx_p1 sxtips" data-href="信息来源：云搜-' + inform + '">' +
                '<span>居住地址：' + item.data[7] + '</span>' +
                '<span></span></p>');
        });


    }

    //同案件
    function tys_aj(data) {
        var tysdata = JSON.parse(data)
        console.log(tysdata)
    }
    //同上网
    function tys_sw(data) {
        var qddata = JSON.parse(data)
        var odata = qddata.column;
        console.log(qddata)
        $.each(qddata.data,function (i,item) {
            var colomdata = item;
            var list = '<li class="sw_li sxtips" data-href="山东警务云上网同记录">' +
                '<ul class="sx_ul2">' +
                '    <li class="sx_li">' + (i+1)+ '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("上网人员姓名")]||"") + '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("同上网人员身份证")]||"") + '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("同上网人员姓名")]||"") + '</li>' +
                '    <li class="sx_li" style="width: 12%;">' + (colomdata[odata.indexOf("网吧号")]||"") + '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("上机时间")]||"") + '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("下机时间")]||"") + '</li>' +
                '    <li class="swxq_1 sx_li swxq_1" data-href="true">' +
                '        <span class="iconfont icon-rwcharacter"></span>' +
                '        <span>详情</span>' +
                '    </li>' +
                '</ul>' +
                '<div class="sw_div1 sw_div2">上机地址：' + (colomdata[odata.indexOf("上机地址")]||"") + '</div>' +
                '</li>';
            $(".tysdt_wangba").append(list);
        });
        $(".guiji_wangtitle").fadeIn();
    }

    //同会员
    function tys_hy(data) {
        var tysdata = JSON.parse(data)
        console.log(tysdata)
    }
    //同电话
    function tys_dh(data) {
        var tysdata = JSON.parse(data)
        console.log(tysdata)
    }
    //同房间
    function tys_fj(data) {
        var tysdata = JSON.parse(data)
        $.each(tysdata,function (i,item) {
            var inform = item.label;
            var odata = item.column
            $.each(item.data, function (i, item) {
                var colomdata = item;
                var olist = '<span>信息来源：'+inform+'</span>';
                $.each(item,function (i,item) {
                    olist+='<span>'+odata[i]+'：'+item+'</span>'
                });
                var list = '<li class="sw_li sxtips smalltips" data-href="'+olist+'">' +
                    '<ul class="sx_ul">' +
                    '    <li class="sx_li">' + (i+1)+ '</li>' +
                    '    <li class="sx_li">' + (colomdata[odata.indexOf("同房间人姓名")]||"") + '</li>' +
                    '    <li class="sx_li">' + (colomdata[odata.indexOf("宾馆名称")]||"") + '</li>' +
                    '    <li class="sx_li">' + (colomdata[odata.indexOf("JG_Q")]||"") + '</li>' +
                    '    <li class="sx_li">' + (colomdata[odata.indexOf("房间号")]||"") + '</li>' +
                    '    <li class="sx_li">' + (colomdata[odata.indexOf("入住时间")]||"") + '</li>' +
                    '    <li class="sx_li">' + (colomdata[odata.indexOf("退宿时间")]||"") + '</li>' +
                    '    <li class="sx_li">' + (colomdata[odata.indexOf("")]||"") + '</li>' +
                    '    <li class="swxq_1 sx_li swxq_1" data-href="true">' +
                    '        <span class="iconfont icon-rwcharacter"></span>' +
                    '        <span>详情</span>' +
                    '    </li>' +
                    '</ul>' +
                    '<div class="sw_div1 sw_div2">现住地址：' + (colomdata[odata.indexOf("现住地址")]||"") + ' &nbsp;  派出所名称：' + (colomdata[odata.indexOf("STA_CODE_ZW")]||"") + '</div>' +
                    '</li>';
                $(".tysdt_tfj").append(list);
            });
        });



        $(".guijibianguan").fadeIn();
    }

    //同车违章
    function tys_tcwz(data) {
        var tysdata = JSON.parse(data)
        console.log(tysdata)
    }
    //同单位
    function tys_dw(data) {
        var tysdata = JSON.parse(data)
        console.log(tysdata)
    }



//定义信息来源
    $(".licontent").on("click", ".sxtips", function () {
        layer.tips($(this).attr("data-href"), $(this), {
            tips: [1, '#3595cc'],
            time: 2000
        })
    });
//定义详情
    $(".licontent").on("click",".smalltips",function () {
        layer.open({
            type:"1",
            shadow:false,
            title:false,
            content:$(this).attr("data-href"),
        })
    });
//定义图片放大
    $(".licontent").on("click", ".imgfangda", function () {
        var data = {
            "title": "", //相册标题
            "id": 123, //相册id
            "start": 0, //初始显示的图片序号，默认0
            "data": [   //相册包含的图片，数组格式
                {
                    "alt": "",
                    "pid": 666, //图片id
                    "src": $(this).attr("src"), //原图地址
                    "thumb": "" //缩略图地址
                }
            ]
        }
        layer.photos({
            photos:data,
            anim:5
        })
    });
})
