<c:if test="${!empty sessionScope.Mylist}">
	<p>Pet Favorites <br />
	Shop for more of your favorite pets here.</p>
	<ul>
		<c:forEach var="product" items="${sessionScope.Mylist}">
			<li><a href="product?productId=${product.productId}">		
			${product.name}
		</a> (${product.productId})</li>
		</c:forEach>
	</ul>

</c:if>
