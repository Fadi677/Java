<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testing JSTL</title>
</head>
<body>
	<h1>Two plus two is: </h1>
	<h2><c:out value="${2+2}"/></h2>
	<p>
        <c:out value="${dojoName}"/>
    </p>
</body>
</html>