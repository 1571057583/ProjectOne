<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>showAll</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
		<table border="1">
			<tr>
				<td>图书id</td>
				<td>书名</td>
				<td>作者</td>
				<td>出版时间</td>
				<td>出版社</td>
				<td>专业</td>
				<td>价格</td>
				
			</tr>
		<c:forEach items="${list}" var="s">
			<tr>
				<td>${s.id}</td>
				<td>${s.bookName}</td>
				<td>${s.authorName}</td>
				<td>${s.publisherTime}</td>
				<td>${s.publisher}</td>
				<td>${s.profession}</td>
				<td>${s.price}</td>
			</tr>
		</c:forEach>
		</table>
  </body>
</html>
