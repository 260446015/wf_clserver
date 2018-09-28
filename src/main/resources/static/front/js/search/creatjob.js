
//创建查询任务
$(function () {
    var insearch = window.location.search.split("?");

    var searchresourceArr = JSON.parse(sessionStorage.getItem("clgapingtai"));

    clga.searchbegin = function ($valuda,turntype,oiscase) {
        var resourceArr = [];
        var $wordtype = "other";
        var $valu = $valuda;
        if($valu==""){
            return
        }
        var reg1 = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
        var reg2 = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
        var reg3 = /^1[3|4|5|7|8][0-9]{9}$/;
        var reg4 = /^[0-9]*$/;
        if (reg1.test($valu)) {
            $wordtype = "idcard";
        }else if(reg2.test($valu)){
            $wordtype = "car";
            turntype = 4;
        }else if(reg3.test($valu)){
            $wordtype = "mobile";
            turntype = 4;
        }else{
            if(reg4.test($valu)){
                turntype = 4;
            }else{
                turntype = 5;
            }
        }
        if(searchresourceArr){
            resourceArr = [];
            $.each(searchresourceArr,function (i,item) {
                resourceArr.push(item.id);
            });
        }
        var data = {
            'word':$valu,
            'wordtype':$wordtype,
            'jobtype':'1',
            'resources':resourceArr,
            'isCache':oiscase
        };
        $.ajax({
            url: ctx + "createJob",
            type: "post",
            xhrFields: {
                withCredentials: true
            },
            contentType:'application/json',
            data: JSON.stringify(data),
            success: function (res) {
                sessionStorage.setItem("jobinfo",JSON.stringify(res.data));
                if(res.data.resources){
                    sessionStorage.setItem("jobinforesouse",JSON.stringify(res.data.resources));
                }
                callLocal(res.data.jobinfo,res.data.resources,turntype);
            }
        });
    };
    function callLocal(jobinfo,resources,turntype){
        jobinfo.resources = resources;
        var job = {"action":"createjob","data":jobinfo};
        var pachong = JSON.parse(sessionStorage.getItem("clgauser")).ip;
        $.ajax({
            url: "http://localhost:19797",
            type: "post",
            data: JSON.stringify(job),
            dataType:"json",
            success: function (res) {
                switch(turntype){
                    case 1:
                        window.location = "search_list.html";
                        break;
                    case 2:
                        window.location = "search_detial.html";
                        break;
                    case 3:
                        window.location = "search_detial.html";
                        break;
                    case 4:
                        window.location = "search_phone.html";
                        break;
                    default:
                        window.location = "search_photo.html";
                        break;
                }
            }
        });
    }
    if(insearch.length>1){
        setTimeout(function () {
            clga.searchbegin(insearch[1],3,true);
        },100);
    }
});

