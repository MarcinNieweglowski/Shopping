<%@ include file="common/header.jsp" %>
<%@ include file="common/navbar.jsp" %>
	
	<div class="container">
		<h2>Showing the list of all products in the database</h2>
		<hr>
		<table class="table table-striped table-hover table-bordered">
			<tr>
				<th>Product name</th>
				<th>Quantity needed</th>
				<th>Current status</th>
				<th>Action</th>
			</tr>
			<c:forEach var="tempProduct" items="${products}">
				<c:url var="updateLink" value="/updateProduct">
					<c:param name="updateId" value="${tempProduct.id}"/>
				</c:url>
				<c:url var="deleteLink" value="/deleteProduct">
					<c:param name="deleteId" value="${tempProduct.id}"/>
				</c:url>
				<tr>
					<td>${tempProduct.productName}</td>
					<td>${tempProduct.quantityNeeded}</td>
					<td>${tempProduct.status}</td>
					<td><a class="btn btn-success" href="${updateLink}">Update</a> <a class="btn btn-danger" href="${deleteLink}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<%@ include file="common/footer.jsp" %>