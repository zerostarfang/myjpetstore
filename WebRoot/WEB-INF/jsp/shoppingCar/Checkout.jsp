<%@ include file="../commons/IncludeTop.jsp"%>

<div id="BackLink"><a href="toCar">
	Return to Shopping Cart</a></div>

<div id="Catalog">

<table>
	<tr>
		<td>
		<h2>Checkout Summary</h2>

		<table>

			<tr>
				<td><b>Item ID</b></td>
				<td><b>Product ID</b></td>
				<td><b>Description</b></td>
				<td><b>In Stock?</b></td>
				<td><b>Quantity</b></td>
				<td><b>List Price</b></td>
				<td><b>Total Cost</b></td>
			</tr>

			<c:forEach var="cartItem" items="${sessionScope.cart.cartItems}">
				<tr>
					<td><a href="item?itemId=${cartItem.item.itemId}">${cartItem.item.itemId}></a></td>
					<td>${cartItem.item.product.productId}</td>
					<td>${cartItem.item.attribute1} ${cartItem.item.attribute2}
					${cartItem.item.attribute3} ${cartItem.item.attribute4}
					${cartItem.item.attribute5} ${cartItem.item.product.name}</td>
					<td>${cartItem.inStock}</td>
					<td>${cartItem.quantity}</td>
					<td>${cartItem.item.listPrice}</td>
					<td>${cartItem.total}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7">Sub Total:${sessionScope.cart.subTotal}</td>
			</tr>
		</table>

		<td>&nbsp;</td>

	</tr>
</table>

</div>

<%@ include file="../commons/IncludeBottom.jsp"%>