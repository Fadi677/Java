<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="main.css"/>
</head>
<body>
	<h1>Fruit Store</h1>
	<table class="table table-striped">
		<tr class="table-danger">
			<th>Name</th>
			<th>Price</th>
		</tr>
		<c:forEach var="type" items="${fruitsAll}">
		<tr class="table-secondary">
			<td><c:out value="${type.name}"/></td>
			<td><c:out value="${type.price}"/></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>