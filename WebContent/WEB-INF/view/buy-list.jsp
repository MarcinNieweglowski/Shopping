<%@ include file="common/header.jsp" %>
<%@ include file="common/navbar.jsp" %>

	<div class="container">
		<h2>Showing the list of items to buy</h2>
		<hr>
		<table class="table table-striped table-hover table-bordered">
			<tr>
				<th>Product name</th>
				<th>To buy</th>
				<th>Action</th>
			</tr>
			<c:forEach var="tempProduct" items="${productToBuy}">
				<c:url var="setMaxStatusLink" value="/setMaxVal">
					<c:param name="setMaxStatus" value="${tempProduct.id}"/>
				</c:url>
				<tr>
					<td>${tempProduct.productName}</td>
					<td>${tempProduct.toBuyValue}</td>
					<td><a class="btn btn-success" href="${setMaxStatusLink}">Max</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<%@ include file="common/footer.jsp" %>