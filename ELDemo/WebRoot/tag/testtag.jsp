<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.journey.javaEL.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testtag.jsp' starting page</title>
    
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
  	<!-- 在页面上对 request 中的customers 属性进行遍历 打印 id ， name ， age -->
  	<c:forEach items="${requestScope.customers }" var="customer">
  		${customer.id },${customer.name },${customer.age }<br>
  	</c:forEach>
   	<%--
		List<Customer> customers = (List<Customer>)request.getAttribute("customers");
		if(customers !=null){
			for(Customer customer:customers){
	%>
		<%= customer.getId() %>,<%= customer.getName() %>,<%= customer.getAge() %>
	<%
			}
		}    	
   	---%>
  </body>
</html>
