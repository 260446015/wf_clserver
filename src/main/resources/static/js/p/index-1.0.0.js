	/* create by jason.zhang on 2017/10/10 */
	/* @email admin@ovday.com */
	var _resources =[];
  
  	(function($){
  		var scale1 = 60/$('body').height();
  		var scale2 = $('body').height()*0.02/$('body').height();
  		$('.container').height((1-(scale1+scale2)*2)*100+'%');
  		var dataFormat={'action':'register','data':{'serverhost':$.getServerPath()}};
  		$.postCross('http://127.0.0.1:19797/',dataFormat,function(result){
  			if(result.success){
  				_resources=result.data;
  				displayResource();
  			}else{
  				$('.resource .res_list').append('加载查询资源失败！');
  			}
  		}); 
  	})(jQuery);
  	
  	function displayResource(){
  		$('.resource .res_list').html('');
  		var typeid =$('.wordtype .active').attr('id');
  		for(var i=0;i<_resources.length;i++){
  			if($.inArray(typeid, _resources[i].wordtype)!=-1){
  				$('.resource .res_list').append('<label><input type="checkbox" value="'+_resources[i].id+'"/>'+_resources[i].name+'</label>');
  			}
		}
  	}
  	
  	$('.wordtype li').bind('click',function(){
  		$('.wordtype li').removeClass('active');
  		$(this).addClass('active');
  		displayResource();
  	});
  	
  	
  	$('.search_box .search_btn').click(function(){
  		var word =$('.search_input').val();
  		var wordtype =$('.wordtype .active').attr('id');
  		var resources =[];
  		$('.resource .res_list input[type=checkbox]:checked').each(function(){
  			resources.push($(this).attr('value'));
  		});
  		if(word.length==0){
  			Showbo.Msg.alert('请输入要查询的信息！');
  			return;
  		}
  		if(resources.length==0){
  			Showbo.Msg.alert('请选择一个查询资源！');
  			return;
  		}
  		var jobparams ={'word':word,'wordtype':wordtype,'jobtype':1,'resources':resources};
  		$.postJson('api/createJob',jobparams,function(result){
  			if(result.success){
  				var jobinfo =result.data.jobinfo;
  				if(result.data.iscache){
  					$.postForm('main',{'job':JSON.stringify(jobinfo),'res':JSON.stringify(_resources),'iscache':true});
  				}else{
  					callLocal(jobinfo,result.data['resources']);
  				}
  			}else{
  				Showbo.Msg.alert(result.msg);
  			}
  		});
  	});
  	
  	/**
  	* 调用采集器进行数据采集
  	*/
  	function callLocal(jobinfo,resources){
  		var dispatherJob =JSON.stringify(jobinfo);
  		jobinfo.resources=resources;
  		var job={'action':'createjob','data':jobinfo};
  		$.postCross('http://127.0.0.1:19797/',job,function(result){
			if(result.success){
				$.postForm('main',{'job':dispatherJob,'res':JSON.stringify(_resources),'iscache':false});
			}else{
				Showbo.Msg.alert('执行任务时出错！');
			}
		});
  	}
  	
  	function selectInvert(){
  		$('.resource .res_list input[type=checkbox]').each(function(){
  			if($(this).is(':checked')){
  				$(this).prop('checked',false);
  			}else{
  				$(this).prop('checked',true);
  			}
  		});
  	}
  	
  	$(window).resize(function() {
  		
	});