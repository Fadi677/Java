<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<title>Baby Names</title>
</head>
<body>
	<h1 style="color: #009e0f; text-align: center; font-size: 40px;"> Hello, ${currentUser.userName}. Here Are Some Suggestions </h1>
	<span style="margin-left: 14px;"><a href="/logout">Log Out</a></span>
	<table  class="table">
	<tr>
		<th>Baby Name</th>
		<th>Name Gender</th>
		<th>Origin</th>
		<th>Posted By</th>
	</tr>
		<c:forEach var="bName" items="${listOfName}">
			<tr>
				<td><a href="/names/${bName.id}">${bName.bornName}</a></td>
				<td>${bName.bornGender}</td>
				<td>${bName.bornOrigin}</td>
				<td>${bName.namedBy.userName}</td>
			</tr>
		</c:forEach>
	</table>
	<span style="margin-left: 10px;"><a href="/names/new" style="font-size: 30px;">new name</a></span>
</body>
