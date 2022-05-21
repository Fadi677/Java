<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read SHare</title>
</head>
<body>
	<h1>Book CLub</h1>
	<p>A place for friends to share thoughts on books.</p>
	<div>
		<div>
			<h1>Register</h1>
				<form:form action="/register" method="post" modelAttribute="newUser">
    			<p>
        			<form:label path="userName">User Name: </form:label>
        			<form:input path="userName"/>
        			<form:errors path="userName"/>
    			</p>
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
    			<p>
        			<form:label path="confirm">Confirm PW: </form:label>
        			<form:input type="password" path="confirm"/>
        			<form:errors path="confirm"/>
    			</p>     
    			<input type="submit" value="Submit"/>
				</form:form> 
		</div>
			<div>
			<h1>Log In</h1>
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
    			<input type="submit" value="Submit"/>
				</form:form> 
		</div>
	</div>
</body>
</body>
</html>