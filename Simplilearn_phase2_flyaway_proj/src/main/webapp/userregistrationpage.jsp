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
<center><h3>Registration Page</h3></center>
<%@ include file="homepageredirect.jsp" %>
<div style = "border:solid black 2px; width: 100%;padding:2em">
	<form style="width:100%;text-align:center;" action = "RegisterUserDetailsServlet" method = "post">
		<table style="width:100%">
			<tr>
			<td>Enter first name :</td><td><input  style="width:100%;text-align:center;" type  ="text" name = "fname" required></td>
			</tr>
			<tr>
			<td>Enter last name : </td><td><input  style="width:100%;text-align:center;"  type = "text" name = "lname" required></td>
			</tr>
			<tr>
			<td>Enter email : </td><td><input  style="width:100%;text-align:center;"  type = "email" name = "email" required></td>
			</tr>
			<tr>
			<td>Enter the number of seats: </td><td><input  style="width:100%;text-align:center;"  type = "text" name = "seats" required/></td>
			</tr>
			<tr>
			<td colspan=2><input  style="width:50%;text-align:center;"  type = "submit" value = "Register"></td>
			</tr>
		</table>
	</form>
	</div>
</div>
</body>
</html>