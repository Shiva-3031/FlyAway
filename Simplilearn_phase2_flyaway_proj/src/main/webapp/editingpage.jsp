<%@page import="com.flyaway.bean.FlightsBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% FlightsBean obj = (FlightsBean) request.getAttribute("editobj"); %>

<form action="SubmissionEditForm" method="post">

	<input type= 'hidden' value='<%= obj.getFlightsId() %>' name='flightId' />
	
	Date :<input type = "Date" value =" <%= obj.getDate() %>" name = 'date' /><br/>
	source :<input type = "text" value =" <%= obj.getSource() %>" name = 'source' /><br/>
	Destination :<input type = "text" value =" <%= obj.getDestination() %>" name = 'destination' /><br/>
	Airlines :<input type = "text" value =" <%= obj.getAirline() %>" name = 'airline' /><br/>
	Price :<input type = "text" value =" <%= obj.getPrice() %>" name = 'price' /><br/>
	Seats :<input type = "text" value =" <%= obj.getAvailableSeats() %>" name = 'seats' /><br/>
	
	<input type = "submit" value="edit"/>
	

</form>

</body>
</html>