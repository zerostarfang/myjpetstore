<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<link rel="StyleSheet" href="css/jpetstore.css" type="text/css" media="screen" />
	
	<meta name="generator"	content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org" />
	<title>JPetStore Demo</title>
	<meta content="text/html; charset=windows-1252" http-equiv="Content-Type" />
	<meta http-equiv="Cache-Control" content="max-age=0" />
	<meta http-equiv="Cache-Control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
	<meta http-equiv="Pragma" content="no-cache" />
	<script type="text/javascript">
var xmlHttp;
var completeDiv;
var inputField;
var nameTable;
var nameTableBody;
function createXMLHttpRequest() {
if (window.ActiveXObject) {
xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
}
else if (window.XMLHttpRequest) {
xmlHttp = new XMLHttpRequest();
}
}
function initVars() {
inputField = $("#names");
nameTable = document.getElementById("name_table");
completeDiv = document.getElementById("popup1");
nameTableBody = document.getElementById("name_table_body");
}
function findNames() {
	inputField = document.getElementById("names");
	nameTable = document.getElementById("name_table");
	completeDiv = document.getElementById("popup1");
	nameTableBody = document.getElementById("name_table_body");

if (inputField.value.length > 0) {
createXMLHttpRequest();
var url = "autoComplete?name=" + escape(inputField.value);
xmlHttp.open("GET", url, true);
xmlHttp.onreadystatechange = callback;
xmlHttp.send(null);
} else {
clearNames();
}
}
function callback() {
if (xmlHttp.readyState == 4) {
if (xmlHttp.status == 200) {
var name =
xmlHttp.responseXML
.getElementsByTagName("name")[0].firstChild.data;
setNames(xmlHttp.responseXML.getElementsByTagName("name"));
} else if (xmlHttp.status == 204){
clearNames();
}
}
}
function setNames(the_names) {
clearNames();
var size = the_names.length;
setOffsets1();
var row, cell, txtNode;
for (var i = 0; i < size; i++) {
var nextNode = the_names[i].firstChild.data;
row = document.createElement("tr");
cell = document.createElement("td");
cell.onmouseout = function() {this.className='mouseOver';};
cell.onmouseover = function() {this.className='mouseOut';};
cell.setAttribute("bgcolor", "#FFFAFA");
cell.setAttribute("border", "0");
cell.onclick = function() { populateName(this); } ;
txtNode = document.createTextNode(nextNode);
cell.appendChild(txtNode);
row.appendChild(cell);
nameTableBody.appendChild(row);
}
}
function setOffsets1() {
var end = inputField.offsetWidth;
var left = calculateOffsetLeft1(inputField);
var top = calculateOffsetTop1(inputField) + inputField.offsetHeight;

completeDiv.style.border = "black 1px solid";
completeDiv.style.left = left + "px";
completeDiv.style.top = top + "px";
nameTable.style.width = end + "px";
}
function calculateOffsetLeft1(field) {
return calculateOffset1(field, "offsetLeft");
}
function calculateOffsetTop1(field) {
return calculateOffset1(field, "offsetTop");
}
function calculateOffset1(field, attr) {
var offset = 0;
while(field) {
offset += field[attr];
field = field.offsetParent;
}
return offset;
}
function populateName(cell) {
inputField.value = cell.firstChild.nodeValue;
clearNames();
}
function clearNames() {
var ind = nameTableBody.childNodes.length;
for (var i = ind - 1; i >= 0 ; i--) {
nameTableBody.removeChild(nameTableBody.childNodes[i]);
}
completeDiv.style.border = "none";
}
</script>
<script type="text/javascript">  
    function changeValidateCode(obj) {  
           //获取当前的时间作为参数，无具体意义  
        var timenow = new Date().getTime();  
           //每次请求需要一个不同的参数，否则可能会返回同样的验证码  
        //这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。  
        obj.src="rand.action?d="+timenow;  
    }  
</script>
<script type="text/javascript" src="<%=basePath%>/jquery-1.10.2.js"></script></head>
<body>

	<div id="Header">

		<div id="Logo">
			<div id="LogoContent">
				<a href="main"><img src="../images/logo-topbar.gif" /></a>
			</div>
		</div>
        
		<div id="Menu">
			<div id="MenuContent">
				<a href="toCar"><img align="middle" name="img_cart" src="images/cart.gif" /></a>
				<img align="middle" src="images/separator.gif" />
				<c:if test="${sessionScope.accountBean == null}">
					<a href=" toSignonForm"><s:text name="signon"/></a>
				</c:if>
				<c:if test="${sessionScope.accountBean != null}">
					<c:if test="${!sessionScope.authenticated}">
						<a href=" toSignonForm"><s:text name="signon"/></a>
					</c:if>
				</c:if>
				<c:if test="${sessionScope.accountBean != null}">
				<c:if test="${sessionScope.authenticated}">
						<a href=" loginOut"><s:text name="signonOut"/></a>
						<img align="middle" src="images/separator.gif" />
						<a href=" toEditAccount"><s:text name="myAccount"/></a>
				</c:if>
				</c:if>
				<img align="middle" src="images/separator.gif" /> 
				<a href="help.html">?</a>
				<img align="middle" src="images/separator.gif" /> 
					<a href="toSignonForm?request_locale=zh_CN"><s:text name="chinese"/></a>
<%--				<s:url action="main"  id="url0">--%>
<%--				<s:param name="request_locale">zh_CN</s:param>--%>
<%--				</s:url>--%>
<%--				<s:a href="%{url0}">chinese</s:a>--%>

				<img align="middle" src="images/separator.gif" /> 
				<a href="toSignonForm?request_locale=en_US"><s:text name="english"/></a>
<%--				<s:url action="main" id="url1">--%>
<%--				<s:param name="request_locale">en_US</s:param>--%>
<%--				</s:url>--%>
<%--				<s:a href="%{url1}">english</s:a>--%>
			</div>
		</div>

		<div id="Search">
			<div id="SearchContent">
				<form action="search" method="post">
					<input type="text" name="keyword" size="14" id="names" onkeyup="findNames();" />
					<input type="submit" name="searchProducts" value="Search"/>
				</form>
			</div>
		</div>
		<div style="position:absolute;" id="popup1">
       <table id="name_table" bgcolor="#FFFAFA" border="0"
       cellspacing="0" cellpadding="0">
      <tbody id="name_table_body"></tbody>
       </table>
		</div>

		<div id="QuickLinks">
			<a href="toCategory?categoryId=FISH"><img src="images/sm_fish.gif" /></a>
			<img src="  images/separator.gif" />
			<a href="toCategory?categoryId=DOGS"><img src="images/sm_dogs.gif" /></a>
			<img src="  images/separator.gif" />
			<a href="toCategory?categoryId=REPTILES"><img src="images/sm_reptiles.gif" /></a>			
			<img src=" images/separator.gif" />
			<a href="toCategory?categoryId=CATS"><img src="images/sm_cats.gif" /></a>
			<img src=" images/separator.gif" />
			<a href="toCategory?categoryId=BIRDS"><img src="images/sm_birds.gif" /></a>
		</div>

	</div>
      
	<div id="Content">