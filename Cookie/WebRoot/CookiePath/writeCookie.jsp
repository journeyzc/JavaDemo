<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'writeCookie.jsp' starting page</title>
    
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
  <!-- 向客户端浏览器写入一个Cookie: cookiePath,cookiePathValue -->
    <%
    
    	Cookie cookie = new Cookie("cookiePath","CookiePathValue");
    	
    	//设置Cookie 的作用范围：
    	cookie.setPath(request.getContextPath());
    	response.addCookie(cookie);
    	
    	//Cookie 的作用范围：可以作用当前目录和当前目录的子目录，但不能作用于当前目录的上一级目录
    	//可以通过  setPath 方法来设置 Cookie 的作用范围，其中/ 代表站点的根目录
    %>
    <a href="cookie2.jsp">To Read Cookie</a>
    <br>
    <br>
	<%= request.getContextPath() %>
  </body>
</html>
