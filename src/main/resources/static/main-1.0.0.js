		/* create by jason.zhang on 2017/10/10 */
		/* @email admin@ovday.com */
		var _ready_data={};
  		var _data_version={};
		var _interval_retrieve;
		var _retrieve_code={};
		var _pagesize=20;
  		
		(function($){
		  	loadSystem();
	  		retrieveData();
	  		if(!_iscache){
		  		_interval_retrieve=setInterval(retrieveData,3000);
	  		}
	  	})(jQuery);
		
		
		/**
		* 加载系统列表
		*/
		function loadSystem(){
			$('.content .system_list').html('');
			for(var i=0;i<_job.resources.length;i++){
				$('.content .system_list').append('<span data-id="'+_job.resources[i]+'">'+getResourceNameByID(_job.resources[i])+'</span>');
			}
			$('.content .system_list span').unbind('click').bind('click',function(){
		  		$('.system_list span').removeClass('active');
		  		$(this).addClass('active');
		  		loadCategory();
		  	});
			$('.content .system_list span:eq(0)').click();
		}
		
		/**
		* 加载分类列表
		*/
		function loadCategory(newresid){
			$('.content .system_list span').css('color','#adadad');
	  		for(var i=0;i<_job.resources.length;i++){
	  			if(_ready_data[_job.resources[i]]!=null){
	  				$('.content .system_list span[data-id="'+_job.resources[i]+'"]').css('color','#222222');
	  			}
	  		}
	  		$('.content .system_list span.active').css('color','#1352f5');
			
			var resid =$('.content .system_list span.active').attr('data-id');
			if(newresid!=null&&newresid!=resid){
				return;
			}
			if(_retrieve_code[resid]==2101){
				$('.content .category_list').html('加载缓存数据失败，请重试。。。');
				$('.content .data_list').html('<div class="loaderror"></div>');
				return;
			}
			if(_ready_data[resid]==null){
				$('.content .category_list').html('数据正在采集中，请稍等。。。');
				$('.content .data_list').html('<div class="loading"></div>');
				return;
			}
			if(_error_code[_ready_data[resid].code]!=null){
				$('.content .category_list').html(_error_code[_ready_data[resid].code]);
				$('.content .data_list').html('<div class="loaderror"></div>');
				return;
			}
			if(_ready_data[resid].data.length==0){
				$('.content .category_list').html('该资源下暂无相关数据。。。');
				$('.content .data_list').html('<div class="nodata"></div>');
				return;
			}
			$('.content .category_list').html('');
			for(var i=0;i<_ready_data[resid].data.length;i++){
				if(_ready_data[resid].data[i].label==''){
					$('.content .category_list').append('<span>未知</span>');
				}else{
					$('.content .category_list').append('<span>'+_ready_data[resid].data[i].label+'</span>');
				}
			}
			$('.category_list span').unbind('click').bind('click',function(){
		  		$('.category_list span').removeClass('active');
		  		$(this).addClass('active');
		  		appendToDataPanel();
		  	});
			$('.content .category_list span:eq(0)').click();
		}
		
		/**
		* 添加数据到页面
		*/
		function appendToDataPanel(){
			var resid =$('.content .system_list span.active').attr('data-id');
			var category =$('.content .category_list span.active').index();
			var resultdata =_ready_data[resid].data[category];
			if(resultdata.format=='list'){
				createListModel(resid,category,1);
			}
		}
		
		/**
		* 创建列表显示模型
		*/
		function createListModel(resid,category,index){
			var data =_ready_data[resid].data[category].data;
			var html='';
			html+='<table style="width: 100%;" border="0" cellspacing="0" cellpadding="0">';
			html+='<tr class="header">';
			for(var i=0;i<data.column.length;i++){
				if(i>8){
					html+='<td width="80px">操作</td>';
					break;
				}
				html+='<td>'+data.column[i]+'</td>';
			}
			html+='</tr>';
			for(var i=((index-1)*_pagesize);i<(index*_pagesize);i++){
				if(i>=data.data.length)break;
				html+='<tr class="content">';
				for(var j=0;j<data.data[i].length;j++){
					if(j>8){
						html+='<td width="80px"><span class="more" onclick="loadListMore(\''+resid+'\','+category+','+i+');">更多</span></td>';
						break;
					}
					html+='<td>'+data.data[i][j]+'</td>';
				}
				html+='</tr>';
			}
			html+='</table>';
			$('.content .data_list').html(html);
			//添加翻页控件
			if(data.data.length>_pagesize){
				$('.content .data_list').append('<div id="page" class="page_div"></div>');
				$('#page').paging({
					pageNo:index,
					totalPage: Math.ceil(data.data.length/_pagesize),
					totalSize: data.data.length,
					callback: function(num) {
						createListModel(resid,category,num);
					}
				});
			}
		}
		
		/**
		* 加载更多数据
		*/
		function loadListMore(resid,category,index){
			var resultdata =_ready_data[resid].data[category];
			var html ='';
			for(var i=0;i<resultdata.data.data[index].length;i++){
				html+='<div>';
				html+='<span class="field">'+resultdata.data.column[i]+'：</span>';
				html+='<span class="value">'+resultdata.data.data[index][i]+'</span>';
				html+='</div>';
			}
			$('.dialog_more .container').html('');
			$('.dialog_more .container').append(html);
			
			$('.dialog_more').show();
			$('body').css('overflow-y','hidden');
			$('.dialog_more').unbind('click').bind('click',function(){
				$('.dialog_more').hide();
				$('body').css('overflow-y','auto');
			});
			$('.dialog_more .close').unbind('click').bind('click',function(){
				$('.dialog_more').hide();
				$('body').css('overflow-y','auto');
			});
		}
		
		/**
		* 拉取数据
		*/
		function retrieveData(){
			var isfinish=true;
			for(var i=0;i<_job.resources.length;i++){
				if(!_ready_data.hasOwnProperty(_job.resources[i])){
					$.postJsonSyn('api/retrieveData',{'jobid':_job.jobid,'resid':_job.resources[i],'version':_data_version[_job.resources[i]]},function(result){
						if(result.success&&result.data!=null){
							_ready_data[result.data.resid]=result.data;
							_data_version[result.data.resid]=result.data.exetime;
							_retrieve_code[_job.resources[i]]=result.data.code;
						}else if(result.data==null&&_iscache){
							_retrieve_code[_job.resources[i]]=2101;
						}
						loadCategory(_job.resources[i]);
					});
					isfinish=false;
				}
			}
			if(isfinish){
				clearInterval(_interval_retrieve);
			}
		}
		
		
		/**
		* 更新采集资源数据
		*/
		function executeUpdate(all){
			var resources=[];
			if(all){
				resources=_job.resources;
			}else{
				var resid =$('.content .system_list span.active').attr('data-id');
				resources.push(resid);
			}
			_iscache=false;
			var jobparams ={'jobid':_job['jobid'],'word':_job['word'],'wordtype':_job['wordtype'],'jobtype':1,'resources':resources};
	  		$.postJson('api/updateJob',jobparams,function(result){
	  			if(result.success){
	  				_job.jobid=result.data.jobinfo.jobid;
	  				callLocal(result.data.jobinfo,result.data.resources);
	  			}else{
	  				Showbo.Msg.alert('创建任务时出错！');
	  			}
	  		});
		}
		
		/**
	  	* 调用采集器进行数据采集
	  	*/
	  	function callLocal(jobinfo,resources){
	  		jobinfo.resources=resources;
	  		var job={'action':'createjob','data':jobinfo};
	  		$.postCross('http://127.0.0.1:19797/',job,function(result){
				if(result.success){
					for(var idx in resources){
						delete _ready_data[resources[idx].id];
						delete _retrieve_code[resources[idx].id];
					}
					var resid =$('.content .system_list span.active').attr('data-id');
					loadCategory(resid);
					clearInterval(_interval_retrieve);
					_interval_retrieve=setInterval(retrieveData,3000);
				}else{
					Showbo.Msg.alert(result.msg);
				}
			});
	  	}
		
		
		/**
		* 导出数据到Excel
		*/
		function exportResult(all){
			var targetid =$('.content .system_list span.active').attr('data-id');
			var option={};
			option.fileName = _job['word'];
			option.datas = [ ];
			for(var resid in _ready_data){
				if(!all&&targetid!=resid){
					continue;
				}
				var sheetData =[];
				for(var i=0;i<_ready_data[resid].data.length;i++){
					sheetData.push([_ready_data[resid].data[i].label]);
					sheetData.push([]);
					sheetData.push(_ready_data[resid].data[i].data.column);
					for(var j=0;j<_ready_data[resid].data[i].data.data.length;j++){
						sheetData.push(_ready_data[resid].data[i].data.data[j]);
					}
					sheetData.push([]);
					sheetData.push([]);
					sheetData.push([]);
				}
				if(sheetData.length!=0){
					option.datas.push({
						sheetData : sheetData,
						sheetName : getResourceNameByID(resid)
					});
				}
			}
			var toExcel = new ExportJsonExcel(option);
			toExcel.saveExcel();
		}
		
		/**
		 * 根据资源ID获取资源名称
		 */
		function getResourceNameByID(id) {
			for (var i = 0; i < _resources.length; i++) {
				if (_resources[i].id == id) {
					return _resources[i].name;
				}
			}
		}
		

		$(document).keydown(function(event) {
			var catelen =$('.content .category_list span').length;
			var cateidx =$('.content .category_list span.active').index();
			if (event.keyCode == 37) {
				if(cateidx!=0){
					$('.content .category_list span:eq('+(cateidx-1)+')').click();
				}
			}else if (event.keyCode == 39) {
				if(cateidx!=catelen-1){
					$('.content .category_list span:eq('+(cateidx+1)+')').click();
				}
			}
		});
		
		