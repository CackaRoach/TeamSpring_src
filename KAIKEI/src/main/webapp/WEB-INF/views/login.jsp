<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<!-- TODO: Login Fail Alert Window -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="Shift_JIS">
    <title>KAIKEI</title>
    <link rel= "stylesheet" type="text/css" href="/css/layout.css">
</head>
<script>
function submit() {
	var form = document.getElementById("form");

	if(document.getElementById("id").value == "") {
		alert("IDを入力してください!");
		document.getElementById("id").focus();
		return false;
	}

	if(document.getElementById("password").value == "") {
		alert("パスワードを入力してください!");
		document.getElementById("password").focus();
		return false;
	}
	
	form.setAttribute("charset", "SHIFT-JIS");
	form.setAttribute("method", "Post"); 
	form.setAttribute("action", "/loginExc.do");

	form.submit();
}
</script>
<body>
	<div style="min-width:400px; padding: 15% 30% 0% 30%">
		<div style="padding: 10px; border:1px solid black; height:226px;">
			<div style="float:left; width:40%">
				<img src="/images/login.png">
			</div>
			<div style="float:left; width:60%;">
				<div>
					<label style="color:#07E0DB; font-size: 2em">KAIKEI</label>
				</div>
				<div style="height:80px;">
					<div align="center" style="float:left; width:20%; height:100%">
						<p style="margin: 12px; font-size: 1em;">I D</p>
						<p style="margin: 12px; font-size: 1em;">PW</p>
					</div>
					<form id="form">
					<div style="float:left; width:40%; height:100%">
						<input class="logininputbox" type="text" id="id" name="id" maxlength="15">
						<br>
						<input class="logininputbox" type="password" id="password" name="password" maxlength="15">
					</div>
					</form>
					<div style="float:left; width:40%; height:100%">
						<button class="loginbutton" style="margin:5px;" onclick="submit();">Login</button>
					</div>
				</div>
				<div align="right" style="margin:10px">
					<input type="checkbox" class="logincheckbox" id="saveid"> Save ID
					<input type="checkbox" class="logincheckbox" id="autologin"> Auto Login
				</div>
				<div align="right">
					<hr>
					<button type="button" class="login-gray-btn" onclick="location.href='/signup.do'">Sign Up</button>
					<button type="button" class="login-gray-btn" onclick="location.href='/forgot.do'">Forgot ID/PW</button>
					<hr>
				</div>
			</div>
		</div>
    </div>
    <span class="spanLoginFont">${loginState}</span>
</body>
</html>
		