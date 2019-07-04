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
    
    <title>My JSP 'BorrowBook.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script>

<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>

  </head>
  
  <body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">系统设置</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">借书</a></li> 
    <li><a href="#tab2">还书</a></li> 
  	</ul>
    </div> 
    
  	<div id="tab1" class="tabson">
    
    <form action="insBorrowBook" method="post">
    <ul class="forminfo">
    <li><label>读者ID<b>*</b></label><input name="readerId" type="text" class="dfinput" value="" /></li>
    <li><label>读者姓名<b>*</b></label><input name="readerName" type="text" class="dfinput" value="" /></li>
    <li><label>图书ID<b>*</b></label><input name="bookId" type="text" class="dfinput" value="" /></li>
    <li><label>书名<b>*</b></label>
    <div class="vocation">
    <select class="select1" name="bookName">
      <c:forEach items="${list}" var="l">
   		 <option>${l.bookName}</option>
  	</c:forEach>
    </select>
    </div>
    <li><input name="" type="submit" class="sure" value="确定" align="middle"/></li>
    
    
    </form>
    </div> 
    
    
  	<div id="tab2" class="tabson">
    
    <form action="selBorrowBookById" method="post">
    <ul class="seachform">
    <li><label>读者ID</label><input name="readId" type="text" class="scinput" /></li>
    <li><input name="" type="submit" class="sure" value="查询" /></li>
    </ul>
    </form>
    
    <form action="updReturnBook" method="post">
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value=""/></th>
        <th>学生ID<i class="sort"><img src="images/px.gif" /></i></th>
        <th>学生姓名</th>
        <th>图书ID</th>
        <th>书名</th>
        <th>状态</th>
        <th>操作</th>
        </tr>
        </thead>
             <c:forEach items="${showBorrowById}" var="s">
        <tbody>
        <tr>
        <td><input name="returnBook" type="checkbox" value="${s.bookid}" /></td>
        <td>${s.studentid}</td>
        <td>${s.studentname}</td>
        <td>${s.bookid}</td>
        <td>${s.bookname}</td>
        <td>已借</td>
        <td><li><input name="" type="submit" value="还书" /></li></td>
        </tr>
    
        </tbody>
        </c:forEach>
    </table>
 </form>
    </div>  
       
	</div> 
 
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

    </div>
  </body>
</html>
