var _logintype={0:'PKI',1:'账号密码',2:'不需要'};
var _wordtype={'idcard':'身份证','mobile':'手机','virtual':'虚拟身份','car':'车辆','name':'姓名','other':'其它'};
var _error_code={2000:'未知错误',2001:'没有找到插件资源',2002:'初始化错误',2003:'验证码输入错误',2004:'验证码超时',2005:'采集错误',2006:'登录系统失败',2007:'没有PKI',2008:'超时'};
var _crawler_url ='http://192.168.1.22:19797/';
var _server_path ='';

document.writeln('<script type="text/javascript" src="js/jquery-1.11.3.js"></script>');
document.writeln('<script type="text/javascript" src="js/jquery.cookie.js"></script>');
document.writeln('<script type="text/javascript" src="js/paging.js"></script>');
document.writeln('<script type="text/javascript" src="js/jedate/jedate.js"></script>');
document.writeln('<script type="text/javascript" src="js/showBo.js"></script>');
document.writeln('<script type="text/javascript" src="js/JsonExportExcel.min.js"></script>');
document.writeln('<script type="text/javascript" src="js/dev.util.js"></script>');
