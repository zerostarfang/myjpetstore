<%@ include file="../commons/IncludeTop.jsp"%>

<div id="Welcome">
<div id="WelcomeContent"><c:if
	  test="${sessionScope.accountBean != null }">
    <c:if test="${sessionScope.authenticated}">
        Welcome ${sessionScope.accountBean.firstName}!
      </c:if>
</c:if></div>
</div>
<script type="text/javascript">
//$(document).ready(function(){

	 var dataTableBody ;
	 var dataTable ;
	 var dataDiv ;
	 var offsetEl;
	 
	 function initVars() {
		 dataTableBody = document.getElementById("courseDataBody");
		 dataTable = document.getElementById("courseData");
		 dataDiv = document.getElementById("popup");
		 }
	 
	    function calculateOffsetTop(field) {
		 return calculateOffset(field, "offsetTop");
		 }
	    
	    function over(element){
			 initVars();
			 offsetEl=element;
		 // var bb=$(this);
		  var val=escape(element.className);
	
		  $.post("showTip", {name:val},
				   function(data){
			     
			     setData(data);	    		    
	   });
		 } 
	    function setData(data) {
	   	 clearData();
	   	 setOffsets();
	   	 var jQueryObject = $(data);
	   	 var name = jQueryObject.find("name")[0].firstChild.data;
	   	 var row;
	   	 var nameData = "name: " +name;
	   	 row = createRow(nameData);
	   	 dataTableBody.appendChild(row);
	   	 }
	   	 
	    function createRow(data) {
			 var row, cell, txtNode;
			 row = document.createElement("tr");
			 cell = document.createElement("td");
			 cell.setAttribute("bgcolor", "#FFFAFA");
			 cell.setAttribute("border", "0");
			 txtNode = document.createTextNode(data);
			 cell.appendChild(txtNode);
			 row.appendChild(cell);
			 return row;
			 }
	    
		 function calculateOffset(field, attr) {
		 var offset = 0;
		 while(field) {
		 offset += field[attr];
		 field = field.offsetParent;
		 }
		 return offset;
		 }
		 
		 function setOffsets() {
			 
			 //var end = offsetEl.offset.left;
			 var end = offsetEl.offsetWidth;
			 var top = calculateOffsetTop(offsetEl);
			 //var top=offsetEl.offset.top;
			
			 dataDiv.style.border = "black 1px solid";
			 dataDiv.style.left = end+ 15 + "px";
			 dataDiv.style.top = top + "px";
			 
			 }
		 
		 

	 

	 
function clearData() {
	  var ind = dataTableBody.childNodes.length;
	  for (var i = ind - 1; i >= 0 ; i--) {
	  dataTableBody.removeChild(dataTableBody.childNodes[i]);
	  }
	  dataDiv.style.border = "none";
	  }
</script>
<div id="Main">
			<div id="Sidebar">
				<div id="SidebarContent">
					<a href="toCategory?categoryId=FISH" name="FISH" class="FISH" onmouseover="over(this)" onmouseout="clearData()"><img src="images/fish_icon.gif" /></a>
					<br/> Saltwater, Freshwater <br/>
					<a href="toCategory?categoryId=DOGS" name="DOGS" class="DOGS" onmouseover="over(this)" onmouseout="clearData()"><img src="images/dogs_icon.gif" /></a>
					<br /> Various Breeds <br />
					<a href="toCategory?categoryId=CATS" name="CATS" class="CATS" onmouseover="over(this)" onmouseout="clearData()"><img src="images/cats_icon.gif" /></a>
					<br /> Various Breeds, Exotic Varieties <br />
					<a href="toCategory?categoryId=REPTILES" name="REPTILES" class="REPTILES" onmouseover="over(this)" onmouseout="clearData()"><img src="images/reptiles_icon.gif" /></a>
					<br /> Lizards, Turtles, Snakes <br />
					<a href="toCategory?categoryId=BIRDS" name="BIRDS" class="BIRDS" onmouseover="over(this)" onmouseout="clearData()"> <img src="images/birds_icon.gif" /></a>
					<br /> Exotic Varieties
				</div>
			</div>

			<div id="MainImage">
				<div id="MainImageContent">
					<map name="estoremap">
						<area alt="Birds" coords="72,2,280,250" href="toCategory?categoryId=BIRDS" shape="RECT"  name="BIRDS" class="BIRDS"  onmouseover="over(this)" onmouseout="clearData()"/>
						<area alt="Fish" coords="2,180,72,250" href="toCategory?categoryId=FISH" shape="RECT" name="FISH" class="FISH" onmouseover="over(this)" onmouseout="clearData()"/>
						<area alt="Dogs" coords="60,250,130,320" href="toCategory?categoryId=DOGS" shape="RECT" name="DOGS" class="DOGS" onmouseover="over(this)" onmouseout="clearData();"/>
						<area alt="Reptiles" coords="140,270,210,340" href="toCategory?categoryId=REPTILES" shape="RECT" name="REPTILES" class="REPTILES" onmouseover="over(this)" onmouseout="clearData()"/>
						<area alt="Cats" coords="225,240,295,310" href="toCategory?categoryId=CATS" shape="RECT" name="CATS" class="CATS" onmouseover="over(this)" onmouseout="clearData()"/>
						<area alt="Birds" coords="280,180,350,250" href="toCategory?categoryId=BIRDS" shape="RECT" name="BIRDS" class="BIRDS" onmouseover="over(this)" onmouseout="clearData()"/>
					</map>
					<img height="355" src="images/splash.gif" align="middle" usemap="#estoremap" width="350" />
				</div>
			</div>
			
<div id="Separator">&nbsp;</div>
           <div style="position:absolute;" id="popup">
			<table id="courseData" bgcolor="#FFFAFA" border="0" cellspacing="2" cellpadding="2">
            <tbody id="courseDataBody"></tbody>
            </table>
             </div>
</div>

<%@ include file="../commons/IncludeBottom.jsp"%>

