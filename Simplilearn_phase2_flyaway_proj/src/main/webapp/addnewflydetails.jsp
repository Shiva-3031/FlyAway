<%@page import="java.time.LocalDate"%>
<%@page import="com.flyaway.DAO.PlaceDAO"%>
<%@page import="com.flyaway.bean.PlacesBean"%>
<%@page import="com.flyaway.bean.AirlinesBean"%>
<%@page import="java.util.List"%>
<%@page import="com.flyaway.DAO.AirlineDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/mystyle.css">
</head>
<body>

<% 
		if(request.getSession(false) == null){
			response.setContentType("text/html");
			request.getRequestDispatcher("admin_login_page.jsp").include(request, response);
		}

%>
	<div class = "centering">
	<center><h3>New Flight Addition</h3></center>
<%@ include file="homepageredirect.jsp" %>
<div style = "border:solid black 2px; width: 100%;padding:2em">

	<form style="width:100%;text-align:center;" action= "CreateFlyDetailsServlet" method = "post" >
	<table style="width:100%">
	<tr>
	<td>Select Date:</td>
	<td><input style="width:100%;text-align:center;" type = "date" name = "date" min= "<%= LocalDate.now() %>" required/></td>
	</tr>
	<tr>
	<td>Select the airline:</td>
	<td><select name= "airline" style="width:100%;text-align:center;" required>
	<% 
		List<AirlinesBean> list = AirlineDAO.airlinesList();
		for(AirlinesBean ab:list){
			out.println("<option value = "+ ab.getAirlineId()+" > "+ab.getAirlineName()+" </option>");
		}
	%>
	</select></td>
	</tr>
	<tr>
	<td>
	Select the source place:</td><td> <select style="width:100%;text-align:center;" name = "source" required>
	<% 
		List<PlacesBean> placelist = PlaceDAO.placesList();
		for(PlacesBean ab:placelist){
			out.println("<option value = "+ ab.getPlaceId()+" > "+ab.getPlaceName()+" </option>");
		}
	%>
	
	</select></td>
	</tr>
	<tr>
	<td>Select the destination place:</td><td> <select style="width:100%;text-align:center;" name = "destination" required>
	<% 
		List<PlacesBean> placedestinationlist = PlaceDAO.placesList();
		for(PlacesBean ab:placedestinationlist){
			out.println("<option value = "+ ab.getPlaceId()+" > "+ab.getPlaceName()+" </option>");
		}
	%>
	
	</select></td>
	</tr>
	<tr>
	<td>
	Enter the total seats:</td><td> <input style="width:100%;text-align:center;" type = "number" min = 1 name = "seats" required/></td>
	</tr>
	<tr>
	<td>Enter the price of the each ticket: </td><td><input style="width:100%;text-align:center;" type = "number" name = "price" required/></td>
	</tr>
	<tr>
	<td colspan=2><input style="width:100%;text-align:center;" type = "submit" name="add Flight"></td>
	
	</table>
	</form>
	
	</div>

</body>
</html>