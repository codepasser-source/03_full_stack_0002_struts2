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
    <h1 align="center">This is ognl test jsp page </h1><br>
   <hr>
<ol>    
<li>
     访问值栈中的action的普通属性:<s:property value="username"/> | password:<s:property value="password"/>
    </li> 
   <hr>
   <li>
   访问值栈中对象的普通属性(get set方法)-user.age:<s:property value="user.age"/> | user['age']:<s:property value="user['age']"/> | 
   user[\"age\"]: <s:property value="user[\"age\"]"/> | wrong: <s:property value="user[age]"/></li> 
   <hr>
   <li>访问值栈中对象的普通属性(get set方法)-cat.friend.name:<s:property value="cat.friend.name"/></li> 
   <hr>
   <li>访问值栈中对象的普通方法-password.length():<s:property value="password.length()"/></li> 
   <hr>
   <li>访问值栈中对象的普通方法-cat.miaomiao():<s:property value="cat.miaomiao()"/></li> 
   <hr>
   <li>访问action普通方法-myLove():<s:property value="myLove()"/></li> 
   <hr>
   <li>访问普通类静态方法-@com.bjsxt.struts2.ognl.S@s():<s:property value="@com.baishui.struts2.ognl.S@s()"/></li>
   <hr>
   <li>访问普通类静态属性-@com.bjsxt.struts2.ognl.S@str:<s:property value="@com.baishui.struts2.ognl.S@str"/></li>
   <hr>
   <li>访问Math类的静态方法-@@max(2,5):<s:property value="@@max(2,5)"/></li>
   <hr>
   <li>访问普通类的构造方法-new com.baishui.struts2.ognl.User(26)：<s:property value="new com.baishui.struts2.ognl.User(26)"/></li>
   <hr/>
    <h3 align="right">访问集合list</h3><br>
    <li>访问list集合-users:<s:property value="users"/></li>
    <li>访问list集合中某个对象-users[1]:<s:property value="users[1]"/></li>
    <li>访问list集合固定属性的集合-users.{age}:<s:property value="users.{age}"/></li>
    <li>访问list集合中某个对象的某个属性的集合中的特定值:<s:property value="users.{age}[0]"/> | <s:property value="users[0].age"/></li>
    <h3 align="right">访问集合set</h3><br>
    <li>访问Set:<s:property value="dogs"/></li>
	<li>访问Set中某个元素:<s:property value="dogs.{name}"/></li>
    <h3 align="right">访问集合map</h3><br>   
    <li>访问Map:<s:property value="dogMap"/></li>
    <li>访问Map中某个元素:<s:property value="dogMap.dog101"/> | <s:property value="dogMap['dog101']"/> | <s:property value="dogMap[\"dog101\"]"/></li>
    <li>访问Map中所有的key:<s:property value="dogMap.keys"/></li>
	<li>访问Map中所有的value:<s:property value="dogMap.values"/></li>
	<li>访问容器的大小：<s:property value="dogMap.size()"/> | <s:property value="users.size"/> </li>
   <hr/>
    <li>投影(过滤)：<s:property value="users.{?#this.age==1}[0]"/></li>
    <li>投影：<s:property value="users.{^#this.age>1}.{age}"/></li>
	<li>投影：<s:property value="users.{$#this.age>1}.{age}"/></li>
	<li>投影：<s:property value="users.{$#this.age>1}.{age} == null"/></li>
	<hr />
		<li>[]:<s:property value="[0].username"/></li>
   <hr/>
</ol>
<s:debug/>
  </body>
</html>
