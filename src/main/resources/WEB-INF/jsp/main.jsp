<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>跨库联查平台</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<style type="text/css">
		.content {width: 96%;height: auto;border: 1px solid #c9ced4;margin: 0 auto;margin-top: 30px;border-radius:3px;background-color: #fff;}
		.content .system_list{font-size: 16px;color: #222222;padding-top: 10px;padding-bottom: 10px;padding-left: 15px;padding-right: 15px;}
		.content .system_list span{margin-right: 15px;cursor: pointer;}
		.content .system_list .active{color: #1352f5;border-bottom: 2px solid #1352f5;padding-bottom: 3px;}
		.content .category_list{border-top: 1px solid #c9ced4;padding-top: 10px;padding-bottom: 10px;padding-left: 15px;padding-right: 15px;color: #626262;}
		.content .category_list span{margin-right: 15px;cursor: pointer;}
		.content .category_list .active{color: #1352f5;}
		.content .data_list{border-top: 1px solid #c9ced4;background-color: #fff;min-height: 500px;}
		.content .data_list table{table-layout: fixed;word-break: break-all; word-wrap: break-word;width: 100%;}
		.content .data_list table tr{text-align: center;}
		.content .data_list table .header{background-color: #eef1f8;}
		.content .data_list table .content{background-color: #fff;margin-bottom: 10px;}
		.content .data_list table .header td{padding-top: 10px;padding-bottom: 10px;height: 50px;}
		.content .data_list table .content td{padding-top: 5px;padding-bottom: 5px;height:50px; border-bottom: 8px solid #eef1f8;border-top: #fbfcff;color: #6c6c6c;-o-text-overflow:ellipsis;text-overflow:ellipsis;overflow:hidden;white-space:nowrap;}
		.content .data_list table .content td:HOVER { white-space: normal;}
		.content .data_list table .content .more{background-color: #195ffd; border-radius:15px;color: #fff;padding-left: 15px;padding-right: 15px;padding-top:2px;padding-bottom:2px;cursor: pointer;}
		.content .process{height: 1px;border-bottom: 1px solid #1352f5;width: 0%;}
		.dialog_more {width: 100%;height: 100%;position: fixed;top: 0px;left: 0px;background: rgba(0,0,0,0.5);display: none;z-index: 999;}
		.dialog_more .box{width: 700px;height: 500px;background-color: #fff;margin: 0 auto;margin-top: 150px;border-radius:5px;}
		.dialog_more .box .title{background-image: url(images/bg_title.jpg);background-size: 100% 100%;position:relative; width: 100%;height: 40px;background-color: #195ffe;border-radius:5px;text-align: center;line-height: 40px;color: #fff;font-weight: bolder;font-size: 16px;}
		.dialog_more .box .container{width: 700px;height: 460px;padding: 20px;overflow: auto;}
		.dialog_more .box .container div{margin-top: 10px;}
		.dialog_more .box .close{transition:All 0.5s ease;-webkit-transition:All 0.5s ease;-moz-transition:All 0.5s ease;-o-transition:All 0.5s ease;position: absolute;right:0px; background: url('images/icon_close.png');width: 25px;height: 25px;float: right;margin: 8px 8px 0px 0px;}
		.dialog_more .box .close:hover{-webkit-transform: rotate(180deg);-moz-transform: rotate(180deg);-o-transform: rotate(180deg);transform: rotate(180deg)}
		.dialog_more .box .field{min-width: 200px;display:inline-block;text-align: right;font-weight: bolder;color: #333333;}
		.dialog_more .box .value{color: #666666;word-wrap: break-word; word-break: break-all;}
		.tool_bar{height: 200px;width: 50px;border:1px solid #5c8eff;position: fixed;left: 0px;bottom: 50%;font-size: 15px;background-color: #195ffd;color: #fff;text-align: center;}
		.tool_bar div{width: 100%;height: 50px;padding: 3px;border-bottom: 1px solid #fff;cursor: default;}
		.tool_bar div:HOVER {background-color: #0042d6;}
		.tool_bar div:ACTIVE {background-color: #0032d6;}
		.loading{width: 400px;height: 300px;margin:0 auto;background-image: url(images/search_loading.gif);background-repeat: no-repeat;margin-top: 80px;}
		.loaderror{width: 128px;height: 128px;margin:0 auto;background-image: url(images/search_loaderror.png);background-repeat: no-repeat;margin-top: 100px;}
		.nodata{width: 215px;height: 159px;margin:0 auto;background-image: url(images/search_nodata.png);background-repeat: no-repeat;margin-top: 100px;}
	</style>
  </head> 
  <body>
  	<div class="header_tools"> 
  		<span class="navigation">
  			<a href="index" style="color: #fff;">跨库联查平台</a>&gt;
  			<a style="color: #5696f7;">查询结果</a>
		</span>
  		<div class="userinfo">
  			<span class="username">未知</span>
  			<span class="logout">退出</span>
  			<ul class="menu" >
				<li>用户管理</li>
				<li>配置管理</li>
				<li>查询日志</li>
			</ul>
		</div>
  	</div>
  	<div class="dialog_more">
		<div class="box" onClick="event.cancelBubble=true">
  			<div class="title">
  				<span>更多信息</span>
  				<span class="close"></span>
  			</div>
  			<div class="container"></div>
  		</div>
  	</div>
  	<div class="tool_bar" >
  		<div onclick="exportResult(false)">导出当前</div>
  		<div onclick="exportResult(true)">导出全部</div>
  		<div onclick="executeUpdate(false);">更新当前</div>
  		<div onclick="executeUpdate(true);">更新全部</div>
  	</div>
  	<div class="content">
  		<div class="system_list">
  			<!-- <span class="active"></span> -->
  		</div>
  		<div class="process"></div>
  		<div class="category_list">
  			<!-- <span class="active"></span> -->
  		</div>
  		<div class="data_list">
  			<!-- <table style="width: 100%;" border="0" cellspacing="0" cellpadding="0">
  				<tr class="header">
  					<td>姓名</td>
  					<td>年龄</td>
  					<td>地址</td>
  					<td>生日</td>
  					<td>操作</td>
  				</tr>
  				<tr class="content">
  					<td>姓名</td>
  					<td>年龄</td>
  					<td>地址</td>
  					<td>生日</td>
  					<td><span class="more">更多</span></td>
  				</tr>
  			</table> -->
  		</div>
  	</div>
  	<div style="width: 100%;text-align: center;font-size: 15px;color: gray;">
  		<br>中科金联（北京）科技有限公司<br><br>
  	</div>
  </body>
  <script type="text/javascript">
  		<%
  			if(request.getParameter("iscache")==null){
  				response.sendRedirect("index");
  			}else{
  				out.println();
  				out.println("\t\tvar _iscache="+request.getParameter("iscache")+";");
  				out.println("\t\tvar _job="+new String(request.getParameter("job").getBytes("iso-8859-1"),"utf-8")+";");
  				out.println("\t\tvar _resources="+new String(request.getParameter("res").getBytes("iso-8859-1"),"utf-8")+";");
  			}
  		%>
	</script>
	<script type="text/javascript" src="js/common.util.js"></script>
	<script type="text/javascript" src="js/p/main-1.0.0.js"></script>
</html>
