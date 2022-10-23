<%@page import="com.flyaway.bean.FlightsBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

	if(request.getSession(false) == null){
		out.println("Session expired.");
		response.setContentType("text/html");
		request.getRequestDispatcher("seachform.jsp").include(request, response);
	}

%>

<jsp:useBean id="flights" class = "com.flyaway.DAO.CreationFlightDAO"></jsp:useBean>
<%-- ${flights.getFlightDetails(request.getAttribute("flightId")).get } --%>
<table border = 1>
	
	<tr>
		<th>Date</th>
		<th>source</th>
		<th>Destination</th>
		<th>Airlines</th>
		<th>price</th>
		<th>seats</th>
	</tr>
	<jsp:useBean id="place" class="com.flyaway.DAO.PlaceDAO"></jsp:useBean>
	<jsp:useBean id="airline" class="com.flyaway.DAO.AirlineDAO"></jsp:useBean>
		<tr>
			<td>${flightObj.date }</td>
			<td>${place.getPlaceName(flightObj.source)}</td>
			<td>${place.getPlaceName(flightObj.destination)}</td>
			<td>${airline.getAirlineName(flightObj.airline) }</td>
			<td>${flightObj.price }</td>
			<td>${flightObj.availableSeats }</td>
		</tr>
		
	
	
	</table><br/>
	
	UserDetails:<br/>
	<table>
	
		<tr>
		
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Email</th>
			<th>Number of seats</th>
		</tr>
		<tr>
			<td>${userDetails.getUserFirstName()}</td>
			<td>${userDetails.getUserLastName()}</td>
			<td>${userDetails.getUserEmail()}</td>
			<td>${userDetails.getUserSeats()}</td>
		</tr>
		
	
	</table>
	
	
	<form action = "payment.jsp" method = "post">
				<input type = "submit" value="Confirm"/>
			
			</form>

</body>
</html>