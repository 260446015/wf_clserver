layui.use(['element'], function(){
	$ = layui.jquery;
  	element = layui.element();

  //导航的hover效果、二级菜单等功能，需要依赖element模块
  // larry-side-menu向左折叠
  	if($(window).width()<750){
		trun = 0;
	}else{
		trun = 1;
	}
	
$('.larry-side-menu').click(function() {
  if(trun){
			$('.x-side').animate({left: '0px'},200).siblings('.x-main').animate({left: '200px'},200);
			trun=0;
		}else{
			$('.x-side').animate({left: '-200px'},200).siblings('.x-main').animate({left: '0px'},200);
			trun=1;
		}

});



  	//监听导航点击
  	element.on('nav(side)', function(elem){
    	title = elem.find('cite').text();
    	url = elem.find('a').attr('_href');
    	// alert(url);

    	for (var i = 0; i <$('.x-iframe').length; i++) {
    		if($('.x-iframe').eq(i).attr('src')==url){
    			element.tabChange('x-tab', i);
    			return;
    		}
    	};

    	res = element.tabAdd('x-tab', {
	        title: title//用于演示
	        ,content: '<iframe frameborder="0" src="'+url+'" class="x-iframe"></iframe>'
		    });


		element.tabChange('x-tab', $('.layui-tab-title li').length-1);

    	$('.layui-tab-title li').eq(0).find('i').remove();
  });


});

var $,tab,skyconsWeather;
layui.config({
	base : "js/"
}).use(['form','element','layer','jquery'],function(){
	var form = layui.form(),
		layer = layui.layer,
		element = layui.element();
		$ = layui.jquery;
   var name = localStorage.getItem("name");//获取name的值
   var photo = localStorage.getItem("photo");//获取photo的值
   var password = localStorage.getItem("password");//获取password的值
	//锁屏
	function lockPage(){
		layer.open({
			title : false,
			type : 1,
			content : '	<div class="admin-header-lock" id="lock-box" style="width: 320px;height: 170px;padding: 20px;position: relative;text-align: center;">'+
							'<div class="admin-header-lock-img" style=" width: 60px;height: 60px;margin: 0 auto;"><img style="width: 60px;height: 60px;border-radius: 100%;" src='+photo+'></div>'+
							'<div class="admin-header-lock-name" style="color: #009688;margin: 8px 0 15px 0;" id="lockUserName">'+name+'</div>'+
							'<div class="input_btn" style=" overflow: hidden;margin-bottom: 10px;">'+
								'<input type="password" class="admin-header-lock-input layui-input" autocomplete="off" placeholder="请输入密码解锁.." name="lockPwd" id="lockPwd" style="width: 170px;color: #fff;background-color: #009688;float: left;margin: 0 10px 0 40px;border: none;"/>'+
								'<button class="layui-btn" id="unlock" style="float: left;background-color: #009688;color: #fff;">解锁</button>'+
							'</div>'+
							'<p style="color: #e60000;">请输入您的密码，否则不会解锁成功哦！！！</p>'+
						'</div>',
			closeBtn : 0,
			shade : 0.9
		})
		$(".admin-header-lock-input").focus();
	}
	$(".lockcms").on("click",function(){
		window.sessionStorage.setItem("lockcms",true);
		lockPage();
	})
	// 判断是否显示锁屏
	if(window.sessionStorage.getItem("lockcms") == "true"){
		lockPage();
	}
	// 解锁
	$("body").on("click","#unlock",function(){
		if($(this).siblings(".admin-header-lock-input").val() == ''){
			layer.msg("请输入解锁密码！");
			$(this).siblings(".admin-header-lock-input").focus();
		}else{
			if($(this).siblings(".admin-header-lock-input").val() == password){
				window.sessionStorage.setItem("lockcms",false);
				$(this).siblings(".admin-header-lock-input").val('');
				layer.closeAll("page");
			}else{
				layer.msg("密码错误，请重新输入！");
				$(this).siblings(".admin-header-lock-input").val('').focus();
			}
		}
	});
	$(document).on('keydown', function() {
		if(event.keyCode == 13) {
			$("#unlock").click();
		}
	});

})


