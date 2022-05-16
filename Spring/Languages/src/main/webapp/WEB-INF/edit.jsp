<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${thisLanguage.languageName}</title>
</head>
<body>
	<a href = '/languages'>Dashboard</a>
	<form action="/languages/${thisLanguage.id}" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete">
	</form>
	<form:form action='/languages/${thisLanguage.getId()}' method="post" modelAttribute="thisLanguage">
	<input type="hidden" name="_method" value="put">
	
    <p>
        <form:label path="languageName">Name</form:label>
        <form:errors path="languageName"/>
        <form:input path="languageName"/>
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:input path="creator"/>
    </p>
    <p>
        <form:label path="langVersion">Version</form:label>
        <form:errors path="langVersion"/>
        <form:input type="Double" path="langVersion"/>
    </p>   
    <input type="submit" value="Submit"/>
</form:form> 
</body>
</html>