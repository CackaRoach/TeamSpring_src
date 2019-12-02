<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="Shift_JIS">
    <title>KAIKEI</title>
    <link rel= "stylesheet" type="text/css" href="/css/layout.css">
</head>
<script>
</script>
<body>
    <div id="header">
    	<div align="center">
			<h1>KAIKEI</h1>
		</div>
    </div>
    <div id="section-only">
		<div id="div-gray" align="center">
			<div>
				<form name="test" action="/forgotId.do" method="post">
					<p>Search ID</p>
					<input class="input-box" type="text" id="email" name="email" placeholder="Enter E-mail">
					<br>
					<input class="button" type="submit" value="Confirm">
				</form>
			</div>
			<div>
				<form>
					<p>Search Password</p>
					<input class="input-box" type="text" id="id" name="id" placeholder="Enter ID">
					<br>
					<input class="input-box" type="text" id="email" name="email" placeholder="Enter E-mail">
					<br>
					<input class="button" type="button" value="Confirm">
				</form>
			</div>
			<div>
				<input class="button" type="button" onclick="location.href='login.do'" value="Cancel">
			</div>
		</div>
    </div>    
    <div id="footer">
    	<div>
			<h6>footer</h6>
		</div>
   	</div>    
</body>
</html>
		