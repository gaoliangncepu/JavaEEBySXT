<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Method.jsp' starting page</title>
    
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
    	<form action="resp" method="get">
    		账号：<input type="text" name="uname" value=""><br />
    		密码：<input type="text" name="pwd" value=""><br />
    		<input type="submit" value="登录"><br />
    		爱好：<br />
    		<input type="checkbox" name="like" value="1">游泳<br />
    		<input type="checkbox" name="like" value="3">足球<br />
    		<input type="checkbox" name="like" value="2">篮球<br />
    	</form>
  </body>
</html>
