<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="Shift_JIS">
<title>${boardVO.title}</title>
</head>
<body>
	<div align="center">
		<table border="1" style="border-collapse:collapse; text-align:center">
			<tr>
				<td>INDEX</td><td>${boardVO.idx}</td><td>TIME</td><td>${boardVO.uptime}</td>
			</tr>
			<tr>
				<td>TITLE</td><td colspan="3">${boardVO.title}</td>
			</tr>
			<tr>
				<td>AUTHOR</td><td colspan="3">${boardVO.author_name}</td>
			</tr>
			<tr>
				<td>TEXT</td><td colspan="3">${boardVO.contents}</td>
			</tr>
		</table>
	</div>
	<div align="center">
		<c:if test="${boardVO.author_id == userVO.id}">
		<a href="deleteBoard.do?idx=${boardVO.idx}">[Delete]</a>
		</c:if>
	    <c:if test="${boardVO.author_id == userVO.id}"> <a href="updateBoard.do">[Modify]</a> </c:if>
		<a href="getBoardList.do">[List]</a>
	</div>
</body>
</html>