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
</head>
<body>

<% 
		if(request.getSession(false) == null){
			response.setContentType("text/html");
			request.getRequestDispatcher("admin_login_page.jsp").include(request, response);
		}

%>

	<form action= "CreateFlyDetailsServlet" method = "post" >
	
	Select Date:
	<input type = "date" name = "date" min= "<%= LocalDate.now() %>" /><br />
	
	Select the airline:
	<select name= "airline">
	<% 
		List<AirlinesBean> list = AirlineDAO.airlinesList();
		for(AirlinesBean ab:list){
			out.println("<option value = "+ ab.getAirlineId()+" > "+ab.getAirlineName()+" </option>");
		}
	%>
	</select><br/>
	
	Select the source place: <select name = "source">
	<% 
		List<PlacesBean> placelist = PlaceDAO.placesList();
		for(PlacesBean ab:placelist){
			out.println("<option value = "+ ab.getPlaceId()+" > "+ab.getPlaceName()+" </option>");
		}
	%>
	
	</select><br />
	
	Select the destination place: <select name = "destination">
	<% 
		List<PlacesBean> placedestinationlist = PlaceDAO.placesList();
		for(PlacesBean ab:placedestinationlist){
			out.println("<option value = "+ ab.getPlaceId()+" > "+ab.getPlaceName()+" </option>");
		}
	%>
	
	</select><br />
	
	Enter the total seats: <input type = "number" min = 1 name = "seats" /><br />
	
	Enter the price of the each ticket: <input type = "number" name = "price" />
	<input type = "submit" name="add Flight">
	
	</form>

</body>
</html>