<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Date</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="js/date.js"></script>
</head>
<body>
	<h1><c:out value="${todayDay}"/> the <c:out value="${todayDayNumber}"/> of <c:out value="${todayMonth}"/> <c:out value="${todayYear}"/></h1>
</body>
</html>