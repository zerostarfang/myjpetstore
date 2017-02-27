<%@ include file="../commons/IncludeTop.jsp"%>

<div id="Catalog"><form action="editAccount" method="post" id="editAccountForm">

	<h3>User Information</h3>

	<table>
		<tr>
			<td>User ID:</td>
			<td>${accountBean.username}<input type="hidden" name="account.username" value="${accountBean.username}"/></td>
		</tr>
		<tr>
			<td>New password:</td>
			<td><input type="password" name="account.password" value="${accountBean.password}" id="password"/></td>
		</tr>
		<tr>
			<td>Repeat password:</td>
			<td><input type="password" name="repeatedPassword" id="repeatedPassword"/><span id="message"></span></td> 
		</tr>
	</table>
	<%@ include file="IncludeAccountFields.jsp"%>

	<input type="button" name="editAccount" value="Save Account Information" id="submitBtn"/>

</form> <a href="toCar">My Orders</a></div>
<script type="text/javascript">
$(document).ready(function(){
	var flag=true;
	$("#repeatedPassword").blur(function(){
		var repeat=document.getElementById("repeatedPassword").value;
		var pass=document.getElementById("password").value;
		if( repeat!=pass)
			{
			 flag=false;
			 document.getElementById("message").innerHTML="<font color=\"red\">wrong </font>";
			}
		else
			 document.getElementById("message").innerHTML="<font color=\"green\">ok </font>";
		
	});
	
	$("#submitBtn").click(function(){
		if(flag=true && $("#password").val()!="" && $("#firstName").val()!="" )
			{
			   $("#editAccountForm").submit();
			}
		
	});
	
});
</script>

<%@ include file="../commons/IncludeBottom.jsp"%>
