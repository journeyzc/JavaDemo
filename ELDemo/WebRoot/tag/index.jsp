<%@ page import="com.journey.javaEL.Customer"%>
<%@ page import="java.util.*" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'simpletag.jsp' starting page</title>
    
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
  <!--  -->
    <% 
		//模拟 Servlet 中的操作.
		List<Customer> customers = new ArrayList<Customer>();
	    customers.add(new Customer(1,"AA",12));
	    customers.add(new Customer(2,"BB",13));
	    customers.add(new Customer(3,"CC",14));
	    customers.add(new Customer(4,"DD",15));
	    customers.add(new Customer(5,"EE",16));
	    
	    request.setAttribute("customers", customers);
	%>
	
	<jsp:forward page="testtag.jsp"></jsp:forward>
  </body>
</html>
