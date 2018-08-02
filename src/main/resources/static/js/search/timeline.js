

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
})
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
    // layer.tips($(this).attr("data-href"), $(this), {
    //     tips: [1, '#3595cc'],
    //     area: ['560px', '350px'],
    //     guide:"1",
    //     more:true,
    //     isGuide:true
    // });
    layer.open({
        type:"1",
        shadow:false,
        title:false,
        content:$(this).attr("data-href"),
    })
});