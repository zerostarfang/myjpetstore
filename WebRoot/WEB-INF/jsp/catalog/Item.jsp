<%@ include file="../commons/IncludeTop.jsp"%>

<div id="BackLink">
	<s:a href="toProduct?productId=%{#session.product.productId} ">Return
		to <s:property value="#session.product.productId"/></s:a>
</div>

<div id="Catalog">

	<table>
		<tr>
			<td>${sessionScope.product.description}</td>
		</tr>
		<tr>
			<td>
				<b> <s:property value="#session.item.itemId"/> </b>
			</td>
		</tr>
		<tr>
			<td>
				<b>
					<font size="4"> 
					<s:property value="#session.item.attribute1 "/>
					<s:property value="#session.item.attribute2 "/>
					<s:property value="#session.item.attribute3 "/>
					<s:property value="#session.item.attribute4 "/>
					<s:property value="#session.item.attribute5 "/>
                    <s:property value="#session.product.name "/> 
					</font>
				</b>
			</td>
		</tr>
		<tr>
			<td>  <s:property value="#session.product.name "/>   </td>
		</tr>
		<tr>
			<td>
				<s:if test="#session.item.quantity <= 0 ">
        			Back ordered.
      			</s:if> 
      			<s:if test="#session.item.quantity > 0 ">
      				  <s:property value="#session.item.quantity  "/>  in stock.
	  			</s:if>
			</td>
		</tr>
		<tr>
			<td>
				 session.item.listPrice 
			</td>
		</tr>

		<tr>
			<td>
				<s:a class="Button" href="addToCar?workingItemId=%{#session.item.itemId}">Add to Cart</s:a>
			</td>
		</tr>
	</table>

</div>

<%@ include file="../commons/IncludeBottom.jsp"%>



