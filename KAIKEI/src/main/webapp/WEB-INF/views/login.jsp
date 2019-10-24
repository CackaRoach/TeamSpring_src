<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div align="center">
	<form action="login.do" method="post">
		<h6>ID</h6><input type="text" name="id" value="${userId}" >
		<h6>Password</h6><input type="password" name="password">
		<h5 style="color:red">${state}</h5>
		<input type="submit" value="Submit">
	</form>
</div>
