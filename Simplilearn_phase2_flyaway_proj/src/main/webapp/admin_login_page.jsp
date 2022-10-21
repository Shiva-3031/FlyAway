<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<form action = "AdminServlet" method = "post">
			<label>User name: </label><input type="text" name="admin_username" />
			<br />
			<label>Password: </label><input type = "password" name = "admin_password" />
			<input type ="submit" value ="submit" />
		</form>
	</div>

</body>
</html>