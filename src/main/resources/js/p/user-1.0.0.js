	/* create by jason.zhang on 2017/10/10 */
	/* @email admin@ovday.com */
	var _page=1;
  
	(function($){
		loadUserList(_page);
	})(jQuery);
	
	function loadUserList(page){
		_page=page;
		var pageSize =10;
		$.postJson('api/userList',{'page':page,'pageSize':pageSize},function(result){
			if(result.success){
				var html='';
				var total =result.data.total;
				var data =result.data.data;
				for(var i=0;i<data.length;i++){
					html+='<tr class="content">';
					html+='<td><input type="checkbox" style="width: 20px;height: 20px;" /></td>';
					html+='<td>'+data[i].username+'</td>';
					html+='<td>'+data[i].realname+'</td>';
					html+='<td>'+data[i].dept+'</td>';
					html+='<td>'+data[i].mobile+'</td>';
					html+='<td>'+$.timestamptodate(data[i].createtime*1000)+'</td>';
					html+='</tr>';
				}
				$('.container table tbody').html(html);
				$('.container table tbody tr').unbind('click').bind('click',function(){
					if(!$(this).find('input[type=checkbox]').is(':checked')){
						$('.container table tbody tr input[type=checkbox]').prop('checked', false);
						$(this).find('input[type=checkbox]').prop('checked', true);
					}else{
						$(this).find('input[type=checkbox]').prop('checked', false);
					}
				});
				if(Math.ceil(total/pageSize)>1){
					$('#page').paging({
						pageNo:page,
						totalPage: Math.ceil(total/pageSize),
						totalSize: total,
						callback: function(num) {
							loadUserList(num);
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

  	
  	function showDialog(){
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
  	}
  
  	function addUser(){
  		showDialog();
  		$('#password').attr('placeholder','');
  		$('.dialog_user .content input[type=text],input[type=password]').val('');
  		$('.dialog_user .title .text').text('添加用户');
  		$('#submit_btn').unbind('click').bind('click',function(){
  			var username =$('#username').val();
  	  		var password =$('#password').val();
  	  		var realname =$('#realname').val();
  	  		var dept =$('#dept').val();
  	  		var mobile =$('#mobile').val();
  	  		var uPattern = /^[a-zA-Z0-9_-]{4,16}$/;
  	  		if(!uPattern.test(username)){
  	  			Showbo.Msg.alert('您输入的用户名不符合系统规则！');
  	  			return;
  	  		}
  	  		var pPattern = /^[\w]{6,12}$/;
	  		if(!pPattern.test(password)){
	  			Showbo.Msg.alert('您输入的密码不符合系统规则！');
	  			return;
	  		}
  			$.postJson('api/userAdd',{'username':username,'password':password,'realname':realname,'dept':dept,'mobile':mobile},function(result){
  				if(result.success){
  					$('.dialog_user .close').click();
  	  				loadUserList(_page);	
  				}else{
  					Showbo.Msg.alert(result.msg);
  				}
  	  		});
  		});
  		
  	}
  	
  	function modify(){
  		var seluser =getSelectedUser();
  		if(seluser==null){
  			Showbo.Msg.alert('请选择一个用户！');
  			return;
  		}
  		showDialog();
  		$('.dialog_user .content input[type=text],input[type=password]').val('');
  		$('.dialog_user .title .text').text('修改用户');
  		$('#username').val(seluser.username);
	  	$('#password').val();
	  	$('#password').attr('placeholder','******');
	  	$('#realname').val(seluser.realname);
	  	$('#dept').val(seluser.dept);
	  	$('#mobile').val(seluser.mobile);
	  	$('#submit_btn').unbind('click').bind('click',function(){
	  		var username =$('#username').val();
  	  		var password =$('#password').val();
  	  		var realname =$('#realname').val();
  	  		var dept =$('#dept').val();
  	  		var mobile =$('#mobile').val();
  	  		var uPattern = /^[a-zA-Z0-9_-]{4,16}$/;
  	  		if(!uPattern.test(username)){
  	  			Showbo.Msg.alert('您输入的用户名不符合系统规则！');
  	  			return;
  	  		}
  	  		var pPattern = /^[\w]{6,12}$/;
  	  		if(password!=''&&!pPattern.test(password)){
  	  			Showbo.Msg.alert('您输入的密码不符合系统规则！');
  	  			return;
  	  		}
  			$.postJson('api/userModify',{'username':username,'realname':realname,'password':password,'dept':dept,'mobile':mobile},function(result){
  				if(result.success){
  					$('.dialog_user .close').click();
  	  				loadUserList(_page);	
  				}else{
  					Showbo.Msg.alert(result.msg);
  				}
  	  		});
  		});
  	}
  	
  	function userDelete(){
  		var seluser =getSelectedUser();
  		if(seluser==null){
  			Showbo.Msg.alert('请选择一个用户！');
  			return;
  		}
  		var username=seluser['username'];
  		Showbo.Msg.confirm('确认要删除 '+username+' 吗？',function(event){
  			if(event=='no')return;
  	  		$.postJson('api/userDelete',{'username':username},function(result){
  	  			if(result.success){
  	  				if($('.container table tbody tr').length==1){
  	  	  				loadUserList(_page-1);	
  	  	  			}else{
  	  		  			loadUserList(_page);
  	  	  			}
  	  			}else{
  	  				Showbo.Msg.alert(result.msg);
  	  			}
  	  		});
  		});
  		
  	}
  	
  	function getSelectedUser(){
  		var usertr =$('.container table tbody input[type=checkbox]:checked').parent().parent();
  		if(usertr.html()==undefined){
  			return null;
  		}
  		var username=usertr.children('td:eq(1)').text();
  		var realname =usertr.children('td:eq(2)').text();
  		var dept =usertr.children('td:eq(3)').text();
  		var mobile =usertr.children('td:eq(4)').text();
  		return {'username':username,'realname':realname,'dept':dept,'mobile':mobile};
  	}