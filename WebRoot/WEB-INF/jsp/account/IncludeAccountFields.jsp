<h3>Account Information</h3>

<table>
	<tr>
		<td>First name:</td>
		<td><input type="text" name="account.firstName" value="${accountBean.firstName} " id="firstName"/>
		</td>
	</tr>
	<tr>
		<td>Last name:</td>
		<td><input type="text" name="account.lastName" value="${accountBean.lastName}"/>
		</td>
	</tr>
	<tr>
		<td>Email:</td>
		<td><input type="text" name="account.email" value="${accountBean.email}"/>
		</td>
	</tr>
	<tr>
		<td>Phone:</td>
		<td><input type="text" name="account.phone" value="${accountBean.phone}"/></td>
	</tr>
	<tr>
		<td>Address 1:</td>
		<td><input type="text" name="account.address1" value="${accountBean.address1}"/></td>
	</tr>
	<tr>
		<td>Address 2:</td>
		<td><input type="text" name="account.address2" value="${accountBean.address2}"/></td>
	</tr>
	<tr>
		<td>City:</td>
		<td><input type="text" name="account.city" value="${accountBean.city}"/></td>
	</tr>
	<tr>
		<td>State:</td>
		<td><input type="text" name="account.state" value="${accountBean.state}"/></td>
	</tr>
	<tr>
		<td>Zip:</td>
		<td><input type="text" name="account.zip" value="${accountBean.zip}"/></td>
	</tr>
	<tr>
		<td>Country:</td>
		<td><input type="text" name="account.country" value="${accountBean.country}"/></td>
	</tr>
	<tr>
		<td>Birthday:</td>
		<td><input type="text" name="birthday" value="yyyy/MM/dd"/> </td>
	</tr>
</table>

<h3>Profile Information</h3>

<table>
	<tr>
		<td>Language Preference:</td>
		<td>
		<select name="account.languagePreference">
		    <option>${accountBean.languagePreference}</option>
		    <option>chinese</option>
<%--			<option collection="${actionBean.languages}" />--%>
		</select></td>
	</tr>
	<tr>
		<td>Favourite Category:</td>
		<td><select name="account.favouriteCategoryId">
		    <option>${accountBean.favouriteCategoryId}</option>
		    <option>FISH</option>
		    <option>BIRDS</option>
		    <option>CATS</option>
		    <option>DOGS</option>
		    <option>REPTILES</option>
<%--			<stripes:options-collection collection="${actionBean.categories}" />--%>
		</select></td>
	</tr>
	<tr>
		<td>Enable MyList</td>
		<td><input type="checkbox" name="account.listOption" checked="checked" /></td>
	</tr>
	<tr>
		<td>Enable MyBanner</td>
		<td><input type="checkbox" name="account.bannerOption"  checked="checked"/></td>
	</tr>

</table>
