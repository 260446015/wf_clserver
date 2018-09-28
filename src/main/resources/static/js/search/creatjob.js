
//创建查询任务
$(function () {
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
                console.log(res);
                sessionStorage.setItem("jobinfo",JSON.stringify(res.data));
                if(res.data.resources){
                    sessionStorage.setItem("jobinforesouse",JSON.stringify(res.data.resources));
                }
                callLocal(res.data.jobinfo,res.data.resources,turntype);
            }
        });
    }
    function callLocal(jobinfo,resources,turntype){
        jobinfo.resources = resources;
        var job = {"action":"createjob","data":jobinfo}
        var pachong = JSON.parse(sessionStorage.getItem("clgauser")).ip;
        console.log(job)
        $.ajax({
            // url: "http://"+pachong+":19797",
            url: "http://localhost:19797",
            //url: "http://10.52.220.87:19797",
            type: "post",
            data: JSON.stringify(job),
            dataType:"json",
            success: function (res) {
                console.log(res);
                if(turntype==1){
                    window.location = "search_list.html";
                }else{
                    window.location = "search_detial.html";
                }
            }
        });
    }

});