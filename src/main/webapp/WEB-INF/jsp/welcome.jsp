<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	var count = 1;
	 $('#but_add').click(function(){
	 
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

input[type=text], select, textarea {
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
}

input[type=submit]:hover {
  background-color: #45a049;
}

input[type=button] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-top: 6px;
  margin-bottom: 16px;
  margin-left: 20px;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
</head>
<body>

<h3>Contact Form</h3>

<div class="container">
  <form method="post" action="save">
  
  	<div class="details">
	    <label for="firstName">First Name</label>
	    <input type="text" id="firstName" name="firstName" placeholder="Your name..">
	
	    <label for="lastName">Last Name</label>
	    <input type="text" id="lastName" name="lastName" placeholder="Your last name..">
    </div>

	<input type='button' id='but_add' value='Add new'>

    <input type="submit" value="Submit">
  </form>
</div>

</body>
</html>
