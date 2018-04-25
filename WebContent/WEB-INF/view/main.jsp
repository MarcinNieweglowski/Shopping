<%@ include file="common/header.jsp" %>
<%@ include file="common/navbar.jsp" %>
	
	<h2 class="centerDiv">Welcome User</h2>
	<div class="desc">
		<h6><i>Details below</i></h6>
		<br>
		<div>
			<ul>
				<li class="centerList">Visit <u><a href="${pageContext.request.contextPath}/showList">Show all products</a></u> to view the complete list of all products that are in the database, edit the given product or remove it completely.</li>
				<li class="centerList">Click <u><a href="${pageContext.request.contextPath}/productForm">Add product</a></u> to create a new product instance in the database.</li>
				<li class="centerList">To view items to buy visit <u><a href="${pageContext.request.contextPath}/buyList">Show buy-list</a></u>.</li>
				<li class="centerList">Search for a specific product - <u><a href="${pageContext.request.contextPath}/searchProduct">Search</a></u>.</li>
			</ul>
		</div>
		<br>
		<p id="navitip"><i><b>Use the navigation bar at the top.</b></i></p>
		<br>
	</div>
	
	<%@ include file="common/footer.jsp" %>