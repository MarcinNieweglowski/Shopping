<%@ include file="common/header.jsp" %>
<%@ include file="common/navbar.jsp" %>

<div class="container">
	<h2>Search result for input: <span style="color:red;">${requestProductName.productName}</span></h2>
	<hr>
	
	<table class="table table-striped table-hover table-bordered">
		<tr>
			<th>Product name</th>
			<th>Quantity needed</th>
			<th>Current status</th>
			<th>Action</th>
		</tr>
		
		<c:url var="updateLink" value="/updateProduct">
			<c:param name="updateId" value="${requestProductName.id}"/>
		</c:url>
		<c:url var="deleteLink" value="/deleteProduct">
			<c:param name="deleteId" value="${requestProductName.id}"/>
		</c:url>
		
		<tr>
			<td>
				${requestProductName.productName}
			</td>
			<td>
				${requestProductName.quantityNeeded}
			</td>
			<td>
				${requestProductName.status}
			</td>
			<td>
				<a class="btn btn-success" href="${updateLink}">Update</a> <a class="btn btn-danger" href="${deleteLink}">Delete</a>
			</td>
		</tr>
	</table>
</div>
	
<%@ include file="common/footer.jsp" %>