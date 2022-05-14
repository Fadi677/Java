<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reading Books</title>
</head>
<body>
	<h1><span><c:out value="${book.title}"/></span></h1>
	<h2>Description: <span><c:out value="${book.description}"/></span></h2>
	<h2>Language: <span><c:out value="${book.language}"/></span></h2>
	<h2>Number Of Pages: <span><c:out value="${book.numberOfPages}"/></span></h2>
</body>
</html>