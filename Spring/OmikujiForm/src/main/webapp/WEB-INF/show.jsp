<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
</head>
<body>
	<h1>Here's Your Omikuji</h1>
	<h2>In <c:out value="${yearNumber}"/> years, you will live in <c:out value="${city}"/> with 
	<c:out value="${personName}"/> as your roommate, <c:out value="${hobby}"/> for a living. The next time you see
	 a <c:out value="${livingThing}"/>, you will have goodluck. Also, <c:out value="${saySomething}"/> </h2>
	 <a href="/omikuji">Go Back</a>
</body>
</html>