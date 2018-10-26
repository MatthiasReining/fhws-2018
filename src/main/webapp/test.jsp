<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Hello FHWS</h1>

tesT: <%= session.getAttribute("counterObject") %>
	<br>
	auf dem Server ist es <%=new Date()%>
		<br>
<%for (int i = 0; i < 5; i++) {%>
hallo <br>
<%}%>
</body>
</html>