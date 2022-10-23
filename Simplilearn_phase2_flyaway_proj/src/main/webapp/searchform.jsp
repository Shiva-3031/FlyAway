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
</head>
<body>
	<form action="SearchFormServlet"  method = "post">
		date of travel : <input type="date" name="date" min="<%= LocalDate.now()%>" /> <br/>
		Select the source place: 
		<select name="source">
		
		<%
		
		List<PlacesBean> placelist = PlaceDAO.placesList();
		for(PlacesBean ab:placelist){
			out.println("<option value = "+ ab.getPlaceId()+" > "+ab.getPlaceName()+" </option>");
		}
		
		%>
		
		</select><br/>
		Select the destination place: <select name = "destination">
			<%
			List<PlacesBean> placedestinationlist = PlaceDAO.placesList();
			for (PlacesBean ab : placedestinationlist) {
				out.println("<option value = " + ab.getPlaceId() + " > " + ab.getPlaceName() + " </option>");
			}
			%>

		</select>
		<br/>
		number of persons : <input type = "number" min = 1 name="persons" /><br/>
		<input type = "submit" value="search">
	</form>

</body>
</html>