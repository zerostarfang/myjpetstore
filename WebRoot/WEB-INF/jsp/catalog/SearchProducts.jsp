<%@ include file="../commons/IncludeTop.jsp"%>

<div id="BackLink"><a href="main">
	Return to Main Menu
</a></div>

<div id="Catalog">

<table>
	<tr>
		<th>&nbsp;</th>
		<th>Product ID</th>
		<th>Name</th>
	</tr>
	 
	<c:forEach var="product" items="${sessionScope.productList}">
		<tr>
			<td>
			<a href="toProduct?productId=${product.productId}">${product.description}</a>
			</td>
			<td>
			 <a href="toProduct?productId=${product.productId}">${product.productId}</a>
			</td>
			<td>${product.name}</td>
		</tr>
	</c:forEach>
	<tr>
		<td></td>
	</tr>

</table>

</div>

<%@ include file="../commons/IncludeBottom.jsp"%>




