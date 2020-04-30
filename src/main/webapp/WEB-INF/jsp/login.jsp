<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}


input[type=text], input[type=password] {
  width: 80%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 20px 0;
  border: none;
  cursor: pointer;
}

button:hover {
  opacity: 0.8;
}


.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

.submitbtn {
  padding: 10px 18px;
}


.container {
  padding: 16px;
  display: table;
  margin: 0 auto;
}

span.psw {
  float: right;
  padding-top: 16px;
}


body {
  background-image: url('${pageContext.request.contextPath}/resources/images/bg1.png');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}
</style>
</head>
<body>



<form action="/login" method="post">
  <h2 style="text-align: center">Login Form</h2>
  <div class="imgcontainer">
    <img src="${pageContext.request.contextPath}/resources/images/user.png" alt="Avatar" class="avatar">
  </div>

  <div class="container">
  	
	    <label for="uname"><b>Username</b></label>&nbsp;
	    <input type="text" placeholder="Enter Username" name="username">

	    <label for="psw"><b>Password</b></label>&nbsp;
	    <input type="password" placeholder="Enter Password" name="password">
     
    <div>
    	<button type="submit" style="align: center">Login</button>
    </div>    
  </div>

</form>

</body>
</html>
