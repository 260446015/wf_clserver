	/* create by jason.zhang on 2017/10/10 */
	/* @email admin@ovday.com */
	(function($){
		var dataFormat={'action':'register','data':{'serverhost':$.getServerPath()}};
		$.postCross('http://127.0.0.1:19797/',dataFormat,function(result){
			if(result.success){
				$('.container table tbody').html('');
				var html ='';
				for(var i=0;i<result.data.length;i++){
					html+='<tr class="content">';
					html+='<td>'+result.data[i].id+'</td>';
					html+='<td>'+result.data[i].name+'</td>';
					html+='<td>'+_logintype[result.data[i].logintype]+'</td>';
					/*html+='<td>'+_wordtype[result.data[i].wordtype]+'</td>';*/
					html+='<td><select style="width:100px;">';
					for(var j=0;j<result.data[i].wordtype.length;j++){
						html+='<option>'+_wordtype[result.data[i].wordtype[j]]+'</option>';
					}
					html+='</select></td>';
					if(result.data[i].logintype==2){
						html+='<td>不需配置</td>';
						html+='<td></td>';
					}else{
						html+='<td>未配置</td>';
	  					html+='<td><input type="button" onclick="showDialog(\''+result.data[i].id+'\',\''+result.data[i].name+'\');" value="配置"></td>';
					}
  					html+='</tr>';
				}
				$('.container table tbody').html(html);
				loadConfiguration();
			}else{
				Showbo.Msg.alert(result.msg);
			}
		}); 
	})(jQuery);
  
	
	function showDialog(id,name){
		$('#sysid').val(id);
		$('#sysname').val(name);
  		$('.dialog_user').show();
		$('body').css('overflow-y','hidden');
		$('.dialog_user').unbind('click').bind('click',function(){
			$('.dialog_user').hide();
			$('body').css('overflow-y','auto');
		});
		$('.dialog_user .close').unbind('click').bind('click',function(){
			$('.dialog_user').hide();
			$('body').css('overflow-y','auto');
		});
		
		$('#submit_btn').unbind('click').bind('click',function(){
			var id =$('#sysid').val();
			var username =$('#username').val();
			var password =$('#password').val();
			$.postJson('api/setConf',{'id':id,'username':username,'password':password},function(result){
				if(result.success){
					$('.dialog_user .close').click();
					window.location.reload(true);
				}else{
					Showbo.Msg.alert(result.msg);
				}
			});
		});
  	}
	
	function loadConfiguration(){
		$.postJson('api/userConf',{},function(result){
			if(result.success){
				$('.container table tbody tr').each(function(){
					for(var i=0;i<result.data.length;i++){
						var id =$(this).children('td:eq(0)').html();
						if(result.data[i].id==id&&result.data[i].username!=''){
							$(this).children('td:eq(4)').text(result.data[i].username);
							break;
						}
					}
				});
			}else{
				Showbo.Msg.alert(result.msg);
			}
		});
	}