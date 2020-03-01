<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Order</title>
</head>
<body>

<center>
		<p>Enter the order which you want to delete</p>
		<form:form modelAttribute="pizzaOrderObject" action="deletePizzaOrder.html">
			Order id: <form:input type="text" path="orderId"/>
			<input type="submit" value="Submit">
		</form:form>
		
</center>
</body>
</html>