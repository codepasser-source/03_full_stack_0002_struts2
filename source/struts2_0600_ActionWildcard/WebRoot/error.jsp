<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'error.jsp' starting page</title>
    
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
   error.jsp <br>
   errorMessages:<s:property value="errorMessages[0]"/><br>
   errorMessages:<s:property value="errorMessages[1]"/><br>
   errors.nameError[0]:<s:property value="errors.nameError[0]"/><br>
  errors.ageError[0]:<s:property value="errors.ageError[0]"/><br> 
  actionErrors[0]:<s:property value="actionErrors[0]"/><br>
  actionErrors[1]:<s:property value="actionErrors[1]"/><br>
 nameError[0]: <s:property value="fieldErrors.nameError[0]"/><br>
 ageError[0] :<s:property value="fieldErrors.ageError[0]"/>
    <s:debug/>
  </body>
</html>
