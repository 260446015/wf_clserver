
//创建查询任务
$(function () {
    var begin1 = false;
    var begin2 = false;
    var searchresourceArr = JSON.parse(sessionStorage.getItem("clgapingtai"));
    clga.searchbegin1 = function ($valuda,turntype,oiscase) {
        var resourceArr = [];
        var $wordtype = "other";
        var $valu = $valuda;
        if($valu==""){
            return
        }
        var reg1 = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
        var reg2 = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
        var reg3 = /^1[3|4|5|7|8][0-9]{9}$/;
        if (reg1.test($valu)) {
            $wordtype = "idcard";
        }else{
            if (reg2.test($valu)) {
                $wordtype = "car";
            }else{
                if (reg3.test($valu)) {
                    $wordtype = "mobile";
                }
            }
        }
        if(searchresourceArr){
            resourceArr = [];
            $.each(searchresourceArr,function (i,item) {
                resourceArr.push(item.id);
            });
        }
        console.log(resourceArr)
        // var resourceArr = ["bxz","jtlhy","lnxz","lnzhxx","sis","qdgacjxt","qgjdc","qgwffzry","qgxdry","qgztry","sdgayjs","sdhl","sdjz","sdxz","ytslgzagl","yunsou","gajgjls"];
        var data = {
            'word':$valu,
            'wordtype':$wordtype,
            'jobtype':'1',
            'resources':resourceArr,
            'isCache':oiscase
        }
        $.ajax({
            url: ctx + "createJob",
            type: "post",
            xhrFields: {
                withCredentials: true
            },
            contentType:'application/json',
            data: JSON.stringify(data),
            success: function (res) {
                sessionStorage.setItem("jobinfo1",JSON.stringify(res.data));
                callLocal1(res.data.jobinfo,res.data.resources,turntype);
            }
        });
    }
    function callLocal1(jobinfo,resources,turntype){
        jobinfo.resources = resources;
        var job = {"action":"createjob","data":jobinfo}
        var pachong = JSON.parse(sessionStorage.getItem("clgauser")).ip;
        $.ajax({
            // url: "http://"+pachong+":19797",
            //url: "http://10.52.220.87:19797",
            url: "http://localhost:19797",
            type: "post",
            data: JSON.stringify(job),
            dataType:"json",
            success: function (res) {
                console.log(res);
                begin2 = true;
                var $index = $(".as_ul1").find(".as_ulliact").attr("data-href");
                if(begin1){
                    window.location = "association_detial.html?"+$index;
                }
            }
        });
    }


    clga.searchbegin2 = function ($valuda,turntype,oiscase) {
        var resourceArr = [];
        var $wordtype = "other";
        var $valu = $valuda;
        if($valu==""){
            return
        }
        var reg1 = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
        var reg2 = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
        var reg3 = /^1[3|4|5|7|8][0-9]{9}$/;
        if (reg1.test($valu)) {
            $wordtype = "idcard";
        }else{
            if (reg2.test($valu)) {
                $wordtype = "car";
            }else{
                if (reg3.test($valu)) {
                    $wordtype = "mobile";
                }
            }
        }
        if(searchresourceArr){
            resourceArr = [];
            $.each(searchresourceArr,function (i,item) {
                resourceArr.push(item.id);
            });
        }
        console.log(resourceArr)
        // var resourceArr = ["bxz","jtlhy","lnxz","lnzhxx","sis","qdgacjxt","qgjdc","qgwffzry","qgxdry","qgztry","sdgayjs","sdhl","sdjz","sdxz","ytslgzagl","yunsou","gajgjls"];
        var data = {
            'word':$valu,
            'wordtype':$wordtype,
            'jobtype':'1',
            'resources':resourceArr,
            'isCache':oiscase
        }
        $.ajax({
            url: ctx + "createJob",
            type: "post",
            xhrFields: {
                withCredentials: true
            },
            contentType:'application/json',
            data: JSON.stringify(data),
            success: function (res) {
                sessionStorage.setItem("jobinfo2",JSON.stringify(res.data));
                callLocal2(res.data.jobinfo,res.data.resources,turntype);
            }
        });
    }
    function callLocal2(jobinfo,resources,turntype){
        jobinfo.resources = resources;
        var job = {"action":"createjob","data":jobinfo}
        var pachong = JSON.parse(sessionStorage.getItem("clgauser")).ip;
        $.ajax({
            // url: "http://"+pachong+":19797",
            //url: "http://10.52.220.87:19797",
            type: "post",
            data: JSON.stringify(job),
            dataType:"json",
            success: function (res) {
                console.log(res)
                begin1 = true;
                var $index = $(".as_ul1").find(".as_ulliact").attr("data-href");
                if(begin2){
                    window.location = "association_detial.html?0";
                }
            }
        });
    }


});