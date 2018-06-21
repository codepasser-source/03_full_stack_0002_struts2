<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ognl.jsp' starting page</title>
    
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
    <h1 align="center">This is struts2 tags test jsp page </h1><br>
   <hr>
<ol>    
<li> s:property标签- username：<s:property value="username"/> |password：<s:property value="password"/> </li>
<li> s:property标签取值为字符串- <s:property value="'i love xr'"/>  </li>
<li> s:property标签取值为默认值- <s:property value="admin" default="管理员"/>  </li>
<li> s:property标签解析html标签- <s:property value="'<hr/>'" escape="true"/>  </li>
  <hr>
</ol>
<s:debug/>
  </body>
</html>
