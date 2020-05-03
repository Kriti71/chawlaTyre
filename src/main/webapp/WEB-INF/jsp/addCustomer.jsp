<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], input[type=number] {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin: 10px;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
</head>
<body>

<div class="container">
  <form method="post" action="saveCustomer">
    <label for="customerName">Customer Name</label>
    <input type="text" name="name" placeholder="Customer name.." required>

    <label for="phoneNumber">Phone Number</label>
    <input type="number" id="phoneNumber" name="phoneNumber" placeholder="Customer Phone Number.." required>

    <label for="vehicleNumber">Vehicle Number</label>
    <input type="text" name="vehicleNumber" placeholder="Vehicle Number..">
    
    <label for="address">Address</label>
    <input type="text" name="address" placeholder="Customer Address.." required>
    
    <label for="bank">Bank</label>
    <input type="text" name="bank" placeholder="Customer Bank..">
    
    <label for="gstNumber">GST Number</label>
    <input type="text" name="gstNumber" placeholder="Customer GST Number..">

    <input type="submit" value="Submit">
    
  </form>
  
  <form action="/welcome" method="get">
		<input type="submit" value="Home">
  </form>
</div>

</body>
</html>
