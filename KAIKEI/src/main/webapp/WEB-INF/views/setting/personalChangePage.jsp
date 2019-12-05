<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
		<script type="text/javascript" src="/js/perAndComChange.js" ></script>

		<div>
			<form action="/setting/personalChange.do" method="post" name="frm">
				<table>
					<tr>
						<th>ID</th><td>${userVO.id}</td>
					</tr>
					<tr>
						<th>Password</th><td><input type="password" name="password"></td>
					</tr>
					<tr>
						<th>Password Check</th><td><input type="password" name="passwordCheck"></td>
					</tr>
					<tr>
						<th>Name</th><td><input type="text" name="name" placeholder="${userVO.name }"></td>
					</tr>
					<tr>
						<th>E-Mail</th><td><input type="text" name="email" placeholder="${userVO.email }"></td>
					</tr>
					<tr>
						<th>Phone</th><td><input type="text" name="phone" placeholder="${userVO.phone }"></td>
					</tr>
				</table>
				<input type="submit" value="Modify" onClick = "return pChangeCheck()">
				<input type="reset" value="Reset">
				<input type="button" onClick = "location.href='/setting/personal.do'" value="Cancel">
			</form>
		</div>