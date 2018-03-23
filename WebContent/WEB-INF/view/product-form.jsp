<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add product</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	
	<nav role="navigation" class="navbar navbar-default">
		<div class="">
			<a href="${pageContext.request.contextPath}/main" class="navbar-brand"><i><b>Product App</b></i></a>
		</div>
		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="${pageContext.request.contextPath}/main">Home</a></li>
				<li><a href="${pageContext.request.contextPath}/showList">Show all products</a></li>
				<li class="active"><a href="${pageContext.request.contextPath}/productForm">Add product</a></li>
				<li><a href="${pageContext.request.contextPath}/buyList">Show buy-list</a></li><li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="containter">
		<h2 class="text-center"><i>Adding a new product to the database</i></h2>
		<br>
		<form:form modelAttribute="addProduct" action="confirmProduct" method="POST" class="needs-validation">
			<form:hidden path="id" />
			<table align="center">
				<tr>
					<td><label>Product name: </label></td>
					<td><form:input path="productName" placeholder="Enter product name" class="form-control" style="width:250px;"/></td>
					<td><form:errors path="productName" class="invalid-feedback"/></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><label>Quantity needed: </label></td>
					<td><form:input path="quantityNeeded" placeholder="Enter the desired quantity" class="form-control"/></td>
					<td class="errors"><form:errors path="quantityNeeded"/></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><label>Current value: </label></td>
					<td><form:input path="status" placeholder="Enter the current status" class="form-control"/></td>
					<td class="errors"><form:errors path="status"/>
					
						<spring:hasBindErrors name="addProduct">
							<c:forEach items="${errors.globalErrors}" var="globalError">
								<c:if test="${fn:contains(globalError, 'status')}">
									<c:out value="${globalError.defaultMessage}"/>
								</c:if>
							</c:forEach>
						</spring:hasBindErrors>
					
					</td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Confirm!" class="btn btn-success"/></td>
				</tr>
			</table>
			<c:if test="${param.error != null}">
				<br><br>
				<i>ERROR:Incorrect input data!</i>
			</c:if>
		</form:form>
		<br>
		<div align="center"><i>Note: <b>current value</b> needs to be equal or smaller than the <b>quantity needed</b>.</i></div>
		
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
</body>
</html>