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

<jsp:useBean id="flights" class = "com.flyaway.DAO.CreationFlightDAO"></jsp:useBean>
<%-- ${flights.getFlightDetails(request.getAttribute("flightId")).get } --%>

</body>
</html>