/*详情展示页面*/
var jobdata = JSON.parse(sessionStorage.getItem("jobinfo"));
var jobetype = jobdata.jobinfo.wordtype;
var infofrom;
var imglist = [];
layui.use(['laydate', 'laypage', 'upload','form']);
var laypage = layui.laypage;
//gajgjls-公安监管拘留所警务工作平台
function setDatagajgjls(residdata) {
    infofrom = "公安监管拘留所警务工作平台"
    $(".biaoqiandetial").append('<li class="sd_red">拘留所</li>');
    var reaData = JSON.parse(residdata).data;
    $.each(reaData, function (i, item) {
        var lisiisis = item.label;
        switch (lisiisis) {
            case "人员基本信息":
                juliu_jiben(item.data);
                break;
            case "拘留信息":
                juliu_xinxi(item.data);
                break;
            case "身体情况":
                juliu_zhuang(item.data);
                break;
            default:
                break;
        }
    });
    //人员基本信息
    function juliu_jiben(juliudata) {
        var colomdata = juliudata.data[0];
        var odata = juliudata.column;
        var list = '<table cellpadding="0" cellspacing="2" class="sj_table2 sxtips" data-href="'+infofrom+'">' +
            '    <tr class="sj_firtr">' +
            '<td colspan="9" style="background: transparent;">拘留基本信息</td>' +
            '    </tr>' +
            '    <tbody>' +
            '    <tr>' +
            '<td>姓名</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("姓名")]||"")+'</td>' +
            '<td>别名</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("别名")]||"")+'</td>' +
            '<td>人员编号</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("人员编号")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>性别</td>' +
            '<td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("性别")]||"")+'</td>' +
            '<td>出生日期</td>' +
            '<td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("出生日期")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>证件号</td>' +
            '<td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("证件号")]||"")+'</td>' +
            '<td>民族</td>' +
            '<td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("民族")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>婚姻状况</td>' +
            '<td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("婚姻状况")]||"")+'</td>' +
            '<td>入所日期</td>' +
            '<td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("入所日期")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>户籍地详址</td>' +
            '<td colspan="8" class="sk_nr">'+(colomdata[odata.indexOf("户籍地详址")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>正面照</td>' +
            '<td colspan="2" class="sk_nr juliu_img"><img src="'+(colomdata[odata.indexOf("正面照")]||"")+'" alt="" onerror="clga.whenoerron(this)"></td>' +
            '<td>左侧照</td>' +
            '<td colspan="2" class="sk_nr juliu_img"><img src="'+(colomdata[odata.indexOf("左侧照")]||"")+'" alt="" onerror="clga.whenoerron(this)"></td>' +
            '<td>右侧照</td>' +
            '<td colspan="2" class="sk_nr juliu_img"><img src="'+(colomdata[odata.indexOf("右侧照")]||"")+'" alt="" onerror="clga.whenoerron(this)"></td>' +
            '    </tr>' +
            '    </tbody>' +
            '</table>';
        $(".juliu_juliu").append(list);
        imglist.push({
            "alt": "公安监管拘留所警务工作平台正面照",
            "pid": "", //图片id
            "src": (colomdata[odata.indexOf("正面照")]||""), //原图地址
            "thumb": "" //缩略图地址
        });
        imglist.push({
            "alt": "公安监管拘留所警务工作平台左侧照",
            "pid": "", //图片id
            "src": (colomdata[odata.indexOf("左侧照")]||""), //原图地址
            "thumb": "" //缩略图地址
        });
        imglist.push({
            "alt": "公安监管拘留所警务工作平台右侧照",
            "pid": "", //图片id
            "src": (colomdata[odata.indexOf("右侧照")]||""), //原图地址
            "thumb": "" //缩略图地址
        });
    }
    //拘留信息
    function juliu_xinxi(juliudata) {
        var colomdata = juliudata.data[0];
        var odata = juliudata.column;
        var list1 = '<table cellpadding="0" cellspacing="2" class="sj_table2 sxtips" data-href="'+infofrom+'">' +
            '    <tr class="sj_firtr">' +
            '<td colspan="9" style="background: transparent;">拘留信息</td>' +
            '    </tr>' +
            '    <tbody>' +
            '    <tr>' +
            '<td>拘室号</td>' +
            '<td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("拘室号")]||"")+'</td>' +
            '<td>收据凭证</td>' +
            '<td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("收据凭证")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>入所文书号</td>' +
            '<td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("入所文书号")]||"")+'</td>' +
            '<td>入所原因</td>' +
            '<td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("入所原因")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>主要案由</td>' +
            '<td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("主要案由")]||"")+'</td>' +
            '<td>成员类型</td>' +
            '<td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("成员类型")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>从案案由</td>' +
            '<td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("从案案由")]||"")+'</td>' +
            '<td>拘留决定机关</td>' +
            '<td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("拘留决定机关")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>入所日期</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("入所日期")]||"")+'</td>' +
            '<td>拘押期限</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("拘押期限")]||"")+'</td>' +
            '<td>拘留天数</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("拘留天数")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>办案单位</td>' +
            '<td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("办案单位")]||"")+'</td>' +
            '<td>办案单位类型</td>' +
            '<td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("办案单位类型")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>办案人</td>' +
            '<td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("办案人")]||"")+'</td>' +
            '<td>办案人电话</td>' +
            '<td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("办案人电话")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>裁决书号</td>' +
            '<td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("裁决书号")]||"")+'</td>' +
            '<td>口音特点</td>' +
            '<td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("口音特点")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>危险等级</td>' +
            '<td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("危险等级")]||"")+'</td>' +
            '<td>健康状况</td>' +
            '<td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("健康状况")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>犯罪经历</td>' +
            '<td colspan="8" class="sk_nr" style="width: 85%;">'+(colomdata[odata.indexOf("犯罪经历")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>情况描述</td>' +
            '<td colspan="8" class="sk_nr" style="width: 85%;">'+(colomdata[odata.indexOf("情况描述")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>出所日期</td>' +
            '<td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("出所日期")]||"")+'</td>' +
            '<td>出所原因</td>' +
            '<td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("出所原因")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>出所去向</td>' +
            '<td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("出所去向")]||"")+'</td>' +
            '<td>备注</td>' +
            '<td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("备注")]||"")+'</td>' +
            '    </tr>' +
            '    </tbody>' +
            '</table>';
        $(".juliu_juliu").append(list1);
        if(colomdata[odata.indexOf("口音特点")]){
            $(".de_ky").html(colomdata[odata.indexOf("口音特点")]);
        }
    }
    //身体情况
    function juliu_zhuang(juliudata) {
        var colomdata = juliudata.data[0];
        var odata = juliudata.column;
        if(colomdata[odata.indexOf("身高(cm)")]){
            $(".de_tx").html(colomdata[odata.indexOf("身高(cm)")]);
        }
        if(colomdata[odata.indexOf("体重(kg)")]){
            $(".de_fs").html(colomdata[odata.indexOf("体重(kg)")]);
        }
        if(colomdata[odata.indexOf("血型")]){
            $(".de_js").html(colomdata[odata.indexOf("血型")]);
        }
        if(colomdata[odata.indexOf("体貌特征")]){
            $(".de_dna").html(colomdata[odata.indexOf("体貌特征")]);
        }
        if(colomdata[odata.indexOf("表达能力")]){
            $(".de_zj").html(colomdata[odata.indexOf("表达能力")]);
        }
    }
}

//gajgkss-公安监管看守所警务工作平台
function setDatagajgkss(residdata) {
    infofrom = "公安监管看守所警务工作平台";
    $(".biaoqiandetial").append('<li class="sd_red">看守所</li>');
    var reaData = JSON.parse(residdata).data;
    $.each(reaData, function (i, item) {
        var lisiisis = item.label;
        switch (lisiisis) {
            case "基本信息":
                juliu_jiben(item.data);
                break;
            case "身体状况":
                juliu_zhuangkuang(item.data);
                break;
            case "同案人员":
                juliu_tongan(item.data);
                break;
            case "环节变动":
                juliu_huanjie(item.data);
                break;
            case "判决情况":
                juliu_panduan(item.data);
                break;
            default:
                break;
        }
    });
    //人员基本信息
    function juliu_jiben(juliudata) {
        var colomdata = juliudata.data[0];
        var odata = juliudata.column;
        var list = '<table cellpadding="0" cellspacing="2" class="sj_table2 sxtips" data-href="'+infofrom+'">' +
            '    <tr class="sj_firtr">' +
            '<td colspan="9" style="background: transparent;">基本信息</td>' +
            '    </tr>' +
            '    <tbody>' +
            '    <tr>' +
            '<td>入所日期</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("入所日期")]||"")+'</td>' +
            '<td>别名</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("别 名")]||"")+'</td>' +
            '<td>人员编号</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("人员编号")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>性别</td>' +
            '<td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("性 别")]||"")+'</td>' +
            '<td>出生日期</td>' +
            '<td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("出生日期")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>证件号</td>' +
            '<td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("证件号")]||"")+'</td>' +
            '<td>民族</td>' +
            '<td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("民 族")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>婚姻状况</td>' +
            '<td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("婚姻状况")]||"")+'</td>' +
            '<td>入所日期</td>' +
            '<td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("入所日期")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>户籍地详址</td>' +
            '<td colspan="8" class="sk_nr">'+(colomdata[odata.indexOf("户籍地详址")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>正面照</td>' +
            '<td colspan="2" class="sk_nr juliu_img"><img src="'+(colomdata[odata.indexOf("正面照")]||"")+'" alt="" onerror="clga.whenoerron(this)"></td>' +
            '<td>左侧照</td>' +
            '<td colspan="2" class="sk_nr juliu_img"><img src="'+(colomdata[odata.indexOf("左侧照")]||"")+'" alt="" onerror="clga.whenoerron(this)"></td>' +
            '<td>右侧照</td>' +
            '<td colspan="2" class="sk_nr juliu_img"><img src="'+(colomdata[odata.indexOf("右侧照")]||"")+'" alt="" onerror="clga.whenoerron(this)"></td>' +
            '    </tr>' +
            '    </tbody>' +
            '</table>';
        imglist.push({
            "alt": "公安监管看守所警务工作平台正面照",
            "pid": "", //图片id
            "src": (colomdata[odata.indexOf("正面照")]||""), //原图地址
            "thumb": "" //缩略图地址
        });
        imglist.push({
            "alt": "公安监管看守所警务工作平台左侧照",
            "pid": "", //图片id
            "src": (colomdata[odata.indexOf("左侧照")]||""), //原图地址
            "thumb": "" //缩略图地址
        });
        imglist.push({
            "alt": "公安监管看守所警务工作平台右侧照",
            "pid": "", //图片id
            "src": (colomdata[odata.indexOf("右侧照")]||""), //原图地址
            "thumb": "" //缩略图地址
        });
        $(".kanshou_kanshou").append(list);
    }
    //身体状况
    function juliu_zhuangkuang(juliudata) {
        var colomdata = juliudata.data[0];
        var odata = juliudata.column;
        if(colomdata[odata.indexOf("身 高")]){
            $(".de_tx").html(colomdata[odata.indexOf("身 高")]);
        }
        if(colomdata[odata.indexOf("体 重")]){
            $(".de_fs").html(colomdata[odata.indexOf("体 重")]);
        }
        if(colomdata[odata.indexOf("血 型")]){
            $(".de_js").html(colomdata[odata.indexOf("血 型")]);
        }
        if(colomdata[odata.indexOf("体貌特征")]){
            $(".de_dna").html(colomdata[odata.indexOf("体貌特征")]);
        }
        if(colomdata[odata.indexOf("表达能力")]){
            $(".de_zj").html(colomdata[odata.indexOf("表达能力")]);
        }
        var list = '<table cellpadding="0" cellspacing="2" class="sj_table2 sxtips" data-href="'+infofrom+'">' +
            '    <tr class="sj_firtr">' +
            '<td colspan="9" style="background: transparent;">身体状况</td>' +
            '    </tr>' +
            '    <tbody>' +
            '    <tr>' +
            '<td>身 高</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("身 高")]||"")+'</td>' +
            '<td>体 重</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("体 重")]||"")+'</td>' +
            '<td>足 长</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("足 长")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>体貌特征</td>' +
            '<td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("体貌特征")]||"")+'</td>' +
            '<td>血 型</td>' +
            '<td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("血 型")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>血 压</td>' +
            '<td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("血 压")]||"")+'</td>' +
            '<td>头 部</td>' +
            '<td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("头 部")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>颈 部</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("颈 部")]||"")+'</td>' +
            '<td>胸 部</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("胸 部")]||"")+'</td>' +
            '<td>腹 部</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("腹 部")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>背 部</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("背 部")]||"")+'</td>' +
            '<td>臀 部</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("臀 部")]||"")+'</td>' +
            '<td>"上 肢</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("上 肢")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>下 肢</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("下 肢")]||"")+'</td>' +
            '<td>表达能力</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("表达能力")]||"")+'</td>' +
            '<td>行走状况</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("行走状况")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>伤 势</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("伤 势")]||"")+'</td>' +
            '<td>致伤单位</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("致伤单位")]||"")+'</td>' +
            '<td>传染病</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("传染病")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>心脏病</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("心脏病")]||"")+'</td>' +
            '<td>高血压</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("高血压")]||"")+'</td>' +
            '<td>本人病史</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("本人病史")]||"")+'</td>' +
            '    </tr>' +

            '    <tr>' +
            '<td>心理测评</td>' +
            '<td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("心理测评")]||"")+'</td>' +
            '<td>疾病来历</td>' +
            '<td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("疾病来历")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>家庭病史</td>' +
            '<td colspan="8" class="sk_nr">'+(colomdata[odata.indexOf("家庭病史")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>检查人</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("检查人")]||"")+'</td>' +
            '<td>医生意见</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("医生意见")]||"")+'</td>' +
            '<td>备 注</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("备 注")]||"")+'</td>' +
            '    </tr>' +
            '    </tbody>' +
            '</table>';
        $(".kanshou_kanshou").append(list);
    }
    //同案人员
    function juliu_tongan(juliudata) {
        var list = '<table cellpadding="0" cellspacing="2" class="sj_table2 sxtips" data-href="'+infofrom+'">' +
            '    <tr class="sj_firtr">' +
            '<td colspan="9" style="background: transparent;">同案人员</td>' +
            '    </tr>' +
            '    <tbody>' +
            '    <tr>' +
            '<td class="center">同案人员</td>' +
            '<td class="center">监室号</td>' +
            '    </tr>'
        $.each(juliudata.data,function (i,item) {
            list+='    <tr>' +
                '<td class="center">'+item[0]+'</td>' +
                '<td class="center">'+item[1]+'</td>' +
                '    </tr>'
        });
        list+='    </tbody>'
            '</table>';
        $(".kanshou_kanshou").append(list);
    }
    //环节变动
    function juliu_huanjie(juliudata) {
        var list = '<table cellpadding="0" cellspacing="2" class="sj_table2 sxtips" data-href="'+infofrom+'">' +
            '    <tr class="sj_firtr">' +
            '<td colspan="9" style="background: transparent;">环节变动</td>' +
            '    </tr>' +
            '    <tbody>' +
            '    <tr>' +
            '<td class="center">变动日期</td>' +
            '<td class="center">变动环节</td>' +
            '<td class="center">办案单位</td>' +
            '<td class="center">办案人</td>' +
            '<td class="center">办案人电话</td>' +
            '<td class="center">关押期限</td>' +
            '    </tr>'
        $.each(juliudata.data,function (i,item) {
            list+='    <tr>' +
                '<td class="center">'+item[0]+'</td>' +
                '<td class="center">'+item[1]+'</td>' +
                '<td class="center">'+item[2]+'</td>' +
                '<td class="center">'+item[3]+'</td>' +
                '<td class="center">'+item[4]+'</td>' +
                '<td class="center">'+item[5]+'</td>' +
                '    </tr>'
        });
        list+='    </tbody>'
        '</table>';
        $(".kanshou_kanshou").append(list);
    }
    //判决情况
    function juliu_panduan(juliudata) {
        var list = '<table cellpadding="0" cellspacing="2" class="sj_table2 sxtips" data-href="'+infofrom+'">' +
            '    <tr class="sj_firtr">' +
            '<td colspan="9" style="background: transparent;">判决情况</td>' +
            '    </tr>' +
            '    <tbody>' +
            '    <tr>' +
            '<td class="center">判决日期</td>' +
            '<td class="center">处理结果</td>' +
            '<td class="center">判决单位</td>' +
            '<td class="center">起始日期</td>' +
            '<td class="center">终止日期</td>' +
            '<td class="center">刑期</td>' +
            '<td class="center">附加刑</td>' +
            '    </tr>'
        $.each(juliudata.data,function (i,item) {
            list+='    <tr>' +
                '<td class="center">'+item[0]+'</td>' +
                '<td class="center">'+item[1]+'</td>' +
                '<td class="center">'+item[2]+'</td>' +
                '<td class="center">'+item[3]+'</td>' +
                '<td class="center">'+item[4]+'</td>' +
                '<td class="center">'+item[5]+'</td>' +
                '<td class="center">'+item[6]+'</td>' +
                '    </tr>'
        });
        list+='    </tbody>'
        '</table>';
        $(".kanshou_kanshou").append(list);
    }

}

//jtlhy-"全国公安交通管理信息综合查询平台"
function setDatajtlhy(residdata) {
    infofrom = "全国公安交通管理信息综合查询平台";
    var reaData = JSON.parse(residdata).data;
    $.each(reaData, function (i, item) {
        var lisiisis = item.label;
        switch (lisiisis) {
            case "公安部驾驶人基本信息":
                jiaotong_jiben(item.data);
                break;
            case "公安部驾驶人详细信息":
                jiaotong_jiashiren(item.data);
                break;
            case "交通违法关联信息":
                jiaotong_weifa(item.data);
                break;
            default:
                shengfenxinxi(item.label,item.data);
                break;
        }
    });

    //公安部驾驶人基本信息
    function jiaotong_jiben(jt_data) {

    }

    //公安部驾驶人详细信息
    function jiaotong_jiashiren(jt_data) {

        //驾驶员信息
        var jiashidata = jt_data.data[0];
        var jiahsiimg = "http://ys.zyfw.ga/photo/renkou/photoSearch.do?method=allPhoto1&searchword=SFZHM:"+jiashidata[jt_data.column.indexOf("身份证明号码")]+"&order=0";
        var jiashi = '<dl class="sx_imgbox sxtips" data-href="' + infofrom + '">' +
            '<dd><img src="'+jiahsiimg+'" alt=""></dd>' +
            '<dt>' +
            '<div>';
        $.each(reaData[1].data.column, function (i, item) {
            jiashi += '<span>' + item + '：<i>' + jiashidata[i] + '</i></span>'
        });
        jiashi += '</div></dt></dl>';
        $(".sx_jiashiren").append(jiashi);
        //电话
        var phone = (jiashidata[jt_data.column.indexOf("联系电话")]||"")
        if (phone) {
            $(".sx_ppplianxi").append('<p class="sx_p1 sxtips" data-href="'+ infofrom +'"><span>手机号：' + phone + '</span><span></span></p>');
        }
    }

    //公安部驾驶人详细信息
    function jiaotong_weifa(jt_data) {
        var chedata = jt_data.data[0]
        var cheliang = '<li class="sw_li">' +
            '<ul  class="sw_ul1">' +
            '    <li class="sxtips" data-href="'+infofrom+'" style="margin: 0;">' + chedata[16] + '</li>' +
            '    <li>' + chedata[18] + '</li>' +
            '    <li class="swxq_1" data-href="true">' +
            '        <span class="iconfont icon-rwcharacter"></span>' +
            '        <span>详情</span>' +
            '    </li>' +
            '    <li  class="swxq_2" data-href="true">' +
            '        <span class="iconfont icon-rwcharacter"></span>' +
            '        <span>详情</span>' +
            '    </li>' +
            '</ul>' +
            '<div class="sw_div1 sw_div2">' + chedata[3] + '</div>' +
            '<div class="sw_div1 sw_div3">当事人：' + chedata[1] + '  &nbsp;  机动车所有人：' + chedata[19] + '  &nbsp;  罚款金额：' + chedata[4] + '  &nbsp;  处理时间：' + chedata[25] + '</div>' +
            '</li>'
        $(".cheliangbox").append(cheliang);
    }

    //其他省份判断
    function shengfenxinxi(jt_lable,jt_data) {
        var numlei = jt_lable.split("交通违法关联信息");
        if(numlei.length>1){
            console.log(jt_data)
            var odata = jt_data.column;
            $.each(jt_data.data,function (i,item) {
                var colomdata = item;
                var cheliang = '<li class="sw_li sxtips" data-href="'+jt_lable+'">' +
                    '<ul  class="sw_ul1">' +
                    '    <li style="margin: 0;width: 10%;">' + (colomdata[odata.indexOf("号牌号码")]||"") + '</li>' +
                    '    <li style="width: 12%;">' + (colomdata[odata.indexOf("号牌种类")]||"") + '</li>' +
                    '    <li style="width: 40%;">' + (colomdata[odata.indexOf("违法地址")]||"") + '</li>' +
                    '    <li style="width: 20%;">' + (colomdata[odata.indexOf("违法时间")]||"") + '</li>' +
                    '    <li style="width: 8%;">' + (colomdata[odata.indexOf("交款标记")]||"") + '</li>' +
                    '    <li class="swxq_1" data-href="true"  style="width: 10%;">' +
                    '        <span class="iconfont icon-rwcharacter"></span>' +
                    '        <span>详情</span>' +
                    '    </li>' +
                    '</ul>' +
                    '<div class="sw_div1 sw_div2" style="padding: 0 3%;clear: both;">违法行为:' + (colomdata[odata.indexOf("违法行为")]||"") + '<br/>电话:' + (colomdata[odata.indexOf("电话")]||"") + '</div>' +
                    '</li>'
                $(".weizhang_box").append(cheliang);
            });
            //电话
            var phone = (jt_data.data[0][jt_data.column.indexOf("电话")]||"")
            if (phone) {
                $(".sx_ppplianxi").append('<p class="sx_p1 sxtips" data-href="'+ infofrom +'"><span>手机号：' + phone + '</span><span></span></p>');
            }
            $(".che_weizhang").fadeIn();
        }
    }
}

//qgwffzry-"全国违法犯罪人员"
function setDataqgwffzry(residdata) {
    $(".qianke").show();
    $(".biaoqiandetial").append('<li class="sd_red">违法犯罪</li>');
    var reaData = JSON.parse(residdata).data;
    $.each(reaData, function (i, item) {
        var lisiisis = item.label;
        switch (lisiisis) {
            case "人员详细信息":
                weifa_jiben(item.data);
                break;
            case "涉案情况":
                weifa_qing(item.data);
                break;
            default:
                break;
        }
    });
    //人员详细信息
    function weifa_jiben(weifadata) {
        var colomdata = weifadata.data[0];
        var odata = weifadata.column;
        var weifa = weifadata.data[0];
        var weifali = '<tr>' +
            '<td>姓名</td>' +
            '<td class="sk_nr">'+weifa[0]+'</td>' +
            '<td>性别</td>' +
            '<td class="sk_nr">'+weifa[1]+'</td>' +
            '<td>别名</td>' +
            '<td class="sk_nr">'+weifa[2]+'</td>' +
            '<td rowspan="7" class="sk_width">' +
            '<img width="200" src="'+colomdata[odata.indexOf("照片1")]+'" alt="" onerror="clga.whenoerron(this)">'+
            '</td>' +
            '</tr>' +
            '<tr>' +
            '<td>民族</td>' +
            '<td class="sk_nr">'+weifa[3]+'</td>' +
            '<td>出生日期</td>' +
            '<td class="sk_nr">'+weifa[4]+'</td>' +
            '<td>身份证号</td>' +
            '<td class="sk_nr">'+weifa[5]+'</td>' +
            '</tr>' +
            '<tr>' +
            '<td>身高</td>' +
            '<td class="sk_nr">'+weifa[6]+'</td>' +
            '<td>足长</td>' +
            '<td class="sk_nr">'+weifa[7]+'</td>' +
            '<td>专长</td>' +
            '<td class="sk_nr">'+weifa[8]+'</td>' +
            '</tr>' +
            '<tr>' +
            '<td>体态标记</td>' +
            '<td colspan="3" class="sk_nr">'+weifa[9]+'</td>' +
            '<td>人员编号</td>' +
            '<td class="sk_nr">'+weifa[10]+'</td>' +
            '</tr>' +
            '<tr>' +
            '<td>教育程度</td>' +
            '<td colspan="3" class="sk_nr">'+weifa[11]+'</td>' +
            '<td>身份</td>' +
            '<td class="sk_nr">'+weifa[12]+'</td>' +
            '</tr>' +
            '<tr>' +
            '<td>户籍地</td>' +
            '<td colspan="3" class="sk_nr">'+weifa[13]+'</td>' +
            '<td>户籍地详情</td>' +
            '<td class="sk_nr">'+weifa[14]+'</td>' +
            '</tr>' +
            '<tr>' +
            '<td>居住地</td>' +
            '<td colspan="3" class="sk_nr">'+weifa[15]+'</td>' +
            '<td>居住地详情</td>' +
            '<td class="sk_nr">'+weifa[16]+'</td>' +
            '</tr>';
        $(".weifa_jiben").append(weifali);
    }
    //涉案情况
    function weifa_qing(weifadata){
        var weiqingda = weifadata.data[0];
        var weiqing = '<tr>' +
            '<td>入所日期</td>' +
            '<td class="sk_nr">'+weiqingda[0]+'</td>' +
            '<td>案件类别</td>' +
            '<td class="sk_nr">'+weiqingda[1]+'</td>' +
            '<td>入所原因</td>' +
            '<td class="sk_nr">'+weiqingda[2]+'</td>' +
            '<td>办案单位</td>' +
            '<td class="sk_nr">'+weiqingda[3]+'</td>' +
            '</tr>' +
            '<tr>' +
            '<td>刑期</td>' +
            '<td class="sk_nr">'+weiqingda[4]+'</td>' +
            '<td>司法处理结果</td>' +
            '<td class="sk_nr">'+weiqingda[5]+'</td>' +
            '<td>法律文书号</td>' +
            '<td class="sk_nr">'+weiqingda[6]+'</td>' +
            '<td>处所原因</td>' +
            '<td class="sk_nr">'+weiqingda[7]+'</td>' +
            '</tr>' +
            '<tr>' +
            '<td>处所日期</td>' +
            '<td colspan="3" class="sk_nr">'+weiqingda[8]+'</td>' +
            '<td>出所去向</td>' +
            '<td colspan="3" class="sk_nr">'+weiqingda[9]+'</td>' +
            '</tr>' +
            '<tr>' +
            '<td>案情简要</td>' +
            '<td colspan="7" class="sk_nr">'+weiqingda[10]+'</td>' +
            '</tr>';
        $(".weifa_qingk").append(weiqing);
    }
}

//qgxdry-"全国吸毒人员"
function setDataqgxdry(residdata) {
    $(".biaoqiandetial").append('<li class="sd_red">吸毒</li>');
    $(".xiduxianshi").show();
    infofrom = "全国吸毒人员";
    var reaData = JSON.parse(residdata).data;
    $.each(reaData, function (i, item) {
        var lisiisis = item.label;
        switch (lisiisis) {
            case "基本信息":
                xidu_jiben(item.data);
                break;
            case "发现情况":
                xidu_zhuangkuangf(item.data);
                break;
            case "管控状态":
                xidu_guankong(item.data);
                break;
            case "就业安置记录":
                xidu_jieye(item.data);
                break;
            default:
                break;
        }
    });
    //基本信息
    function xidu_jiben(xududata) {
        var colomdata = xududata.data[0];
        var odata = xududata.column;
        var xd_mes = xududata.data[0];
        var xd_jiben = '<tr>' +
            '    <td>姓名</td>' +
            '    <td class="sk_nr">' + (colomdata[odata.indexOf("姓名")]||"") + '</td>' +
            '    <td>绰号/别名</td>' +
            '    <td class="sk_nr">' +(colomdata[odata.indexOf("绰号/别名")]||"") + '</td>' +
            '    <td>性别</td>' +
            '    <td class="sk_nr">' + (colomdata[odata.indexOf("性别")]||"") + '</td>' +
            '    <td rowspan="7" class="sk_width">' +
            '        <img style="width: 200px;" src="'+colomdata[odata.indexOf("照片")]+'" alt="" onerror="clga.whenoerron(this)">' +
            '    </td>' +
            '</tr>' +
            '<tr>' +
            '    <td>民族</td>' +
            '    <td class="sk_nr">' + (colomdata[odata.indexOf("民族")]||"") + '</td>' +
            '    <td>出生日期</td>' +
            '    <td class="sk_nr">' + (colomdata[odata.indexOf("出生日期")]||"") + '</td>' +
            '    <td>身高</td>' +
            '    <td class="sk_nr">' + (colomdata[odata.indexOf("身高")]||"") + '</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>国籍</td>' +
            '    <td class="sk_nr">' +(colomdata[odata.indexOf("国籍")]||"")+ '</td>' +
            '    <td>证件类型</td>' +
            '    <td class="sk_nr">' + (colomdata[odata.indexOf("证件类型")]||"") + '</td>' +
            '    <td>证件号码</td>' +
            '    <td class="sk_nr">' + (colomdata[odata.indexOf("证件号码")]||"") + '</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>婚姻状况</td>' +
            '    <td class="sk_nr">' + (colomdata[odata.indexOf("婚姻状况")]||"") + '</td>' +
            '    <td>文化程度</td>' +
            '    <td class="sk_nr">' + (colomdata[odata.indexOf("文化程度")]||"") + '</td>' +
            '    <td>从业状况</td>' +
            '    <td class="sk_nr">' +(colomdata[odata.indexOf("从业状况")]||"") + '</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>指纹编号</td>' +
            '    <td class="sk_nr">' + (colomdata[odata.indexOf("指纹编号")]||"")+ '</td>' +
            '    <td>DNA编号</td>' +
            '    <td colspan="3" class="sk_nr">' + (colomdata[odata.indexOf("DNA编号")]||"") + '</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>户籍地</td>' +
            '    <td colspan="3" class="sk_nr">' + (colomdata[odata.indexOf("户籍地")]||"") + '</td>' +
            '    <td>户籍地详情</td>' +
            '    <td class="sk_nr">' + (colomdata[odata.indexOf("户籍地详情")]||"") + '</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>居住地</td>' +
            '    <td colspan="3" class="sk_nr">' + (colomdata[odata.indexOf("居住地")]||"") + '</td>' +
            '    <td>居住地详情</td>' +
            '    <td class="sk_nr">' + (colomdata[odata.indexOf("居住地详情")]||"") + '</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>户籍地派出所</td>' +
            '    <td colspan="3" class="sk_nr">' + (colomdata[odata.indexOf("户籍地派出所")]||"") + '</td>' +
            '    <td>居住地派出所</td>' +
            '    <td colspan="2" class="sk_nr">' + (colomdata[odata.indexOf("居住地派出所")]||"") + '</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>工作单位</td>' +
            '    <td colspan="3" class="sk_nr">' + (colomdata[odata.indexOf("工作单位")]||"") + '</td>' +
            '    <td>吸毒人员来源</td>' +
            '    <td colspan="2" class="sk_nr">' + (colomdata[odata.indexOf("吸毒人员来源")]||"") + '</td>' +
            '</tr>';
        $(".xidu_jiben").append(xd_jiben);
    }

    //发现情况
    function xidu_zhuangkuangf(xududata) {
        var xd_qing = xududata.data[0];
        var xidu_qing = '<tr>' +
            '    <td>初次发现单位</td>' +
            '    <td colspan="2" class="sk_nr">' + xd_qing[0] + '</td>' +
            '    <td>初次发现日期</td>' +
            '    <td colspan="2" class="sk_nr">' + xd_qing[1] + '</td>' +
            '    <td>初次录入单位</td>' +
            '    <td colspan="2" class="sk_nr">' + xd_qing[2] + '</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>脱失次数</td>' +
            '    <td colspan="2" class="sk_nr">' + xd_qing[3] + '</td>' +
            '    <td>滥用毒品优先级</td>' +
            '    <td colspan="5" class="sk_nr">' + xd_qing[4] + '</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>滥用毒品种类</td>' +
            '    <td colspan="5" class="sk_nr">' + xd_qing[5] + '</td>' +
            '    <td>初次录入日期</td>' +
            '    <td colspan="2" class="sk_nr">' + xd_qing[6] + '</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>当前管控状态</td>' +
            '    <td colspan="2" class="sk_nr">' + xd_qing[7] + '</td>' +
            '    <td>当前管控记录</td>' +
            '    <td colspan="5" class="sk_nr">' + xd_qing[8] + '</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>当前管控地区</td>' +
            '    <td colspan="2" class="sk_nr">' + xd_qing[9] + '</td>' +
            '    <td>当前管控填表单位</td>' +
            '    <td colspan="5" class="sk_nr">' + xd_qing[10] + '</td>' +
            '</tr>';
        $(".xidu_qingkuang").append(xidu_qing);
    }

    //管控状态
    function xidu_guankong(xududata) {
        $(".xidu_zhuang").empty();
        $.each(xududata.data, function (i, item) {
            var xidu_zhuan = '<tr style="text-align: center;">' +
                '<td class="sk_nr">' + item[0] + '</td>' +
                '<td class="sk_nr">' + item[1] + '</td>' +
                '<td class="sk_nr">' + item[2] + '</td>' +
                '<td class="sk_nr">' + item[3] + '</td>' +
                '<td class="sk_nr">' + item[4] + '</td>' +
                '<td class="sk_nr">' + item[5] + '</td>' +
                '<td class="sk_nr">' + item[6] + '</td>' +
                '<td class="sk_nr">' + item[7] + '</td>' +
                '</tr>';
            $(".xidu_zhuang").append(xidu_zhuan);
        });
    }

    //就业安置记录
    function xidu_jieye(xududata) {

    }
}

//qgztry-"全国在逃人员"
function setDataqgztry(residdata) {
    infofrom = "全国在逃人员";
    var reaData = JSON.parse(residdata).data;
    $.each(reaData, function (i, item) {
        var lisiisis = item.label;
        switch (lisiisis) {
            case "在逃查询":
                zaitao_jiben(item.data);
                break;
            case "照片":
                zaitao_zhaopian(item.data);
                break;
            default:
                break;
        }
    });
    //在逃查询
    function zaitao_jiben(zt_data) {
        $(".biaoqiandetial").append('<li class="sd_red">在逃</li>');
        var colomdata = zt_data.data[0];
        var odata = zt_data.column;
        var zaitaolist = '<table cellpadding="0" cellspacing="2" class="sj_table2 sxtips" data-href="' + infofrom + '">' +
            '<tr class="sj_firtr">' +
            '    <td colspan="10" style="background: transparent;">人员犯罪信息</td>' +
            '</tr>' +
            '<tbody>' +
            '<tr>' +
            '    <td>在逃人员编号</td>' +
            '    <td colspan="8" class="sk_nr">'+(colomdata[odata.indexOf("在逃人员编号")]||"")+'</td>' +
            '    <td rowspan="7" class="sk_width">' +
            '        <img class="zaitao_imgge" style="width: 200px;" src="" alt="" onerror="clga.whenoerron(this)">' +
            '    </td>' +
            '</tr>' +
            '<tr>' +
            '    <td>姓名</td>' +
            '    <td class="sk_nr" colspan="3">'+(colomdata[odata.indexOf("姓名")]||"")+'</td>' +
            '    <td>曾用名/别名绰号</td>' +
            '    <td class="sk_nr" colspan="3">'+(colomdata[odata.indexOf("曾用名/别名绰号")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>性别</td>' +
            '    <td class="sk_nr" colspan="3">'+(colomdata[odata.indexOf("性别")]||"")+'</td>' +
            '    <td>出生日期</td>' +
            '    <td class="sk_nr" colspan="3">'+(colomdata[odata.indexOf("出生日期")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>证件</td>' +
            '    <td class="sk_nr" colspan="3">身份证：'+(colomdata[odata.indexOf("证件")]||"")+'</td>' +
            '    <td>民族</td>' +
            '    <td class="sk_nr" colspan="3">'+(colomdata[odata.indexOf("民族")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>其他证件</td>' +
            '    <td class="sk_nr" colspan="7">身份证：'+(colomdata[odata.indexOf("其他证件")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>身高</td>' +
            '    <td class="sk_nr" colspan="3">'+(colomdata[odata.indexOf("身高")]||"")+'</td>' +
            '    <td>口音</td>' +
            '    <td class="sk_nr" colspan="3">'+(colomdata[odata.indexOf("口音")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>职业</td>' +
            '    <td class="sk_nr" colspan="7">'+(colomdata[odata.indexOf("职业")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>籍贯</td>' +
            '    <td class="sk_nr" colspan="9">'+(colomdata[odata.indexOf("籍贯")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>体貌特征</td>' +
            '    <td class="sk_nr" colspan="9">'+(colomdata[odata.indexOf("体貌特征")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>体表记号</td>' +
            '    <td class="sk_nr" colspan="9">'+(colomdata[odata.indexOf("体表记号")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>案件类别</td>' +
            '    <td class="sk_nr" colspan="9">'+(colomdata[odata.indexOf("案件类别")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>简要案情及附加信息</td>' +
            '    <td class="sk_nr" colspan="9">'+(colomdata[odata.indexOf("简要案情及附加信息")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>立案单位</td>' +
            '    <td class="sk_nr" colspan="2">'+(colomdata[odata.indexOf("立案单位")]||"")+'</td>' +
            '    <td>立案单位详称</td>' +
            '    <td class="sk_nr" colspan="3">'+(colomdata[odata.indexOf("立案单位详称")]||"")+'</td>' +
            '    <td>立案日期</td>' +
            '    <td class="sk_nr" colspan="2">'+(colomdata[odata.indexOf("立案日期")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>逃跑日期</td>' +
            '    <td class="sk_nr" colspan="2">'+(colomdata[odata.indexOf("逃跑日期")]||"")+'</td>' +
            '    <td>逃跑方向</td>' +
            '    <td class="sk_nr" colspan="3">'+(colomdata[odata.indexOf("逃跑方向")]||"")+'</td>' +
            '    <td>在逃类型</td>' +
            '    <td class="sk_nr" colspan="2">'+(colomdata[odata.indexOf("在逃类型")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>法律文书</td>' +
            '    <td class="sk_nr" colspan="9">'+(colomdata[odata.indexOf("法律文书")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>备注</td>' +
            '    <td class="sk_nr" colspan="9">'+(colomdata[odata.indexOf("备注")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>通缉令</td>' +
            '    <td class="sk_nr" colspan="2">'+(colomdata[odata.indexOf("通缉令")]||"")+'</td>' +
            '    <td>通缉令级别</td>' +
            '    <td class="sk_nr" colspan="3">'+(colomdata[odata.indexOf("通缉令级别")]||"")+'</td>' +
            '    <td>奖金</td>' +
            '    <td class="sk_nr" colspan="2">'+(colomdata[odata.indexOf("奖金")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>主办单位分类</td>' +
            '    <td class="sk_nr" colspan="2">'+(colomdata[odata.indexOf("主办单位分类")]||"")+'</td>' +
            '    <td>主办单位</td>' +
            '    <td class="sk_nr" colspan="6">'+(colomdata[odata.indexOf("主办单位")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>主办人</td>' +
            '    <td class="sk_nr" colspan="2">'+(colomdata[odata.indexOf("主办人")]||"")+'</td>' +
            '    <td>联系电话</td>' +
            '    <td class="sk_nr" colspan="3">'+(colomdata[odata.indexOf("联系电话")]||"")+'</td>' +
            '    <td>主办人2</td>' +
            '    <td class="sk_nr" colspan="2">'+(colomdata[odata.indexOf("主办人2")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>联系方式</td>' +
            '    <td class="sk_nr" colspan="2">'+(colomdata[odata.indexOf("联系方式")]||"")+'</td>' +
            '    <td>主办方电话</td>' +
            '    <td class="sk_nr" colspan="3">'+(colomdata[odata.indexOf("主办方电话")]||"")+'</td>' +
            '    <td>上网等级审批人</td>' +
            '    <td class="sk_nr" colspan="2">'+(colomdata[odata.indexOf("上网等级审批人")]||"")+'</td>' +
            '</tr>' +
            '</tbody>' +
            '</table>';
        $(".zaitao_mes").append(zaitaolist);
    }

    //照片
    function zaitao_zhaopian(zt_data) {
        var colomdata = zt_data.data[0];
        var odata = zt_data.column;
        imglist.push({
            "alt": "全国在逃人员",
            "pid": "", //图片id
            "src": colomdata[odata.indexOf("照片")], //原图地址
            "thumb": "" //缩略图地址
        });
        setTimeout(function () {
            $(".zaitao_mes").find(".zaitao_imgge").attr("src",colomdata[odata.indexOf("照片")]);
        },1000)
    }
}

//yunsou-""云搜""
function setDatayunsou(residdata) {
    infofrom = "信息来源：云搜";
    var reaData = JSON.parse(residdata).data;
    // console.log(reaData)

    $.each(reaData, function (i, item) {
        var ij = i;
        var lisiisis = item.label;
        // console.log(lisiisis);
        // console.log(item.data);
        switch (lisiisis) {
            case "全国人口基本信息":
                yun_jiben(item.data);
                break;
            case "全国驾驶人":
                yun_jiashi(item.data);
                break;
            case "全国机动车":
                yun_jidongche(item.data);
                break;
            case "同住址":
                yun_zhuzhi(item.data);
                break;
            case "同户号":
                yun_huhao(item.data);
                break;
            case "同机构":
                yun_jigou(item.data);
                break;
            case "邻居":
                yun_linju(item.data);
                break;
            case "铁路同乘车":
                yun_chengche(item.data);
                break;
            case "民航同订票":
                yun_jipiao(item.data);
                break;
            case "婚姻":
                yun_hunyin(item.data);
                break;
            case "全国在逃人员登记":
                yun_zatao(item.data);
                break;
            case "全国出入境证件":
                yun_churujing(item.data);
                break;
            case "同乘机":
                yun_byplan(item.data);
                break;
            case "同车违章":
                yun_weizhang(item.data);
                break;
            default:
                break;
        }
    });

    //全国人口基本信息
    function yun_jiben(yundata) {
        var sxdata = yundata.data[0];

        var gonganimg = "";
        if(sxdata[yundata.column.indexOf("公民身份证号")]){
            gonganimg = "http://ys.zyfw.ga/photo/renkou/photoSearch.do?method=allPhoto1&searchword=SFZHM:"+sxdata[yundata.column.indexOf("公民身份证号")]+"&order=0";
        }else{
            gonganimg = "../../img/default.jpg";
        }
        imglist.push({
            "alt": "云搜全国人口基本信息",
            "pid": "", //图片id
            "src": "http://ys.zyfw.ga/photo/renkou/photoSearch.do?method=allPhoto1&searchword=SFZHM:"+sxdata[yundata.column.indexOf("公民身份证号")]+"&order=0", //原图地址
            "thumb": "" //缩略图地址
        });
        $(".ad_coimgdetial").attr("src",gonganimg);
        $.each(yundata.data,function (i,item) {
            console.log(item);
            $(".jibenxinxi").append('<p class="sx_p1 sxtips" data-href="' + infofrom + '">' +
                '<span>姓名：' + item[1] + '</span>' +
                '<span>性别：' + item[2] + '</span>' +
                '<span>户籍地址：' + item[6] + '</span>' +
                '<span></span></p>');
            var oname = item[1].split("(已注销:迁出)");
            if(oname.length==1){
                $(".jbde_name").html(item[4]);
                $(".title").html(item[4]);
                $(".jbde_hujidi").html(item[9]);
                $(".jbde_chudizhi").html(item[11]);

                $(".jbde_jiguan").html(item[6]);
                $(".jbde_zhiye").html(item[1]);
                $(".jbde_chusd").html(item[6]);
            }
        });
        $(".jbde_gender").html(sxdata[yundata.column.indexOf("性别")]);
        $(".jbde_minzu").html(sxdata[yundata.column.indexOf("民族")]);
        $(".jbde_idcard").html(sxdata[yundata.column.indexOf("公民身份证号")]);
    }

    //全国驾驶人
    function yun_jiashi(yundata) {
        //驾驶员信息
        var jiashidata = yundata.data[0];
        var jiahsiimg = "http://ys.zyfw.ga/photo/renkou/photoSearch.do?method=allPhoto1&searchword=SFZHM:"+jiashidata[yundata.column.indexOf("身份证明号码")]+"&order=0";
        var jiashi = '<dl class="sx_imgbox sxtips" data-href="' + infofrom + '">' +
            '<dd><img src="'+jiahsiimg+'" alt=""></dd>' +
            '<dt>' +
            '<div>';
        $.each(reaData[1].data.column, function (i, item) {
            jiashi += '<span>' + item + '：<i>' + jiashidata[i] + '</i></span>'
        });
        jiashi += '</div></dt></dl>';
        $(".sx_jiashiren").append(jiashi);
        //电话
        var phone = yundata.data[0][15]
        if (phone) {
            $(".sx_ppplianxi").append('<p class="sx_p1 sx_ppplianxi sxtips" data-href="' + infofrom + '"><span>手机号：' + phone + '</span><span></span></p>');
        }
    }

    //同住址
    function yun_zhuzhi(yundata) {
        //console.log(yundata)
    }

    //同户号
    function yun_huhao(yundata) {
        //console.log(yundata)
        $.each(yundata.data,function (i,item) {
            var img = item[1].split("'")[1];
            var yun_weizhang = '<li class="sw_li">' +
                '<ul  class="sw_ul2">' +
                '    <li><img class="imgfangda" src="'+img+'" style="height: 30px;margin: 6px;" onerror="clga.whenoerron(this)"></li>' +
                '    <li class="sxtips" data-href="'+infofrom+'" style="margin: 0;">'+item[3]+'</li>' +
                '    <li>无</li>' +
                '    <li>'+item[6]+'</li>' +
                '    <li>'+item[4]+'</li>' +
                '    <li>'+item[5]+'</li>' +
                '    <li style="width: 22%;">'+item[0]+'</li>' +
                '</ul>' +
                '</li>';
            $(".yun_tongcheweizjhang").append(yun_weizhang);
        });
        $(".tonghu_num").html(yundata.data[0][7]);
    }

    //同机构
    function yun_jigou(yundata) {
        function setPageNo(count) {
            laypage.render({
                elem: 'listpage2',
                count: count,
                limit:21,
                first: '首页',
                last: '尾页',
                jump: function (obj, first) {
                    //clga.setpagecss(obj.elem);
                    if (!first) {
                        gettong(obj.curr - 1);
                    }
                }
            });
        }
        function gettong(pageNum) {
            $.ajax({
                url: ctx+"analysis/getList",
                type: "get",
                xhrFields: {
                    withCredentials: true
                },
                data: {
                    pageNum:pageNum,
                    pageSize:21,
                    jobid:jobdata.jobinfo.jobid,
                    platform:'yunsou',
                    dataType:'同机构'
                },
                dataType:"json",
                success: function (res) {
                    if (res.code != 0) {
                        return layer.msg(res.message, {anim: 6});
                    }
                    if (0 === pageNum) {
                        count = res.data.totalNumber;
                        setPageNo(count);
                    }
                    var odata = res.data.columns
                    $.each(res.data.dataList, function (i, item) {
                        var linjuimg = item[1].split("'")[1];
                        var linju = '<li class="sxtips" data-href="'+infofrom+'-同机构">' +
                            '<img src="' + linjuimg + '" alt="" onerror="clga.whenoerron(this)">' +
                            '<p>' + item[3] + '</p>' +
                            '<p>' + item[0] + '</p>' +
                            '<p>' + item[4] + '    ' + item[6] + '   ' + item[5] + '岁</p>' +
                            '<p>' + item[8] + '</p>' +
                            '</li>';
                        $(".yun_jigou").append(linju);
                    });
                    $(".yun_jigou").find("img").css("height", liwidth);
                }
            });
        }
    }

    //邻居
    function yun_linju(yundata) {
        gettong(0);
        function setPageNo(count) {
            laypage.render({
                elem: 'listpage1',
                count: count,
                limit:21,
                first: '首页',
                last: '尾页',
                jump: function (obj, first) {
                    //clga.setpagecss(obj.elem);
                    if (!first) {
                        gettong(obj.curr - 1);
                    }
                }
            });
        }
        function gettong(pageNum) {
            $.ajax({
                url: ctx+"analysis/getList",
                type: "get",
                xhrFields: {
                    withCredentials: true
                },
                data: {
                    pageNum:pageNum,
                    pageSize:21,
                    jobid:jobdata.jobinfo.jobid,
                    platform:'yunsou',
                    dataType:'邻居'
                },
                dataType:"json",
                success: function (res) {
                    if (res.code != 0) {
                        return layer.msg(res.message, {anim: 6});
                    }
                    if (0 === pageNum) {
                        count = res.data.totalNumber;
                        setPageNo(count);
                    }
                    $(".linju_numce").html(res.data.totalNumber);
                    var odata = res.data.columns
                    $.each(res.data.dataList, function (i, item) {
                        var linjuimg = item[1].split("'")[1];
                        var linju = '<li class="sxtips" data-href="'+infofrom+'-邻居">' +
                            '<img  src="' + linjuimg + '" alt="" onerror="clga.whenoerron(this)">' +
                            '<p>' + item[3] + '</p>' +
                            '<p>' + item[0] + '</p>' +
                            '<p>' + item[4] + '    ' + item[6] + '   ' + item[5] + '岁</p>' +
                            '<p>' + item[8] + '</p>' +
                            '</li>';
                        $(".sx_linju").append(linju);
                    });
                    $(".sx_linju").find("img").css("height", liwidth);
                }
            });
        }
    }

    //铁路同乘车
    function yun_chengche(yundata) {
        gettong(0);
        function setPageNo(count) {
            laypage.render({
                elem: 'listpage3',
                count: count,
                limit:21,
                first: '首页',
                last: '尾页',
                jump: function (obj, first) {
                    //clga.setpagecss(obj.elem);
                    if (!first) {
                        gettong(obj.curr - 1);
                    }
                }
            });
        }
        function gettong(pageNum) {
            $.ajax({
                url: ctx+"analysis/getList",
                type: "get",
                xhrFields: {
                    withCredentials: true
                },
                data: {
                    pageNum:pageNum,
                    pageSize:21,
                    jobid:jobdata.jobinfo.jobid,
                    platform:'yunsou',
                    dataType:'铁路同乘车'
                },
                dataType:"json",
                success: function (res) {
                    if (res.code != 0) {
                        return layer.msg(res.message, {anim: 6});
                    }
                    if (0 === pageNum) {
                        count = res.data.totalNumber;
                        setPageNo(count);
                    }
                    var odata = res.data.columns
                    $.each(res.data.dataList, function (i, item) {
                        var linjuimg = item[8].split("'")[1];
                        var linju = '<li class="sxtips" data-href="'+infofrom+'-铁路同乘车">' +
                            '<img src="' + linjuimg + '" alt="" onerror="clga.whenoerron(this)">' +
                            '<p>' + item[1] + '</p>' +
                            '<p>' + item[7] + '</p>' +
                            '<p>' + item[4]  + '   ' + item[2] + '岁</p>' +
                            '<p>' + item[5] + '</p>' +
                            '</li>';
                        $(".yun_chengche").append(linju);
                    });
                    $(".yun_chengche").find("img").css("height",liwidth);
                }
            });
        }
    }

    //民航同订票
    function yun_jipiao(yundata) {
        gettong(0);
        function setPageNo(count) {
            laypage.render({
                elem: 'listpage5',
                count: count,
                limit:21,
                first: '首页',
                last: '尾页',
                jump: function (obj, first) {
                    //clga.setpagecss(obj.elem);
                    if (!first) {
                        gettong(obj.curr - 1);
                    }
                }
            });
        }
        function gettong(pageNum) {
            $.ajax({
                url: ctx+"analysis/getList",
                type: "get",
                xhrFields: {
                    withCredentials: true
                },
                data: {
                    pageNum:pageNum,
                    pageSize:21,
                    jobid:jobdata.jobinfo.jobid,
                    platform:'yunsou',
                    dataType:'民航同订票'
                },
                dataType:"json",
                success: function (res) {
                    if (res.code != 0) {
                        return layer.msg(res.message, {anim: 6});
                    }
                    if (0 === pageNum) {
                        count = res.data.totalNumber;
                        setPageNo(count);
                    }
                    var odata = res.data.columns
                    $.each(res.data.dataList, function (i, item) {
                        var linjuimg = item[8].split("'")[1];
                        var linju = '<li class="sxtips" data-href="'+infofrom+'-民航同订票">' +
                            '<img src="' + linjuimg + '" alt="" onerror="clga.whenoerron(this)">' +
                            '<p>' + item[1] + '</p>' +
                            '<p>' + item[7] + '</p>' +
                            '<p>' + item[4]  + '   ' + item[2] + '岁</p>' +
                            '<p>' + item[5] + '</p>' +
                            '</li>';
                        $(".yun_dingpiao").append(linju);
                    });
                    $(".yun_dingpiao").find("img").css("height",liwidth);
                }
            });
        }
    }

    //婚姻
    function yun_hunyin(yundata) {
        $.each(yundata.data,function (i,item) {
            var img = item[1].split("'")[1];
            var jiashi = '<dl class="sx_imgbox sxtips" data-href="' + infofrom + '">' +
                '<dd><img src="'+img+'" alt=""onerror="clga.whenoerron(this)"></dd>' +
                '<dt>' +
                '<div>';
            var huiyindata = yundata.column;
            $.each(item, function (i, item) {
                if(i!=1){
                    jiashi += '<span>' + huiyindata[i] + '：<i>' + item + '</i></span>';
                }
            });
            jiashi += '</div></dt></dl>';
            $(".huinyinbox").append(jiashi);
        });
    }

    //全国在逃人员登记
    function yun_zatao(yundata) {
        // var zt_da = yundata.data[0];
        // var zaitaolist = '<table cellpadding="0" cellspacing="2" class="sj_table2 sxtips" data-href="' + infofrom + '">' +
        //     '<tr class="sj_firtr">' +
        //     '    <td colspan="10" style="background: transparent;">人员犯罪信息</td>' +
        //     '</tr>' +
        //     '<tbody>' +
        //     '<tr>' +
        //     '    <td>在逃人员编号</td>' +
        //     '    <td colspan="8" class="sk_nr">' + zt_da[37] + '</td>' +
        //     '    <td rowspan="7" class="sk_width">' +
        //     '        <img src="../../img/default.jpg" alt="" onerror="clga.whenoerron(this)">' +
        //     '    </td>' +
        //     '</tr>' +
        //     '<tr>' +
        //     '    <td>姓名</td>' +
        //     '    <td class="sk_nr" colspan="3">' + zt_da[1] + '</td>' +
        //     '    <td>曾用名/别名绰号</td>' +
        //     '    <td class="sk_nr" colspan="3"></td>' +
        //     '</tr>' +
        //     '<tr>' +
        //     '    <td>性别</td>' +
        //     '    <td class="sk_nr" colspan="3">' + zt_da[2] + '</td>' +
        //     '    <td>出生日期</td>' +
        //     '    <td class="sk_nr" colspan="3">' + zt_da[4] + '</td>' +
        //     '</tr>' +
        //     '<tr>' +
        //     '    <td>证件</td>' +
        //     '    <td class="sk_nr" colspan="3">身份证：' + zt_da[3] + '</td>' +
        //     '    <td>民族</td>' +
        //     '    <td class="sk_nr" colspan="3">' + zt_da[5] + '</td>' +
        //     '</tr>' +
        //     '<tr>' +
        //     '    <td>其他证件</td>' +
        //     '    <td class="sk_nr" colspan="7"></td>' +
        //     '</tr>' +
        //     '<tr>' +
        //     '    <td>身高</td>' +
        //     '    <td class="sk_nr" colspan="3">' + zt_da[6] + '</td>' +
        //     '    <td>口音</td>' +
        //     '    <td class="sk_nr" colspan="3">' + zt_da[7] + '</td>' +
        //     '</tr>' +
        //     '<tr>' +
        //     '    <td>职业</td>' +
        //     '    <td class="sk_nr" colspan="7">' + zt_da[8] + '</td>' +
        //     '</tr>' +
        //     '<tr>' +
        //     '    <td>籍贯</td>' +
        //     '    <td class="sk_nr" colspan="9">' + zt_da[9] + '</td>' +
        //     '</tr>' +
        //     '<tr>' +
        //     '    <td>体貌特征</td>' +
        //     '    <td class="sk_nr" colspan="9"></td>' +
        //     '</tr>' +
        //     '<tr>' +
        //     '    <td>体表记号</td>' +
        //     '    <td class="sk_nr" colspan="9">' + zt_da[0] + '</td>' +
        //     '</tr>' +
        //     '<tr>' +
        //     '    <td>案件类别</td>' +
        //     '    <td class="sk_nr" colspan="9">' + zt_da[16] + '</td>' +
        //     '</tr>' +
        //     '<tr>' +
        //     '    <td>简要案情及附加信息</td>' +
        //     '    <td class="sk_nr" colspan="9">' + zt_da[19] + '</td>' +
        //     '</tr>' +
        //     '<tr>' +
        //     '    <td>立案单位</td>' +
        //     '    <td class="sk_nr" colspan="2">' + zt_da[23] + '</td>' +
        //     '    <td>立案单位详称</td>' +
        //     '    <td class="sk_nr" colspan="3">' + zt_da[23] + '</td>' +
        //     '    <td>立案日期</td>' +
        //     '    <td class="sk_nr" colspan="2">' + zt_da[40] + '</td>' +
        //     '</tr>' +
        //     '<tr>' +
        //     '    <td>逃跑日期</td>' +
        //     '    <td class="sk_nr" colspan="2">' + zt_da[20] + '</td>' +
        //     '    <td>逃跑方向</td>' +
        //     '    <td class="sk_nr" colspan="3">' + zt_da[21] + '</td>' +
        //     '    <td>在逃类型</td>' +
        //     '    <td class="sk_nr" colspan="2">' + zt_da[17] + '</td>' +
        //     '</tr>' +
        //     '<tr>' +
        //     '    <td>法律文书</td>' +
        //     '    <td class="sk_nr" colspan="9"></td>' +
        //     '</tr>' +
        //     '<tr>' +
        //     '    <td>备注</td>' +
        //     '    <td class="sk_nr" colspan="9"></td>' +
        //     '</tr>' +
        //     '<tr>' +
        //     '    <td>通缉令</td>' +
        //     '    <td class="sk_nr" colspan="2">' + zt_da[32] + '</td>' +
        //     '    <td>通缉令级别</td>' +
        //     '    <td class="sk_nr" colspan="3">' + zt_da[31] + '</td>' +
        //     '    <td>奖金</td>' +
        //     '    <td class="sk_nr" colspan="2"></td>' +
        //     '</tr>' +
        //     '<tr>' +
        //     '    <td>主办单位分类</td>' +
        //     '    <td class="sk_nr" colspan="2">' + zt_da[26] + '</td>' +
        //     '    <td>主办单位</td>' +
        //     '    <td class="sk_nr" colspan="6">' + zt_da[26] + '</td>' +
        //     '</tr>' +
        //     '<tr>' +
        //     '    <td>主办人</td>' +
        //     '    <td class="sk_nr" colspan="2">' + zt_da[27] + '</td>' +
        //     '    <td>联系电话</td>' +
        //     '    <td class="sk_nr" colspan="3">' + zt_da[28] + '</td>' +
        //     '    <td>主办人2</td>' +
        //     '    <td class="sk_nr" colspan="2"></td>' +
        //     '</tr>' +
        //     // '<tr>' +
        //     // '    <td>联系方式</td>' +
        //     // '    <td class="sk_nr" colspan="2"></td>' +
        //     // '    <td>主办方电话</td>' +
        //     // '    <td class="sk_nr" colspan="3"></td>' +
        //     // '    <td>上网等级审批人</td>' +
        //     // '    <td class="sk_nr" colspan="2"></td>' +
        //     // '</tr>' +
        //     '</tbody>' +
        //     '</table>';
        // $(".zaitao_mes").append(zaitaolist);
    }

    //全国出入境证件
    function yun_churujing(yundata) {
        //全国出入境证件
        var huzhaodata = yundata.column;
        var huzhao = '<dl class="sx_imgbox sxtips" data-href="' + infofrom + '">' +
            '<dd><img src="../../img/default.jpg" alt="" onerror="clga.whenoerron(this)"></dd>' +
            '<dt>' +
            '<div>';
        $.each(yundata.data, function (i, item) {
            if (i > 0) {
                huzhao += '<hr class="layui-bg-blue">'
            }
            $.each(item, function (i, item) {
                huzhao += '<span>' + huzhaodata[i] + '：<i>' + item + '</i></span>';
            });
        });
        huzhao += '</div></dt></dl>';
        $(".sx_huzhao").append(huzhao);
    }

    //同乘机
    function yun_byplan(yundata) {
        gettong(0);
        function setPageNo(count) {
            laypage.render({
                elem: 'listpage4',
                count: count,
                limit:21,
                first: '首页',
                last: '尾页',
                jump: function (obj, first) {
                    //clga.setpagecss(obj.elem);
                    if (!first) {
                        gettong(obj.curr - 1);
                    }
                }
            });
        }
        function gettong(pageNum) {
            $.ajax({
                url: ctx+"analysis/getList",
                type: "get",
                xhrFields: {
                    withCredentials: true
                },
                data: {
                    pageNum:pageNum,
                    pageSize:21,
                    jobid:jobdata.jobinfo.jobid,
                    platform:'yunsou',
                    dataType:'同乘机'
                },
                dataType:"json",
                success: function (res) {
                    if (res.code != 0) {
                        return layer.msg(res.message, {anim: 6});
                    }
                    if (0 === pageNum) {
                        count = res.data.totalNumber;
                        setPageNo(count);
                    }
                    var odata = res.data.columns
                    $.each(res.data.dataList, function (i, item) {
                        var linjuimg = item[8].split("'")[1];
                        var linju = '<li class="sxtips" data-href="'+infofrom+'-同乘机">' +
                            '<img src="' + linjuimg + '" alt="" onerror="clga.whenoerron(this)">' +
                            '<p>' + item[1] + '</p>' +
                            '<p>' + item[7] + '</p>' +
                            '<p>' + item[4]  + '   ' + item[2] + '岁</p>' +
                            '<p>' + item[5] + '</p>' +
                            '</li>';
                        $(".yun_chengji").append(linju);
                    });
                    $(".yun_chengji").find("img").css("height",liwidth);
                }
            });
        }
    }

    //同车违章
    function yun_weizhang(yundata) {
        $.each(yundata.data,function (i,item) {
            var img = item[8].split("'")[1];
            var yun_weizhang = '<li class="sw_li">' +
                '<ul  class="sw_ul2">' +
                '    <li>'+i+'</li>' +
                '    <li><img class="imgfangda" src="'+img+'" style="height: 30px;margin: 6px;" onerror="clga.whenoerron(this)"></li>' +
                '    <li class="sxtips" data-href="'+infofrom+'" style="margin: 0;">'+item[1]+'</li>' +
                '    <li>'+item[7]+'</li>' +
                '    <li>'+item[3]+'</li>' +
                '    <li style="width: 22%;">'+item[6]+'</li>' +
                '</ul>' +
                '</li>';
            $(".yun_weizhang").append(yun_weizhang);
        });
        $(".che_weizhang").fadeIn();
    }

    //全国机动车
    function yun_jidongche(yundata) {
        //console.log(yundata);
        var odata = yundata.column;
        $.each(yundata.data,function (i,item) {
            var colomdata = item;
            var cheliang = '<li>' +
                '<ul  class="sw_ul1 sxtips" data-href="'+infofrom+'">' +
                '    <li class="sxtips"  style="margin: 0;">' + (colomdata[odata.indexOf("号牌号码")]||"") + '</li>' +
                '    <li>' + (colomdata[odata.indexOf("车辆品牌")]||"") + '</li>' +
                '    <li>' + (colomdata[odata.indexOf("机动车所有人")]||"") + '</li>' +
                '    <li>' + (colomdata[odata.indexOf("初次登记日期")]||"") + '</li>' +
                '    <li style="width: 25%;">' + (colomdata[odata.indexOf("联系电话")]||"") + '</li>' +
                '    <li class="swxq_1" data-href="true">' +
                '        <span class="iconfont icon-rwcharacter"></span>' +
                '        <span>详情</span>' +
                '    </li>' +
                '</ul>' +
                '<div class="sw_div1 sw_div2" style="padding: 0 3%;clear: both;">' + (colomdata[odata.indexOf("住所详细地址")]||"") + '</div>' +
                '</li>'
            $(".cheliangbox").append(cheliang);
        });
        $(".che_liang").fadeIn();
    }

    //业务
    $(".ding_chengche").click(function () {
        var current = $(".yun_chengche").offset().top-300;
        $("html body").animate(({scrollTop:current}),300);
    });
    $(".ding_chengji").click(function () {
        var current = $(".yun_chengji").offset().top-300;
        $("html body").animate(({scrollTop:current}),300);
    });
    $(".ding_dingpiao").click(function () {
        var current = $(".yun_dingpiao").offset().top-300;
        $("html body").animate(({scrollTop:current}),300);
    });
}

//sdgayjs-"警务千度"
function setDatasdgayjs(residdata) {
    var reaData = JSON.parse(residdata).data;
    var infofrom = "警务千度";
    $.each(reaData, function (i, item) {
        var lisiisis = item.label;
        // console.log(lisiisis)
        // console.log(item.data)
        switch (lisiisis) {
            case "基本信息"://基本信息
                qiandu_jiben(item.data);
                break;
            case "联系方式":
                qiandu_lianxi(item.data);
                break;
            case "全省警员":
                qiandu_jingyuanixnxi(item.data);
                break;
            case "地址信息":
                qiandu_dizhi(item.data);
                break;
            case "工作学习履历":
                qiandu_lvli(item.data);
                break;
            case "新常口同户亲属关系":
                qiandu_tonghuguanxi(item.data);
                break;
            case "婚姻":
                qiandu_hunyin(item.data);
                break;
            case "同单位":
                qiandu_tongdanwei(item.data);
                break;
            case "户籍变迁":
                qiandu_hjbq(item.data);
                break;
            case "案件":
                qiandu_aj(item.data);
                break;
            case "宾馆疑似同住人员":
                qiandu_bgystzry(item.data);
                break;
            case "宾馆同住人员":
                qiandu_bgtzry(item.data);
                break;
            case "公安请求服务火车购票记录":
                qiandu_gaqqhcgpjl(item.data);
                break;
            case "山东警务云同火车搭乘":
                qiandu_thcdc(item.data);
                break;
            case "山东核录"://轨迹
                qiandu_sdhl(item.data);
                break;
            case "人社厅-参保人员信息":
                qiandu_cbryjl(item.data);
                break;
            case "全国联查":
                qiandu_qglc(item.data);
                break;
            case "股东信息":
                qiandu_gdxx(item.data);
                break;
            case "宾馆住宿":
                qiandu_bgzs(item.data);
                break;
            case "出所人员":
                qiandu_csry(item.data);
                break;
            case "民航进出港":
                qiandu_mhjcg(item.data);
                break;
            case "民政婚姻":
                qiandu_mzhy(item.data);
                break;
            case "新常住人口":
                qiandu_xczrk(item.data);
                break;
            case "情报重点人员":
                qiandu_qbzdry(item.data);
                break;
            case "人社参保人员":
                qiandu_rscbry(item.data);
                break;
            case "执法闭环":
                qiandu_zfbh(item.data);
                break;
            case "执法闭环嫌疑人":
                qiandu_zfbhxyr(item.data);
                break;
            case "常住人口":
                qiandu_czrk(item.data);
                break;
            case "高危人员":
                qiandu_gwry(item.data);
                break;
            case "案件嫌疑人":
                qiandu_ajxyr(item.data);
                break;
            case "流动人口":
                qiandu_ldrk(item.data);
                break;
            case "驾驶证":
                qiandu_jsz(item.data);
                break;
            case "新常口历史同户亲属关系":
                qiandu_xcklsthqsgx(item.data);
                break;
            case "机动车":
                qiandu_wp(item.data);
                break;
            case "同违章":
                qiandu_twz(item.data);
                break;
            case "山东警务云宾馆同房间":
                qiandu_sdjwybgtfj(item.data);
                break;
            case "山东警务云宾馆同宾馆":
                qiandu_sdjwybgtbg(item.data);
                break;
            case "同房间":
                qiandu_sdjwybgtfj(item.data);
                break;
            case "山东警务云民航同订票":
                qiandu_sdjwymhtdp(item.data);
                break;
            case "公共就业人才服务信息":
                qiandu_ggjyrcfwxx(item.data);
                break;
            case "社会保险信息":
                qiandu_shbxxx(item.data);
                break;
            case "人事管理信息":
                qiandu_rsglxx(item.data);
                break;
            case "交通违法":
                qiandu_jtwf(item.data);
                break;
            case "山东警务云上网同记录":
                qiandu_sdjwyswtjl(item.data);
                break;
            case "铁路记录":
                qiandu_tljl(item.data);
                break;
            case "高校毕业生":
                qiandu_gxbys(item.data);
                break;
            case "出境申请":
                qiandu_cjsq(item.data);
                break;
            case "汽车购票信息":
                qiandu_qcgpxx(item.data);
                break;
            case "互联网服务商":
                qiandu_hlwfws(item.data);
                break;
            case "监狱释放人员":
                qiandu_jysfry(item.data);
                break;
            case "传销人员":
                qiandu_cxry(item.data);
                break;
            case "互联网上网场所":
                qiandu_hlwswcs(item.data);
                break;
            case "新疆国内旅客":
                qiandu_xjgnlk(item.data);
                break;
            case "新疆客运售票":
                qiandu_xjkysp(item.data);
                break;
            default:
                qiandu_hdls(lisiisis,item.data);
                break;
        }
    });
    //console.log(reaData);
    //基本信息
    function qiandu_jiben(qddata) {
        var sxdata = qddata.data[0];
        var odata = qddata.column;
        console.log(odata)
        console.log(sxdata)

        $(".jbde_cengyongming").html(sxdata[odata.indexOf("曾用名")]);
        $(".jbde_wenhua").html(sxdata[odata.indexOf("文化程度")]);
        $(".jbde_clzjdz").html(sxdata[odata.indexOf("初领身份证地址")]);
        $(".jbde_joindata").html(sxdata[odata.indexOf("出生日期")]);


        $(".jbde_mianmao").html(sxdata[odata.indexOf("政治面貌")]);

        $(".jbde_hjdxz").html(sxdata[odata.indexOf("详细地址")]);
    }

    //警员信息
    function qiandu_jingyuanixnxi(qddata) {
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            console.log(item)
            var jiashi = '<dl class="sx_imgbox sxtips" data-href="' + infofrom + '-全省警员">' +
                '<dt style="margin-left: 0;">' +
                '<div>';
            $.each(item, function (i, item) {
                if(item!=""){
                    jiashi += '<span>' + odata[i] + '：<i>' + item + '</i></span>';
                }
            });
            jiashi += '</div></dt></dl>';
            $(".jingyuanxinxi").append(jiashi);
        });
    }

    //联系方式
    function qiandu_lianxi(qddata) {
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var colomdata = item;
            var phone = (colomdata[odata.indexOf("手机")]||"")
            if (phone) {
                $(".sx_ppplianxi").append('<p class="sx_p1 sxtips" data-href="' + infofrom +'-'+colomdata[odata.indexOf("来源")]+ '"><span>手机号：' + phone + '</span><span>时间：'+colomdata[odata.indexOf("时间")]+'</span></p>');
            }
        })
    }

    //互联网服务商
    function qiandu_hlwfws(qddata) {
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var jiashi = '<dl class="sx_imgbox sxtips" data-href="' + infofrom + '-互联网服务商">' +
                '<dt style="margin-left: 0;"><div>';
            $.each(item, function (i, item) {
                if (i != 1) {
                    jiashi += '<span>' + odata[i] + '：<i>' + item + '</i></span>';
                }
            });
            jiashi += '</div></dt></dl>';
            $(".hlwfwsbox").append(jiashi);
        })
    }

    //地址信息
    function qiandu_dizhi(qddata) {

    }

    //工作学习履历
    function qiandu_lvli(qddata) {
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var colomdata = item;
            $(".gongzuodanwei").append('<p class="sx_p1 sxtips" data-href="' + infofrom + '">' +
                '<span>工作单位：' + (colomdata[odata.indexOf("工作单位")]||"") + '</span>' +
                '<span>时间：' + (colomdata[odata.indexOf("时间")]||"") + '</span>' +
                '<span>信息来源：' + (colomdata[odata.indexOf("信息来源")]||"") + '</span>' +
                '<span></span>' +
                '</p>');
        })
    }

    //新常口同户亲属关系
    function qiandu_tonghuguanxi(qddata) {
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var colomdata = item;
            var yun_weizhang = '<li class="sw_li">' +
                '<ul  class="sw_ul2">' +
                '    <li><img class="imgfangda" src="http://ys.zyfw.ga/photo/renkou/photoSearch.do?method=allPhoto1&searchword=SFZHM:'+(colomdata[odata.indexOf("身份证号")]||"")+'&order=0" style="height: 30px;margin: 6px;" onerror="clga.whenoerron(this)"></li>' +
                '    <li class="sxtips" data-href="'+infofrom+'" style="margin: 0;">'+(colomdata[odata.indexOf("名字")]||"")+'</li>' +
                '    <li>'+(colomdata[odata.indexOf("关系")]||"")+'</li>' +
                '    <li>无</li>' +
                '    <li>无</li>' +
                '    <li>无</li>' +
                '    <li style="width: 22%;">'+(colomdata[odata.indexOf("身份证号")]||"")+'</li>' +
                '</ul>' +
                '</li>';
            $(".yun_tongcheweizjhang").append(yun_weizhang);
        });
    }

    //婚姻
    function qiandu_hunyin(qddata) {
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var img = "http://ys.zyfw.ga/photo/renkou/photoSearch.do?method=allPhoto1&searchword=SFZHM:"+(item[odata.indexOf('身份证')]||'')+"&order=0";
            var jiashi = '<dl class="sx_imgbox sxtips" data-href="' + infofrom + '">' +
                '<dd><img src="'+img+'" alt=""onerror="clga.whenoerron(this)"></dd>' +
                '<dt>' +
                '<div>';
            $.each(item, function (i, item) {
                if(i!=1){
                    jiashi += '<span>' + odata[i] + '：<i>' + item + '</i></span>';
                }
            });
            jiashi += '</div></dt></dl>';
            $(".huinyinbox").append(jiashi);
        });
    }

    //同单位
    function qiandu_tongdanwei(qddata) {
        gettong(0);
        function setPageNo(count) {
            laypage.render({
                elem: 'listpage6',
                count: count,
                first: '首页',
                last: '尾页',
                jump: function (obj, first) {
                    //clga.setpagecss(obj.elem);
                    if (!first) {
                        gettong(obj.curr - 1);
                    }
                }
            });
        }
        function gettong(pageNum) {
            $.ajax({
                url: ctx+"analysis/getList",
                type: "get",
                xhrFields: {
                    withCredentials: true
                },
                data: {
                    pageNum:pageNum,
                    pageSize:21,
                    jobid:jobdata.jobinfo.jobid,
                    platform:"sdgayjs",
                    dataType:"同单位"
                },
                dataType:"json",
                success: function (res) {
                    if (res.code != 0) {
                        return layer.msg(res.message, {anim: 6});
                    }
                    if (0 === pageNum) {
                        count = res.data.totalNumber;
                        setPageNo(count);
                    }
                    var odata = res.data.columns
                    $.each(res.data.dataList, function (i, item) {
                        var colomdata = item;
                        var linju = '<li class="sxtips" data-href="'+infofrom+'-同单位">' +
                            '<img src="http://ys.zyfw.ga/photo/renkou/photoSearch.do?method=allPhoto1&searchword=SFZHM:'+(colomdata[odata.indexOf("身份证")]||"")+'&order=0" alt="" onerror="clga.whenoerron(this)">' +
                            '<p>' + (colomdata[odata.indexOf("姓名")]||"") + '</p>' +
                            '<p>' + (colomdata[odata.indexOf("身份证")]||"") + '</p>' +
                            '</li>';
                        $(".qiandu_danwei").append(linju);
                    });
                    $(".qiandu_danwei").find("img").css("height",liwidth);
                }
            });
        }
        //业务
        $(".ding_danwei").click(function () {
            var current = $(".qiandu_danwei").offset().top-300;
            $("html body").animate(({scrollTop:current}),300);
        });
    }

    //户籍变迁
    function qiandu_hjbq(qddata) {
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var img = "../../img/default.jpg";
            var jiashi = '<dl class="sx_imgbox sxtips" data-href="' + infofrom + '-户籍变迁">' +
                '<dd><img src="'+img+'" alt=""onerror="clga.whenoerron(this)"></dd>' +
                '<dt>' +
                '<div>';
            $.each(item, function (i, item) {
                if(i!=1){
                    jiashi += '<span>' + odata[i] + '：<i>' + item + '</i></span>';
                }
            });
            jiashi += '</div></dt></dl>';
            $(".qiandu_hujibianqian").append(jiashi);
        });
    }

    //案件
    function qiandu_aj(qddata) {
        $(".biaoqiandetial").append('<li class="sd_red">案件</li>');
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var colomdata = item;
            var list = '<table cellpadding="0" cellspacing="2" class="sj_table2 sxtips" data-href="'+infofrom+'-案件">' +
                '<tr class="sj_firtr">' +
                '    <td colspan="9" style="background: transparent;">案件'+(i+1)+'</td>' +
                '</tr>' +
                '<tbody>' +
                '<tr>' +
                '    <td>案件名称</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("案件名称")]||"")+'</td>' +
                '    <td>案件编号</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("案件编号")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>地点</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("地点")]||"")+'</td>' +
                '    <td>案件类别</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("案件类别")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>报警时间</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("报警时间")]||"")+'</td>' +
                '    <td>案件状态</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("案件状态")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>简要案情</td>' +
                '    <td colspan="8" class="sk_nr" style="width: 85%;">'+(colomdata[odata.indexOf("案情简要")]||"")+'</td>' +
                '</tr>' +
                '</tbody>' +
                '                </table>';
            $(".qiandu_anjian").append(list);
        });

    }

    //人社厅-参保人员信息
    function qiandu_cbryjl(qddata) {
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var colomdata = item;
            //电话
            var phone = colomdata[odata.indexOf("联系方式")];
            if (phone) {
                $(".sx_ppplianxi").append('<p class="sx_p1 sxtips" data-href="' + infofrom +'-人社厅-参保人员信息"><span>手机号：' + phone + '</span></p>');
            }
            var list = ' <tr class="sxtips" data-href="'+infofrom+'-人社厅参保人员信息">' +
                '<td>'+(colomdata[odata.indexOf("个人身份")]||"")+'</td>' +
                '<td>'+(colomdata[odata.indexOf("医疗保险状态")]||"")+'</td>' +
                '<td>'+(colomdata[odata.indexOf("社保缴纳地市")]||"")+'</td>' +
                '<td>'+(colomdata[odata.indexOf("社会保障号码")]||"")+'</td>' +
                '<td>'+(colomdata[odata.indexOf("离退休状态")]||"")+'</td>' +
                '<td>'+(colomdata[odata.indexOf("常住地址")]||"")+'</td>' +
                '<td>'+(colomdata[odata.indexOf("联系方式")]||"")+'</td>' +
                '<td>'+(colomdata[odata.indexOf("养老保险状态")]||"")+'</td>' +
                '</tr>'
            $(".qiandu_yibao").append(list);


        });
    }

    //互联网上网场所
    function qiandu_hlwswcs(qddata) {
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var colomdata = item;
            var list = ' <tr class="sxtips" data-href="'+infofrom+'-互联网上网场所">' +
                '<td>'+(colomdata[odata.indexOf("CSMC")]||"")+'</td>' +
                '<td>'+(colomdata[odata.indexOf("场所地址")]||"")+'</td>' +
                '<td>'+(colomdata[odata.indexOf("经营性质")]||"")+'</td>' +
                '<td>'+(colomdata[odata.indexOf("法定代表人姓名")]||"")+'</td>' +
                '<td>'+(colomdata[odata.indexOf("FDDBRSFZH")]||"")+'</td>' +
                '<td>'+(colomdata[odata.indexOf("开办日期")]||"")+'</td>' +
                '<td>'+(colomdata[odata.indexOf("起始IP地址")]||"")+'</td>' +
                '<td>'+(colomdata[odata.indexOf("结束IP地址")]||"")+'</td>' +
                '</tr>';
            $(".qiandu_hlwswcsbox").append(list);
        });
        $(".qiandu_hlwswcstitle").fadeIn();
    }

    //全国联查
    function qiandu_qglc(qddata) {
        $(".biaoqiandetial").append('<li class="sd_red">联查</li>');
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var colomdata = item;
            var list = '<table cellpadding="0" cellspacing="2" class="sj_table2 sxtips" data-href="'+infofrom+'-全国联查">' +
                '<tr class="sj_firtr">' +
                '    <td colspan="9" style="background: transparent;">全国联查'+'</td>' +
                '</tr>' +
                '<tbody>' +
                '<tr>' +
                '    <td>身份证号</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("身份证号")]||"")+'</td>' +
                '    <td>数据来源</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("数据来源")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>案情简介</td>' +
                '    <td colspan="8" class="sk_nr" style="width: 85%;">'+(colomdata[odata.indexOf("案情简介")]||"")+'</td>' +
                '</tr>' +
                '</tbody>' +
                '                </table>';
            $(".qiandu_quanguoliancha").append(list);
        })
    }

    //股东信息
    function qiandu_gdxx(qddata) {
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var colomdata = item;
            var list = '<table cellpadding="0" cellspacing="2" class="sj_table2 sxtips" data-href="'+infofrom+'-股东信息">' +
                '<tr class="sj_firtr">' +
                '    <td colspan="9" style="background: transparent;">股东信息'+'</td>' +
                '</tr>' +
                '<tbody>' +
                '<tr>' +
                '   <td>姓名</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("INV")]||"")+'</td>' +
                '   <td>证件类型</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("证件类型")]||"")+'</td>' +
                '   <td>证件号码</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("证件号码")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>系统编号</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("系统编号")]||"")+'</td>' +
                '    <td>RECID</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("RECID")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>认缴出资额</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("认缴出资额")]||"")+'</td>' +
                '   <td>出资方式（认缴）</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("出资方式（认缴）")]||"")+'</td>' +
                '   <td>实缴出资方式</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("实缴出资方式")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>FROM_WHERE</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("FROM_WHERE")]||"")+'</td>' +
                '    <td>修改时间</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("修改时间")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>src</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("src")]||"")+'</td>' +
                '    <td>_version_</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("_version_")]||"")+'</td>' +
                '</tr>' +
                '</tbody>' +
                '                </table>';
            $(".qiandu_gudongxinxi").append(list);
        })
    }

    //出所人员
    function qiandu_csry(qddata) {
        $(".biaoqiandetial").append('<li class="sd_red">出所人</li>');
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var colomdata = item;
            var list = '<table cellpadding="0" cellspacing="2" class="sj_table2 sxtips" data-href="'+infofrom+'-出所人员">' +
                '<tr class="sj_firtr">' +
                '    <td colspan="9" style="background: transparent;">出所人员'+'</td>' +
                '</tr>' +
                '<tbody>' +
                '<tr>' +
                '    <td>系统编号</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("系统编号")]||"")+'</td>' +
                '    <td>LFFH</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("LFFH")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>姓名</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("姓名")]||"")+'</td>' +
                '   <td>姓名拼音</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("姓名拼音")]||"")+'</td>' +
                '   <td>别化名</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("别化名")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>性别</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("性别")]||"")+'</td>' +
                '   <td>出生时间</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("出生时间")]||"")+'</td>' +
                '   <td>证件类型</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("证件类型")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>证件号码</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("证件号码")]||"")+'</td>' +
                '   <td>婚姻状况</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("婚姻状况")]||"")+'</td>' +
                '   <td>民族</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("民族")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>国籍</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("国籍")]||"")+'</td>' +
                '   <td>户籍地</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("户籍地")]||"")+'</td>' +
                '   <td>文化程度</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("文化程度")]||"")+'</td>' +
                '<tr>' +
                '    <td>暂住地详址</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("暂住地详址")]||"")+'</td>' +
                '    <td>户籍地详址</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("户籍地详址")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>职业</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("职业")]||"")+'</td>' +
                '   <td>工作单位</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("工作单位")]||"")+'</td>' +
                '   <td>身份</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("身份")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>特殊身份</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("特殊身份")]||"")+'</td>' +
                '   <td>入所日期</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("入所日期")]||"")+'</td>' +
                '   <td>入所性质</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("入所性质")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>送押单位</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("送押单位")]||"")+'</td>' +
                '   <td>所有人</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("所有人")]||"")+'</td>' +
                '   <td>SYPZ_ZW</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("SYPZ_ZW")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>JYRQ</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("JYRQ")]||"")+'</td>' +
                '    <td>关押期限</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("关押期限")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>案由</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("案由")]||"")+'</td>' +
                '   <td>BAHJ_ZW</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("BAHJ_ZW")]||"")+'</td>' +
                '   <td>JSH</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("JSH")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>ZDRY_ZW</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("ZDRY_ZW")]||"")+'</td>' +
                '   <td>在所状态</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("在所状态")]||"")+'</td>' +
                '   <td>SCBZ</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("SCBZ")]||"")+'</td>' +
                '</tr>' +


                '<tr>' +
                '    <td>DAH</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("DAH")]||"")+'</td>' +
                '    <td>DWLX_ZW</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("DWLX_ZW")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>政治面貌</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("政治面貌")]||"")+'</td>' +
                '   <td>出所原因</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("出所原因")]||"")+'</td>' +
                '   <td>刑期</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("刑期")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>CLJG_ZW</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("CLJG_ZW")]||"")+'</td>' +
                '    <td>BADW</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("BADW")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>籍贯</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("籍贯")]||"")+'</td>' +
                '   <td>暂住地</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("暂住地")]||"")+'</td>' +
                '   <td>CSQX</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("CSQX")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>FZJL_ZW</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("FZJL_ZW")]||"")+'</td>' +
                '    <td>关押期限</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("关押期限")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>年龄</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("年龄")]||"")+'</td>' +
                '   <td>拘留日期</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("拘留日期")]||"")+'</td>' +
                '   <td>足长</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("足长")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>WSH</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("WSH")]||"")+'</td>' +
                '    <td>GLZT_ZW</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("GLZT_ZW")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>JKZK_ZW</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("JKZK_ZW")]||"")+'</td>' +
                '   <td>BYZDB</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("BYZDB")]||"")+'</td>' +
                '   <td>YXCS</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("YXCS")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>单位职务</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("单位职务")]||"")+'</td>' +
                '    <td>BYZDD</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("BYZDD")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>BYZDF</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("BYZDF")]||"")+'</td>' +
                '   <td>入所案情</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("入所案情")]||"")+'</td>' +
                '   <td>STJGBZ</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("STJGBZ")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>XZBZ</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("XZBZ")]||"")+'</td>' +
                '    <td>SCSTBZ</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("SCSTBZ")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>RFID</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("RFID")]||"")+'</td>' +
                '   <td>ZHKRKSJ</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("ZHKRKSJ")]||"")+'</td>' +
                '   <td>SJC</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("SJC")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>src</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("src")]||"")+'</td>' +
                '    <td>_version_</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("_version_")]||"")+'</td>' +
                '</tr>' +
                '</tr>' +
                '    <td>案情简介</td>' +
                '    <td colspan="8" class="sk_nr" style="width: 85%;">'+(colomdata[odata.indexOf("简要案情")]||"")+'</td>' +
                '</tr>' +
                '</tbody>' +
                '                </table>';
            $(".qiandu_chusuo").append(list);
        })
    }

    //监狱释放人员
    function qiandu_jysfry(qddata) {
        $(".biaoqiandetial").append('<li class="sd_red">监狱释放</li>');
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var colomdata = item;
            var list = '<table cellpadding="0" cellspacing="2" class="sj_table2 sxtips" data-href="'+infofrom+'-监狱释放人员">' +
                '<tr class="sj_firtr">' +
                '    <td colspan="9" style="background: transparent;">监狱释放人员'+'</td>' +
                '</tr>' +
                '<tbody>' +
                '<tr>' +
                '    <td>系统编号</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("系统编号")]||"")+'</td>' +
                '    <td>罪犯编号</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("罪犯编号")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>姓名</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("姓名")]||"")+'</td>' +
                '   <td>性别</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("性别")]||"")+'</td>' +
                '   <td>民族</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("民族")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>出生日期</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("出生时间")]||"")+'</td>' +
                '   <td>身份证号</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("身份证号")]||"")+'</td>' +
                '   <td>户籍地址</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("户籍地址")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>家庭住址</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("家庭住址")]||"")+'</td>' +
                '   <td>捕前文化程度</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("捕前文化程度")]||"")+'</td>' +
                '   <td>婚姻状况</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("婚姻状况")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>捕前面貌</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("捕前面貌")]||"")+'</td>' +
                '   <td>罪名</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("罪名")]||"")+'</td>' +
                '   <td>刑期</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("刑期")]||"")+'</td>' +
                '<tr>' +
                '    <td>判决机关</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("判决机关")]||"")+'</td>' +
                '    <td>判决字号</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("判决字号")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>判决日期</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("判决日期")]||"")+'</td>' +
                '   <td>起日</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("起日")]||"")+'</td>' +
                '   <td>止日</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("止日")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>入监日期</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("入监日期")]||"")+'</td>' +
                '   <td>离监日期</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("离监日期")]||"")+'</td>' +
                '   <td>离监类别</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("离监类别")]||"")+'</td>' +
                '</tr>' +
                '</tbody>' +
                '                </table>';
            $(".qiandu_jianyushifang").append(list);
        })
    }

    //传销人员
    function qiandu_cxry(qddata) {
        $(".biaoqiandetial").append('<li class="sd_red">传销</li>');
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var colomdata = item;
            var list = '<table cellpadding="0" cellspacing="2" class="sj_table2 sxtips" data-href="'+infofrom+'传销人员">' +
                '<tr class="sj_firtr">' +
                '    <td colspan="9" style="background: transparent;">传销人员'+'</td>' +
                '</tr>' +
                '<tbody>' +
                '<tr>' +
                '    <td>系统编号</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("系统编号")]||"")+'</td>' +
                '    <td>所属辖区</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("所属辖区")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>姓名</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("姓名")]||"")+'</td>' +
                '   <td>性别</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("性别")]||"")+'</td>' +
                '   <td>公民身份证号</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("公民身份证号")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>出生时间</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("出生日期")]||"")+'</td>' +
                '   <td>工作单位</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("工作单位")]||"")+'</td>' +
                '   <td>学历</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("学历")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>籍贯</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("籍贯")]||"")+'</td>' +
                '   <td>姓名拼音</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("姓名拼音")]||"")+'</td>' +
                '   <td>联系地址</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("联系地址")]||"")+'</td>' +
                '</tr>' +
                '</tbody>' +
                '                </table>';
            $(".qiandu_chuanxiaory").append(list);
        })
    }

    //民政婚姻
    function qiandu_mzhy(qddata) {
        var odata = qddata.column;
        console.log(qddata)
        $.each(qddata.data,function (i,item) {
            var jiashi = '<dl class="sx_imgbox sxtips" data-href="' + infofrom + '-民政婚姻">' +
                '<dd></dd>' +
                '<dt style="margin-left: 0;">' +
                '<div>';
            $.each(item, function (i, item) {
                if(i!=1){
                    jiashi += '<span>' + odata[i] + '：<i>' + item + '</i></span>';
                }
            });
            jiashi += '</div></dt></dl>';
            $(".huinyinbox").append(jiashi);
        });
    }

    //新常住人口
    function qiandu_xczrk(qddata) {
        var odata = qddata.column;
        var sxdata = qddata.data[0]
        $.each(qddata.data,function (i,item) {
            var img ='http://ys.zyfw.ga/photo/renkou/photoSearch.do?method=allPhoto1&searchword=SFZHM:'+item[odata.indexOf("公民身份号码")]+'&order=0';
            var jiashi = '<dl class="sx_imgbox sxtips" data-href="' + infofrom + '-新常住人口">' +
                '<dd><img src="'+img+'" alt=""onerror="clga.whenoerron(this)"></dd>' +
                '<dt>' +
                '<div>';
            $.each(item, function (i, item) {
                jiashi += '<span>' + odata[i] + '：<i>' + item + '</i></span>';
            });
            jiashi += '</div></dt></dl>';
            $(".qiandu_jiating").append(jiashi);
        });
    }

    //情报重点人员
    function qiandu_qbzdry(qddata) {
        $(".biaoqiandetial").append('<li class="sd_red">重点人</li>');
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var colomdata = item;
            var list = '<table cellpadding="0" cellspacing="2" class="sj_table2 sxtips" data-href="'+infofrom+'-情报重点人员">' +
                '<tr class="sj_firtr">' +
                '    <td colspan="9" style="background: transparent;">情报重点人员'+'</td>' +
                '</tr>' +
                '<tbody>' +
                '<tr>' +
                '    <td>系统编号</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("系统编号")]||"")+'</td>' +
                '    <td>BJZDRYBH</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("BJZDRYBH")]||"")+'</td>' +
                '<tr>' +
                '<tr>' +
                '   <td>姓名</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("姓名")]||"")+'</td>' +
                '   <td>姓名拼音</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("姓名拼音")]||"")+'</td>' +
                '   <td>性别</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("性别")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>出生时间</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("出生时间")]||"")+'</td>' +
                '   <td>国籍</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("国籍")]||"")+'</td>' +
                '   <td>身份证号</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("身份证号")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>民族</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("民族")]||"")+'</td>' +
                '    <td>籍贯</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("籍贯")]||"")+'</td>' +
                '<tr>' +
                '<tr>' +
                '    <td>HJDQH</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("HJDQH")]||"")+'</td>' +
                '    <td>户籍地区划</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("户籍地区划")]||"")+'</td>' +
                '<tr>' +
                '<tr>' +
                '   <td>户籍地详址</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("户籍地详址")]||"")+'</td>' +
                '   <td>户籍地派出所</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("户籍地派出所")]||"")+'</td>' +
                '   <td>HJDPCSDM</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("HJDPCSDM")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '   <td>姓名</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("XZDQH")]||"")+'</td>' +
                '   <td>姓名拼音</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("现住地区划")]||"")+'</td>' +
                '   <td>别化名</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("现住地详址")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>立案单位</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("立案单位")]||"")+'</td>' +
                '    <td>LADWJGDM</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("LADWJGDM")]||"")+'</td>' +
                '<tr>' +
                '<tr>' +
                '    <td>身份证号</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("最近立案时间")]||"")+'</td>' +
                '    <td>数据来源</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("纳入部级重点人员库时间")]||"")+'</td>' +
                '<tr>' +
                '<tr>' +
                '   <td>ZDRYLBBJ</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("ZDRYLBBJ")]||"")+'</td>' +
                '   <td>ZDRYXL</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("ZDRYXL")]||"")+'</td>' +
                '   <td>重点人员细类</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("重点人员细类")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>有效性</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("有效性")]||"")+'</td>' +
                '    <td>记录变更时间</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("记录变更时间")]||"")+'</td>' +
                '<tr>' +
                '<tr>' +
                '   <td>记录新增时间</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("记录新增时间")]||"")+'</td>' +
                '   <td>HCK_RKSJ</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("HCK_RKSJ")]||"")+'</td>' +
                '   <td>src</td>' +
                '   <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("src")]||"")+'</td>' +
                '</tr>' +
                '</tbody>' +
                '                </table>';
            $(".qiandu_zhongdianrenyuan").append(list);
        })
    }

    //人社参保人员
    function qiandu_rscbry(qddata) {
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var colomdata = item;
            //电话
            var phone = colomdata[odata.indexOf("联系方式")];
            if (phone) {
                $(".sx_ppplianxi").append('<p class="sx_p1 sxtips" data-href="' + infofrom +'-人社参保人员"><span>手机号：' + phone + '</span></p>');
            }
            var list = ' <tr class="sxtips" data-href="'+infofrom+'-人社参保人员">' +
                '<td>'+(colomdata[odata.indexOf("姓名")]||"")+'</td>' +
                '<td>'+(colomdata[odata.indexOf("医疗保险参保状态")]||"")+'</td>' +
                '<td>'+(colomdata[odata.indexOf("上报市")]||"")+'</td>' +
                '<td>'+(colomdata[odata.indexOf("社会保障号码")]||"")+'</td>' +
                '<td>'+(colomdata[odata.indexOf("离退休标识")]||"")+'</td>' +
                '<td>'+(colomdata[odata.indexOf("户口所在地")]||"")+'</td>' +
                '<td>'+(colomdata[odata.indexOf("联系方式")]||"")+'</td>' +
                '<td>'+(colomdata[odata.indexOf("YLBXZT_ZW")]||"")+'</td>' +
                '</tr>'
            $(".qiandu_yibao").append(list);
        });
        $(".qiandu_yibaotitle").fadeIn();
    }

    //执法闭环
    function qiandu_zfbh(qddata) {
        var colomdata = qddata.data[0];
        var odata = qddata.column;
        var list = '<table cellpadding="0" cellspacing="2" class="sj_table2 sxtips" data-href="'+infofrom+'-执法闭环">' +
            '<tr class="sj_firtr">' +
            '    <td colspan="9" style="background: transparent;">执法闭环</td>' +
            '</tr>' +
            '<tbody>' +
            '<tr>' +
            '    <td>案件名称</td>' +
            '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("案件名称")]||"")+'</td>' +
            '    <td>案件编号</td>' +
            '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("案件编号")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>案件类型</td>' +
            '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("案件类型")]||"")+'</td>' +
            '    <td>案件状态</td>' +
            '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("状态")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>姓名</td>' +
            '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("姓名")]||"")+'</td>' +
            '    <td>ZBDWJZ</td>' +
            '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("ZBDWJZ")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>ZBDWJZ_ZW</td>' +
            '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("ZBDWJZ_ZW")]||"")+'</td>' +
            '    <td>CBDW_BH</td>' +
            '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("CBDW_BH")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>发案地点</td>' +
            '    <td colspan="8" class="sk_nr">'+(colomdata[odata.indexOf("发案地点")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>立案时间</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("立案时间")]||"")+'</td>' +
            '    <td>SLSJ</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("SLSJ")]||"")+'</td>' +
            '    <td>FASJ</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("FASJ")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>CBDW_MC</td>' +
            '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("CBDW_MC")]||"")+'</td>' +
            '    <td>JQBH</td>' +
            '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("JQBH")]||"")+'</td>' +
            '</tr>' +

            '<tr>' +
            '    <td>XYR_XM</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("XYR_XM")]||"")+'</td>' +
            '    <td>ZBX</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("ZBX")]||"")+'</td>' +
            '    <td>AYMC</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("AYMC")][0]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>_version_</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("_version_")]||"")+'</td>' +
            '    <td>XYR_RYBH</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("XYR_RYBH")][0]||"")+'</td>' +
            '    <td>XYR_CYM</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("XYR_CYM")][0]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>XYR_BH</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("XYR_BH")][0]||"")+'</td>' +
            '    <td>XYR_SFZH</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("XYR_SFZH")][0]||"")+'</td>' +
            '    <td>src</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("src")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>简要案情</td>' +
            '    <td colspan="8" class="sk_nr" style="width: 85%;">'+(colomdata[odata.indexOf("简要案情")]||"")+'</td>' +
            '</tr>' +
            '</tbody>' +
            '                </table>';
        $(".bihuan_anjian").append(list);
    }

    //执法闭环嫌疑人
    function qiandu_zfbhxyr(qddata) {
        var colomdata = qddata.data[0];
        var odata = qddata.column;
        var list = '<table cellpadding="0" cellspacing="2" class="sj_table2 sxtips" data-href="'+infofrom+'-执法闭环嫌疑人">' +
            '<tr class="sj_firtr">' +
            '    <td colspan="9" style="background: transparent;">执法闭环嫌疑人</td>' +
            '</tr>' +
            '<tbody>' +
            '<tr>' +
            '    <td>系统编号</td>' +
            '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("系统编号")]||"")+'</td>' +
            '    <td>人员编号</td>' +
            '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("人员编号")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>姓名</td>' +
            '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("姓名")]||"")+'</td>' +
            '    <td>姓名拼音</td>' +
            '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("姓名拼音")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>曾用名</td>' +
            '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("曾用名")]||"")+'</td>' +
            '    <td>罪犯编号</td>' +
            '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("罪犯编号")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>身份证号</td>' +
            '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("身份证号")]||"")+'</td>' +
            '    <td>QTZJLX1</td>' +
            '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("QTZJLX1")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>QTZJLX1_ZW</td>' +
            '    <td colspan="8" class="sk_nr">'+(colomdata[odata.indexOf("QTZJLX1_ZW")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>性别</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("性别")]||"")+'</td>' +
            '    <td>民族</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("民族")]||"")+'</td>' +
            '    <td>出生时间</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("出生时间")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>联系方式</td>' +
            '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("联系方式")]||"")+'</td>' +
            '    <td>户籍地详址</td>' +
            '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("户籍地详址")]||"")+'</td>' +
            '</tr>' +

            '<tr>' +
            '    <td>政治面貌</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("政治面貌")]||"")+'</td>' +
            '    <td>SFTSQT</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("SFTSQT")]||"")+'</td>' +
            '    <td>TSQT</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("TSQT")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>是否特殊群体</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("是否特殊群体")]||"")+'</td>' +
            '    <td>SFLAR</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("SFLAR")]||"")+'</td>' +
            '    <td>国籍</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("国籍")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>工作单位</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("工作单位")]||"")+'</td>' +
            '    <td>CH</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("CH")]||"")+'</td>' +
            '    <td>出生年份</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("出生年份")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>出生日期</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("出生日期")]||"")+'</td>' +
            '    <td>状态</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("状态")]||"")+'</td>' +
            '    <td>src</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("src")]||"")+'</td>' +
            '</tr>' +
            '</tbody>' +
            '                </table>';
        $(".bihuan_anjian").append(list);
    }

    //常住人口
    function qiandu_czrk(qddata) {
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var jiashi = '<dl class="sx_imgbox sxtips" data-href="' + infofrom + '-常住人口">' +
                '<dt style="margin-left: 0;">' +
                '<div>';
            $.each(item, function (i, item) {
                if(i!=1){
                    jiashi += '<span>' + odata[i] + '：<i>' + item + '</i></span>';
                }
            });
            jiashi += '</div></dt></dl>';
            $(".qiandu_changzhurenkou").append(jiashi);
        });
    }

    //高危人员
    function qiandu_gwry(qddata) {
        $(".biaoqiandetial").append('<li class="sd_red">高危</li>');
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var colomdata = item;
            var list = '<table cellpadding="0" cellspacing="2" class="sj_table2 sxtips" data-href="'+infofrom+'-高危人员">' +
                '<tr class="sj_firtr">' +
                '    <td colspan="9" style="background: transparent;">高危人员'+(i+1)+'</td>' +
                '</tr>' +
                '<tbody>' +
                '<tr>' +
                '    <td>系统编号</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("系统编号")]||"")+'</td>' +
                '    <td>姓名</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("姓名")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>性别</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("性别")]||"")+'</td>' +
                '    <td>出生时间</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("出生时间")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>公民身份号码</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("公民身份号码")]||"")+'</td>' +
                '    <td>民族</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("民族")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>学历</td>' +
                '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("学历")]||"")+'</td>' +
                '    <td>工作单位</td>' +
                '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("工作单位")]||"")+'</td>' +
                '    <td>现住地详址</td>' +
                '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("现住地详址")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>职业</td>' +
                '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("职业")]||"")+'</td>' +
                '    <td>姓名拼音</td>' +
                '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("姓名拼音")]||"")+'</td>' +
                '    <td>出生年份</td>' +
                '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("出生年份")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>出生日期</td>' +
                '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("出生日期")]||"")+'</td>' +
                '    <td>src</td>' +
                '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("src")]||"")+'</td>' +
                '    <td>_version_</td>' +
                '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("_version_")]||"")+'</td>' +
                '</tr>' +
                '</tbody>' +
                '                </table>';
            $(".qiandu_gaoweirenyuan").append(list);
        });
    }

    //案件嫌疑人
    function qiandu_ajxyr(qddata) {
        $(".biaoqiandetial").append('<li class="sd_red">嫌疑人</li>');
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var colomdata = item;
            var list = '<table cellpadding="0" cellspacing="2" class="sj_table2 sxtips" data-href="'+infofrom+'-案件嫌疑人">' +
                '<tr class="sj_firtr">' +
                '    <td colspan="9" style="background: transparent;">案件嫌疑人'+(i+1)+'</td>' +
                '</tr>' +
                '<tbody>' +
                '<tr>' +
                '    <td>系统编号</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("系统编号")]||"")+'</td>' +
                '    <td>姓名</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("姓名")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>学历</td>' +
                '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("学历")]||"")+'</td>' +
                '    <td>工作单位</td>' +
                '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("工作单位")]||"")+'</td>' +
                '    <td>现住地详址</td>' +
                '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("现住地详址")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>职业</td>' +
                '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("职业")]||"")+'</td>' +
                '    <td>姓名拼音</td>' +
                '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("姓名拼音")]||"")+'</td>' +
                '    <td>出生年份</td>' +
                '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("出生年份")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>性别</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("性别")]||"")+'</td>' +
                '    <td>出生时间</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("出生时间")]||"")+'</td>' +
                '</tr>' +
                '<tr>' +
                '    <td>公民身份号码</td>' +
                '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("公民身份号码")]||"")+'</td>' +
                '    <td>民族</td>' +
                '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("民族")]||"")+'</td>' +
                '</tr>' +

                '<tr>' +
                '    <td>出生日期</td>' +
                '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("出生日期")]||"")+'</td>' +
                '    <td>src</td>' +
                '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("src")]||"")+'</td>' +
                '    <td>_version_</td>' +
                '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("_version_")]||"")+'</td>' +
                '</tr>' +
                '</tbody>' +
                '                </table>';
            $(".qiandu_anjian").append(list);
        });
    }

    //机动车
    function qiandu_wp(qddata) {
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var colomdata = item;
            var cheliang = '<li>' +
                '<ul  class="sw_ul1 sxtips" data-href="'+infofrom+'">' +
                '    <li class="sxtips"  style="margin: 0;">' + (colomdata[odata.indexOf("HPHM_UPCASE")]||"") + '</li>' +
                '    <li>' + (colomdata[odata.indexOf("中文品牌")]||"") + '</li>' +
                '    <li>' + (colomdata[odata.indexOf("机动车所有人")]||"") + '</li>' +
                '    <li>' + (colomdata[odata.indexOf("发证日期")]||"") + '</li>' +
                '    <li style="width: 25%;">' + (colomdata[odata.indexOf("联系电话")]||"") + '</li>' +
                '    <li class="swxq_1" data-href="true">' +
                '        <span class="iconfont icon-rwcharacter"></span>' +
                '        <span>详情</span>' +
                '    </li>' +
                '</ul>' +
                '<div class="sw_div1 sw_div2" style="padding: 0 3%;clear: both;">发动机号：' + (colomdata[odata.indexOf("XJD_XZ")]||"") + '</div>' +
                '</li>'
            $(".cheliangbox").append(cheliang);
        });
        $(".che_liang").fadeIn();
    }

    //交通违法
    function qiandu_jtwf(qddata) {
        gettong(0);
        var totalnu = 0;
        function setPageNo(count) {
            laypage.render({
                elem: 'listpage16',
                count: count,
                first: '首页',
                last: '尾页',
                jump: function (obj, first) {
                    //clga.setpagecss(obj.elem);
                    if (!first) {
                        gettong(obj.curr - 1);
                    }
                }
            });
        }
        function gettong(pageNume) {
            $.ajax({
                url: ctx+"track/sort",
                type: "post",
                xhrFields: {
                    withCredentials: true
                },
                data: JSON.stringify({
                    "data": qddata,
                    "pageNum": pageNume,
                    "pageSize": 10,
                    "sortMsg": "违法时间",
                    "sortType": 0,
                    "page":true
                }),
                contentType:"application/json",
                success: function (res) {
                    if (0 === pageNume) {
                        count = res.data.data.totalNumber;
                        setPageNo(count);
                    }
                    var odata = qddata.column;
                    $.each(res.data.data.dataList,function (i,item) {
                        totalnu++;
                        var colomdata = item;
                        var cheliang = '<li class="sw_li sxtips" data-href="'+infofrom+'-交通违法">' +
                            '<ul  class="sw_ul1">' +
                            '    <li style="margin: 0;width: 10%;">' + (colomdata[odata.indexOf("号牌号码")]||"") + '</li>' +
                            '    <li style="width: 12%;">' + (colomdata[odata.indexOf("号牌种类")]||"") + '</li>' +
                            '    <li style="width: 40%;">' + (colomdata[odata.indexOf("违法地址")]||"") + '</li>' +
                            '    <li style="width: 20%;">' + (colomdata[odata.indexOf("违法时间")]||"") + '</li>' +
                            '    <li style="width: 8%;">' + (colomdata[odata.indexOf("交款标记")]||"") + '</li>' +
                            '    <li class="swxq_1" data-href="true"  style="width: 10%;">' +
                            '        <span class="iconfont icon-rwcharacter"></span>' +
                            '        <span>详情</span>' +
                            '    </li>' +
                            '</ul>' +
                            '<div class="sw_div1 sw_div2" style="padding: 0 3%;clear: both;">' + (colomdata[odata.indexOf("违法行为")]||"") + '</div>' +
                            '</li>';
                        $(".weizhang_box").append(cheliang);
                    });
                    $(".che_weizhang").fadeIn();
                }
            });
        }
    }

    //宾馆住宿
    function qiandu_bgzs(qddata) {
        gettong(0);
        var totalnu = 0;
        function setPageNo(count) {
            laypage.render({
                elem: 'listpage15',
                count: count,
                first: '首页',
                last: '尾页',
                jump: function (obj, first) {
                    //clga.setpagecss(obj.elem);
                    if (!first) {
                        gettong(obj.curr - 1);
                    }
                }
            });
        }
        function gettong(pageNume) {
            $.ajax({
                url: ctx+"track/sort",
                type: "post",
                xhrFields: {
                    withCredentials: true
                },
                data: JSON.stringify({
                    "data": qddata,
                    "pageNum": pageNume,
                    "pageSize": 10,
                    "sortMsg": "入住时间",
                    "sortType": 0,
                    "page":true
                }),
                contentType:"application/json",
                success: function (res) {
                    if (0 === pageNume) {
                        count = res.data.data.totalNumber;
                        setPageNo(count);
                    }
                    var odata = qddata.column;
                    $.each(res.data.data.dataList,function (i,item) {
                        totalnu++;
                        var colomdata = item;
                        var list = '<li class="sw_li sxtips" data-href="'+infofrom+'-宾馆住宿">' +
                            '<ul class="sx_ul">' +
                            '    <li class="sx_li">' + totalnu+ '</li>' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("姓名")]||"") + '</li>' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("宾馆名称")]||"") + '</li>' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("CITY_CODE_ZW")]||"") + '</li>' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("入住房号")]||"") + '</li>' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("入住时间")]||"") + '</li>' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("退房时间")]||"") + '</li>' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("房间号")]||"") + '</li>' +
                            '    <li class="swxq_1 sx_li swxq_1" data-href="true">' +
                            '        <span class="iconfont icon-rwcharacter"></span>' +
                            '        <span>详情</span>' +
                            '    </li>' +
                            '</ul>' +
                            '<div class="sw_div1 sw_div2">派出所名称：' + (colomdata[odata.indexOf("STA_CODE_ZW")]||"") + '</div>' +
                            '</li>'
                        $(".guiji_binguan").append(list);
                    });
                    $(".guijibianguan").fadeIn();
                }
            });
        }
    }

    //铁路记录
    function qiandu_tljl(qddata) {
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var colomdata = item;
            var list = '<li class="sw_li sxtips" data-href="'+infofrom+'-铁路记录">' +
                '<ul class="sx_ul">' +
                '    <li class="sx_li">' + (i+1)+ '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("姓名")]||"") + '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("公民身份号码")]||"") + '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("乘车日期")]||"") + '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("车次")]||"") + '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("座位号")]||"") + '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("出发站")]||"") + '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("到达站")]||"") + '</li>' +
                '    <li class="swxq_1 sx_li swxq_1" data-href="true">' +
                '        <span class="iconfont icon-rwcharacter"></span>' +
                '        <span>详情</span>' +
                '    </li>' +
                '</ul>' +
                '<div class="sw_div1 sw_div2">购票人姓名：' + (colomdata[odata.indexOf("购票人姓名")]||"") + '  &nbsp;   购票人证件号码：' + (colomdata[odata.indexOf("购票人证件号码")]||"") + '</div>' +
                '</li>'
            $(".qiandu_huoche").append(list);
        });
        $(".guiji_huoche").fadeIn();
    }

    //民航进出港
    function qiandu_mhjcg(qddata) {
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var colomdata = item;
            var list = '<li class="sw_li sxtips" data-href="'+infofrom+'-民航进出港">' +
                '<ul class="sx_ul">' +
                '    <li class="sx_li">' + (i+1)+ '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("姓名")]||"") + '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("证件号码")]||"") + '</li>' +
                '    <li class="sx_li" style="width: 12%;">' + (colomdata[odata.indexOf("离港时间")]||"") + '</li>' +
                '    <li class="sx_li" style="width: 12%;">' + (colomdata[odata.indexOf("进港时间")]||"") + '</li>' +
                '    <li class="sx_li" style="width: 5%;">' + (colomdata[odata.indexOf("当前航站座位号")]||"") + '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("登记机场")]||"") + '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("到达机场")]||"") + '</li>' +
                '    <li class="swxq_1 sx_li swxq_1" data-href="true">' +
                '        <span class="iconfont icon-rwcharacter"></span>' +
                '        <span>详情</span>' +
                '    </li>' +
                '</ul>' +
                '<div class="sw_div1 sw_div2">旅客舱位信息：' + (colomdata[odata.indexOf("旅客舱位信息")]||"") + '  &nbsp;   联系方式：' + (colomdata[odata.indexOf("联系方式")]||"") + '  &nbsp;   航班日期：' + (colomdata[odata.indexOf("航班日期")]||"") + '</div>' +
                '</li>'
            $(".qiandu_jinchugang").append(list);
        });
        $(".guiji_jinchugangtitle").fadeIn();
    }

    //山东警务云上网同记录
    function qiandu_sdjwyswtjl(qddata) {
        $.ajax({
            url: ctx + "/track/get",
            type: "get",
            xhrFields: {
                withCredentials: true
            },
            data: {
                jobid: jobdata.jobinfo.jobid,
                trackType: '网吧轨迹',
                beginDate: '',
                endDate:''
            },
            dataType: "json",
            success: function (res) {
                var odata = res[0].columns
                $.each(res,function (i,item) {
                    var colomdata = item.dataList;
                    var list = '<li class="sw_li sxtips" data-href="'+infofrom+'-山东警务云上网同记录">' +
                        '<ul class="sx_ul2">' +
                        '    <li class="sx_li">' + (i+1)+ '</li>' +
                        '    <li class="sx_li">' + (colomdata[odata.indexOf("上网人员姓名")]||"") + '</li>' +
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
                    $(".gjtongshang").append(list);
                });
                $(".guiji_wangtitle").fadeIn();
            }
        });

        gettong(0);
        function setPageNo(count) {
            laypage.render({
                elem: 'listpage17',
                count: count,
                first: '首页',
                limit:21,
                last: '尾页',
                jump: function (obj, first) {
                    //clga.setpagecss(obj.elem);
                    if (!first) {
                        gettong(obj.curr - 1);
                    }
                }
            });
        }
        function gettong(pageNum) {
            $.ajax({
                url: ctx+"track/sort",
                type: "post",
                xhrFields: {
                    withCredentials: true
                },
                data: JSON.stringify({
                    "data": qddata,
                    "pageNum": pageNum,
                    "pageSize": 21,
                    "sortMsg": "上机时间",
                    "sortType": 0,
                    "page":true
                }),
                contentType:"application/json",
                success: function (res) {
                    if (0 === pageNum) {
                        count = res.data.data.totalNumber;
                        setPageNo(count);
                    }
                    var odata = qddata.column;
                    $.each(res.data.data.dataList,function (i,item) {
                        var olist = '<span>信息来源：'+infofrom+'-山东警务云上网同记录</span>';
                        $.each(item,function (i,item) {
                            olist+='<span>'+odata[i]+'：'+item+'</span>'
                        });
                        var colomdata = item;
                        var linju = '<li class="smalltips" data-href="'+olist+'">' +
                            '<img src="http://ys.zyfw.ga/photo/renkou/photoSearch.do?method=allPhoto1&searchword=SFZHM:'+colomdata[odata.indexOf("同上网人员姓名")]+'&order=0" alt="" onerror="clga.whenoerron(this)">' +
                            '<p>' + (colomdata[odata.indexOf("同上网人员姓名")]||"") + '</p>' +
                            '<p>' + (colomdata[odata.indexOf("同上网人员身份证")]||"") + '</p>' +
                            '<p>网吧号：' + (colomdata[odata.indexOf("网吧号")]||"") + '</p>' +
                            '</li>';
                        $(".qiandu_tswrenyuan").append(linju);
                    });
                    $(".qiandu_tswrenyuan").find("img").css("height",liwidth);
                }
            });
        }
    }

    //同违章
    function qiandu_twz(qddata) {
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var sxdata = item;
            var gonganimg = "";
            if(sxdata[odata.indexOf("身份证")]){
                gonganimg = "http://ys.zyfw.ga/photo/renkou/photoSearch.do?method=allPhoto1&searchword=SFZHM:"+sxdata[odata.indexOf("身份证")]+"&order=0";
            }else{
                gonganimg = "../../img/default.jpg";
            }
            var yun_weizhang = '<li class="sw_li">' +
                '<ul  class="sw_ul2">' +
                '    <li>'+sxdata[odata.indexOf("车牌")]+'</li>' +
                '    <li><img class="imgfangda" src="'+gonganimg+'" style="height: 30px;margin: 6px;" onerror="clga.whenoerron(this)"></li>' +
                '    <li class="sxtips" data-href="'+infofrom+'" style="margin: 0;">'+sxdata[odata.indexOf("违法人姓名")]+'</li>' +
                '    <li>'+sxdata[odata.indexOf("身份证")]+'</li>' +
                '    <li></li>' +
                '    <li style="width: 22%;"></li>' +
                '    <li style="width: 22%;">'+sxdata[odata.indexOf("违法时间")]+'</li>' +
                '</ul>' +
                '</li>';
            $(".yun_weizhang").append(yun_weizhang);
        });
        $(".che_weizhang").fadeIn();
    }

    //驾驶证
    function qiandu_jsz(qddata) {
        //驾驶员信息
        var jiashidata = qddata.data[0];
        var jiashi = '<dl class="sx_imgbox sxtips" data-href="' + infofrom + '">' +
            '<dd><img src="../../img/default.jpg" alt=""></dd>' +
            '<dt>' +
            '<div>';
        $.each(qddata.column, function (i, item) {
            jiashi += '<span>' + item + '：<i>' + jiashidata[i] + '</i></span>'
        });
        jiashi += '</div></dt></dl>';
        $(".sx_jiashiren").append(jiashi);
    }

    //流动人口
    function qiandu_ldrk(qddata) {
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var jiashi = '<dl class="sx_imgbox sxtips" data-href="' + infofrom + '-流动人口">' +
                '<dt style="margin-left: 0;">' +
                '<div>';
            $.each(item, function (i, item) {
                if(i!=1){
                    jiashi += '<span>' + odata[i] + '：<i>' + item + '</i></span>';
                }
            });
            jiashi += '</div></dt></dl>';
            $(".qiandu_liudongrenkou").append(jiashi);
        });
    }

    //山东核录
    function qiandu_sdhl(qddata) {
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var colomdata = item;
            var list = '<li class="sw_li sxtips" data-href="'+infofrom+'-山东核录">' +
                '<ul class="sx_ul5">' +
                '    <li class="sx_li" style="width: 6%;">'+(i+1)+'</li>' +
                '    <li class="sx_li" style="width: 10%;">' + (colomdata[odata.indexOf("姓名")]||"") + '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("证件号码")]||"") + '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("核录位置")]||"") + '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("核录时间")]||"") + '</li>' +
                '    <li class="sx_li" style="width:12%;">' + (colomdata[odata.indexOf("坐标(东经)")]||"") + '</li>' +
                '    <li class="sx_li" style="width:12%;">' + (colomdata[odata.indexOf("坐标(北纬)")]||"") + '</li>' +
                '</ul>' +
                '</li>';
            $(".qiandu_shangdonghelu").append(list);
        });
        $(".qianduhelu_title").fadeIn();
    }

    //公安请求服务火车购票记录
    function qiandu_gaqqhcgpjl(qddata) {
        gettong(0);
        var totalnu = 0;
        function setPageNo(count) {
            laypage.render({
                elem: 'listpage13',
                count: count,
                first: '首页',
                last: '尾页',
                jump: function (obj, first) {
                    ////clga.setpagecss(obj.elem);
                    if (!first) {
                        gettong(obj.curr - 1);
                    }
                }
            });
        }
        function gettong(pageNume) {
            $.ajax({
                url: ctx+"track/sort",
                type: "post",
                xhrFields: {
                    withCredentials: true
                },
                data: JSON.stringify({
                    "data": qddata,
                    "pageNum": pageNume,
                    "pageSize": 10,
                    "sortMsg": "发车日期",
                    "sortType": 0,
                    "page":true
                }),
                contentType:"application/json",
                success: function (res) {
                    if (0 === pageNume) {
                        count = res.data.data.totalNumber;
                        setPageNo(count);
                    }
                    var odata = res.data.column;
                    $.each(res.data.data.dataList,function (i,item) {
                        totalnu++;
                        var colomdata = item;
                        var list = '<li class="sw_li sxtips" data-href="'+infofrom+'-公安请求服务火车购票记录">' +
                            '<ul class="sx_ul5">' +
                            '    <li class="sx_li" style="width: 6%;">'+totalnu+'</li>' +
                            '    <li class="sx_li" style="width: 10%;">' + (colomdata[odata.indexOf("票号")]||"") + '</li>' +
                            '    <li class="sx_li" style="width: 10%;">' + (colomdata[odata.indexOf("发车日期")]||"") + '</li>' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("车次")]||"") + '</li>' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("出发站")]||"") + '</li>' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("到达站")]||"") + '</li>' +
                            '    <li class="sx_li" style="width:12%;">' + (colomdata[odata.indexOf("状态")]||"") + '</li>' +
                            '</ul>' +
                            '</li>';
                        $(".qiandu_gaqqfwhcgpjl").append(list);
                    });
                }
            });
        }
        $(".qiandu_gaqqfwhcgpjltitle").fadeIn();
    }

    //汽车购票信息
    function qiandu_qcgpxx(qddata) {
        gettong(0);
        var totalnu = 0;
        function setPageNo(count) {
            laypage.render({
                elem: 'listpage18',
                count: count,
                first: '首页',
                last: '尾页',
                jump: function (obj, first) {
                    ////clga.setpagecss(obj.elem);
                    if (!first) {
                        gettong(obj.curr - 1);
                    }
                }
            });
        }
        function gettong(pageNume) {
            $.ajax({
                url: ctx+"track/sort",
                type: "post",
                xhrFields: {
                    withCredentials: true
                },
                data: JSON.stringify({
                    "data": qddata,
                    "pageNum": pageNume,
                    "pageSize": 10,
                    "sortMsg": "购票日期时间",
                    "sortType": 0,
                    "page":true
                }),
                contentType:"application/json",
                success: function (res) {
                    if (0 === pageNume) {
                        count = res.data.data.totalNumber;
                        setPageNo(count);
                    }
                    var odata = res.data.column;
                    $.each(res.data.data.dataList,function (i,item) {
                        totalnu++;
                        var colomdata = item;
                        var list = '<li class="sw_li sxtips" data-href="'+infofrom+'-公安请求服务火车购票记录">' +
                            '<ul class="sx_ul5">' +
                            '    <li class="sx_li" style="width: 6%;">'+totalnu+'</li>' +
                            '    <li class="sx_li" style="width: 10%;">' + (colomdata[odata.indexOf("旅客姓名")]||"") + '</li>' +
                            '    <li class="sx_li" style="width: 13%;">' + (colomdata[odata.indexOf("购票日期时间")]||"") + '</li>' +
                            '    <li class="sx_li" style="width: 13%;">' + (colomdata[odata.indexOf("发车日期时间")]||"") + '</li>' +
                            '    <li class="sx_li" style="width: 8%;">' + (colomdata[odata.indexOf("车次")]||"") + '</li>' +
                            '    <li class="sx_li" style="width: 8%;">' + (colomdata[odata.indexOf("车牌号码")]||"") + '</li>' +
                            '    <li class="sx_li" style="width: 12%;">' + (colomdata[odata.indexOf("出发站")]||"") + '</li>' +
                            '    <li class="sx_li" style="width: 12%;">' + (colomdata[odata.indexOf("到达站")]||"") + '</li>' +
                            '    <li class="sx_li" style="width: 12%;">' + (colomdata[odata.indexOf("GPFS")]||"") + '</li>' +
                            '</ul>' +
                            '</li>';
                        $(".qiandu_qcgpxx").append(list);
                    });
                }
            });
        }
        $(".qiandu_qcgpxxtitle").fadeIn();
    }

    //宾馆疑似同住人员
    function qiandu_bgystzry(qddata) {
        gettong(0);
        function setPageNo(count) {
            laypage.render({
                elem: 'listpage7',
                count: count,
                limit:21,
                first: '首页',
                last: '尾页',
                jump: function (obj, first) {
                    //clga.setpagecss(obj.elem);
                    if (!first) {
                        gettong(obj.curr - 1);
                    }
                }
            });
        }
        function gettong(pageNum) {
            $.ajax({
                url: ctx+"analysis/getList",
                type: "get",
                xhrFields: {
                    withCredentials: true
                },
                data: {
                    pageNum:pageNum,
                    pageSize:21,
                    jobid:jobdata.jobinfo.jobid,
                    platform:"sdgayjs",
                    dataType:"宾馆疑似同住人员"
                },
                dataType:"json",
                success: function (res) {
                    if (res.code != 0) {
                        return layer.msg(res.message, {anim: 6});
                    }
                    if (0 === pageNum) {
                        count = res.data.totalNumber;
                        setPageNo(count);
                    }
                    var odata = res.data.columns
                    $.each(res.data.dataList, function (i, item) {
                        var colomdata = item;
                        var linju = '<li class="sxtips" data-href="'+infofrom+'-宾馆疑似同住人员">' +
                            '<img src="http://ys.zyfw.ga/photo/renkou/photoSearch.do?method=allPhoto1&searchword=SFZHM:'+colomdata[odata.indexOf("身份证号")]+'&order=0" alt="" onerror="clga.whenoerron(this)">' +
                            '<p>' + (colomdata[odata.indexOf("姓名")]||"") + '</p>' +
                            '<p>' + (colomdata[odata.indexOf("身份证号")]||"") + '</p>' +
                            '<p>疑似次数：' + (colomdata[odata.indexOf("疑似次数")]||"") + '</p>' +
                            '</li>';
                        $(".qiandu_binguanyisi").append(linju);
                    });
                    $(".qiandu_binguanyisi").find("img").css("height",liwidth);
                }
            });
        }
        //业务
        $(".ding_yisitongzhu").click(function () {
            var current = $(".qiandu_binguanyisi").offset().top-300;
            $("html body").animate(({scrollTop:current}),300);
        });
    }

    //宾馆同住人员
    function qiandu_bgtzry(qddata) {
        gettong(0);
        function setPageNo(count) {
            laypage.render({
                elem: 'listpage8',
                count: count,
                limit:21,
                first: '首页',
                last: '尾页',
                jump: function (obj, first) {
                    //clga.setpagecss(obj.elem);
                    if (!first) {
                        gettong(obj.curr - 1);
                    }
                }
            });
        }
        function gettong(pageNum) {
            $.ajax({
                url: ctx+"analysis/getList",
                type: "get",
                xhrFields: {
                    withCredentials: true
                },
                data: {
                    pageNum:pageNum,
                    pageSize:21,
                    jobid:jobdata.jobinfo.jobid,
                    platform:"sdgayjs",
                    dataType:"宾馆同住人员"
                },
                dataType:"json",
                success: function (res) {
                    if (res.code != 0) {
                        return layer.msg(res.message, {anim: 6});
                    }
                    if (0 === pageNum) {
                        count = res.data.totalNumber;
                        setPageNo(count);
                    }
                    var odata = res.data.columns
                    $.each(res.data.dataList, function (i, item) {
                        var colomdata = item;
                        var linju = '<li class="sxtips" data-href="'+infofrom+'-宾馆同住人员">' +
                            '<img src="http://ys.zyfw.ga/photo/renkou/photoSearch.do?method=allPhoto1&searchword=SFZHM:'+colomdata[odata.indexOf("身份证号")]+'&order=0" alt="" onerror="clga.whenoerron(this)">' +
                            '<p>' + (colomdata[odata.indexOf("姓名")]||"") + '</p>' +
                            '<p>' + (colomdata[odata.indexOf("身份证号")]||"") + '</p>' +
                            '<p>同住次数：' + (colomdata[odata.indexOf("同住次数")]||"") + '</p>' +
                            '</li>';
                        $(".qiandu_binguantongzhu").append(linju);
                    });
                    $(".qiandu_binguantongzhu").find("img").css("height",liwidth);
                }
            });
        }
        //业务
        $(".ding_binguantongzhu").click(function () {
            var current = $(".qiandu_binguantongzhu").offset().top-300;
            $("html body").animate(({scrollTop:current}),300);
        });
    }

    //出境申请
    function qiandu_cjsq(qddata) {
        console.log(qddata)
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var colomdata = item;
            var list = '<li class="sw_li sxtips" data-href="'+infofrom+'-出境申请">' +
                '<ul class="sx_ul5">' +
                '    <li class="sx_li" style="width: 6%;">'+(i+1)+'</li>' +
                '    <li class="sx_li" style="width: 6%;">' + (colomdata[odata.indexOf("姓名")]||"") + '</li>' +
                '    <li class="sx_li" style="width: 10%;">' + (colomdata[odata.indexOf("出生时间")]||"") + '</li>' +
                '    <li class="sx_li" style="width: 6%;">' + (colomdata[odata.indexOf("民族")]||"") + '</li>' +
                '    <li class="sx_li" style="width: 8%;">' + (colomdata[odata.indexOf("状态")]||"") + '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("手机")]||"") + '</li>' +
                '    <li class="sx_li" style="width:12%;">' + (colomdata[odata.indexOf("_version_")]||"") + '</li>' +
                '</ul>' +
                '</li>';
            $(".qiandu_churujing").append(list);
        });
        $(".qiandu_churutitle").fadeIn();
    }

    //山东警务云宾馆同房间
    function qiandu_sdjwybgtfj(qddata) {
        gettong(0);
        function setPageNo(count) {
            laypage.render({
                elem: 'listpage9',
                count: count,
                limit:21,
                first: '首页',
                last: '尾页',
                jump: function (obj, first) {
                    //clga.setpagecss(obj.elem);
                    if (!first) {
                        gettong(obj.curr - 1);
                    }
                }
            });
        }
        function gettong(pageNum) {
            $.ajax({
                url: ctx+"analysis/getList",
                type: "get",
                xhrFields: {
                    withCredentials: true
                },
                data: {
                    pageNum:pageNum,
                    pageSize:21,
                    jobid:jobdata.jobinfo.jobid,
                    platform:"sdgayjs",
                    dataType:"山东警务云宾馆同房间"
                },
                dataType:"json",
                success: function (res) {
                    if (res.code != 0) {
                        return layer.msg(res.message, {anim: 6});
                    }
                    if (0 === pageNum) {
                        count = res.data.totalNumber;
                        setPageNo(count);
                    }
                    var odata = res.data.columns
                    $.each(res.data.dataList, function (i, item) {
                        var olist = '<span>信息来源：'+infofrom+'-山东警务云宾馆同房间</span>';
                        $.each(item,function (i,item) {
                            olist+='<span>'+odata[i]+'：'+item+'</span>'
                        });
                        var colomdata = item;
                        var linju = '<li class="smalltips" data-href="'+olist+'">' +
                            '<img src="http://ys.zyfw.ga/photo/renkou/photoSearch.do?method=allPhoto1&searchword=SFZHM:'+colomdata[odata.indexOf("同房间人身份证")]+'&order=0" alt="" onerror="clga.whenoerron(this)">' +
                            '<p>' + (colomdata[odata.indexOf("同房间人姓名")]||"") + '</p>' +
                            '<p>' + (colomdata[odata.indexOf("同房间人身份证")]||"") + '</p>' +
                            '<p>同住次数：' + (colomdata[odata.indexOf("同住次数")]||"") + '</p>' +
                            '</li>';
                        $(".qiandu_binguantongfj").append(linju);
                    });
                    $(".qiandu_binguantongfj").find("img").css("height",liwidth);
                }
            });
        }
        //业务
        $(".ding_sdjwybgtfj").click(function () {
            var current = $(".qiandu_binguantongfj").offset().top-300;
            $("html body").animate(({scrollTop:current}),300);
        });
    }

    //山东警务云宾馆同宾馆
    function qiandu_sdjwybgtbg(qddata) {
        gettong(0);
        function setPageNo(count) {
            laypage.render({
                elem: 'listpage10',
                count: count,
                limit:21,
                first: '首页',
                last: '尾页',
                jump: function (obj, first) {
                    //clga.setpagecss(obj.elem);
                    if (!first) {
                        gettong(obj.curr - 1);
                    }
                }
            });
        }
        function gettong(pageNum) {
            $.ajax({
                url: ctx+"analysis/getList",
                type: "get",
                xhrFields: {
                    withCredentials: true
                },
                data: {
                    pageNum:pageNum,
                    pageSize:21,
                    jobid:jobdata.jobinfo.jobid,
                    platform:"sdgayjs",
                    dataType:"山东警务云宾馆同宾馆"
                },
                dataType:"json",
                success: function (res) {
                    if (res.code != 0) {
                        return layer.msg(res.message, {anim: 6});
                    }
                    if (0 === pageNum) {
                        count = res.data.totalNumber;
                        setPageNo(count);
                    }
                    var odata = res.data.columns
                    $.each(res.data.dataList, function (i, item) {
                        var olist = '<span>信息来源：'+infofrom+'-山东警务云宾馆同宾馆</span>';
                        $.each(item,function (i,item) {
                            olist+='<span>'+odata[i]+'：'+item+'</span>'
                        });
                        var colomdata = item;
                        var linju = '<li class="smalltips" data-href="'+olist+'">' +
                            '<img src="http://ys.zyfw.ga/photo/renkou/photoSearch.do?method=allPhoto1&searchword=SFZHM:'+colomdata[odata.indexOf("同旅馆人身份证")]+'&order=0" alt="" onerror="clga.whenoerron(this)">' +
                            '<p>' + (colomdata[odata.indexOf("同旅馆人姓名")]||"") + '</p>' +
                            '<p>' + (colomdata[odata.indexOf("同旅馆人身份证")]||"") + '</p>' +
                            '<p>同旅馆人姓名：' + (colomdata[odata.indexOf("同旅馆人姓名")]||"") + '</p>' +
                            '</li>';
                        $(".qiandu_binguantongbg").append(linju);
                    });
                    $(".qiandu_binguantongbg").find("img").css("height",liwidth);
                }
            });
        }
        //业务
        $(".ding_sdjwybgtbj").click(function () {
            var current = $(".qiandu_binguantongbg").offset().top-300;
            $("html body").animate(({scrollTop:current}),300);
        });
    }

    //山东警务云同火车搭乘
    function qiandu_thcdc(qddata) {
        gettong(0);
        function setPageNo(count) {
            laypage.render({
                elem: 'listpage11',
                count: count,
                limit:21,
                first: '首页',
                last: '尾页',
                jump: function (obj, first) {
                    //clga.setpagecss(obj.elem);
                    if (!first) {
                        gettong(obj.curr - 1);
                    }
                }
            });
        }
        function gettong(pageNum) {
            $.ajax({
                url: ctx+"analysis/getList",
                type: "get",
                xhrFields: {
                    withCredentials: true
                },
                data: {
                    pageNum:pageNum,
                    pageSize:21,
                    jobid:jobdata.jobinfo.jobid,
                    platform:"sdgayjs",
                    dataType:"山东警务云同火车搭乘"
                },
                dataType:"json",
                success: function (res) {
                    if (res.code != 0) {
                        return layer.msg(res.message, {anim: 6});
                    }
                    if (0 === pageNum) {
                        count = res.data.totalNumber;
                        setPageNo(count);
                    }
                    var odata = res.data.columns
                    $.each(res.data.dataList, function (i, item) {
                        var olist = '<span>'+infofrom+'-山东警务云同火车搭乘</span>';
                        $.each(item,function (i,item) {
                            olist+='<span>'+odata[i]+'：'+item+'</span>'
                        });
                        var colomdata = item;
                        var linju = '<li class="smalltips" data-href="'+olist+'">' +
                            '<img src="http://ys.zyfw.ga/photo/renkou/photoSearch.do?method=allPhoto1&searchword=SFZHM:'+colomdata[odata.indexOf("同火车人身份证")]+'&order=0" alt="" onerror="clga.whenoerron(this)">' +
                            '<p>' + (colomdata[odata.indexOf("同旅馆人姓名")]||"") + '</p>' +
                            '<p>' + (colomdata[odata.indexOf("同火车人身份证")]||"") + '</p>' +
                            '<p>同火车人姓名：' + (colomdata[odata.indexOf("同火车人姓名")]||"") + '</p>' +
                            '</li>';
                        $(".qiandu_guanxisdjwyhctdc").append(linju);
                    });
                    $(".qiandu_guanxisdjwyhctdc").find("img").css("height",liwidth);
                }
            });
        }
        //业务
        $(".ding_sdjwyhctdc").click(function () {
            var current = $(".qiandu_guanxisdjwyhctdc").offset().top-300;
            $("html body").animate(({scrollTop:current}),300);
        });
    }

    //山东警务云民航同订票
    function qiandu_sdjwymhtdp(qddata) {
        gettong(0);
        function setPageNo(count) {
            laypage.render({
                elem: 'listpage12',
                count: count,
                limit:21,
                first: '首页',
                last: '尾页',
                jump: function (obj, first) {
                    //clga.setpagecss(obj.elem);
                    if (!first) {
                        gettong(obj.curr - 1);
                    }
                }
            });
        }
        function gettong(pageNum) {
            $.ajax({
                url: ctx+"analysis/getList",
                type: "get",
                xhrFields: {
                    withCredentials: true
                },
                data: {
                    pageNum:pageNum,
                    pageSize:21,
                    jobid:jobdata.jobinfo.jobid,
                    platform:"sdgayjs",
                    dataType:"山东警务云民航同订票"
                },
                dataType:"json",
                success: function (res) {
                    if (res.code != 0) {
                        return layer.msg(res.message, {anim: 6});
                    }
                    if (0 === pageNum) {
                        count = res.data.totalNumber;
                        setPageNo(count);
                    }
                    var odata = res.data.columns
                    $.each(res.data.dataList, function (i, item) {
                        var olist = '<span>'+infofrom+'-山东警务云民航同订票</span>';
                        $.each(item,function (i,item) {
                            olist+='<span>'+odata[i]+'：'+item+'</span>'
                        });
                        var colomdata = item;
                        var linju = '<li class="smalltips" data-href="'+olist+'">' +
                            '<img src="http://ys.zyfw.ga/photo/renkou/photoSearch.do?method=allPhoto1&searchword=SFZHM:'+colomdata[odata.indexOf("同机人身份证号")]+'&order=0" alt="" onerror="clga.whenoerron(this)">' +
                            '<p>' + (colomdata[odata.indexOf("同机人姓名")]||"") + '</p>' +
                            '<p>' + (colomdata[odata.indexOf("同机人身份证号")]||"") + '</p>' +
                            '</li>';
                        $(".qiandu_guanxisdjwymhtdp").append(linju);
                    });
                    $(".qiandu_guanxisdjwymhtdp").find("img").css("height",liwidth);
                }
            });
        }
        //业务
        $(".ding_sdjwymhtdp").click(function () {
            var current = $(".qiandu_guanxisdjwymhtdp").offset().top-300;
            $("html body").animate(({scrollTop:current}),300);
        });
    }

    //高校毕业生
    function qiandu_gxbys(qddata) {
        var odata = qddata.column;
        $.each(qddata.data,function (i,item) {
            var jiashi = '<dl class="sx_imgbox sxtips" data-href="' + infofrom + '-高校毕业生">' +
                '<dt style="margin-left: 0;">' +
                '<div>';
            $.each(item, function (i, item) {
                if(i!=1){
                    jiashi += '<span>' + odata[i] + '：<i>' + item + '</i></span>';
                }
            });
            jiashi += '</div></dt></dl>';
            $(".qiandu_gxbysbox").append(jiashi);
        });
    }

    //新常口历史同户亲属关系
    function qiandu_xcklsthqsgx(qddata) {
        var colomdata = qddata.data[0];
        var odata = qddata.column;
        console.log(qddata)
    }

    //公共就业人才服务信息
    function qiandu_ggjyrcfwxx(qddata) {
        var colomdata = qddata.data[0];
        var odata = qddata.column;
        console.log(qddata)
    }

    //社会保险信息
    function qiandu_shbxxx(qddata) {
        var colomdata = qddata.data[0];
        var odata = qddata.column;
        console.log(qddata)
    }

    //人事管理信息
    function qiandu_rsglxx(qddata) {
        var colomdata = qddata.data[0];
        var odata = qddata.column;
        console.log(qddata)
    }

    //新疆国内旅客
    function qiandu_xjgnlk(qddata) {
        gettong(0);
        var totalnu = 0;
        function gettong(pageNume) {
            $.ajax({
                url: ctx+"track/sort",
                type: "post",
                xhrFields: {
                    withCredentials: true
                },
                data: JSON.stringify({
                    "data": qddata,
                    "pageNum": pageNume,
                    "pageSize": 10,
                    "sortMsg": "入住时间",
                    "sortType": 0,
                    "page":true
                }),
                contentType:"application/json",
                success: function (res) {
                    var odata = qddata.column;
                    $.each(res.data.data.dataList,function (i,item) {
                        totalnu++;
                        var colomdata = item;
                        var list = '<li class="sw_li sxtips" data-href="'+infofrom+'-新疆国内旅客">' +
                            '<ul class="sx_ul">' +
                            '    <li class="sx_li">' + totalnu+ '</li>' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("姓名")]||"") + '</li>' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("旅馆名称")]||"") + '</li>' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("管辖地名称")]||"") + '</li>' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("入住房号")]||"") + '</li>' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("入住时间")]||"") + '</li>' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("旅馆编码")]||"") + '</li>' +
                            '    <li class="swxq_1 sx_li swxq_1" data-href="true">' +
                            '        <span class="iconfont icon-rwcharacter"></span>' +
                            '        <span>详情</span>' +
                            '    </li>' +
                            '</ul>' +
                            '<div class="sw_div1 sw_div2">旅馆地址：' + (colomdata[odata.indexOf("旅馆地址")]||"") + '</div>' +
                            '</li>'
                        $(".guiji_xjgnlkbox").append(list);
                    });
                    $(".xjgnlktitle").fadeIn();
                }
            });
        }
    }

    //新疆客运售票
    function qiandu_xjkysp(qddata) {
        gettong(0);
        var totalnu = 0;
        function gettong(pageNume) {
            $.ajax({
                url: ctx+"track/sort",
                type: "post",
                xhrFields: {
                    withCredentials: true
                },
                data: JSON.stringify({
                    "data": qddata,
                    "pageNum": pageNume,
                    "pageSize": 10,
                    "sortMsg": "乘车时间",
                    "sortType": 0,
                    "page":true
                }),
                contentType:"application/json",
                success: function (res) {
                    var odata = qddata.column;
                    $.each(res.data.data.dataList,function (i,item) {
                        totalnu++;
                        var colomdata = item;
                        var list = '<li class="sw_li sxtips" data-href="'+infofrom+'-新疆客运售票">' +
                            '<ul class="sx_ul">' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("姓名")]||"") + '</li>' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("客运站名称")]||"") + '</li>' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("发车站")]||"") + '</li>' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("到达站")]||"") + '</li>' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("乘车时间")]||"") + '</li>' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("售票时间")]||"") + '</li>' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("班次编号")]||"") + '</li>' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("车牌号")]||"") + '</li>' +
                            '    <li class="sx_li">' + (colomdata[odata.indexOf("座位号")]||"") + '</li>' +
                            '</ul>' +
                            '</li>'
                        $(".guiji_xjkyspbox").append(list);
                    });
                    $(".xjkysptitle").fadeIn();
                }
            });
        }
    }

    //华东六省
    function qiandu_hdls(label,qddata) {
        var numlei = label.split("华东六省");
        if(numlei.length>1){
            var labeln = numlei[1];
            gettong(0);
            function setPageNo(count) {
                laypage.render({
                    elem: 'listpage14',
                    count: count,
                    first: '首页',
                    last: '尾页',
                    jump: function (obj, first) {
                        //clga.setpagecss(obj.elem);
                        if (!first) {
                            gettong(obj.curr - 1);
                        }
                    }
                });
            }
            function gettong(pageNume) {
                $.ajax({
                    url: ctx+"track/sort",
                    type: "post",
                    xhrFields: {
                        withCredentials: true
                    },
                    data: JSON.stringify({
                        "data": qddata,
                        "pageNum": pageNume,
                        "pageSize": 10,
                        "sortMsg": "入住时间",
                        "sortType": 0,
                        "page":true
                    }),
                    contentType:"application/json",
                    success: function (res) {
                        if (0 === pageNume) {
                            count = res.data.data.totalNumber;
                            setPageNo(count);
                        }
                        var odata = res.data.column;
                        $.each(res.data.data.dataList,function (i,item) {
                            var colomdata = item;
                            var list = '<li class="sw_li sxtips" data-href="'+infofrom+'-'+label+'">' +
                                '<ul class="sx_ul">' +
                                '    <li class="sx_li" style="width: 8%;">' + labeln + '</li>' +
                                '    <li class="sx_li">' + (colomdata[odata.indexOf("姓名")]||"") + '</li>' +
                                '    <li class="sx_li" style="width: 18%;">' + (colomdata[odata.indexOf("旅客编号")]||"") + '</li>' +
                                '    <li class="sx_li" style="width: 18%;">' + (colomdata[odata.indexOf("证件号码")]||"") + '</li>' +
                                '    <li class="sx_li" style="width: 10%;">' + (colomdata[odata.indexOf("房间号码")]||"") + '</li>' +
                                '    <li class="sx_li" style="width: 12%;">' + (colomdata[odata.indexOf("入住时间")]||"") + '</li>' +
                                '    <li class="sx_li" style="width: 12%;">' + (colomdata[odata.indexOf("退房时间")]||"") + '</li>' +
                                '    <li class="swxq_1 sx_li swxq_1" data-href="true">' +
                                '        <span class="iconfont icon-rwcharacter"></span>' +
                                '        <span>详情</span>' +
                                '    </li>' +
                                '</ul>' +
                                '<div class="sw_div1 sw_div2">详细地址：' + (colomdata[odata.indexOf("详细地址")]||"") +' 旅馆名称：' + (colomdata[odata.indexOf("旅馆名称")]||"") + '</div>' +
                                '</li>'
                            $(".guiji_huadongliusheng").append(list);
                        });
                        $(".guijihuadongliushneg").fadeIn();
                    }
                });
            }
            $(".qiandu_gaqqfwhcgpjltitle").fadeIn();
        }
    }
}

