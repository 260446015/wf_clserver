$(function () {
    "鲁A8650W"
    var _data_version = {};
    //接收查询任务创建返回的信息
    var jobdata = JSON.parse(sessionStorage.getItem("jobinfo"));
    var searchresourceArr = JSON.parse(sessionStorage.getItem("clgapingtai"));
    console.log(jobdata)
    console.log(searchresourceArr)
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
    retrieveData();
    //计算查询时间
    var numbtime = 0;
    var chaxuntimeer = setInterval(function () {
        if(timekey){
            element.progress('jindutiao', '100%')
            clearInterval(chaxuntimeer);
            $(".cxtm_box").empty();
        }
        numbtime++;
        $(".chaxuntime").html(numbtime);
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
                        element.progress('jindutiao', elementn+'%');
                        if (result.data.data.length != 0) {
                            switchresid(JSON.stringify(result.data));
                            $(".cxtm_wrap").append('<span style="color: #64ff4d;">'+searchresourceArr[i].name+'</span>');
                        }else{
                            $(".cxtm_wrap").append('<span style="color: #eb9927;">'+searchresourceArr[i].name+'</span>');
                        }
                    }
                }
            });
            isfinish = false;
        }
        if (_job.resources.length == keynum) {
            element.progress('jindutiao', '100%')
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
        var resid = JSON.parse(residdata).resid;
        //console.log(resid);

        switch (resid) {
            case "yunsou":
                setDatayunsou(residdata);
                break;
            case "gajgjls":
                setDatagajgjls(residdata);
                break;
            case "jtlhy":
                setDatajtlhy(residdata);
                break;
            case "qgwffzry":
                setDataqgwffzry(residdata);
                break;
            case "qgxdry":
                setDataqgxdry(residdata);
                break;
            case "qgztry":
                setDataqgztry(residdata);
                break;
            case "sdgayjs":
                setDatasdgayjs(residdata);
                break;
            case "gajgkss":
                setDatagajgkss(residdata);
                break;
            case "sdzfpt":
                setDatasdzfpt(residdata);
                break;
            case "gabdxzp":
                setDatagabdxzp(residdata);
                break;
            case "sdsrkxx":
                setDatasdsrkxx(residdata);
                break;
            case "wfjcsj":
                setDatawfjcsj(residdata);
                break;
            case "wfsznzd":
                setDatawfsznzd(residdata);
                break;
            case "qgbdqqc":
                setDataqgbdqqc(residdata);
                break;
            default:
                break;
        }
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
                pageSize:10,
                search:data
            },
            dataType:"json",
            success: function (res) {
                console.log(res);
                $.each(res.data.dataList,function (i,item){
                    var totallength = 0;
                    var list =  '<div class="shehuidataconte shehuida'+i+'" id="shehuida'+i+'">'
                    var itemer = item.content.split("{")[1].split("}")[0].split(",");
                    $.each(itemer,function (i,item) {
                        var itdata = item.split("'")
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
                    var laiyun = item.source;
                    var shijian = clga.timechange(item.createTime);
                    var zuozhe = item.username;
                    var laiyuanlength = 0;
                    var shijianlength = 0;
                    var zuozhelength = 0;
                    if(clga.getlength("数据来源")>clga.getlength(laiyun)){
                        laiyuanlength = clga.getlength("数据来源")*10;
                    }else{
                        laiyuanlength = clga.getlength(laiyun)*10;
                    }
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
                    list +=  '<dl class="sh_dlbox">' +
                        '<dd style="width: '+laiyuanlength+'px">数据来源</dd>' +
                        '<dt style="width: '+laiyuanlength+'px">'+laiyun+'</dt>' +
                        '</dl>'+
                        '<dl class="sh_dlbox">' +
                        '<dd style="width: '+shijianlength+'px">上传时间</dd>' +
                        '<dt style="width: '+shijianlength+'px">'+shijian+'</dt>' +
                        '</dl>'+
                        '<dl class="sh_dlbox">' +
                        '<dd style="width: '+zuozhelength+'px">上传人</dd>' +
                        '<dt style="width: '+zuozhelength+'px">'+zuozhe+'</dt>' +
                        '</dl>'
                    totallength+=laiyuanlength;
                    totallength+=shijianlength;
                    totallength+=zuozhelength;
                    list+= '</div>';
                    if(item.contentType=="0"){
                        $(".shehuishujudata").append(list);
                        $(".sgehuitittle").fadeIn();
                    }else{
                        $(".hulianwangshujudata").append(list);
                        $(".hulianwntitle").fadeIn();
                    }
                    console.log(totallength)
                    $(".shehuidatabox").find(".shehuida"+i+"").css("width",totallength+100);
                });

            }
        });
    }
})


"15891151512"