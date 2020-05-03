<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text] {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=number] {
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
  <form method="post" action="saveProduct">
    <label for="company">Company</label>
    <input type="text" name="company" placeholder="Company" required>

    <label for="model">Model</label>
    <input type="text" name="model" placeholder="Model.." required>

    <label for="hsn">HSN</label>
    <input type="text" name="hsn" placeholder="HSN..">
    
    <label for="commodityType">Commodity Type</label>
    <input type="text" name="commodityType" placeholder="Commodity Type.." required>
    
    <label for="number">Number</label>
    <input type="text" name="number" placeholder="Number..">

    <input type="submit" value="Submit">
    
  </form>
  <form action="/welcome" method="get">
		<input type="submit" value="Home">
  </form>
</div>

</body>
</html>
