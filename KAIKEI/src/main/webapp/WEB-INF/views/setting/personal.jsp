<%@page import="com.ts.kaikei.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
		<div>
				<table>
					<tr>
						<th>ID</th><td>${userVO.id }</td>
					</tr>
					<tr>
						<th>Name</th><td>${userVO.name }</td>
					</tr>
					<tr>
						<th>E-Mail</th><td>${userVO.email }</td>
					</tr>
					<tr>
						<th>Phone</th><td>${userVO.phone }</td>
					</tr>
					<tr>
						<th>Company</th><td>${userVO.company_cd }</td>
					</tr>
				</table>
			<!-- <a href = "/kaikei/setting/personalChangePage.do">Modify</a> -->
			<button onClick = "location.href='/setting/personalChangePage.do'">Modify</button>
		</div>