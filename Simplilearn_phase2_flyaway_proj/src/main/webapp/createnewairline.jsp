<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="errorpage.jsp" %>
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
<center><h3>Create New Airline</h3></center>
<%@ include file="homepageredirect.jsp" %>
<div style = "border:solid black 2px; width: 100%;padding:2em">
	<form style="width:100%;text-align:center;" action = "CreateNewAirlineServlet" method= "post">
		Enter the new airline name: <input type = "text" name="newairlinename" required>
		<input type = "submit" name = "add airline">
	</form>
</div>
</div>
</body>
</html>