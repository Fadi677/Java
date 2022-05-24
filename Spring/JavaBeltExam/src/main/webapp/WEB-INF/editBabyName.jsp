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
<title>Edit ${thisBabyName.bornName}</title>
</head>
<body>
	<h1 style="margin-left: 16px;">Change <span>${thisBabyName.bornName}</span></h1>
	<form:form action="/names/${thisBabyName.id}/edit" method="post" modelAttribute="thisBabyName">
	<input type="hidden" name="_method" value="put">
		<div style="margin-left: 16px;" class="form-group">
        	<form:label path="bornName">New Name: </form:label>
        	<form:errors path="bornName"/>
        	<form:input class= "form-control" path="bornName"/>
    	</div>
    	<div style="margin-left: 16px;" class="form-group">
    		<form:label path="bornGender">Typical Gender: </form:label>
        	<form:select path="bornGender">
        			<option value="Neutral">Neutral</option>
        			<option value="Male">Male</option>
        			<option value="Female">Female</option>
        	</form:select>
    	</div>
    	<div style="margin-left: 16px;" class="form-group">
        	<form:label path="bornOrigin">Origin: </form:label>
        	<form:errors path="bornOrigin"/>
        	<form:input class= "form-control" path="bornOrigin"/>
    	</div>
    	<div style="margin-left: 16px;" class="form-group">
        	<form:label path="bornMeaning">Meaning: </form:label>
        	<form:errors path="bornMeaning"/>
        	<form:input class= "form-control" path="bornMeaning"/>
    	</div>
    	<input type="submit"  class="btn btn-success" style="margin-left: 16px;" value="Submit"/>
	</form:form>
	<button class="btn btn-warning" style="margin-top:10px;  margin-left: 16px;"><a href="/home">Cancel</a></button>
	<c:choose>
    <c:when test="${thisBabyName.namedBy.id==currentUserId}">
        <form action="/names/${thisBabyName.id}/delete" method="post">
	    	<input type="hidden" name="_method"  value="delete">
	    	<input type="submit" class="btn btn-danger" style="margin-top:10px; margin-left: 16px" value="DELETE">
		</form>
    </c:when>
    </c:choose>
</body>
</html>