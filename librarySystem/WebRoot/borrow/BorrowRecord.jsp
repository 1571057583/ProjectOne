<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'BorrowRecord.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
    <li><a href="#">首页</a></li>
    <li><a href="#">借换书记录</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
   <form action="record" method="post">
   <ul class="prosearch">
   
   <li><label>状态：</label><input name="book" type="radio" value="已借" />&nbsp;借书&nbsp;&nbsp;
   <input name="book" type="radio" value="已还" />&nbsp;还书&nbsp;&nbsp;
   <input name="book" type="radio" value="1" />&nbsp;全部</li>
   <li><label>查询：
   </label><i>书名</i><a><input name="bookname" type="text" class="scinput" />
   </a><i>读者姓名</i><a><input name="readername" type="text" class="scinput" /></a><a>
   <input name="" type="submit" class="sure" value="查询"/></a></li>
   </ul>
   </form>
   
   <div class="formtitle1"><span>记录</span></div>
   
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>读者ID<i class="sort"><img src="images/px.gif" /></i></th>
        <th>读者姓名</th>
        <th>图书ID</th>
        <th>书名</th>
        <th>状态</th>
       
        </tr>
        </thead>
        <c:forEach items="${record}" var="r">	
        <tbody>
      		<tr>
      			<td>${r.studentid}</td>
      			<td>${r.studentname}</td>
      			<td>${r.bookid}</td>
      			<td>${r.bookname}</td>
      			<td>${r.state}</td>
      		</tr>
 
        </tbody>
        </c:forEach>
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
