<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/jspViews/header.html" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Order Details</title>
</head>
<body>

<center>
<h2>Update Order Details</h2>
<h3>Welcome : ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/cstlogout" />" > Logout</a></h3>
	
		<form:form modelAttribute="pizzaOrderObject" action="loadUpdateOrder2.html">
		
			<p>Enter the order id which you want to update</p>
			<div class="form-group form-inline" style="width:25%">
			   
			  Order id<form:input path="orderId"  class="form-control" placeholder="Order id" style='width:100%;'/>
	  	</div>
	  		  	<button type="submit" class="btn btn-secondary">Submit</button>
	  		  	<button class="btn btn-light"><a href="index.jsp">Home</a></button>
	  	<br/>
	  	<br/>
	  	
			</form:form>
				<c:if test="${not empty pizzaOrderObject2}">
			 	<h3>Below are the details for this Order</h3>
			 	
			 	<form:form modelAttribute="pizzaOrderObject2" action="UpdatePizzaOrder.html">
			 			<br>
				
			<table border="2" class="table table-striped" style="width:60%;">
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
		
	  		  	<button type="submit" class="btn btn-primary">Update</button><br/><br/>
		</form:form>
			 </c:if>
</center>
</body>
</html>