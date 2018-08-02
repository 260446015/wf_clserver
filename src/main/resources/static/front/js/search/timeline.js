

function systole(){
    if(!$(".history").length){
        return;
    }
    var $warpEle = $(".history-date"),
        $targetA = $warpEle.find("h2 a,ul li dl dt a"),
        parentH,
        eleTop = [];

    parentH = $warpEle.parent().height();
    $warpEle.parent().css({"height":59});

    setTimeout(function(){

        $warpEle.find("ul").children(":not('div:first')").each(function(idx){
            eleTop.push($(this).position().top);
            $(this).css({"margin-top":-eleTop[idx]}).children().hide();
        }).animate({"margin-top":0}, 1600).children().fadeIn();

        $warpEle.parent().animate({"height":parentH}, 2600);

        $warpEle.find("ul").children(":not('div:first')").addClass("bounceInDown").css({"-webkit-animation-duration":"2s","-webkit-animation-delay":"0","-webkit-animation-timing-function":"ease","-webkit-animation-fill-mode":"both"}).end().children("h2").css({"position":"relative"});

    }, 600);

    $targetA.click(function(){
        $(this).parent().css({"position":"relative"});
        $(this).parent().siblings().slideToggle();
        $warpEle.parent().removeAttr("style");
        return false;
    });
};



function getchecked() {
    var checkval = "";
    $("input:checkbox[name='guijicheck']:checked").each(function (i,item) {
        if(i=="0"){
            checkval+=item.value
        }else{
            checkval+=','+item.value
        }
    });
    return checkval
}
//数据接入
var jobdata = JSON.parse(sessionStorage.getItem("jobinfo"));
console.log(jobdata.jobinfo.jobid);
$(".licontent").on("click",".guijichaxunbtn",function () {
    getguiji()
});
function getguiji() {
    var timeval = $("#test1").val()||"";
    $.ajax({
        url: ctx + "/track/get",
        type: "get",
        xhrFields: {
            withCredentials: true
        },
        data: {
            jobid: jobdata.jobinfo.jobid,
            trackType: getchecked(),
            beginDate: timeval.split(" - ")[0],
            endDate:timeval.split(" - ")[1]
        },
        dataType: "json",
        success: function (res) {
            if(res.length == 0){
                layer.msg("暂无数据");
            }
            $(".guijishijian").empty();
            $.each(res,function (i,item) {
                var olist = "";
                var adata = item.dataList;
                $.each(item.columns,function (i,item) {
                    olist+='<span>'+item+'：'+adata[i]+'</span>'
                });
                if(i%2){
                    var list = '<li class="bounceInDown timeclass timeeractive cr">' +
                        '    <div class="timeclassleft">' +
                        '        <span class="tili_te tili_texlef">'+item.stayDate+'</span>' +
                        '    </div>' +
                        '    <div class="timeclassright">' +
                        '        <div class="tili_tex tili_texbtnr gjsjz_addres" data-href="'+olist+'">'+(item.address||"")+'</div>' +
                        '    </div>' +
                        '</li>';
                }else{
                    var list = '<li class="bounceInDown timeclass cr" data-href="">' +
                        '    <div class="timeclassleft">' +
                        '        <div class="tili_tex tili_texbtnl gjsjz_addres" data-href="'+olist+'">'+(item.address||"")+'</div>' +
                        '    </div>' +
                        '    <div class="timeclassright">' +
                        '        <span class="tili_te tili_texrig">'+item.stayDate+'</span>' +
                        '    </div>' +
                        '</li>';
                }
               $(".guijishijian").append(list);
            });
            systole();
        }
    });
}

$(".guijishijian").on("click",".gjsjz_addres",function () {
    layer.open({
        type:"1",
        shadow:false,
        title:false,
        content:$(this).attr("data-href"),
    })
});


//当前7天时间
var time1 = new Date();
time1.setTime(time1.getTime());
var Y1 = time1.getFullYear();
var M1 = ((time1.getMonth() + 1) > 10 ? (time1.getMonth() + 1) : '0' + (time1.getMonth() + 1));
var D1 = (time1.getDate() > 10 ? time1.getDate() : '0' + time1.getDate());
var timer1 = Y1 +'-'+ M1 +'-'+ D1 ;// 当前时间
var time2 = new Date();
time2.setTime(time2.getTime() + (24 * 60 * 60 * 1000 * 7));
var Y2 = time2.getFullYear();
var M2 = ((time2.getMonth() + 1) > 9 ? (time2.getMonth() + 1) : '0' + (time2.getMonth() + 1));
var D2 = (time2.getDate() > 9 ? time2.getDate() : '0' + time2.getDate());
var timer2 = Y2+'-'+ M2+'-'+ D2; // 之后的七天或者一个月
console.log(timer1+'---'+timer2);
smalltipsluguan();
function smalltipsluguan() {
    $.ajax({
        url: ctx + "/track/get",
        type: "get",
        xhrFields: {
            withCredentials: true
        },
        data: {
            jobid: jobdata.jobinfo.jobid,
            trackType: "住宿轨迹",
            beginDate: timer1,
            endDate:timer2
        },
        dataType: "json",
        success: function (res) {
            $(".smalltipsluguan").find(".sd_sp2").html(res.length);
            smalltipschuxing();
        }
    });
}
function smalltipschuxing() {
    $.ajax({
        url: ctx + "/track/get",
        type: "get",
        xhrFields: {
            withCredentials: true
        },
        data: {
            jobid: jobdata.jobinfo.jobid,
            trackType: "客车轨迹,火车轨迹，飞机轨迹，出入境轨迹，628轨迹",
            beginDate: timer1,
            endDate:timer2
        },
        dataType: "json",
        success: function (res) {
            $(".smalltipschuxing").find(".sd_sp2").html(res.length);
            smalltipsshangwang();
        }
    });
}
function smalltipsshangwang() {
    $.ajax({
        url: ctx + "/track/get",
        type: "get",
        xhrFields: {
            withCredentials: true
        },
        data: {
            jobid: jobdata.jobinfo.jobid,
            trackType: "网吧轨迹",
            beginDate: timer1,
            endDate:timer2
        },
        dataType: "json",
        success: function (res) {
            $(".smalltipsshangwang").find(".sd_sp2").html(res.length);
        }
    });
}