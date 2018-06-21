<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
   <h1 align="center">Access Web Elements</h1><br>
<hr>
<h3>访问web元素    ( MAP类型 )  方法一：依赖于容器  (利用 ActionContext)</h3>
<form action="login1" method="post">
name:<input type="text" name="user.name"><br>
age:<input type="text" name="user.age"><br>
<input type="submit" value="登陆">
</form>

<hr>
<h3>访问web元素    ( SessionAware )  方法二：(最常用的方法)IOC（inverse of control  反转控制）(实现 SessionAware) </h3>
<form action="login2" method="post">
name:<input type="text" name="user.name"><br>
age:<input type="text" name="user.age"><br>
<input type="submit" value="登陆">
</form>
<h3>web 元素   真实类型： HttpSession,ServletContext  方法一：依赖于容器 (利用 ServletActionContext)</h3>
<form action="login3" method="post">
name:<input type="text" name="user.name"><br>
age:<input type="text" name="user.age"><br>
<input type="submit" value="登陆">
</form>
<h3>web 元素   真实类型： HttpSession,ServletContext 方法二：IOC（inverse of control  反转控制）(实现ServletRequestAware)</h3>
<form action="login4" method="post">
name:<input type="text" name="user.name"><br>
age:<input type="text" name="user.age"><br>
<input type="submit" value="登陆">
</form>
  </body>
</html>
