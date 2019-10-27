<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<div id="div-gray" align="center">
			<form action="main.do" method="post">
				<div id="div-space">
				</div>
				<h3>Login</h3>
				<table>
					<tr>
						<td style="text-align:center">ID</td>
						<td><input id="input-box" type="text" name="id" ></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input id="input-box" type="password" name="password"></td>
					</tr>
					<tr style="text-align:right">
						<td>Sign Up</td>
						<td>forgot Password</td>
					</tr>
				</table>
				<input id="button" type="submit" value="Login">
				<div id="div-space">
				</div>
			</form>
		</div>

		