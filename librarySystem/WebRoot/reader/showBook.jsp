<%@ page language="java" import="java.util.*,com.it.pojo.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">信息管理</a></li>
    <li><a href="#">个人信息</a></li>
    <li><a href="#">查看图书信息</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
  
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>图书ID<i class="sort"><img src="images/px.gif" /></i></th>
        <th>书名</th>
        <th>作者</th>
        <th>出版时间</th>
        <th>出版社</th>
        <th>专业</th>
        <th>价格</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${showallbook}" var="l">
        <tr>
       		<td>${l.id}</td>
       		<td>${l.bookName}</td>
       		<td>${l.authorName}</td>
       		<td>${l.publisherTime}</td>
       		<td>${l.publisher}</td>
       		<td>${l.profession}</td>
       		<td>${l.price}</td>
        </tr> 
        </c:forEach>
        </tbody>
    </table>
    

    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
