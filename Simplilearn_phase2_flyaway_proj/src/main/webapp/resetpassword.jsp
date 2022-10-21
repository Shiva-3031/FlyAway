<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="ResetPasswordServlet" method = "post">
	
		<label>Enter the old password </label> <input type = "text" name="oldpass"><br/>
		<label>Enter the new password </label> <input type = "text" name="newpass"><br/>
		<label>Confirm new password </label> <input type = "text" name="confirmnewpass"><br/>
		<input type = "submit" value = "submit"/>
	
	</form>

</body>
</html>