//山东执法办案平台
function setDatasdzfpt(residdata) {
    $(".biaoqiandetial").append('<li class="sd_red">闭环</li>');
    infofrom = "山东执法办案平台";
    //人员核查业务
    var reaData = JSON.parse(residdata).data;
    //console.log(reaData)
    $.each(reaData, function (i, item) {
        var lisiisis = item.label;
        switch (lisiisis) {
            case "案件基本信息 ":
                bihuan_anjian(item.data);
                break;
            default:
                break;
        }
    });
    function bihuan_anjian(bihuandata) {
        var colomdata = bihuandata.data[0];
        var odata = bihuandata.column;
        var list = '<table cellpadding="0" cellspacing="2" class="sj_table2 sxtips" data-href="'+infofrom+'">' +
            '<tr class="sj_firtr">' +
            '    <td colspan="9" style="background: transparent;">闭环案件基本信息</td>' +
            '</tr>' +
            '<tbody>' +
            '<tr>' +
            '    <td>案件名称</td>' +
            '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("案件名称")]||"")+'</td>' +
            '    <td>案件编号</td>' +
            '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("案件编号")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>案件类型</td>' +
            '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("案件类型")]||"")+'</td>' +
            '    <td>案件状态</td>' +
            '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("案件状态")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>案件来源</td>' +
            '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("案件来源")]||"")+'</td>' +
            '    <td>案 由</td>' +
            '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("案 由")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>主办单位</td>' +
            '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("主办单位")]||"")+'</td>' +
            '    <td>办案民警</td>' +
            '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("办案民警")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>地理坐标</td>' +
            '    <td colspan="8" class="sk_nr">'+(colomdata[odata.indexOf("地理坐标")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>受理时间</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("受理时间")]||"")+'</td>' +
            '    <td>发案时间</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("发案时间")]||"")+'</td>' +
            '    <td>发案地点</td>' +
            '    <td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("发案地点")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>立案时间</td>' +
            '    <td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("立案时间")]||"")+'</td>' +
            '    <td>结案时间</td>' +
            '    <td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("结案时间")]||"")+'</td>' +
            '</tr>' +
            '<tr>' +
            '    <td>简要案情</td>' +
            '    <td colspan="8" class="sk_nr" style="width: 85%;">'+(colomdata[odata.indexOf("简要案情")]||"")+'</td>' +
            '</tr>' +
            '</tbody>' +
            '                </table>';
        $(".bihuan_anjian").append(list);
    }
}

