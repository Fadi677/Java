<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Omikuji</title>
</head>
<body>
	<h1>Send an Omikuji!</h1>
	<form action='/passData' method='POST'>
		<div class="mb-3">
			<label for="yearNumber">Pick any number from 5 to 25</label>
  				<input type="number" id="quantity" name="yearNumber" min="5" max="25">
		</div>
  		<div class="mb-3">
    		<label for="city" class="form-label">Enter the name of any city.</label>
    		<input type="text" class="form-control" id="city" name="city" aria-describedby="emailHelp">
  		</div>
  		<div class="mb-3">
    		<label for="personName" class="form-label">Enter the name of any real person</label>
    		<input type="text" class="form-control" id="personName" name="personName" aria-describedby="emailHelp">
  		</div>
  		<div class="mb-3">
    		<label for="hobby" class="form-label">Enter professional endeaver or hobby:</label>
    		<input type="text" class="form-control" id="hobby" name="hobby" aria-describedby="emailHelp">
  		</div>
  		<div class="mb-3">
    		<label for="livingThing" class="form-label">Enter any type of living thing.</label>
    		<input type="text" class="form-control" id="livingThing" name="livingThing" aria-describedby="emailHelp">
  		</div>
  		<div class="mb-3">
  			<label for="saySomething" class="form-label">Say something nice to someone:</label>
  			<textarea name="saySomething" rows="4" cols="50"></textarea>
  		</div>
  		<div class="mb-3">
  			<label>Send and show a friend</label>
  			<button type="submit" class="btn btn-primary">Send</button>
  		</div>
	</form>
</body>
</html>