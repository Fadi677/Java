<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Lender Dashboard</title>
</head>
<body>
	<h1>Hello, <span>${currentUser.userName}</span></h1>
	<h1>Welcome to the BookBroker</h1>
	<a href="/logout">Log Out</a>
	<h3>Available Books to Borrow</h3>
	<h3><a href="/books/new">+Add a book to my shelf</a></h3>
	<table>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Owner</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="theBook" items="${allTheBooks}">
		<tr>
			<td>${theBook.id}</td>
			<td><a href="/books/${theBook.id}">${theBook.title}</a></td>
			<td>${theBook.author}</td>
			<td>${theBook.postedBy.userName}</td>
			<c:choose>
				<c:when test="${currentUserId==theBook.postedBy.id}">
					<td><a href="/books/${theBook.id}/edit">Edit </a> <a href="/books/${theBook.id}/delete">Delete </a></td>
				</c:when>
				<c:otherwise>
					<td><a href="/books/${theBook.id}/borrow">Borrow </a></td>
				</c:otherwise>
			</c:choose>
		</tr>
		</c:forEach>
	</table>
	<h3>Books I'm Borrowing..</h3>
	<table>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Owner</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="bookBorrowed" items="${allTheBooksBorrowedByUser}">
		<tr>
			<td>${bookBorrowed.id}</td>
			<td><a href="/books/${bookBorrowed.id}">${bookBorrowed.title}</a></td>
			<td>${bookBorrowed.author}</td>
			<td>${bookBorrowed.postedBy.userName}</td>
			<td><a href="/books/${bookBorrowed.id}/return">Return</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>