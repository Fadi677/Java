<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h1>Home Page</h1>
	<a href="products/new">New Product</a>
	<a href="categories/new">New Category</a>
	<h2>Products</h2>
		<c:forEach var="pro" items="${allTheProducts}">
		<ul><a href ='/products/${pro.id}'>${pro.productName}</a></ul>
		</c:forEach>
	<h2>Categories</h2>
	<c:forEach var="cat" items="${allTheCategories}">
		<ul><a href ='/categories/${cat.id}'>${cat.categoryName}</a></ul>
		</c:forEach>
</body>
</html>