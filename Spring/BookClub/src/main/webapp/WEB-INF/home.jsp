<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read SHare</title>
</head>
<body>
	<h1>Welcome, <span>${currentUser.userName}</span></h1>
	<a href="/logout">Log Out</a>
	<h3>Books from everyone's shelves</h3>
	<h3><a href="/books/new">+Add a book to my shelf</a></h3>
	<table>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Posted By</th>
		</tr>
		<c:forEach var="theBook" items="${allTheBooks}">
		<tr>
			<td>${theBook.id}</td>
			<td><a href="/books/${theBook.id}">${theBook.title}</a></td>
			<td>${theBook.author}</td>
			<td>${theBook.postedBy.userName}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>