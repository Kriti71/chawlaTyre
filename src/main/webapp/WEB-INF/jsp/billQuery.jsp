<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		var count = 1;
		$('#but_add').click(function() {

			// Create clone of <div class='details'>
			var newel = $('.details:last').clone(true);
			$(newel).attr('id', ++count);

			// Add after last <div class='details'>
			$(newel).insertAfter(".details:last");
		});

	});
</script>

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

input[type=txt]{
  padding: 5px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=submit], input[type=button] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin: 5px;
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
  <form method="post" action="generatePdf">
  
	 <label for="customerName">Customer Name</label>
	 <input type="text" name="customerName" placeholder="Customer name.." required>
	
	 <label for="customerAddress">Customer Address</label>
	 <input type="text" name="customerAddress" placeholder="Customer Address.." required>
	 
	 <label for="phoneNumber">Customer Phone Number</label>
	 <input type="number" name="phoneNumber" placeholder="Customer Phone Number.." required>
	 
	 <label for="vehicleNumber">Customer Vehicle Number</label>
	 <input type="text" name="vehicleNumber" placeholder="Customer Vehicle Number..">
	 
	 <label for="gstNumber">Customer GST Number</label>
	 <input type="text" name="gstNumber" placeholder="Customer GST Number..">
	 
	 <div class="details">   
	 	<div>
		 	<label for="type">Type</label>
		    <input type="txt" name="bill.type" value="Tyre">
		    
		    <label for="hsn">HSN</label>
		    <input type="txt" name="bill.hsn" value="4011,4012,4013">
		 
		    <label for="sellingPrice">Selling Price</label>
		    <input type="txt" name="bill.sellingPrice" placeholder="Selling Price..">
		    
		    <label for="quantity">Quantity</label>
		    <input type="txt" name="bill.quantity" placeholder="Quantity..">
		    
		    <label for="description">Description</label>
		    <input type="txt" name="bill.description" placeholder="Description..">
	    </div>
	</div>
	<input type='button' id='but_add' value='Add new'>
	<input type="submit" value="Submit">
			
		</form>
		<form action="/welcome" method="get">
			<input type="submit" value="Home">
		</form>
	</div>

</body>
</html>
