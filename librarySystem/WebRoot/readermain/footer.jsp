<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function showTime() { 
  var now = new Date(); 
  var nowTime = now.toLocaleString(); 
  var date = nowTime.substring(0,10);//截取日期 
  var time = nowTime.substring(10,20); //截取时间 
  var week = now.getDay(); //星期 
  var hour = now.getHours(); //小时 
  //判断星期几 
  var weeks = ["日","一","二","三","四","五","六"]; 
  var getWeek = "星期" + weeks[week]; 
  var sc; 
  //判断是AM or PM 
  if(hour >= 0 && hour < 5){ 
   sc = '凌晨'; 
  } 
  else if(hour > 5 && hour <= 7){ 
   sc = '早上'; 
  } 
  else if(hour > 7 && hour <= 11){ 
   sc = '上午'; 
  } 
  else if(hour > 11 && hour <= 13){ 
   sc = '中午'; 
  } 
  else if(hour> 13 && hour <= 18){ 
   sc = '下午'; 
  } 
  else if(hour > 18 && hour <= 23){ 
   sc = '晚上'; 
  } 
  document.getElementById('time').innerHTML ="当前时间：" + date+" " + getWeek +" "+"   "+sc+"  "+time;
  setTimeout('showTime()',1000); 
} 
</script> 
 
</head>

<body onload="showTime()">
	<div class="footer">
    <div id="time"></div> 
    <i>版权所有 StoreFish</i>    
    </div>    
</body>
</html>
   