//山东省人口信息管理系统
function setDatasdsrkxx(residdata) {
    infofrom = "山东省人口信息管理系统";
    //人员核查业务
    var reaData = JSON.parse(residdata).data;
    $.each(reaData, function (i, item) {
        var lisiisis = item.label;
        switch (lisiisis) {
            case "人口全项信息":
                qiandu_rkqx(item.data);
                break;
            case "户口信息":
                qiandu_hkxx(item.data);
                break;
            default:
                break;
        }
    });
    //人口全项信息
    function qiandu_rkqx(data) {
        var odata = data.column;
        $.each(data.data,function (i,item) {
            var jiashi = '<dl class="sx_imgbox sxtips" data-href="' + infofrom + '-人口全项信息">' +
                '<dt style="margin-left: 0;">' +
                '<div>';
            $.each(item, function (i, item) {
                if(item!=""){
                    jiashi += '<span>' + odata[i] + '：<i>' + item + '</i></span>';
                }
            });
            jiashi += '</div></dt></dl>';
            $(".sdrkxi_rkqx").append(jiashi);
        });
    }
    //户口信息
    function qiandu_hkxx(data) {
        var odata = data.column;
        $.each(data.data,function (i,item) {
            var jiashi = '<dl class="sx_imgbox sxtips" data-href="' + infofrom + '-山东省人口信息管理系统">' +
                '<dt style="margin-left: 0;">' +
                '<div>';
            $.each(item, function (i, item) {
                if(item!=""){
                    jiashi += '<span>' + odata[i] + '：<i>' + item + '</i></span>';
                }
            });
            jiashi += '</div></dt></dl>';
            $(".sdrkxi_hkxi").append(jiashi);
        });
    }
}

