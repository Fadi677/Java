<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Share</title>
</head>
<body>
	<h1>Choose your Entry</h1>
	<a href="/bookmarket">back to the shelves</a>
	<form:form action="/books/${certainBook.id}/edit" method="post" modelAttribute="certainBook">
  		<input type="hidden" name="_method" value="put">
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
	<form:form action="/books/${certainBook.id}/delete" method="post" modelAttribute="certainBook">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="Delete"/>
	</form:form>
</body>
</html>