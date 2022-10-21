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
		date of travel <input type="date" name="date" min="<%= LocalDate.now()%>" /> <br/>
		source <input type = "text" name="source" /> <br/>
		destination <input type = "text" name = "destination" /><br/>
		number of persons <input type = "number" min = 1 name="persons" /><br/>
		<input type = "submit" value="search">
	</form>

</body>
</html>