<nav role="navigation" class="navbar navbar-default">
		<div onclick="activeNavBtn">
			<a href="https://github.com/MarcinNieweglowski/" class="navbar-brand">GitHub Account</a>
		</div>
		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="naviButton" onclick="activeNavBtn(this)"><a href="${pageContext.request.contextPath}/main">Home</a></li>
				<li class="naviButton" onclick="activeNavBtn(this)"><a href="${pageContext.request.contextPath}/showList">Show all products</a></li>
				<li class="naviButton" onclick="activeNavBtn(this)"><a href="${pageContext.request.contextPath}/productForm">Add product</a></li>
				<li class="naviButton" onclick="activeNavBtn(this)"><a href="${pageContext.request.contextPath}/buyList">Show buy-list</a></li>
				<li class="naviButton"><a href="${pageContext.request.contextPath}/searchProduct">Search</a></li>
<!-- 				<li><span>Search:</span> -->
					
<!-- 					<form:form modelAttribute="requestProductName" action="searchResult" method="POST"> -->
<!-- 						<input type="text" placeholder="Enter product name"> -->
<!-- 						<button type="submit" value="Search!">Search!</button> -->
<!-- 					</form:form> -->
					
<!-- 				</li> -->
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a><span id="theTime"></span></a></li>
				<li id="logoutBtn"><a href="/logout">Logout</a></li>
			</ul>
		</div>
	</nav>