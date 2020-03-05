
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="/WEB-INF/jspViews/header.html" %>

<title>Dan's Pizza</title>
<style>

	.main-list{
		list-style:none;
	
		
	}
	.main-list li{
		margin:2em 0em;
	}
	
	.list-button{
		padding:2em;
		width:25%;
	}
	
	
	
</style>
</head>
<body>

	<!-- As a link -->
		<nav class="navbar navbar-light bg-light">
		  <a class="navbar-brand" href="index.jsp">Dan's Pizza</a>
		</nav>
		
	
		
		<center>
				<ul class="main-list">
					<li><a class="list-button btn btn-outline-dark" href="loadPizzaOrder.html">Save Order</a></li>
					<li><a class="list-button btn btn-outline-dark"  href="loadBillRangeReport.html">Order Report</a></li>
					<li><a class="list-button btn btn-outline-dark"  href="loadUpdateOrder.html">Update Order</a></li>
			
				</ul>
		</center>
		
		
</body>
</html>