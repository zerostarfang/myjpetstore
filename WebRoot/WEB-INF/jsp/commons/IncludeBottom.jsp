</div>


<div id="Footer">

<div id="PoweredBy">&nbsp<a href="www.mybatis.org">www.mybatis.org</a>
</div>

<div id="Banner"><c:if test="${sessionScope.accountBean != null }">
	<c:if test="${sessionScope.authenticated}">
		<c:if test="${sessionScope.accountBean.bannerOption}">
<%--          ${sessionScope.accountBean.bannerName}--%>
        </c:if>
	</c:if>
</c:if></div>

</div>

</body>
</html>