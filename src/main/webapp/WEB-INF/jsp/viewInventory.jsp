<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

tr:nth-child(even){background-color: #f2f2f2}

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
     <th>Company</th>
     <th>Model</th>
     <th>HSN</th>
     <th>Commodity Type</th>
     <th>Number</th>
    </tr>
    <c:forEach var="product" items="${inventoryList}">
     <tr>
      <td>${product.company}</td>
      <td>${product.model}</td>
      <td>${product.hsn}</td>
      <td>${product.commodityType}</td>
      <td>${product.number}</td>
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
