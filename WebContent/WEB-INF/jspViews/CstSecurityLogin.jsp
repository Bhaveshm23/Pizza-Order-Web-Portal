<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/jspViews/header.html" %>

<html>
<head>
<title>Login Page</title>
<style>
	.error{
		color:red;
	}
	.success{
		color:green;
	}
</style>
</head>
<body >

<center>
	

						<c:if test="${param.error != null}">
									<h4 class="error">Invalid username and password.</h4>
							</c:if>
							<c:if test="${param.logout != null}">
									<h4 class="success">You have been logged out successfully.</h4>
							</c:if>

<div class="login-form">
	<h1>Login</h1>
		<form name='loginForm' action="<c:url value='/cstValidateSecureLogin'/>" method='POST'>

		 <div class="form-group form-inline" style="width:25%">
			   
			   Username <input  name='msd_uname123'type="text" class="form-control" placeholder="Username" style="width:100%">
	  </div>
	  <div class="form-group form-inline" style="width:25%">
			   Password <input name='msd_pwd123' type="password" class="form-control"  placeholder="Password" style="width:100%">
	  </div>
	 
	  <button type="submit" class="btn btn-primary">Submit</button>
	  <button class="btn btn-light"><a href="index.jsp">Home</a></button>

		</form>
</div>

</center>	

</body>
</html>