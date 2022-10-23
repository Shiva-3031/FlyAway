<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="CreateFlyDetailsServlet" method = "post">
	
		Enter the airline Name: <input type = "text" name = "airlinename" ><br />
		Enter the Date of Flight: <input type = "text" name = "dateofflight" ><br />
		Enter the source : <input type = "text" name = "source"><br/>
		Enter the destination: <input type = "text" name = "destination" ><br />
		Enter the price: <input type = "text" name = "price" ><br />
		Enter the seats: <input type = "number" min = 1 name = "seats" ><br />
		
		<input type="submit" value = "add">	
		
	
	</form>

</body>
</html>