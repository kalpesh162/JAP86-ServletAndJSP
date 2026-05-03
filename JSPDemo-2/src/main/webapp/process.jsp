<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<%
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double marks = Double.parseDouble(request.getParameter("marks"));

		out.print(id);
		out.print(name);
		out.print(marks);
		%>
	</h1>

	<h1 style="color: red; font-family: monospace;">
		ID:
		<%=id%>
		<br>
	</h1>

	<h1 style="color: green; font-family: sans-serif;">
		NAME:
		<%=name%>
	</h1>

	<h1 style="color: blue; font-family: cursive;">
		<br> MARKS:
		<%=marks%>
		<br>
	</h1>

	<hr>

	<!-- Decalration Tag -->

	<%!
	
	int cube(int x) {
		return x * x * x;
	}
	
	%>

	<h2>
		<% out.print(cube(5)); %>

		<br>

		<%= cube(6) %>
	</h2>



</body>
</html>