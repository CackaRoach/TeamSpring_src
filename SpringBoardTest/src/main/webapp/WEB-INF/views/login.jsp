<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="Shift_JIS">
<title>Login</title>
<script type="text/javascript">

</script> 
</head>
<body>
	<div align="center">
		<form action="login.do" method="post">
			<h6>ID</h6><input type="text" name="id" value="${userId}" >
			<h6>Password</h6><input type="password" name="passwd">
			<h5 style="color:red">${state}</h5>
			<input type="submit" value="Submit">
		</form>
	</div>
	<div align="center">
		<h2><a href="regist.do">Sign UP</a></h2>
	</div>
</body>
</html>