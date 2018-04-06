<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<title>Product Database</title>
	<link href="<c:url value="/resources/main.css" />" rel="stylesheet">
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<spring:url value="/resources/main.js" var="mainJS" />
	<style>
		.differentColor {
			color: red;
		}
	</style>
</head>

<body>
	<nav role="navigation" class="navbar navbar-default">
		<div class="">
			<a href="${pageContext.request.contextPath}/main" class="navbar-brand"><i><b>Product App</b></i></a>
		</div>
		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="${pageContext.request.contextPath}/main">Home</a></li>
				<li><a href="${pageContext.request.contextPath}/showList">Show all products</a></li>
				<li><a href="${pageContext.request.contextPath}/productForm">Add product</a></li>
				<li><a href="${pageContext.request.contextPath}/buyList">Show buy-list</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/logout">Logout</a></li>
			</ul>
		</div>
	</nav>
	<h2 align="center">Welcome User</h2>
	<div align="center">
		<h6><i>Hover to see more details</i></h6>
		<div class="desc" style="width:600px">
			<ul>
				<li>Visit <u><a href="${pageContext.request.contextPath}/showList">Show all products</a></u> to view the complete list of all products that are in the database, edit the given product or remove it completely.</li>
				<li>Click <u><a href="${pageContext.request.contextPath}/productForm">Add product</a></u> to create a new product instance in the database.</li>
				<li>To view items to buy visit <u><a href="${pageContext.request.contextPath}/buyList">Show buy-list</a></u>.</li>
			</ul>
		</div>
	</div>
	<button id="buttonAl">CLICK FOR ALERT!</button>
	
	<script src="${mainJS}" type="text/javascript" ></script>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>

</html>