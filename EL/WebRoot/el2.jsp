<%@page import="com.journey.javaEL.Customer"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'el2.jsp' starting page</title>

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


	<!-- EL 的关系运算符 -->
	${param.score > 60 ? "及格" : "不及格" }
	<br>
	<%
		List<String> names = new ArrayList<String>();
		names.add("journey");
		request.setAttribute("names", names);
	%>
	names is empty: ${empty requestScope.names }
	<br>
	<!-- ${pageScope.username}  取出 Page 范围的 username 变量
		 ${requestScope.username}  取出 Request 范围的 username 变量
		 ${sessionScope.username}  取出 Session 范围的 username 变量
		 ${applicationScope.username}  取出 Application 范围的 username 变量 -->
	<!-- 其他隐含对象:pageContext -->
	pageContext: 
	<br>
	sessionAttributeName: ${pageContext.session.attributeNames }
	<br>
	sessionAttributeName: <%= request.getSession().getAttributeNames() %>
	<br>
	contextPath: ${pageContext.request.contextPath }
	<br>
	contextPath: <%= request.getContextPath() %>
	<br>
	sessionId: ${pageContext.session.id }
	<br>
	sessionId: <%= request.getSession().getId() %>
	<br>
	initParam: ${initParam.initName }
	<br>
	
	Accept-Language: ${header["Accept-Language"] }
	
	<br>
	JSESSIONID: ${cookie.JSESSIONID.name }-->${cookie.JSESSIONID.value }
	<br>
	JSESSIONID: <%= request.getCookies()[0].getName() %>--><%= request.getCookies()[0].getValue() %>
	<br>
	<!-- 与输入有关的隐含对象:param	paramValues -->
	score: ${param.score }
	<br>
	score: <%= request.getParameter("score") %>
	<br>
	names: ${paramValues.name[0].class.name }
	<br>
	names: <%= request.getParameterValues("name")[0].getClass().getName() %>
	<br>
	<!-- 隐含对象之与范围相关的：pageScope	requestScope	sessionScope	applicationScope -->
	${applicationScope.time }
	<br>
	<%= application.getAttribute("time") %>
	<br>
	<!-- EL 可以自动转变类型 -->
	score:${param.score + 11 }
	<br>
	score:<%= request.getParameter("score") + 11%>
	<%
		Customer cust2 = new Customer();
		cust2.setAge(28);
		request.setAttribute("customer", cust2);
	%>
	<!-- EL 的 . 或 [] 运算符 -->
	<br> age: ${sessionScope.customer.age }
	<br> age: ${sessionScope.customer["age"] }
	<br> age: ${customer.age }
	<br> age: ${customer["age"] }
	<br>
	<!--  	${username}。 它的意思是取出某一范围中名称为 username
			的变量。因为我们并没有指定哪一个范围的 username，所以它的默认值会先从 Page 范围找，假如
			找不到，再依序到 Request、Session、Application 范围。假如途中找到 username，就直接回传，
			不再继续找下去，但是假如全部的范围都没有找到时，就回传 null -->
			
	<%
		Customer customer = new Customer();
		customer.setName("journey");
		session.setAttribute("com.journey.EL", customer);
	%>
	name: ${sessionScope["com.journey.EL"].name }
</body>
</html>
