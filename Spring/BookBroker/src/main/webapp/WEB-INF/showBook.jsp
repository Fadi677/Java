<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read Share</title>
</head>
<body>
	<h1><span>${certainBook.title}</span></h1>
	<a href="/bookmarket">back to the shelves</a>
	<c:if test="${currentUserId==postedByUserId}">
		<p>You read ${certainBook.title} by ${certainBook.author}.</p>
		<p>Here are your thoughts:</p>
		<p>${certainBook.thoughts}</p>
	</c:if>
	<c:if test="${currentUserId!=postedByUserId}">
		<p>${certainBook.postedBy.userName} read ${certainBook.title} by ${certainBook.author}.</p>
		<p>Here are ${certainBook.postedBy.userName}'s thoughts:</p>
		<p>${certainBook.thoughts}</p>
	</c:if>
	<c:if test="${currentUserId==postedByUserId}">
		<form:form action='/books/${certainBook.id}/edit' method="get" modelAttribute="newBook">
    		<input type="submit" value="Edit"/>
		</form:form>
	</c:if>
</body>
</html>