<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${showLanguage.languageName}</title>
</head>
<body>
	<a href = '/languages'>Dashboard</a>
	<p>${showLanguage.languageName}</p>
	<p>${showLanguage.creator}</p>
	<p>${showLanguage.langVersion}</p>
	<p><a href = '/languages/${showLanguage.id}/edit'>Edit</a></p>
	<p>
		<form action="/languages/${showLanguage.id}" method="post">
	    	<input type="hidden" name="_method" value="delete">
	    	<input type="submit" value="Delete">
		</form>
	</p>
</body>
</html>