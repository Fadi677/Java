<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read Share</title>
</head>
<body>
	<h1>Expense Details</h1>
	<a href = '/expenses'>Go Back</a>
	<h2>Expense Name: ${thisExpense.expenseTitle}</h2>
	<h2>Expense Description: ${thisExpense.description}</h2>
	<h2>Vendor: ${thisExpense.vendor}</h2>
	<h2>Amount Spent: ${thisExpense.amount}</h2>
</body>
</html>