<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
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
    <s:text name="login.welcome" >
      <s:param value="username"/>
    </s:text> <br> 
    国际化文件经过Action之后才可以，并且 文件和该类放在同文件夹下<br>
  application别的i18n配置文件命名必须以应用名开头<br>
    在xml中配置： constant name="struts.custom.i18n.resources" value="struts2_i18n"<br>
  在i18n配置文件中使用通配符{0} 动态显示内容<br>
  在页面中使用   s:text 标签<br>
  动态切换中英文  ： 在请求中加入 request_locale=en_US  (或：zh_CN)
  </body>
</html>
