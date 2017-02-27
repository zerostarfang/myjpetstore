<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head> 
    <title>等待页面</title>
    <s:url includeParams="all" id="temp"/>
    <meta http-equiv="refresh" content="5;url=${temp}"/>
  </head>
  
  <body>
    您的请求正在处理，请稍等。<br>
    如果页面没有自动重新加载，请<s:a href="%{#temp}">单击这里</s:a>
  </body>
</html>
