<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<div id="div-gray" align="center">
			<form action="loginExe.do" method="post">
				<h2>Login</h2>
				<table>
					<tr>
						<td style="text-align:center">ID</td>
						<td><input class="input-box" type="text" name="id" maxlength="15"></td>
					</tr>
					<tr>
						<td style="height:20px"></td>
						<td style="text-align:center"><span class="spanLoginFont" style="display:${state}">Incorrect ID, Password</span></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input class="input-box" type="password" name="password" maxlength="20"></td>
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

		