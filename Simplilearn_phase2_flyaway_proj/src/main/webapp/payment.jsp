<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="false" errorpage = "errorpage.jsp" %>
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

<center><h3>Payment Amount</h3></center>
<%@ include file="homepageredirect.jsp" %>
<div style = "border:solid black 2px; width: 100%;padding:2em">

	<center>amount: ${flightObj.price * userDetails.getUserSeats() }</center>
	
	<form style="margin:1em 0 0 ;width:100%;text-align:center;" action="PaymentServlet" method = "post">
	
		<input style="width:50%;" type = "submit" value ="Confirm booking" />
	
	</form>
	</div>
</div>
</body>
</html>