<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% request.setAttribute("flight", request.getParameter("flight")); %>
	<form action = "RegisterUserDetailsServlet" method = "post">
		<%= request.getAttribute("flight") %>
		<input type = "hidden" value = "<%= request.getAttribute("flight") %>" name = "flight"/>
		Enter first name :<input type  ="text" name = "fname"><br/>
		Enter last name : <input type = "text" name = "lname"><br />
		Enter email : <input type = "email" name = "email"><br />
		<input type = "submit" value = "Register">
	
	</form>
</body>
</html>