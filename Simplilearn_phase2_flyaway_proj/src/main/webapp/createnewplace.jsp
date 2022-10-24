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
		response.setContentType("text/html");;
		request.getRequestDispatcher("admin_login_page.jsp").include(request, response);
	}
		
%>
<center><h3>New Place Creation</h3></center>
<%@ include file="homepageredirect.jsp" %>
<div style = "border:solid black 2px; width: 100%;padding:2em">

	<form style = "width:100%;text-align:center;" action="CreateNewPlaceServlet" method = "post">
	
		Enter the new place name: <input type= "text" name= "newplacename">
		<input type = "submit" value ="add">
	</form>
</div>
</div>
</body>
</html>