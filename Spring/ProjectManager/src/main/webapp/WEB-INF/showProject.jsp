<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Details</title>
</head>
<body>
	<h1>Project Details</h1>
	<a href="/dashboard">Back To Dashboard</a>
	
	<h3>Project: ${projectDet.title}</h3>
	<h3>Description: ${projectDet.description}</h3>
	<h3>Due Date: ${projectDet.dueDate}</h3>
	<c:choose>
    <c:when test="${projectDet.projectLeader.id==currentUserId}">
        <form action="/projects/${projectDet.id}/delete" method="post">
	    	<input type="hidden" name="_method" value="delete">
	    	<input type="submit" value="Delete Project">
		</form>
    </c:when>
    </c:choose>
	
</body>
</html>