//潍坊智能终端分析系统（蛛网系统）wfsznzd
function setDatawfsznzd(residdata) {
    infofrom = "潍坊智能终端分析系统（蛛网系统）";
    //人员核查业务
    var reaData = JSON.parse(residdata).data;
    $.each(reaData, function (i, item) {
        var lisiisis = item.label;
        switch (lisiisis) {
            case "手机通讯录":
                zwxt_sjtxl(item.data);
                break;
            case "手机通联":
                zwxt_sjlt(item.data);
                break;
            case "QQ好友":
                zwxt_qqhy(item.data);
                break;
            case "QQ聊天":
                zwxt_qqlt(item.data);
                break;
            case "QQ群聊天":
                zwxt_qqqlt(item.data);
                break;
            case "微信好友":
                zwxt_wxhy(item.data);
                break;
            case "微信聊天":
                zwxt_wwlt(item.data);
                break;
            case "微信群聊天":
                zwxt_wxqlt(item.data);
                break;
            case "微信群成员":
                zwxt_wxqcy(item.data);
                break;
            default:
                break;
        }
    });
    console.log(reaData)
    //手机通讯录
    function zwxt_sjtxl(data) {
        var odata = data.column;
        $.each(data.data, function (i, item) {
            var colomdata = item;
            var list = '<tr class="sxtips" data-href="'+infofrom+'">' +
                '    <td>' + (colomdata[odata.indexOf("联系人号码")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("被采集号码")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("被采集实名")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("最后采集日期")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("备注名")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("其他命中信息")]||"") + '</td>' +
                '</tr>';
            $(".zwpt_sjtxlbox").append(list);
        });
        $(".hlwtit_txl").fadeIn();
    }

    //手机通联
    function zwxt_sjlt(data) {
        var odata = data.column;
        $.each(data.data, function (i, item) {
            var colomdata = item;
            var olist = '<span>'+infofrom+'</span>' +
                '<span>内容/通话时长'+(colomdata[odata.indexOf("内容/通话时长")]||"")+'</span>';
            var list = '<tr class="smalltips" data-href="'+olist+'">' +
                '    <td>' + (colomdata[odata.indexOf("机主号码")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("被采集实名")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("对方姓名")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("对方号码")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("本地动作")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("发送/接收时间")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("操作")]||"") + '</td>' +
                '</tr>';
            $(".zwpt_sjtlt").append(list);
        });
        $(".hlwtit_sjlt").fadeIn();
    }

    //QQ好友
    function zwxt_qqhy(data) {
        var odata = data.column;
        $.each(data.data, function (i, item) {
            var colomdata = item;
            var list = '<tr class="sxtips" data-href="'+infofrom+'">' +
                '    <td>' + (colomdata[odata.indexOf("昵称")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("被采集号码")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("好友昵称")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("好友号码")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("最后采集日期")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("好友备注名")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("其他命中信息")]||"") + '</td>' +
                '</tr>';
            $(".zwpt_qqhy").append(list);
        });
        $(".hlwtit_qqhy").fadeIn();
    }

    //QQ聊天
    function zwxt_qqlt(data) {
        var odata = data.column;
        $.each(data.data, function (i, item) {
            var colomdata = item;
            var list = '<tr class="sxtips" data-href="'+infofrom+'">' +
                '    <td>' + (colomdata[odata.indexOf("机主昵称")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("机主账号")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("好友昵称")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("好友账号")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("本地动作")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("内容")]||"") + '</td>' +
                '</tr>';
            $(".zwptqqlt").append(list);
        });
        $(".hlwtit_qqlt").fadeIn();
    }

    //QQ群聊天
    function zwxt_qqqlt(data) {
        var odata = data.column;
        $.each(data.data, function (i, item) {
            var colomdata = item;
            var olist = '<span>'+infofrom+'</span>' +
                '<span>内容'+(colomdata[odata.indexOf("内容")]||"")+'</span>';
            var list = '<tr class="smalltips" data-href="'+olist+'">' +
                '    <td>' + (colomdata[odata.indexOf("发送方号码")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("发送方昵称")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("群号码")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("群名称")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("时间")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("其他命中信息")]||"") + '</td>' +
                '</tr>';
            $(".zwptqqqlt").append(list);
        });
        $(".hlwtit_qqqlt").fadeIn();
    }

    //微信好友
    function zwxt_wxhy(data) {
        var odata = data.column;
        $.each(data.data, function (i, item) {
            var colomdata = item;
            var list = '<tr class="sxtips" data-href="'+infofrom+'">' +
                '    <td>' + (colomdata[odata.indexOf("昵称")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("被采集号码")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("好友昵称")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("好友号码")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("最后采集日期")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("好友备注名")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("其他命中信息")]||"") + '</td>' +
                '</tr>';
            $(".hlw_weixinhaoyou").append(list);
        });
        $(".hlwtit_wxhy").fadeIn();
    }

    //微信聊天
    function zwxt_wwlt(data) {
        var odata = data.column;
        $.each(data.data, function (i, item) {
            var colomdata = item;
            var olist = '<span>'+infofrom+'</span>' +
                '<span>内容'+(colomdata[odata.indexOf("内容")]||"")+'</span>';
            var list = '<tr class="smalltips" data-href="'+olist+'">' +
                '    <td>' + (colomdata[odata.indexOf("发送/接收时间")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("机主账号")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("机主昵称")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("好友账号")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("好友昵称")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("本地动作")]||"") + '</td>' +
                '</tr>';
            $(".zwpt_wxlt").append(list);
        });
        $(".hlwtit_wxlt").fadeIn();
    }

    //微信群聊天
    function zwxt_wxqlt(data) {
        var odata = data.column;
        $.each(data.data, function (i, item) {
            var colomdata = item;
            var olist = '<span>'+infofrom+'</span>' +
                '<span>内容'+(colomdata[odata.indexOf("内容")]||"")+'</span>';
            var list = '<tr class="smalltips" data-href="'+olist+'">' +
                '    <td>' + (colomdata[odata.indexOf("时间")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("发送方号码")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("发送方昵称")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("群号码")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("群名称")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("其他命中信息")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("操作")]||"") + '</td>' +
                '</tr>';
            $(".zwpt_wxqlt").append(list);
        });
        $(".hlwtit_wxqlt").fadeIn();
    }

    //微信群成员
    function zwxt_wxqcy(data) {
        var odata = data.column;
        $.each(data.data, function (i, item) {
            var colomdata = item;
            var list = '<tr class="sxtips" data-href="'+infofrom+'">' +
                '    <td>' + (colomdata[odata.indexOf("群号码")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("群名称")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("群成员号码")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("备注名")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("其他命中信息")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("最后采集日期")]||"") + '</td>' +
                '    <td>' + (colomdata[odata.indexOf("操作")]||"") + '</td>' +
                '</tr>';
            $(".zwpt_wxqhy").append(list);
        });
        $(".hlwtit_wxqcy").fadeIn();
    }

}

