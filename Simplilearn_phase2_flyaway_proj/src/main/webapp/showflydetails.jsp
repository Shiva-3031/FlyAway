<%@page import="com.flyaway.DAO.AirlineDAO"%>
<%@page import="com.flyaway.DAO.PlaceDAO"%>
<%@page import="com.flyaway.DAO.CreationFlightDAO"%>
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

	<table border = 1>
	
	<tr>
		<th>Date</th>
		<th>source</th>
		<th>Destination</th>
		<th>Airlines</th>
		<th>price</th>
		<th>seats</th>
		<th></th>
	</tr>
	
	<%
	
		List<FlightsBean> list = CreationFlightDAO.getFlightsList();
		for(FlightsBean fb: list){
			out.println("<tr>");
			out.println("<td>"+ fb.getDate()+"</td>" +"<td>"+PlaceDAO.getPlaceName(fb.getSource())+"</td>"+
			"<td>"+PlaceDAO.getPlaceName(fb.getDestination())+"</td>"+"<td>"+AirlineDAO.getAirlineName(fb.getAirline())+"</td>"+"<td>"+
				fb.getPrice()+"</td>"+"<td>"+fb.getAvailableSeats()+"</td>");
			out.println("<td><form action='EditFlightsServlet' method='post'><input type='hidden' value='"+fb.getFlightsId()+"' name = 'flightId' ><input type='submit' value='Edit'></form></td>");
			out.println("</tr>");
		}
	
	%>
	
	
	</table>

</body>
</html>