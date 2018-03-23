<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List of all products</title>
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
				<li><a href="${pageContext.request.contextPath}/productForm">Add product</a></li>
				<li class="active"><a href="${pageContext.request.contextPath}/buyList">Show buy-list</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/logout">Logout</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<h2>Showing the list of items to buy</h2>
		<hr>
		<div class="container">
			<table class="table table-striped table-hover">
				<tr>
					<th>Product name</th>
					<th>To buy</th>
				</tr>
				<c:forEach var="tempProduct" items="${productToBuy}">
<%-- 					<c:url var="setMaxStatusLink" value="/setMaxVal"> --%>
<%-- 						<c:param name="setMaxStatus" value="${tempProduct.id}"/> --%>
<%-- 					</c:url> --%>
					<tr>
						<td>${tempProduct.productName}</td>
						<td>${tempProduct.toBuyValue}</td>
<%-- 						<td><a class="btn btn-success" href="${setMaxStatusLink}">Max</a></td> --%>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>