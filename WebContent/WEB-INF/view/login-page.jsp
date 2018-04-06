<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<c:if test="${param.error != null}">
			<i><u>Your entered an invalid username and/or password</u></i>
		</c:if>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<br><br>
		<input type="submit" value="Login!">
	</form:form>
</body>
</html>