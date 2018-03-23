<!DOCTYPE html>
<html>

<head>
	<title>Product Database</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
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
	<h2 align="center">Welcome</h2>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>

</html>