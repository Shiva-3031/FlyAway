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
	<center><h3>Admin Login Page</h3></center>
	<div style = "border:solid black 2px; width: 100%;padding:2em" class="innerclass">
		<form style="text-align:center;" action = "AdminServlet" method = "post">
			<label>User name: </label><input type="text" name="admin_username" />
			<br />
			<label>Password: </label><input type = "password" name = "admin_password" /><br />
			<input style="margin:1em;" type ="submit" value ="Login" />
		</form>
		</div>
	</div>

</body>
</html>