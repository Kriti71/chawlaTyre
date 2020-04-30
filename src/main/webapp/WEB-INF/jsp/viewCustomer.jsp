<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: #4CAF50;
	color: white;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin: 20px;
}
</style>
</head>
<body>

	<h2>Customer Details</h2>

	<table>
		<tr>
			<th>Name</th>
			<th>Phone Number</th>
			<th>Vehicle Number</th>
			<th>Address</th>
			<th>Bank</th>
			<th>GST Number</th>
		</tr>
		<c:forEach var="cust" items="${customers}">
			<tr>
				<td>${cust.name}</td>
				<td>${cust.phoneNumber}</td>
				<td>${cust.vehicleNumber}</td>
				<td>${cust.address}</td>
				<td>${cust.bank}</td>
				<td>${cust.gstNumber}</td>
			</tr>
		</c:forEach>
	</table>

	<div>
		<form action="/welcome" method="get">
			<input type="submit" value="Home">
		</form>
	</div>





</body>
</html>
