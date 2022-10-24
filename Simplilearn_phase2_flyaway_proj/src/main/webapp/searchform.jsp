<%@page import="com.flyaway.DAO.PlaceDAO"%>
<%@page import="com.flyaway.bean.PlacesBean"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
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
<center><h3>Search Form</h3></center>
<%@ include file="homepageredirect.jsp" %>
<div style = "border:solid black 2px; width: 100%;padding:2em" class="innerclass">
	
	<form action="SearchFormServlet"  method = "post">
	<table style ="width:100%;">
	<tr>
		<td style="text-align:center;">Date of travel : </td> <td><input style="width:100%;text-align:center;" type="date" name="date" min="<%= LocalDate.now()%>" required/></td>
	</tr>	
	<tr>
	<td style="text-align:center;">Select the source place: </td>
		<td><select style="width:100%;text-align:center;" name="source" required>
		
		<%
		
		List<PlacesBean> placelist = PlaceDAO.placesList();
		for(PlacesBean ab:placelist){
			out.println("<option value = "+ ab.getPlaceId()+" > "+ab.getPlaceName()+" </option>");
		}
		
		%>
		
		</select></td>
		</tr>
		<tr>
		<td style="text-align:center;">Select the destination place:</td> 
		<td>
		<select name = "destination" style ="width:100%;text-align:center;"required>
			<%
			List<PlacesBean> placedestinationlist = PlaceDAO.placesList();
			for (PlacesBean ab : placedestinationlist) {
				out.println("<option value = " + ab.getPlaceId() + " > " + ab.getPlaceName() + " </option>");
			}
			%>

		</select></td>
		</tr>
		<tr>
		<td style="text-align:center;">Number of seats:</td><td><input style="width:100%;" type ="text" name= "persons" />
		<tr>
		<td colspan = 2><input type = "submit" value="search" style="width:100%;background-color:rgb(100,170,255);padding:0.25em 0;margin:0.2em 0 0;"></td>
		</tr>
		</table>
	</form>
</div>
</div>
</body>
</html>