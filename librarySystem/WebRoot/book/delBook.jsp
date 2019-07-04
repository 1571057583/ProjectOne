<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page contentType="text/html; charset=utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<!--引入jQuery文件  -->
<script type="text/javascript" src="js/jquery.js"></script>
<!--声明jQuery代码域  -->
<script type="text/javascript">
	$(function(){
		//校验密码修改
		$("#fm").submit(function(){
			if($("#bookeName").val()=="" ||$("#id").val()==""){//校验填空
				alert("信息不能为空,请重新填写");
				return false;
			}else{	
				alert("删除成功");			
				return true;
				
			}
		})
		
		
	})

</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">图书信息</a></li>
    <li><a href="#">删除图书</a></li>
    </ul>
    </div> 
  
    <div class="formbody">
    
    <div class="formtitle"><span>删除图书</span></div>
	    <form action="delBook" method="get" id="fm" target="_top">
	    	<input  type="hidden" name="oper" value="pwd" />
		    <ul class="forminfo">
		    <li><label>图书ID</label><input name="id" id="id" type="text" class="dfinput" /><i></i></li>
		     <li><label>书名</label><input name="bookName" id="bookName" type="text" class="dfinput" /><i></i></li>
		    <li><label>&nbsp;</label><input class="loginbtn"  name="" type="submit"  value="确认删除" /></li>
		    </ul>
	    </form>

    </div>

</body>

</html>
