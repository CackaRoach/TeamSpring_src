<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="Shift_JIS">
<title>Post</title>
</head>
<body>
	<div align="center">
		<form action="${action}" method="post">	
			<table border="1" style="border-collapse:collapse; text-align:center">
				<tr>
					<td>Title</td><td><input type="text" name="title" value="${boardVO.title}"></td>
				</tr>
				<tr>
					<td>Author</td><td>${userVO.name}</td>
				</tr>
				<tr>
					<td>Text</td><td><input type="text" name="contents" value="${boardVO.contents}"></td>
				</tr>
			</table>
			<input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>