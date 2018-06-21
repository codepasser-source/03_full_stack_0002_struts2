<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
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
    <h1>错误信息页面</h1> <br>
<hr>
    
     s:fielderror|<s:fielderror fieldName="nameError" /> <br>
     s:actionerror|<s:actionerror/><br>
     s:property -value="actionErrors"|<s:property value="actionErrors[0]"/><br>
     s:property -value="actionErrors"|<s:property value="actionErrors[1]"/><br>
     s:property -value="errorMessages"|<s:property value="errorMessages[0]"/><br>
     s:property -value="errorMessages"|<s:property value="errorMessages[1]"/><br>
    <s:debug/>
  
  </body>
</html>
