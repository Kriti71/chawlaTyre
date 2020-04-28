<!DOCTYPE html>
<html>
<head>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
  border-right:1px solid #bbb;
}

li:last-child {
  border-right: none;
}

li a,button {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
}

button{
  background-color: #333;
}


* {
  box-sizing: border-box;
}

.column {
  float: left;
  width: 40%;
  padding: 10px;
}

body {
  background-image: url('${pageContext.request.contextPath}/resources/images/bg2.png');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}

</style>
</head>
<body>

<ul>
  <li><a class="active" href="#home">Home</a></li>
  <li><form action="/customer" method="get"><button type="submit">Customer</button></form></li>
  <li><form action="/inventory" method="get"><button type="submit">Inventory</button></form></li>
  <li><form action="/contact" method="get"><button type="submit">Contact</button></form></li>
  <li style="float:right"><a href="#about">About</a></li>
</ul>

<div class="row1">
  <div class="column">
    <img src="${pageContext.request.contextPath}/resources/images/jk.png" alt="Birla" style="width:100%">
  </div>
  <div class="column">
    <img src="${pageContext.request.contextPath}/resources/images/apollo.png" alt="birla" style="width:100%">
  </div>
  
</div>

  <div  class="row1">
	  <div class="column">
	    <img src="${pageContext.request.contextPath}/resources/images/birla.png" alt="apollo" style="width:100%">
	  </div>
	  <div class="column">
	    <img src="${pageContext.request.contextPath}/resources/images/tyres.png" alt="apollo" style="width:50%">
	  </div>
  </div>
</div>

</body>
</html>
