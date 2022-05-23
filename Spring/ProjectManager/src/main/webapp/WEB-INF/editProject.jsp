<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit My Project</title>
</head>
<body>
	<form:form action="/projects/${thisProject.id}/edit" method="post" modelAttribute="thisProject">
	<input type="hidden" name="_method" value="put">
  		
    	<p>
        	<form:label path="title">Project Title: </form:label>
        	<form:errors path="title"/>
        	<form:input path="title"/>
    	</p>
    	<p>
        	<form:label path="description">Project Description: </form:label>
        	<form:errors path="description"/>
        	<form:input path="description"/>
    	</p>
    	<p>
        	<form:label path="dueDate">Due Date: </form:label>
        	<form:errors path="dueDate"/>
        	<form:input type="date" path="dueDate"/>
    	</p>    
    	
    	<input type="submit" value="Submit"/>
	</form:form>
	<button><a href="/dashboard">Cancel</a></button>
</body>
</html>