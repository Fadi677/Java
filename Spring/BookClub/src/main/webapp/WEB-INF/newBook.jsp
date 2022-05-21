<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Share</title>
</head>
<body>
	<h1>Add a book to Your Shell!</h1>
	<form:form action="/books/new" method="post" modelAttribute="newBook">
  		
    	<p>
        	<form:label path="title">Book Title: </form:label>
        	<form:errors path="title"/>
        	<form:input path="title"/>
    	</p>
    	<p>
        	<form:label path="author">Book Author: </form:label>
        	<form:errors path="author"/>
        	<form:input path="author"/>
    	</p>
    	<p>
        	<form:label path="thoughts">My Thoughts: </form:label>
        	<form:errors path="thoughts"/>
        	<form:input path="thoughts"/>
    	</p>    
    	
    	<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>