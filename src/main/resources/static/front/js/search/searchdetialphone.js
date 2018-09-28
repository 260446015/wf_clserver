$(function () {
    var _data_version = {};
    //接收查询任务创建返回的信息
    var jobdata = JSON.parse(sessionStorage.getItem("jobinfo"));
    var searchresourceArr = JSON.parse(sessionStorage.getItem("clgapingtai"));
    var ouser = JSON.parse(sessionStorage.getItem("clgauser"));
    var _error_code={2000:'未知错误',2001:'没有找到插件资源',2002:'初始化错误',2003:'验证码输入错误',2004:'验证码超时',2005:'采集错误',2006:'系统异常或无PKI',2007:'没有PKI',2008:'超时'};
    console.log(jobdata);
    console.log(searchresourceArr);
    var _job = jobdata.jobinfo;
    $(".sl_input").val(jobdata.jobinfo.word);
    //查询社会数据
    shehuishuju(jobdata.jobinfo.word);
    //进度条控制
    layui.use('element');
    var element = layui.element;
    var elementn = 0;
    var residziyuan = [];
    var timekey = false;
    //开始数据爬去
    setTimeout(function () {
        retrieveData();
    },200);
    //计算查询时间
    var numbtime = 0;
    var chaxuntimeer = setInterval(function () {
        if(timekey){
            element.progress('jindutiao', '100%');
            clearInterval(chaxuntimeer);
            $(".cxtm_box").empty();
        }
        numbtime++;
        $(".chaxuntime").html(numbtime);
    },1000);
    //调用爬虫
    function retrieveData() {
        var keynum = 0;
        for (var i = 0; i < _job.resources.length; i++) {
            var ite = i;
            $.postJsonSyn(ctx + 'retrieveData', {
                'jobid': _job.jobid,
                'resid': _job.resources[i]
            }, function (result) {
                if(result.data!=null){
                    if (result.data.code== 1000) {
                        keynum++;
                        //判断是否被加载在过
                        var key = $.inArray(_job.resources[i],residziyuan);
                        if(key=="-1"){
                            residziyuan.push(_job.resources[i]);
                            elementn+=parseInt(100/_job.resources.length);
                            element.progress('jindutiao', elementn+'%');
                            if (result.data.data.length != 0) {
                                switchresid(JSON.stringify(result.data));
                                $(".cxtm_wrap").append('<span style="color: #64ff4d;">'+searchresourceArr[i].name+'</span>');
                            }else{
                                $(".cxtm_wrap").append('<span style="color: #eb9927;">'+searchresourceArr[i].name+'</span>');
                            }
                        }
                    }else if(result.data.code!=1000){
                        keynum++;
                        //判断是否被加载在过
                        var key1 = $.inArray(_job.resources[i],residziyuan);
                        if(key1=="-1"){
                            residziyuan.push(_job.resources[i]);
                            elementn+=parseInt(100/_job.resources.length);
                            element.progress('jindutiao', elementn+'%');
                            $.each(_error_code,function (i,item) {
                                if(result.data.code==i){
                                    $(".cxtm_wrap").append('<span style="color: #ff0000;">'+searchresourceArr[ite].name+'【'+item+'】'+'</span>');
                                }
                            });
                        }
                    }
                }
            });
        }
        if (_job.resources.length == keynum) {
            element.progress('jindutiao', '100%');
            $(".sd_jindu2").show().addClass("bounce");
            timekey = true;
            $(".shehuidata").fadeIn();
            setTimeout(function () {
                //$(".shadow").hide();
            },2000);
            $(".sd_jindu2").click(function () {
                $(".shadow").hide();
            });
        }else{
            setTimeout(function () {
                retrieveData();
            },3000);
        }
    }
    //定义循环结果
    function switchresid(residdata) {
        var resdata = JSON.parse(residdata);
        //平台名称获取
        var oname = "";
        $.each(searchresourceArr,function (i,item) {
            if(resdata.resid==item.id){
                oname = item.name
            }
        });
        $.each(resdata.data,function (i,item) {
            var olist = '<div class="sx_title"><span class="iconfont icon-danwei"></span><span>'+oname+'-<i class="ptda_name">'+item.label+'</i></span></div>' +
                '<div class="sx_pibox gongzuodanwei">';
            console.log(oname+'-'+item.label);
            var column = item.data.column
            $.each(item.data.data,function (i,item) {
                olist+='<p class="ptda_p">'
                $.each(item,function (i,item) {
                    var reg1 = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
                    var reg2 = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
                    var reg3 = /^1[3|4|5|7|8][0-9]{9}$/;
                    if (reg1.test(item)||reg3.test(item)) {
                        olist += '<span>' + column[i] + '：<a href="../../html/search/search_detial.html?'+item+'" target="_blank">' + item + '</a></span>'
                    }else{
                        olist += '<span>' + column[i] + '：<i>' + item + '</i></span>'
                    }
                });
                olist+='</p>'
            });
            olist+='</div>';
            $(".pingtaidata").append(olist);
        })
    }

    //社会数据展示
    function shehuishuju(data) {
        $.ajax({
            url: ctx+"file/upload",
            type: "get",
            xhrFields: {
                withCredentials: true
            },
            data: {
                pageNum:0,
                pageSize:100,
                search:data
            },
            dataType:"json",
            success: function (res) {
                console.log(res);
                $.each(res.data.dataList,function (i,item){
                    var laiyun = item.source;
                    var shijian = clga.timechange(item.createTime);
                    var zuozhe = item.username;
                    var jinghaoname = "";
                    if(item.policeNumber){
                        jinghaoname = item.policeNumber
                    }
                    var laiyuanlength = 0;
                    var shijianlength = 0;
                    var zuozhelength = 0;
                    var totallength = 0;
                    var jinghaolength = 0;
                    var list =  '<div class="shehuidataconte shehuida'+i+'" id="shehuida'+i+'">'
                    var itemer = item.content.split("{")[1].split("}")[0].split(",");
                    if(clga.getlength("数据来源")>clga.getlength(laiyun)){
                        laiyuanlength = clga.getlength("数据来源")*10;
                    }else{
                        laiyuanlength = clga.getlength(laiyun)*10;
                    }
                    list +=  '<dl class="sh_dlbox" style="border-left: 1px solid #ccc;">' +
                        '<dd style="width: '+laiyuanlength+'px">数据来源</dd>' +
                        '<dt style="width: '+laiyuanlength+'px">'+laiyun+'</dt>' +
                        '</dl>';
                    $.each(itemer,function (i,item) {
                        var itdata = item.split("'");
                        var lengther = "";
                        if(clga.getlength(itdata[1])>clga.getlength(itdata[3])){
                            lengther = clga.getlength(itdata[1])*10;
                        }else{
                            lengther = clga.getlength(itdata[3])*10;
                        }
                        totallength+=lengther;
                        list +=  '<dl class="sh_dlbox">' +
                            '<dd style="width: '+lengther+'px">'+itdata[1]+'</dd>' +
                            '<dt style="width: '+lengther+'px">'+itdata[3]+'</dt>' +
                            '</dl>';
                    });


                    if(clga.getlength("上传时间")>clga.getlength(shijian)){
                        shijianlength = clga.getlength("上传时间")*10;
                    }else{
                        shijianlength = clga.getlength(shijian)*10;
                    }
                    if(clga.getlength("上传人")>clga.getlength(zuozhe)){
                        zuozhelength = clga.getlength("上传人")*10;
                    }else{
                        zuozhelength = clga.getlength(zuozhe)*10;
                    }
                    if(clga.getlength("警号")>clga.getlength(jinghaoname)){
                        jinghaolength = clga.getlength("警号")*10;
                    }else{
                        jinghaolength = clga.getlength(jinghaoname)*10;
                    }
                    list +=  '<dl class="sh_dlbox">' +
                        '<dd style="width: '+shijianlength+'px">上传时间</dd>' +
                        '<dt style="width: '+shijianlength+'px">'+shijian+'</dt>' +
                        '</dl>'+
                        '<dl class="sh_dlbox">' +
                        '<dd style="width: '+zuozhelength+'px">上传人</dd>' +
                        '<dt style="width: '+zuozhelength+'px">'+zuozhe+'</dt>' +
                        '</dl>'+
                        '<dl class="sh_dlbox">' +
                        '<dd style="width: '+jinghaolength+'px">警号</dd>' +
                        '<dt style="width: '+jinghaolength+'px">'+jinghaoname+'</dt>' +
                        '</dl>';
                    totallength+=laiyuanlength;
                    totallength+=shijianlength;
                    totallength+=zuozhelength;
                    totallength+=jinghaolength;
                    list+= '</div>';
                    if(item.contentType=="0"){
                        $(".shehuishujudata").append(list);
                        $(".sgehuitittle").fadeIn();
                    }else{
                        $(".hulianwangshujudata").append(list);
                        $(".hulianwntitle").fadeIn();
                    }
                    $(".shehuidatabox").find(".shehuida"+i+"").css("width",totallength+100);
                });

            }
        });
    }

    // 关闭按钮
    $(".cxtm_closebtyn").click(function () {
        $(".shadow").hide();
    });
});