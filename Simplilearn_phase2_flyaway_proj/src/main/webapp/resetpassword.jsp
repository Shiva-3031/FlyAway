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

	<form action="ResetPasswordServlet" method = "post">
	
		<label>Enter the old password </label> <input type = "text" name="oldpass"><br/>
		<label>Enter the new password </label> <input type = "text" name="newpass"><br/>
		<label>Confirm new password </label> <input type = "text" name="confirmnewpass"><br/>
		<input type = "submit" value = "submit"/>
	
	</form>
</div>
</body>
</html>