<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ include file="/WEB-INF/jspViews/header.html" %>

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
		<h3>Welcome : ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/cstlogout" />" > Logout</a></h3>
	
		<h2>Add Pizza Details</h2>
		
		
		<form:form modelAttribute="pizzaOrderObject" action="SavePizzaOrder.html">

		 <div class="form-group form-inline" style="width:25%">
			   
			   Customer Name <form:input path="customerName"  class="form-control" placeholder="Customer Name" style='width:100%;'/>
	  	</div>
	  	
	  	 <div class="form-group form-inline" style="width:25%">
			   
			  Customer Contact <form:input path="contactNumber"  class="form-control" placeholder="Customer Contact" style='width:100%;'/>
	  	</div>
	  	
	  	 <div class="form-group form-inline" style="width:25%">
			   
			   Pizza Name
	  			<form:select path="pizzaId" class="form-control" style='width:100%;'>
							<form:option label="--Select--" value="" />
							<form:options items="${pizzaNamesAndId}" />
						</form:select>
	  	</div>
	  	
	  	 <div class="form-group form-inline" style="width:25%">
			   
			   Quantity <form:input path="numberOfPiecesOrdered"  class="form-control" placeholder="Quantity" style='width:100%;'/>
	  	</div>
	  	
	  	 <button type="submit" class="btn btn-secondary">Order</button>
	  	<button class="btn btn-light"><a href="index.jsp">Home</a></button>
	  	

		<spring:hasBindErrors name="pizzaOrderObject">
			<h3>All Errors</h3>
			<form:errors path="*"  cssClass="error"/>
	   	</spring:hasBindErrors>
	   	
		</form:form>
	</center>
</body>
</html>