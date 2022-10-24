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

<center><h3>Flight Details</h3></center>
<%@ include file="homepageredirect.jsp" %>
<div style = "border:solid black 2px; width: 100%;padding:2em">

	<table style="width:100%;" border = 1>
	
	<tr>
		<th>Date</th>
		<th>source</th>
		<th>Destination</th>
		<th>Airlines</th>
		<th>price</th>
		<th>seats</th>
	</tr>
	
	<%
	
		List<FlightsBean> list = CreationFlightDAO.getFlightsList();
		for(FlightsBean fb: list){
			out.println("<tr>");
			out.println("<td>"+ fb.getDate()+"</td>" +"<td>"+PlaceDAO.getPlaceName(fb.getSource())+"</td>"+
			"<td>"+PlaceDAO.getPlaceName(fb.getDestination())+"</td>"+"<td>"+AirlineDAO.getAirlineName(fb.getAirline())+"</td>"+"<td>"+
				fb.getPrice()+"</td>"+"<td>"+fb.getAvailableSeats()+"</td>");
			out.println("</tr>");
		}
	
	%>
	
	
	</table>
</div>
</body>
</html>