//电信诈骗
function setDatagabdxzp(residdata) {
    infofrom = "电信诈骗"
    $(".biaoqiandetial").append('<li class="sd_red">电诈</li>');
    //人员核查业务
    var reaData = JSON.parse(residdata).data;
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
    //人员基本信息
    function qiandu_jiben(juliudata) {
        var colomdata = juliudata.data[0];
        var odata = juliudata.column;
        var list = '<table cellpadding="0" cellspacing="2" class="sj_table2 sxtips" data-href="'+infofrom+'">' +
            '    <tr class="sj_firtr">' +
            '<td colspan="9" style="background: transparent;">电信诈骗</td>' +
            '    </tr>' +
            '    <tbody>' +
            '    <tr>' +
            '<td>类别</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("类别")]||"")+'</td>' +
            '<td>姓名</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("姓名")]||"")+'</td>' +
            '<td>绰号</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("绰号")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>性别</td>' +
            '<td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("性别")]||"")+'</td>' +
            '<td>出生日期</td>' +
            '<td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("出生日期")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>抓获状态</td>' +
            '<td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("抓获状态")]||"")+'</td>' +
            '<td>DNA</td>' +
            '<td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("DNA")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>指纹编号</td>' +
            '<td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("指纹编号")]||"")+'</td>' +
            '<td>是否刑拘</td>' +
            '<td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("是否刑拘")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>抓获时间</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("抓获时间")]||"")+'</td>' +
            '<td>抓获单位</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("抓获单位")]||"")+'</td>' +
            '<td>抓获地（国家）</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("抓获地（国家）")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>抓获详址</td>' +
            '<td colspan="8" class="sk_nr">'+(colomdata[odata.indexOf("抓获详址")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>证件类别</td>' +
            '<td colspan="3" class="sk_nr">'+(colomdata[odata.indexOf("证件类别")]||"")+'</td>' +
            '<td>证件号码</td>' +
            '<td colspan="4" class="sk_nr">'+(colomdata[odata.indexOf("证件号码")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>角色</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("角色")]||"")+'</td>' +
            '<td>通信方式</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("通信方式")]||"")+'</td>' +
            '<td>户籍区划</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("户籍区划")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>案件类别</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("案件类别")]||"")+'</td>' +
            '<td>现住址区划</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("现住址区划")]||"")+'</td>' +
            '<td>关联案件ID</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("关联案件ID")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>户籍地详址</td>' +
            '<td colspan="8" class="sk_nr">'+(colomdata[odata.indexOf("户籍地详址")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>现住址详址</td>' +
            '<td colspan="8" class="sk_nr">'+(colomdata[odata.indexOf("现住址详址")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>简要案情</td>' +
            '<td colspan="8" class="sk_nr">'+(colomdata[odata.indexOf("简要案情")]||"")+'</td>' +
            '    </tr>' +
            '    <tr>' +
            '<td>缴获物品-银行卡</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("缴获物品-银行卡")]||"")+'</td>' +
            '<td>缴获物品-手机号</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("缴获物品-手机号")]||"")+'</td>' +
            '<td>已上传刑拘材料</td>' +
            '<td colspan="2" class="sk_nr">'+(colomdata[odata.indexOf("已上传刑拘材料")]||"")+'</td>' +
            '    </tr>' +

            '    <tr>' +
            '<td>正面照</td>' +
            '<td colspan="2" class="sk_nr juliu_img"><img src="'+(colomdata[odata.indexOf("正面照片")]||"")+'" alt="" onerror="clga.whenoerron(this)"></td>' +
            '<td>左侧照</td>' +
            '<td colspan="2" class="sk_nr juliu_img"><img src="'+(colomdata[odata.indexOf("左侧照片")]||"")+'" alt="" onerror="clga.whenoerron(this)"></td>' +
            '<td>右侧照</td>' +
            '<td colspan="2" class="sk_nr juliu_img"><img src="'+(colomdata[odata.indexOf("右侧照片")]||"")+'" alt="" onerror="clga.whenoerron(this)"></td>' +
            '    </tr>' +
            '    </tbody>' +
            '</table>';
        $(".dianxinzhapianbox").append(list);
    }
}

//潍坊城市基础数据管控平台（三实平台）wfjcsj
function setDatawfjcsj(residdata) {
    var infofrom = "潍坊城市基础数据管控平台（三实平台）"
    //人员核查业务
    var reaData = JSON.parse(residdata).data;
    console.log(reaData)
    $.each(reaData, function (i, item) {
        var lisiisis = item.label;
        switch (lisiisis) {
            case "人口信息":
                qiandu_jiben(item.data);
                break;
            case "居住轨迹":
                qiandu_juzhuguiji(item.data);
                break;
            default:
                break;
        }
    });
    //基本信息
    function qiandu_jiben(data) {

    }
    //居住轨迹
    function qiandu_juzhuguiji(data) {
        var odata = data.column;
        $.each(data.data,function (i,item) {
            var colomdata = item;
            var list = '<li class="sw_li sxtips" data-href="'+infofrom+'">' +
                '<ul class="sx_ul">' +
                '    <li class="sx_li">' + (i+1)+ '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("姓名")]||"") + '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("联系方式")]||"") + '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("居住状态")]||"") + '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("房主电话")]||"") + '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("入住日期")]||"") + '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("离开日期")]||"") + '</li>' +
                '    <li class="sx_li">' + (colomdata[odata.indexOf("人员类型")]||"") + '</li>' +
                '    <li class="swxq_1 sx_li swxq_1" data-href="true">' +
                '        <span class="iconfont icon-rwcharacter"></span>' +
                '        <span>详情</span>' +
                '    </li>' +
                '</ul>' +
                '<div class="sw_div1 sw_div2">房屋地址：' + (colomdata[odata.indexOf("房屋地址")]||"") + '</div>' +
                '</li>'
            $(".guiji_juzhugj").append(list);
        });
        $(".guiji_juzhugjtitle").fadeIn();
    }
}

