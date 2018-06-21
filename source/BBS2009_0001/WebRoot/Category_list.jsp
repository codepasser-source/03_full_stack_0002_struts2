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
    
    <title>My JSP 'Category_list.jsp' starting page</title>
    
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
  <h1 align="center">Category List  列表功能模块</h1>

<table align="center" border="1" width="60%" height="60%">
   <tr>
     <td width="20%" height="5%">category id</td>
     <td width="30%" height="5%">category name</td>
     <td width="50%" height="5%">category descrtiption</td>
   </tr>
  <s:iterator value="categories" var="category">
  <tr>
     <td><s:property value="#category.id"/></td>
     <td><s:property value="#category.name"/></td>
     <td><s:property value="#category.descrtiption"/></td>
   </tr>
  </s:iterator>
</table>


<s:debug></s:debug>
  </body>
</html>
