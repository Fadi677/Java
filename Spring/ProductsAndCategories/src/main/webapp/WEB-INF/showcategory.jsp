<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Page</title>
</head>
<body>
	<h1><span>${theCategory.categoryName}</span></h1>
	<a href="/">Home</a>
	<h2><span>Products: </span></h2>
	<c:forEach var="prod" items="${productsForTheCategory}">
	<li>>${prod.productName}</li>
	</c:forEach>
	
	<form:form action="/categories/${theCategory.id}/addProduct" method="post" modelAttribute="CategoriesModel">
	
	<form:label path="products">Add Product</form:label>
        	<form:select path="products">
        		<c:forEach var="product" items="${productsExcCategory}">
        			<option value="${product.id}">${product.productName}</option>
        		</c:forEach>
        	</form:select>
    	<input type="submit" value="Add"/>
	</form:form>
</body>
</html>