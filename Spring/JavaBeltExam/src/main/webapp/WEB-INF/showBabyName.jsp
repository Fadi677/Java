<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<title>${babyNameToShow.bornName}</title>
</head>
<body>
	<h1 style="margin-left: 20px;"><span>${babyNameToShow.bornName}</span></h1>
	<span style="margin-left: 20px;"><a href="/home">Go Back</a></span>
	<ul class="list-group">
		 <li class="list-group-item">(added by <span>${babyNameToShow.namedBy.userName}</span>)</li>
		 <li class="list-group-item">Gender: <span>${babyNameToShow.bornGender}</span></li>
		 <li class="list-group-item">Origin: <span>${babyNameToShow.bornOrigin}</span></li>
		 <li class="list-group-item">Meaning: <span>${babyNameToShow.bornMeaning}</span></li>
	</ul>
	<c:choose>
    	<c:when test="${babyNameToShow.namedBy.id==currentUserId}">
			<p style="background-color: #f6d87b; margin-left: 20px;"><a href="/names/${babyNameToShow.id}/edit">Edit</a></p>
    	</c:when>
    </c:choose>
</body>
</html>