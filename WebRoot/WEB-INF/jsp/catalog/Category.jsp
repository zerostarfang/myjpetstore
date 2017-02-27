<%@ include file="../commons/IncludeTop.jsp"%>

<div id="BackLink">
	<a href="main">Return to Main Menu</a>
</div>

<div id="Catalog">

<%--	<h2>${sessionScope.category.name}</h2>--%>
	<h2><s:property value="#session.category.name"/>   </h2>

	<table>
		<tr>
			<th>Product ID</th>
			<th>Name</th>
		</tr>
		<%--<c:forEach var="product" items="${sessionScope.productList}">
			<tr>
				<td>
					<a href="product?productId=${product.productId}">${product.productId}</a>
				</td>
				<td>${product.name}</td>
			</tr>
		</c:forEach>
	--%>
	   <s:iterator   value="#session.productList" status="rowstatus" id="product">
			<tr>
				<td>
					<s:a href="toProduct?productId=%{#product.productId}"><s:property value="#product.productId"/> </s:a>
				</td>
				<td><s:property value="#product.name"/></td>
			</tr>
		</s:iterator>
	</table>

</div>

<%@ include file="../commons/IncludeBottom.jsp"%>


