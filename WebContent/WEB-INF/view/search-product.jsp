<%@ include file="common/header.jsp" %>
<%@ include file="common/navbar.jsp" %>

<div class="container maxWidth centerDiv">
	<h2>Search:</h2>
	<hr>
		<form:form modelAttribute="requestProductName" action="searchResult" method="POST">
			<form:input path="productName" placeholder="Enter product name" class="form-control centerDiv"/>
			<br>
			<input type="submit" value="Search" class="btn btn-success"/>
		</form:form>
</div>

<%@ include file="common/footer.jsp" %>