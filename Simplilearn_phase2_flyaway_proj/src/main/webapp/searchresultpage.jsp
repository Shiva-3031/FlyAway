<%@page import="com.flyaway.DAO.PlaceDAO"%>
<%@page import="com.flyaway.DAO.SearchFlightsDAO"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.stream.Stream"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Collections"%>
<%@page import="com.flyaway.bean.FlightsBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="errorpage.jsp" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href = "css/mystyle.css">
</head>
<body>
<div class="centering">
	<center><h3>Flights Details</h3></center>
<%@ include file="homepageredirect.jsp" %>
<div style = "border:solid black 2px; width: 100%;padding:2em">
	<c:choose>
	<c:when test="${!empty list}">
	<table style="width:100%;" border = 1>
	
	<tr>
		<th>Date</th>
		<th>source</th>
		<th>Destination</th>
		<th>Airlines</th>
		<th>price</th>
		<th>seats</th>
		<th>Book</th>
	</tr>
	<jsp:useBean id="place" class="com.flyaway.DAO.PlaceDAO"></jsp:useBean>
	<jsp:useBean id="airline" class="com.flyaway.DAO.AirlineDAO"></jsp:useBean>
	<c:forEach var = "li" items = "${list}">
		<tr>
			<td>${li.date }</td>
			<td>${place.getPlaceName(li.source)}</td>
			<td>${place.getPlaceName(li.destination)}</td>
			<td>${airline.getAirlineName(li.airline) }</td>
			<td>${li.price }</td>
			<td>${li.availableSeats }</td>
			<td>
			<form action = "UserRegistrationServlet" method = "post">
			<!-- <form action = "userregistrationpage.jsp" method = 'post'> -->
				<input type = "hidden" value = "${li.flightsId}" name="flightId"/>
				<input type = "submit" value="Book"/>
			
			</form>
			</td>
		</tr>
	
	</c:forEach>
	
	</table>
	</c:when>
	<c:when test="${empty list}">
		No result found.
	</c:when>
	</c:choose>
	</div>
</div>
</body>
</html>