<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read Share</title>
</head>
<body>
	<h1>Save Travels</h1>
	<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Expense</th>
            <th>Vendor</th>
            <th>Amount</th>
            <th>Description</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="exp" items="${expenseObject}">
    	<tr>
    		<td>
    			<c:out value="${exp.id}"></c:out>
    		</td>
    		<td>
    			<a href='/expenses/<c:out value="${exp.id}"/>'>${exp.expenseTitle}</a>
    		</td>
    		<td>
    			<c:out value="${exp.vendor}"></c:out>
    		</td>
    		<td>
    			<c:out value="${exp.amount}"></c:out>
    		</td>
    		<td>
    			<c:out value="${exp.description}"></c:out>
    		</td>
    		<td>
    			<a href = '/expenses/<c:out value ="${exp.id}" />/edit'>Edit</a>
    		</td>
    		<td>
    			<form action="/expenses/${exp.id}/delete" method="post">
    				<input type="hidden" name="_method" value="delete">
    				<input type="submit" value="Delete">
				</form>
    		</td>
    	</tr>
    </c:forEach>
    </tbody>
</table>
	<h1>Add an Expense:</h1>
	<form:form action="/expenses/new" method="post" modelAttribute="expenses">
    <p>
        <form:label path="expenseTitle">Expense</form:label>
        <form:errors path="expenseTitle"/>
        <form:input path="expenseTitle"/>
    </p>
    <p>
        <form:label path="vendor">Vendor</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount</form:label>
        <form:errors path="amount"/>
        <form:input type="number" path="amount"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>     
        <form:textarea path="description"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>  
</body>
</html>