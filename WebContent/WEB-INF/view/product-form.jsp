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
	<link href="<c:url value="/resources/form-validation.css" />" rel="stylesheet">
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
 	<spring:url value="/resources/form-validation.js" var="formJS" />
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

	<div class="containter regist">
		<h2 class="header-info"><i>Adding a new product to the database</i></h2>
		<br>
		<div align="center">
		<form:form modelAttribute="addProduct" action="confirmProduct" method="POST" id="registration">
			<form:hidden path="id" />
			
			<label for="productName" class="inputAreaWidth">
				<span>Product name:</span>
				<form:input path="productName" placeholder="Enter product name" id="productName" class="form-control" />
				<ul class="input-requirements">
					<li>Min 2 chars (without leading & trailing whitespace)</li>
					<li>Must only contain letters / digits</li>
				</ul>
			</label>
			
			<br><br>
			
			<label for="quantityNeeded" class="inputAreaWidth">
				<span>Quantity needed:</span>
				<form:input path="quantityNeeded" placeholder="Enter the desired quantity" id="quantityNeeded" class="form-control" />
				<ul class="input-requirements">
					<li>Must be a digit and at least 1</li>
				</ul>
			</label>
			
			<br><br>
			
			<label for="status" class="inputAreaWidth">
				<span>Current status:</span>
				<form:input path="status" placeholder="Enter the current status" id="status" class="form-control" />
				<ul class="input-requirements">
					<li>Must be a digit and at least 0</li>
					<li>Must be equal or less than the quantity needed</li>
				</ul>
			</label>
			<br>
			
			<c:if test="${not empty isInvalidName}">
				<div align="center"><i><b>Error : ${isInvalidName}</b></i></div>
			</c:if>
			
			<c:if test="${formerrors ne null}">
				<div align="center"><i><b>Error : Correct the input field(s)!</b></i></div>
			</c:if>
			
			<input type="submit" value="Confirm!" class="btn btn-success"/>
			</form:form>
		</div>
	</div>
	
	<script src="${formJS}" type="text/javascript"></script>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
</body>
</html>