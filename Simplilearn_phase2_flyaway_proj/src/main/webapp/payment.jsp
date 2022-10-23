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
		out.println("Session expired.");
		response.setContentType("text/html");
		request.getRequestDispatcher("seachform.jsp").include(request, response);
	}

%>

	amount: ${flightObj.price * userDetails.getUserSeats() }
	
	<form action="PaymentServlet" method = "post">
	
		<input type = "submit" value ="Confirm booking" />
	
	</form>
</div>
</body>
</html>