

function linjuguanxi() {
    $(".sx_linju").find("img").css("height", liwidth);
    $(".yun_chengji").find("img").css("height", liwidth);
    $(".yun_dingpiao").find("img").css("height", liwidth);
    $(".yun_chengche").find("img").css("height", liwidth);
}

layui.use('element');
var element = layui.element;
element.on('nav(daohang)', function (elem) {
    var $index = elem.context.dataset.href;
    if (!$index) {
        return
    }
    var loadingi = layer.load(1, {
        shade: [0.1, '#000'] //0.1透明度的白色背景
    });
    setTimeout(function () {
        layer.close(loadingi)
    }, 400)
    //console.log($index)
    $(".sd_wrapbox").find(".licontent").eq($index).fadeIn().siblings().hide();
    if ($index == 3) {
        linjuguanxi();//邻居关系对其
    }
    if ($index == 7) {
        linjuguanxi();
        getguiji();
    }
    sessionStorage.setItem("$index", $index);
});

//xuanxiangzhanshi();//控制选项卡的显示
function xuanxiangzhanshi() {
    var indexnum = sessionStorage.getItem("$index");
    if (indexnum) {
        var numbli;
        switch (parseInt(indexnum)) {
            case 0:
                numbli = 0;
                break;
            case 1:
                numbli = 1;
                break;
            case 2:
                numbli = 2;
                break;
            case 3:
                numbli = 3;
                break;
            case 4:
                numbli = 4;
                break;
            case 5:
                numbli = 5;
                break;
            case 6:
                numbli = 5;
                break;
            case 7:
                numbli = 5;
                break;
            case 8:
                numbli = 6;
                break;
            case 9:
                numbli = 7;
                break;
            case 10:
                numbli = 8;
                break;
            case 11:
                numbli = 9;
                break;
            case 12:
                numbli = 10;
                break;
            default:
                numbli = 12;
                break;
        }
        $(".layui-nav").find("li").eq(numbli).addClass("layui-this").siblings().removeClass("layui-this");
        $(".sd_wrapbox").find(".licontent").eq(indexnum).fadeIn().siblings().hide();
        if (numbli == 3) {
            linjuguanxi();//邻居关系对其
        }
    } else {
        $(".layui-nav").find("li").eq(0).addClass("layui-this").siblings().removeClass("layui-this");
        $(".sd_wrapbox").find(".licontent").eq(0).fadeIn().siblings().hide();
    }
}

wupin();

function wupin() {
    //物品-详细信息
    $(".sw_ul").on("click", ".swxq_1", function () {
        if ($(this).attr("data-href") == "true") {
            $(this).parent().parent().find(".sw_div2").slideDown();
            $(this).attr("data-href", "false");
        } else {
            $(this).parent().parent().find(".sw_div2").slideUp();
            $(this).attr("data-href", "true");
        }
    });
    //物品-轨迹
    $(".sw_ul").on("click", ".swxq_2", function () {
        if ($(this).attr("data-href") == "true") {
            $(this).parent().parent().find(".sw_div3").slideDown();
            $(this).attr("data-href", "false");
        } else {
            $(this).parent().parent().find(".sw_div3").slideUp();
            $(this).attr("data-href", "true");
        }
    });
}

layui.use('laydate');
var laydate = layui.laydate;
//执行一个laydate实例
//开始时间
laydate.render({
    elem: '#test1' //指定元素
    ,type:'datetime'
    ,theme:'#0f8fe0'
    ,range:true
});

//下拉框
$(".sl_clickbtn").click(function (e) {
    e.preventDefault();
    if ($(this).attr("data-href") == "true") {
        $(".sl_selectcon").show();
        $(this).attr("data-href", "false");
    } else {
        $(".sl_selectcon").hide();
        $(this).attr("data-href", "true");
    }
});
//封装下拉框逻辑
$(".sl_selectcon li").click(function () {
    var $this = $(this).find("span");
    if ($this.attr("data-code") == "9") {
        if ($this.attr("data-href") == "false") {
            $(".sl_selectcon li").find("span")
                .removeClass("layui-icon layui-icon-ok sl_selcheckblue")
                .attr("data-href", false);
            $this.addClass("layui-icon layui-icon-ok sl_selcheckblue");
            $this.attr("data-href", true);
        } else {
            $this.removeClass("layui-icon layui-icon-ok sl_selcheckblue");
            $this.attr("data-href", false);
        }
    } else {
        $(".sl_selectcon").find(".quanbu_daochu").find("span")
            .removeClass("layui-icon layui-icon-ok sl_selcheckblue")
            .attr("data-href", false);
        if ($this.attr("data-href") == "false") {
            $this.addClass("layui-icon layui-icon-ok sl_selcheckblue");
            $this.attr("data-href", true);
        } else {
            $this.removeClass("layui-icon layui-icon-ok sl_selcheckblue");
            $this.attr("data-href", false);
        }
    }
});
//导出逻辑
$(".daochubtndachu").click(function () {
    $(".sd_wrapbox").find(".licontent").hide();
    var codenum;
    var codenumlist = [];
    $(".sl_selectcon").find(".sl_selcheckblue").each(function (i, item) {
        if (parseInt(item.getAttribute("data-code")) == 5) {
            for (codenum = 5; codenum < 8; codenum++) {
                $(".sd_wrapbox").find(".licontent").eq(codenum).show();
                codenumlist.push(codenum);
            }
        } else {
            switch (parseInt(item.getAttribute("data-code"))) {
                case 0:
                    codenum = 0;
                    break;
                case 1:
                    codenum = 1;
                    break;
                case 2:
                    codenum = 2;
                    break;
                case 3:
                    codenum = 3;
                    break;
                case 4:
                    codenum = 4;
                    break;
                case 5:
                    codenum = 5;
                    break;
                case 6:
                    codenum = 8;
                    break;
                case 7:
                    codenum = 9;
                    break;
                case 8:
                    codenum = 10;
                    break;
                case 9:
                    codenum = 11;
                    break;
                default:
                    codenum = 12;
                    break;
            }

            if (codenum == 3) {
                linjuguanxi();//邻居关系对其
            }
            if (codenum == 11) {
                $(".sd_wrapbox").find(".licontent").show();
            } else {
                $(".sd_wrapbox").find(".licontent").eq(codenum).show();
            }
            codenumlist.push(codenum);
        }
    });
    if (codenumlist.length == 0) {
        xuanxiangzhanshi();
        return layer.msg('请点击左侧导出按钮，选择您要导出的模块');
    }
    $(".sy_top").hide();
    $(".sd_top").css("margin-top", 0);
    $(".sl_selectcon li").find("span")
        .removeClass("layui-icon layui-icon-ok sl_selcheckblue")
        .attr("data-href", false);//清除选中
    $(".sl_selectcon").hide();
    window.print();
    $(".sy_top").show();
    $(".sd_top").css("margin-top", "72px");
});