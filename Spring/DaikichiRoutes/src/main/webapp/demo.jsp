<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>First JSP Page</title>
</head>
<body>
	<h1>Test</h1>
	<%for(int i=0;i<5;i++){ %>
	<h2>I: <%=i %></h2>
	<%} %>
	<h2>The Date and Time are: <%= new Date() %></h2>
</body>
</html>