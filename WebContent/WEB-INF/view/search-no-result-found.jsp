<%@ include file="common/header.jsp" %>
<%@ include file="common/navbar.jsp" %>

<div class="container centerDiv">
	<h3>No result found for <b>${requestProductName.productName}</b></h3>
	<h3><a class="btn btn-info" href="${pageContext.request.contextPath}/productForm">Add a new product?</a>
	<a class="btn btn-info" href="${pageContext.request.contextPath}/searchProduct">Search again</a></h3>
</div>
	
<%@ include file="common/footer.jsp" %>
