<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
</head>
<body>
	<h1><span>${theProduct.productName}</span></h1>
	<a href="/">Home</a>
	<li>${theProduct.productDescription}</li>
	<li>${theProduct.productPrice}</li>
	<h2><span>Categories: </span></h2>
	<c:forEach var="cat" items="${categoriesForTheProduct}">
	<li>>${cat.categoryName}</li>
	</c:forEach>
	
	<form:form action="/products/${theProduct.id}/addCategory" method="post" modelAttribute="theProduct">
	
	<form:label path="categories">Add Category</form:label>
        	<form:select path="categories">
        		<c:forEach var="category" items="${categoriesExceptTheProduct}">
        			<option value="${category.id}">${category.categoryName}</option>
        		</c:forEach>
        	</form:select>
    	<input type="submit" value="Add"/>
	</form:form>
</body>
</html>