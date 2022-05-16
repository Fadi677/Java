<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
</head>
<body>
	<form:form action="/ninjas/new" method="post" modelAttribute="createNewNinja">
    	<p>
        	<form:label path="ninjaFirstName">First Name: </form:label>
        	<form:errors path="ninjaFirstName"/>
        	<form:input path="ninjaFirstName"/>
    	</p>
    	<p>
        	<form:label path="ninjaLastName">Last Name: </form:label>
        	<form:errors path="ninjaLastName"/>
        	<form:input path="ninjaLastName"/>
    	</p>
    	<p>
        	<form:label path="ninjaAge">Age: </form:label>
        	<form:errors path="ninjaAge"/>
        	<form:input type="Integer" path="ninjaAge"/>
    	</p>
    	<p>
        	<form:label path="dojo">Dojo: </form:label>
        	<form:errors path="dojo"/>
        	<form:select path="dojo">
        		<c:forEach var="dojo" items="${dojosList}">
        		<option value="${dojo.id}">${dojo.dojoName}</option>
        		</c:forEach>
        	</form:select>
    	</p>    
    	
    	<input type="submit" value="Create"/>
	</form:form> 
</body>
</html>