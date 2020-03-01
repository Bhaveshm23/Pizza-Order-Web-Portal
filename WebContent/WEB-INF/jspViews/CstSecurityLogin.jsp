<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<h1>Login</h1>

						<c:if test="${param.error != null}">
									<h4 class="error">Invalid username and password.</h4>
							</c:if>
							<c:if test="${param.logout != null}">
									<h4 class="success">You have been logged out successfully.</h4>
							</c:if>

		<h2>Login with Username and Password</h2>

		<form name='loginForm' action="<c:url value='/cstValidateSecureLogin'/>" method='POST'>

		  <table border="2">
			<tr>
				<td>User:</td>
				<td><input type='text' name='msd_uname123' ></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='msd_pwd123' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="submit" /></td>
			</tr>
		  </table>


		</form>
		<a href="index.jsp">Home</a>
</center>
</body>
</html>