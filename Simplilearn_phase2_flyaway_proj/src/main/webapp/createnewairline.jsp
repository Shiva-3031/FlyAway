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

	<form action = "CreateNewAirlineServlet" method= "post">
		Enter the new airline name: <input type = "text" name="newairlinename" >
		<input type = "submit" name = "add airline">
	</form>
</div>
</body>
</html>