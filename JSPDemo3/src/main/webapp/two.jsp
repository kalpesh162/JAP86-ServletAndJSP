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
	<h1>This is two.jsp</h1>

	<%
	ArrayList<String> list = (ArrayList<String>) request.getAttribute("data");
	%>

	<h1>
		<%=list%>
	</h1>
</body>
</html>