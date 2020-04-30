<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  background-image: url('${pageContext.request.contextPath}/resources/images/bg2.png');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}

.split {
  height: 100%;
  width: 50%;
  position: fixed;
  z-index: 1;
  top: 0;
  overflow-x: hidden;
  padding-top: 20px;
}

.left {
  left: 0;
}

.right {
  right: 0;
}
</style>

</head>
<body>

	<div class="split left">
		<iframe
			src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3684.531682207516!2d88.312795914082!3d22.559209485189616!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3a0279d26c4a46b3%3A0x69050cecbde88424!2sChawla%20Tyre!5e0!3m2!1sen!2sin!4v1588092963828!5m2!1sen!2sin"
			width="600" height="450" frameborder="0" style="border: 0;"
			allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
	</div>

	<div class="split right">
		<h1>Chawla Tyres</h1>
		<h2>Mohan Chawla</h2>
		<h2>Ph: 9830276923</h2>
		<h2>Address: 23, Ram Kumar Ganguly Lane, Howrah - 711103</h2>

		<div>
			<form action="/welcome" method="get">
				<input type="submit" value="Home">
			</form>
		</div>
	</div>


</body>
</html>
