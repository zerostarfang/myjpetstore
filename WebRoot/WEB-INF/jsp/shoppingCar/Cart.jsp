<%@ include file="../commons/IncludeTop.jsp"%>

<div id="BackLink"><a href="main">
	Return to Main Menu</a></div>

<div id="Catalog">

<div id="Cart">

<h2>Shopping Cart</h2>
<form action="updateCartQuantities" method="post">
	<table>
		<tr>
			<th><b>Item ID</b></th>
			<th><b>Product ID</b></th>
			<th><b>Description</b></th>
			<th><b>In Stock?</b></th>
			<th><b>Quantity</b></th>
			<th><b>List Price</b></th>
			<th><b>Total Cost</b></th>
			<th>&nbsp;</th>
		</tr>

		<c:if test="${sessionScope.cart.numberOfItems == 0 || sessionScope.cart==null}">
			<tr>
				<td colspan="8"><b>Your cart is empty.</b></td>
			</tr>
		</c:if>
     
		<c:forEach var="cartItem" items="${sessionScope.cart.cartItems}">
			<tr>
				<td><a href="item?itemId=${cartItem.item.itemId}">
				${cartItem.item.itemId}
			  </a></td>
				<td>${cartItem.item.product.productId}</td>
				<td>${cartItem.item.attribute1} ${cartItem.item.attribute2}
				${cartItem.item.attribute3} ${cartItem.item.attribute4}
				${cartItem.item.attribute5} ${cartItem.item.product.name}</td>
				<td>${cartItem.inStock}</td>
				<td><input type="text" size="3" name="quantity"
					value="${cartItem.quantity}" /></td>
				<td><input type="text" disabled="disabled" value="${cartItem.item.listPrice}"/>
					</td>
				<td><input type="text" disabled="disabled" value="${cartItem.total}"/></td>
				<td><a href="removeCar?itemId=${cartItem.item.itemId}"> 
            	Remove
            </a></td>
			</tr>
		</c:forEach>
	
		<tr>
			<td colspan="7">Sub Total: <input type="text" disabled="disabled" value="${sessionScope.cart.subTotal}" />
			 
			<input type="submit" name="updateCartQuantities" value="Update Cart" /></td>
			<td>&nbsp;</td>
		</tr>
		
	</table>

</form> <c:if test="${sessionScope.cart.numberOfItems > 0}">
	<a href="toNewOrder" class="Button">
      	Proceed to Checkout
      </a>
</c:if></div>

<div id="MyList">
  <c:if test="${sessionScope.accountBean != null}">
	<c:if test="${!sessionScope.authenticated}">
	  <c:if test="${!empty sessionScope.accountBean.listOption}">
	    <%@ include file="IncludeMyList.jsp"%>
      </c:if>
	</c:if>
  </c:if>
</div>

<div id="Separator">&nbsp;</div>
</div>

<%@ include file="../commons/IncludeBottom.jsp"%>