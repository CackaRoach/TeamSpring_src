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
	var form = document.createElement("form");

	form.setAttribute("charset", "SHIFT-JIS");
	form.setAttribute("method", "Post"); 
	form.setAttribute("action", "/loginExc.do");

	var id = document.getElementById("id").value;
	var password = document.getElementById("password").value;

	hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "id");
    hiddenField.setAttribute("value", id);

    form.appendChild(hiddenField);

    hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "password");
    hiddenField.setAttribute("value", password);

    form.appendChild(hiddenField);
    document.body.appendChild(form);

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
						<p style="margin: 12px">I D</p>
						<p style="margin: 12px">Password</p>
					</div>
					<div style="float:left; width:40%; height:100%">
						<input class="logininputbox" type="text" id="id" name="id" maxlength="15">
						<br>
						<input class="logininputbox" id="password" name="password" maxlength="15">
					</div>
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
					<button type="button" class="" onclick="location.href='/signup.do'">Sign Up</button>
					<button type="button" class="">forgot ID,Password</button>
					<hr>
				</div>
			</div>
		</div>
    </div>
    <div align="center">asd, asd = Admin Page<br>qwe, qwe = CEO Page<br>zxc, zxc = 社員ページ</div>
    <span class="spanLoginFont">${loginState}</span>
</body>
</html>
		