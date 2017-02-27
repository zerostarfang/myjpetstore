<%@ include file="../commons/IncludeTop.jsp"%>

<div id="Catalog"><form action="doChange" method="post">

	<table>
		<tr>
			<th colspan=2>Shipping Address</th>
		</tr>

		<tr>
			<td>First name:</td>
			<td><input type="text" name="order.billToFirstName" value="${sessionScope.order.billToFirstName }" /></td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td><input type="text" name="order.billToLastName" value="${sessionScope.order.billToLastName}"/></td>
		</tr>
		<tr>
			<td>Address 1:</td>
			<td><input type="text" size="40" name="order.billAddress1" value="${sessionScope.order.billAddress1}"/></td>
		</tr>
		<tr>
			<td>Address 2:</td>
			<td><input type="text" size="40" name="order.billAddress2" value="${sessionScope.order.billAddress2}"/></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><input type="text" name="order.billCity" value="${sessionScope.order.billCity}"/></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><input type="text" size="4" name="order.billState" value="${sessionScope.order.billState}"/></td>
		</tr>
		<tr>
			<td>Zip:</td>
			<td><input type="text" size="10" name="order.billZip" value="${sessionScope.order.billZip}"/></td>
		</tr>
		<tr>
			<td>Country:</td>
			<td><input type="text" size="15" name="order.billCountry" value="${sessionScope.order.billCountry}"/></td>
		</tr>


	</table>

	<input type="submit" name="newOrder" value="Continue" />

</form></div>

<%@ include file="../commons/IncludeBottom.jsp"%>