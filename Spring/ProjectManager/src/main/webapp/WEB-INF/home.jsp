<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Manager Dashboard</title>
</head>
<body>
	<h1>Welcome, <span>${currentUser.userName}</span></h1>
	<a href="/logout">Log Out</a>
	<h3>All Projects</h3>
	<button><a href="/projects/new">+ new project</a></button>
	<table>
		<tr>
			<th>Project</th>
			<th>Team Lead</th>
			<th>Due Date</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="notProject" items="${projectsNot}">
		<tr>
		<td><a href ='/projects/${notProject.id}'>${notProject.title}</a></td>
		<td>${notProject.projectLeader.userName}</td>
		<td>${notProject.dueDate}</td>
		<td><a href ='/projects/${notProject.id}/join'>Join Team</a></td>
		</tr>
		</c:forEach>
	</table>
	
	<h3>Your Projects</h3>
	<table>
		<tr>
			<th>Project</th>
			<th>Team Lead</th>
			<th>Due Date</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="inProject" items="${projectsFor}">
		<tr>
		<td><a href ='/projects/${inProject.id}'>${inProject.title}</a></td>
		<td>${inProject.projectLeader.userName}</td>
		<td>${inProject.dueDate}</td>
		<td>
		<c:choose>
    	<c:when test="${inProject.projectLeader.id==currentUserId}">
        	<td><a href ='/projects/${inProject.id}/edit'>edit</a></td>
    	</c:when>
    	<c:otherwise>
        	<td><a href ='/projects/${inProject.id}/leave'>Leave Team</a></td>
    	</c:otherwise>
		</c:choose>
		</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>