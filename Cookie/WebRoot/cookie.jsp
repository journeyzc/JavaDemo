<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" session="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cookie.jsp' starting page</title>
    
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
    <%
    	//在 JavaWEB 规范中使用 Cookie 类代表 cookie
    	
    	//1. 创建一个 Cookie 对象
    	//Cookie cookie = new Cookie("name","journey");
    	//2. 调用 response 的一个方法 把 Cookie 传给客户端。
    	//response.addCookie(cookie);
    	
    	//1. 获取 Cookie
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null && cookies.length > 0){
    		for(Cookie cookie:cookies){
    		//2. 获取Cookie 的name 和 value
    			out.print(cookie.getName() + ":" + cookie.getValue());
    			out.print("<br>");
    		}
    	}else{
    		out.print("没有一个 Cookie ， 正在创建并返回");
    		//1. 创建一个 Cookie 对象
    		Cookie cookie = new Cookie("name","journey");
    		//setMaxAge 设置 Cookie 的最大失效 ， 以秒为单位 ， 若为0 表示立即删除该Cookie
    		//若为负数 ， 表示不存储该Cookie ， 若为正数 ， 表示该Cookie 的存储时间 以秒为单位
    		cookie.setMaxAge(30);
    		//2. 调用 response 的一个方法 把 Cookie 传给客户端。
    		response.addCookie(cookie);
    	}
     %>
  </body>
</html>
