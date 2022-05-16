<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
</head>
<body>
	<table>
    	<thead>
        	<tr>
            	<th>ID</th>
            	<th>Name</th>
            	<th>Creator</th>
            	<th>Version</th>
            	<th>Action</th>
        	</tr>
    	</thead>
    	<tbody>
    		<c:forEach var="lang" items="${languagesList}">
    		<tr>
    			<td>
    				<c:out value="${lang.id}"></c:out>
    			</td>
    			<td>
    				<a href='/languages/${lang.id}'>${lang.languageName}</a>
    			</td>
    			<td>
    				<c:out value="${lang.creator}"></c:out>
    			</td>
    			<td>
    				<c:out value="${lang.creator}"></c:out>
    			</td>
    			<td>
    				<c:out value="${lang.langVersion}"></c:out>
    			</td>
    			<td>
    				
    			</td>
    			<td>
    				<form action="/languages/${lang.id}" method="post">
	    					<input type="hidden" name="_method" value="delete">
	    				<input type="submit" value="Delete">
					</form>
					<a href = '/languages/${lang.id}/edit'>Edit</a>
    			</td>
    		</tr>
    		</c:forEach>
    	</tbody>
	</table>
	<form:form action="/languages" method="post" modelAttribute="languages">
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
        <form:label path="langVersion">Language Version</form:label>
        <form:errors path="langVersion"/>
        <form:input type="double" path="langVersion"/>
    </p>   
    <input type="submit" value="Submit"/>
	</form:form> 
</body>
</html>