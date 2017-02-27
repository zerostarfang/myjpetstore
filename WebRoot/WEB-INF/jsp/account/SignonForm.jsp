<%@ include file="../commons/IncludeTop.jsp"%>

<div id="Catalog"><s:form action="login" method="post" theme="simple" >
<s:text name="logintitle"/>
 <table align="center">
 
 <tr>
	<td><s:text name="username1"/></td><td><s:textfield name="username" /></td>
</tr>
<tr>
	<td><s:text name="password1"/></td><td><s:password name="password" /></td>
</tr>	
<tr><td><s:text name="clickMe"/></td><td align="center"><img src="rand.action" onclick="changeValidateCode(this)"/></td></tr>
<tr>
<td><s:text name="yanzheng1"/></td><td><s:textfield name="yanzheng" /></td>
</tr>
<tr>
	<td align="right"><s:submit value="%{getText('login')}"/></td><td></td>
</tr>	
    </table>
     
     <br/>
    <font color="red"><s:property value="#request.toCarError"/> <s:property value="#request.error"/></font> 
</s:form>



<s:text name="loginleft"/>
 <a href="toRegister"><s:text name="loginright"/>  </a></div>

<%@ include file="../commons/IncludeBottom.jsp"%>