//全国被盗抢机动车信息资源库qgbdqqc
function setDataqgbdqqc(residdata) {
    var reaData = JSON.parse(residdata).data;
    console.log(reaData)
}


//定义信息来源
$(".licontent,.sd_ul2").on("click", ".sxtips", function () {
    layer.tips($(this).attr("data-href"), $(this), {
        tips: [1, '#3595cc'],
        time: 2000
    })
});
//定义详情
$(".licontent,.sd_right").on("click",".smalltips",function () {
    layer.open({
        type:"1",
        shadow:false,
        title:false,
        content:$(this).attr("data-href")
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
    };
    layer.photos({
        photos:data,
        anim:5
    })
});
//人员历史图片
$(".ad_coimgdetial").click(function () {
    $(".historypicbox").empty();
    $.each(imglist,function (i,item) {
        var list = '<li style="float: left;width: 150px;height: 250px;margin: 10px;overflow: hidden">' +
            '<div style="width: 150px;height: 200px;overflow: hidden;">' +
            '<img style="width: 150px;" src="'+item.src+'" alt="">' +
            '</div>' +
            '<p style="text-align: center;">'+item.alt+'</p>' +
            '</li>';
        $(".historypicbox").append(list);
    });
    layer.open({
        type:1,
        title:"人员历史图片",
        skin:'layui-layui-demo',
        area:["740px","630px"],
        id:"historypic",
        anim:2,
        content:$("#historypicbox"),
        cancel:function () {
            $(".historypicbox").hide();
        }
    })
});

// again再次爬去
$(".againpathon").click(function () {
    clga.searchbegin(jobdata.jobinfo.word,2,false);
});

