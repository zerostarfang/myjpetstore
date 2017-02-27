<%@ include file="../commons/IncludeTop.jsp"%>

<div id="Catalog"><s:form  action="register" method="post"  theme="simple" >

	<h3>User Information</h3>

	<table>
		<tr>
			<td>User ID:</td>
			<td><input type="text" name="account.username" id="userName"/></td>
			<td><span id="userNameExist"></span><font color="red">
				 <s:fielderror>
					<s:param>length.error</s:param>
				</s:fielderror> 
			</font></td>
			  
		</tr>
		<tr>
			<td>New password:</td>
			<td><input type="password" name="account.password" id="password"/></td>
			
			<td></td>
		</tr>
		<tr>
			<td>Repeat password:</td>
			<td><input type="password" name="repeatedPassword" id="passWordAgain"/></td><td><span id="passAgain"></span></td>
          <s:fielderror cssStyle="color: red"></s:fielderror>
          
		</tr>
	</table>
	<script type="text/javascript">
 $(document).ready(function(){
	
<%--	  用于检测用户名是否存在--%>
	  var userName=$("#userName");
	  
	  var exist;  
<%--	  此全局变量用于后续的表单提交--%>
	  userName.focus();
	  userName.blur(function(){	  
		  var userNameValue=document.getElementById("userName").value;
		
		 if(userNameValue.length>0)
			 {
		  $.post("userExist",
				  {name:userNameValue },
				   function(data){
					  
					  var jQueryObject = $(data);
					    //获取message节点对象
					    var message = jQueryObject.find("percent")[0].firstChild.data;
					    
					    //获取文本内容
					    
					  
				     if(message=='0')
				    	 {

				    	   var strHTML="<font color=\"red\">it's not ok </font>";
				    	   document.getElementById("userNameExist").innerHTML=strHTML;
				    	 }
				     else 
				    	 {
				    	 
				    	 var strHTML="<font color=\"green\">it's ok</font>";
				    	 document.getElementById("userNameExist").innerHTML=strHTML;
				    	 }
				   });}
		 else
			 {
			 var strHTML="<font color=\"red\">can't be null </font>";
	    	   document.getElementById("userNameExist").innerHTML=strHTML;
			 }
		  
	  });
	
<%--	  密码验证--%>
     $("#passWordAgain").blur(function(){
    	 if(document.getElementById("password").value==document.getElementById("passWordAgain").value)
    		 {
    		 var strHTML="<font color=\"green\">ok </font>";
	    	   document.getElementById("passAgain").innerHTML=strHTML;
    		 }
    	 else
    		 {
    		 var strHTML="<font color=\"red\">wrong </font>";
	    	   document.getElementById("passAgain").innerHTML=strHTML;
    		 }
    	 
     });
 });
     </script>
	

	<%@ include file="IncludeAccountFields.jsp"%>

	<input type="submit" name="newAccount" value="Save Account Information" />

</s:form></div>

<%@ include file="../commons/IncludeBottom.jsp"%>