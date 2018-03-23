<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

	<h2>LOG IN:</h2>
	
	<form:form action="${pageContext.request.contextPath}/verifyUserData" method="POST">
		<h3>Login:</h3>
		<input type="text" name="appUsername">
		
		<h3>Password:</h3>
		<input type="password" name="userPassword">
		<br><br>
		<input type="submit" value="Login!">
	</form:form>
</body>
</html>