<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Order Details</title>
</head>
<body>

<center>
<h2>Update Order Details</h2>
		<form:form modelAttribute="pizzaOrderObject" action="loadUpdateOrder2.html">
			<p>Enter the order id which you want to update</p>
			Order id : <form:input type="text" path="orderId" onchange="submit()"/>
			</form:form>
				<c:if test="${not empty pizzaOrderObject2}">
			 	<h3>Below are the details for this Order</h3>
			 	
			 	<form:form modelAttribute="pizzaOrderObject2" action="UpdatePizzaOrder.html">
			 			<br>
				
			<table border="2">
				<tr>
					<th>Customer Name</th>
					<td><form:input path="customerName" /></td>
				</tr>
				<tr>
					<th>Customer Contact</th>
					<td><form:input path="contactNumber" /></td>
				</tr>
				<tr>

					<th>Pizza Name</th>
					<td><form:select path="pizzaId">
							<form:option label="--Select--" value="" />
							<form:options items="${pizzaNamesAndId}" />
						</form:select>
				</tr>

				<tr>
					<th>Quantity</th>
					<td><form:input path="numberOfPiecesOrdered" /></td>
				</tr>
			</table>
			<br />
			
			<br />
			<br />
			<input type="submit" value="Update"/>
		</form:form>
			 </c:if>
</center>
</body>
</html>