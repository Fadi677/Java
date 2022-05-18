<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Category</title>
</head>
<body>
	<h1>New Category</h1>
	<a href="/">Home</a>
	<form:form action="/categories/new" method="post" modelAttribute="createNewCategory">
    	<p>
        	<form:label path="categoryName">Name: </form:label>
        	<form:errors path="categoryName"/>
        	<form:input path="categoryName"/>
    	</p>  
    	<input type="submit" value="Create"/>
	</form:form> 
</body>
</html>