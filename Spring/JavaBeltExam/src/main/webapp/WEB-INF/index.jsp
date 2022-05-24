</html><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<title>Joy Bundler</title>
</head>
<body>
	<h1 style="color: #009e0f; text-align: center; font-size: 100px">Joy Bundler Names</h1>
	<div style="display: flex; align-items: start; width: 800; margin: 0 auto;">
		<div style="margin-right:120px;">
			<h1 style="font-family: cursive;">Register</h1>
				<form:form action="/register" method="post" modelAttribute="newUser" class="row g-3">
    			<div class="col-md-6">
        			<form:label path="userName" class="form-label">User Name: </form:label>
        			<form:input path="userName" class="form-control"/>
        			<form:errors path="userName"/>
    			</div>
    			<div class="col-md-6">
        			<form:label path="email">Email: </form:label>
        			<form:input path="email"/>
        			<form:errors path="email"/>
    			</div>
    			<div class="col-md-6">
        			<form:label path="password">Password: </form:label>
        			<form:input type="password" path="password"/>
        			<form:errors path="password"/>
    			</div>
    			<div class="col-md-6">
        			<form:label path="confirm">Confirm PW: </form:label>
        			<form:input type="password" path="confirm"/>
        			<form:errors path="confirm"/>
    			</div>     
    			<input type="submit" style="box-shadow: 2px 2px 2px #888888; margin-top: 10px; margin-left:16px; background-color: grey;" value="Register"/>
				</form:form> 
		</div>
			<div style="margin-left:120px;">
			<h1 style="font-family: cursive;">Log In</h1>
				<form:form action="/login" method="post" modelAttribute="newLogin">
    			<p>
        			<form:label path="email">Email: </form:label>
        			<form:input path="email"/>
        			<form:errors path="email"/>
    			</p> 
    			<p>
        			<form:label path="password">Password: </form:label>
        			<form:input type="password" path="password"/>
        			<form:errors path="password"/>
    			</p>   
    			<input type="submit" style="box-shadow: 2px 2px 2px #888888; background-color: grey;" value="Login"/>
				</form:form> 
		</div>
	</div>
</body>
</html>