<%@ include file="common/header.jsp" %>
<%@ include file="common/navbar.jsp" %>

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
	
	<%@ include file="common/footer.jsp" %>