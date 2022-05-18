<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${thisNinja.ninjaFirstName}</title>
</head>
<body>
	<h1><span>${thisNinja.ninjaFirstName} ${thisNinja.ninjaFirstName}</span></h1>
	<li>${thisNinja.ninjaAge}</li>
	<li>${thisNinja.dojo.dojoName}</li>
</body>
</html>