<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="Shift_JIS">
    <title>KAIKEI</title>
    <link rel= "stylesheet" type="text/css" href="/kaikei/css/layout.css">
</head>
<body>
    <div id="header">
    	<div align="center">
			<h1>KAIKEI</h1>
		</div>
    </div>
    <div id="section-only">
		<div id="div-gray" align="center">
			<form action="loginExe.do" method="post">
				<h2>Login</h2>
				<table>
					<tr>
						<td><input class="input-box" type="text" name="id" placeholder="ID" maxlength="15"></td>
					</tr>
					<tr>
						<td style="height:20px; text-align:center"><span class="spanLoginFont" style="display:${state}">Incorrect ID, Password</span></td>
					</tr>
					<tr>
						<td><input class="input-box" type="password" name="password" placeholder="Password" maxlength="20"></td>
					</tr>
				</table>
				<div style="height:20px">
				</div>
				<input class="button" type="submit" value="Login">
				<div style="height:20px">
				</div>
				<table style="text-align:center">
					<tr>
						<td style="padding:10px 0px"><a href="signup.do">Sign Up</a></td>
					</tr>
					<tr>
						<td style="padding:10px 0px"><a href="forgot.do">forgot ID,Password</a></td>
					</tr>
				</table>
			</form>
		</div>
    </div>    
    <div id="footer">
    	<div>
			<h6>footer</h6>
		</div>
   	</div>    
</body>
</html>
		