<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<center>
		<h2>Add Pizza Details</h2>
	<h3>Welcome : ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/cstlogout" />" > Logout</a></h3>
		
		<form:form modelAttribute="pizzaOrderObject" action="SavePizzaOrder.html">

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
			<input type="submit" value="Order" />
			<br />
			<br />
			<a href="index.jsp"> Home</a>
		<spring:hasBindErrors name="pizzaOrderObject">
			<h3>All Errors</h3>
			<form:errors path="*"  cssClass="error"/>
	   	</spring:hasBindErrors>
	   	
		</form:form>
	</center>
</body>
</html>