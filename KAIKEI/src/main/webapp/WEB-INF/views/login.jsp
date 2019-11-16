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
   	<div align="center" style="min-width:400px; padding: 100px 0px; margin: 0% 20%;">
		<div style="font-size: 40px; font-style: italic;">K A I K E I</div>
	</div>
	<div align="center" style="min-width:400px; padding: 30px;">
		<form action="loginExe.do" method="post">
			<table>
				<tr>
					<td><input class="input-box input-box-login" type="text" name="id" placeholder="Enter ID" maxlength="15"></td>
				</tr>
				<tr>
					<td style="text-align:center;"><span class="spanLoginFont">${loginState}</span></td>
				</tr>
				<tr>
					<td><input class="input-box input-box-login" type="password" name="password" placeholder="Enter Password" maxlength="15"></td>
				</tr>
			</table>
			<div style="height:20px">
			</div>
			<input class="button button-login" type="submit" value="Login">
		</form><br>
		<input class="button button-login" type="button" value="Sign Up" onclick="location.href='/signup.do'">
		<table style="text-align:center">
			<tr>
				<td style="padding:10px 0px"><!--<a href="forgot.do"></a>-->forgot ID,Password</td>
			</tr>
		</table>
    </div>
    <div align="center">asd, asd = Admin Page<br>qwe, qwe = CEO Page<br>zxc, zxc = 社員ページ</div>
</body>
</html>
		