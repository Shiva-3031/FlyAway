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

<% 
		if(request.getSession(false) == null){
			response.setContentType("text/html");
			request.getRequestDispatcher("admin_login_page.jsp").include(request, response);
		}

%>
<div class="centering">
<a href="resetpassword.jsp">Reset Password</a><br/>

<a href="createnewplace.jsp">Create new place</a>
<a href="createnewairline.jsp">Create new Airline</a>
<a href="addnewflydetails.jsp">Add new Flight</a>
<a href="showflydetails.jsp">Show Flight Details</a>

</div>
</body>
</html>