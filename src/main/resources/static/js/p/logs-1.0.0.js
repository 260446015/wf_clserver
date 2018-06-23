/* create by jason.zhang on 2017/10/10 */
/* @email admin@ovday.com */
jeDate({
		dateCell:"#startTime",
		format:"YYYY-MM-DD",
		isTime:false,
		minDate:"2014-09-19"
	});
    jeDate({
		dateCell:"#endTime",
		format:"YYYY-MM-DD",
		isTime:false,
		minDate:"2014-09-19"
	});
    
    var pageSize =10;
    var _word,_username,_startTime,_endTime;
    
	(function($){
		if($.cookie('superuser')=='false'){
			$('#username').hide();
		}
		loadLogList(1);
		$('#search_btn').bind('click',function(){
			_word =$('#word').val();
			_username =$('#username').val();
			_startTime =$('#startTime').val();
			_endTime =$('#endTime').val();
			loadLogList(1);
		});
		
	})(jQuery);
	
	function loadLogList(page){
		var postdata ={'criteria':{'word':_word,'username':_username,'startTime':_startTime,'endTime':_endTime},'page':{'page':page,'pageSize':pageSize}};
		$.postJson('api/logList',postdata,function(result){
			if(result.success){
				var html='';
				var total =result.data.total;
				var data =result.data.data;
				for(var i=0;i<data.length;i++){
					html+='<tr class="content">';
					html+='<td>'+data[i].username+'</td>';
					html+='<td>'+data[i].word+'</td>';
					html+='<td><select style="width:100px;">';
					html+='<option>'+data[i].resources.length+'个资源</option>';
					for(var j=0;j<data[i].resources.length;j++){
						html+='<option>'+data[i].resources[j]+'</option>';
					}
					html+='</select></td>';
					html+='<td>'+data[i].ip+'</td>';
					html+='<td>'+$.timestamptodate(data[i].exetime*1000)+'</td>';
					html+='</tr>';
				}
				$('.container table tbody').html(html);
				
				if(Math.ceil(total/pageSize)>1){
					$('#page').paging({
						pageNo:page,
						totalPage: Math.ceil(total/pageSize),
						totalSize: total,
						callback: function(num) {
							loadLogList(num);
						}
					});
					$('#page').show();
				}else{
					$('#page').hide();
				}
			}else{
				Showbo.Msg.alert(result.msg);
			}
  		});
	}