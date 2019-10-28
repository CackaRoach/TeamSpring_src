<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%><%-- 
		<div>
			<h3>PS</h3>
		</div>
		<div align="center">
		<table border="1" style="border-collapse:collapse; text-align:center">
			<tr>
				<th bgcolor="#B2FF95" style="width:50px">Index</th>
				<th bgcolor="#B2FF95" style="width:200px">Title</th>
				<th bgcolor="#B2FF95" style="width:200px">Time</th>
				<th bgcolor="#B2FF95" style="width:70px">Author</th>
				<th bgcolor="#B2FF95" style="width:50px">Hits</th>
			</tr>
			<c:forEach var="StatementVO" items="${boardList}">
				<tr>
				<td>${boardVO.idx}</td>
				<td><a href="getBoardDetail.do?idx=${boardVO.idx}">${boardVO.title}</a></td>
				<td>${boardVO.uptime}</td>
				<td>${boardVO.author_name}</td>
				<td>${boardVO.hits}</td>
				</tr>
			</c:forEach>
		</table>
		<p></p>
			<div align="center">
				<input type="button" onClick="location.href = 'addBoard.do'" value="Post">
			</div>
		<p></p>
		</div> --%>