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
<center><h3>Dashboard</h3></center>
<%@include file="homepageredirect.jsp" %>
<div style = "border:solid black 2px; width: 100%;padding:2em" class="innerclass">
<table style="width:100%;">
<tr>
<td colspan=3></td>
<td style="border:solid black 2px;text-align:center;padding:0.25em;"><a " href="resetpassword.jsp">Reset Password</a></td>
</tr>
<td style="border:solid black 2px;text-align:center;padding:0.25em;">
<a href="createnewplace.jsp">Create new place</a></td>
<td style="border:solid black 2px;text-align:center;padding:0.25em;">
<a href="createnewairline.jsp">Create new Airline</a></td>
<td style="border:solid black 2px;text-align:center;padding:0.25em;">
<a href="addnewflydetails.jsp">Add new Flight</a></td>
<td style="border:solid black 2px;text-align:center;padding:0.25em;">
<a href="showflydetails.jsp">Show Flight Details</a></td>
</table>
</div>
</div>
</body>
</html>