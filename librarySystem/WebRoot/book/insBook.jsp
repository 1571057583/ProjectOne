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
			if($("#bookeName").val()=="" ||$("#publisherTime").val()==""||$("#publisher").val()==""||$("#profession").val()==""||$("#price").val()==""||$("#authorName").val()=="" ){//校验填空
				alert("信息不能为空,请重新填写");
				return false;
			}else{	
				alert("增加成功");			
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
    <li><a href="#">增加图书</a></li>
    </ul>
    </div> 
    
   
    
    <div class="formbody">
    
    <div class="formtitle"><span>增加图书信息</span></div>
	    <form action="insBook" method="post" id="fm" target="_top">
	    	<input  type="hidden" name="oper" value="pwd" />
		    <ul class="forminfo">
		    <li><label>书名</label><input name="bookName" id="bookName" type="text" class="dfinput" /><i></i></li>
		     <li><label>作者</label><input name="authorName" id="authorName" type="text" class="dfinput" /><i></i></li>
		      <li><label>出版时间</label><input name="publisherTime" id="publisherTime" type="text" class="dfinput" /><i></i></li>
		       <li><label>出版社</label><input name="publisher" id="publisher" type="text" class="dfinput" /><i></i></li>
		        <li><label>专业</label><input name="profession" id="profession" type="text" class="dfinput" /><i></i></li>
		         <li><label>价格</label><input name="price" id="price" type="text" class="dfinput" /><i></i></li> 
		     
		    <li><label>&nbsp;</label><input class="loginbtn"  name="" type="submit"  value="确认增加" /></li>
		    </ul>
	    </form>
    
    </div>


</body>

</html>
