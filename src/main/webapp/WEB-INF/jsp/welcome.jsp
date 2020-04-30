<!DOCTYPE html>
<html>
<head>
<style>
button {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
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

.navbar {
	overflow: hidden;
	background-color: #333;
}

.navbar a {
	float: left;
	font-size: 16px;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

.dropdown {
	float: left;
	overflow: hidden;
}

.dropdown .dropbtn {
	font-size: 16px;
	border: none;
	outline: none;
	color: white;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn{
	background-color: yellow;
	color: black;
}

.drop:hover {
	background-color: #20b2aa
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #ddd;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
	background-color: #ddd;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.drop {
	background-color: #ddd;
	font-size: 16px;
	border: none;
	outline: none;
	color: black;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
}

.dropdown:hover .dropdown-content {
	display: block;
}

body {
	background-image:
		url('${pageContext.request.contextPath}/resources/images/bg2.png');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
}
</style>
</head>
<body>

	<div class="navbar">
		<div class="dropdown">
			<form action="/welcome" method="get">
				<button type="submit" class="dropbtn">Home</button>
			</form>
		</div>
		<div class="dropdown">
			<button class="dropbtn">
				Inventory <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<form action="/addProduct" method="get">
					<button type="submit" class="drop">Add</button>
				</form>
				<form action="/viewProduct" method="get">
					<button type="submit" class="drop">View Details</button>
				</form>
			</div>
		</div>
		<div class="dropdown">
			<button class="dropbtn">
				Customer <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<form action="/addCustomer" method="get">
					<button type="submit" class="drop">Add</button>
				</form>
				<form action="/viewCustomer" method="get">
					<button type="submit" class="drop">View Details</button>
				</form>
			</div>
		</div>
		<div class="dropdown">
			<form action="/billQuery" method="get">
				<button type="submit" class="dropbtn">Generate Bill</button>
			</form>
		</div>
		<div class="dropdown">
			<form action="/contact" method="get">
				<button type="submit" class="dropbtn">Contact</button>
			</form>
		</div>
	</div>

	<div class="row1">
		<div class="column">
			<img src="${pageContext.request.contextPath}/resources/images/jk.png"
				alt="Birla" style="width: 100%">
		</div>
		<div class="column">
			<img
				src="${pageContext.request.contextPath}/resources/images/apollo.png"
				alt="birla" style="width: 100%">
		</div>

	</div>

	<div class="row1">
		<div class="column">
			<img
				src="${pageContext.request.contextPath}/resources/images/birla.png"
				alt="apollo" style="width: 100%">
		</div>
		<div class="column">
			<img
				src="${pageContext.request.contextPath}/resources/images/tyres.png"
				alt="apollo" style="width: 50%">
		</div>
	</div>

</body>
</html>
