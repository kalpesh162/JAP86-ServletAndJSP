<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>This is one.jsp</h1>

	<form action="two.jsp" method="get">
		<input type="submit" value="NEXT">
	</form>

	<hr>

	<h1>
		<a href='two.jsp'>LINK</a>
	</h1>

	<hr>

	<%-- 
	<%
	ArrayList<String> list = new ArrayList<String>();
	list.add("Anup");
	list.add("Navin");
	request.setAttribute("data", list);

	request.getRequestDispatcher("/two.jsp").forward(request, response);
	%>
	
 --%>

	<% response.sendRedirect(request.getContextPath()+"/two.jsp"); %>
	<h1>

		<%= request.getContextPath()  %>
	</h1>
</body>
</html>