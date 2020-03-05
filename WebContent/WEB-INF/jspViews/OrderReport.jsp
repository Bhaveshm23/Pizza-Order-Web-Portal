<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/jspViews/header.html" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Report</title>

<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<center>
		<h2>Order with in Price Range Report</h2>		
		<h3>Welcome : ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/cstlogout" />" > Logout</a></h3>
	
		<form:form action="FetchDetails.html" modelAttribute="billRangeObj">
		<div class="form-group form-inline" style="width:25%">
			   
			  From Price <form:input path="fromPrice"  class="form-control" placeholder="Price" style='width:100%;'/>
	  	</div>
	  	
	  	<div class="form-group form-inline" style="width:25%">
			   
			   To Price <form:input path="toPrice"  class="form-control" placeholder="Price" style='width:100%;'/>
	  	</div>
	  	
	  	<button type="submit" class="btn btn-secondary">Fetch Details</button>
	  	<button class="btn btn-light"><a href="index.jsp">Home</a></button>
	  	<br/>
	  	<br/>
	  	<spring:hasBindErrors name="billRangeObj">
			<h3>All Errors</h3>
			<form:errors path="*"  cssClass="error"/>
	   	</spring:hasBindErrors>
	   	
			<br>
			<br>
			<br>
			<h4 class="error">${priceError}</h4>
			<c:if test="${not empty pizzaOrderList}">
				
				<table border="2" class="table table-striped" style="width:60%;">
				<tr>
					<th>Order Id</th><th>Customer Name</th><th>PizzaId</th><th>Bill</th><th>Quantity</th>
				</tr>
				
				<c:forEach items="${pizzaOrderList}" var="itr">
				<tr>
					<td><c:out value="${itr.orderId}"/> </td>
					<td><c:out value="${itr.customerName}"/> </td>
					<td><c:out value="${itr.pizzaId}"/></td>
					<td> <fmt:formatNumber value="${itr.bill}" type="currency" currencySymbol="INR." ></fmt:formatNumber>
					</td>
					<td><c:out value="${itr.numberOfPiecesOrdered}"/></td>
				</tr>
				</c:forEach>
				
			</table>
			
			</c:if>
			
				
			
			
		</form:form>

	</center>
</body>
</html>