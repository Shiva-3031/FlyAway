<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href = "css/mystyle.css">
</head>
<body>
<div class="centering">
<%

	if(request.getSession(false) == null){
		out.println("Session expired.");
		response.setContentType("text/html");
		request.getRequestDispatcher("seachform.jsp").include(request, response);
	}

%>

	<form action = "RegisterUserDetailsServlet" method = "post">
		Enter first name :<input type  ="text" name = "fname"><br/>
		Enter last name : <input type = "text" name = "lname"><br />
		Enter email : <input type = "email" name = "email"><br />
		Enter the number of seats: <input type = "text" name = "seats" />
		<br/><input type = "submit" value = "Register">
	
	</form>
</div>
</body>
</html>