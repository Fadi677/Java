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
<title>Create A New Name</title>
</head>
<body>
	<h1>Add a Name!</h1>
	<form:form action="/names/new" method="post" modelAttribute="newName">
		<div class="form-group">
        	<form:label path="bornName">New Name: </form:label>
        	<form:errors path="bornName"/>
        	<form:input class= "form-control" path="bornName"/>
    	</div>
    	<div class="form-group">
    		<form:label path="bornGender">Typical Gender: </form:label>
        	<form:select path="bornGender">
        			<option value="Neutral">Neutral</option>
        			<option value="Male">Male</option>
        			<option value="Female">Female</option>
        	</form:select>
    	</div>
    	<div class="form-group">
        	<form:label path="bornOrigin">Origin: </form:label>
        	<form:errors path="bornOrigin"/>
        	<form:input class= "form-control" path="bornOrigin"/>
    	</div>
    	<div class="form-group">
        	<form:label path="bornMeaning">Meaning: </form:label>
        	<form:errors path="bornMeaning"/>
        	<form:input class= "form-control" path="bornMeaning"/>
    	</div>
    	<input class="btn btn-success" type="submit" value="Submit"/>
	</form:form>
	<button class="btn btn-warning" style="margin-top:10px;"><a href="/home">Cancel</a></button>
</body>
</html>