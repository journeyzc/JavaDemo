<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 导入标签库（描述文件） -->
<%@ taglib prefix="journey" uri="http://www.journey.com/mytag/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
  
  <body>
  	<journey:readFile src="/WEB-INF/RUNNING.txt" />
  	<br>
    <journey:hello value="${param.name }" count="10"/>
    <journey:max num1="${param.a }" num2="${param.b }" />
  </body>
</html>
