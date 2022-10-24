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
			response.setContentType("text/html");
			request.getRequestDispatcher("admin_login_page.jsp").include(request, response);
		}

%>
<center><h3>Reset Password</h3></center>
<%@ include file="homepageredirect.jsp" %>
<div style = "border:solid black 2px; width: 100%;padding:2em">
	<form style="text-align:center;width:100%;" action="ResetPasswordServlet" method = "post">
	
		<label>Enter the old password </label> <input type = "text" name="oldpass" required><br/>
		<label>Enter the new password </label> <input type = "text" name="newpass" required><br/>
		<label>Confirm new password </label> <input type = "text" name="confirmnewpass" required><br/>
		<input style="margin: 1em 0 0 ;" type = "submit" value = "submit"/>
	
	</form>
	</div>
</div>
</body>
</html>