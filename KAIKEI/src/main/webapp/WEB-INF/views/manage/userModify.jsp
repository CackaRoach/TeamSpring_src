<!-- CompanyDetail Page.HLS -->
<%@ page language="java" contentType="text/html; charset=Shift_JIS"
	pageEncoding="Shift_JIS"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set value="${userInfo}" var="userInfo"></c:set>

<script type="text/javascript">
	$(document).ready(function() {
		$("#deleteBtn").click(function(){
			location.href = "/manage/userDelete.do?id=${userInfo.id}";
		});
	
		$("#cancelBtn").click(function(){
			location.href = "/manage/userDetail.do?id=${userInfo.id}";
		});
	});
</script>

<div>
	<div>
		<h3>Manage - UserModify</h3>
	</div>

	<div style="margin: 5px">
		<div align="right">
			<button class="button" id="cancelBtn">Cancel</button>
		</div>

		<form action = "/manage/userModify.do" method = "POST">
		<table class="detail">
			<tbody>

				<tr>
					<td>ID</td>
					<td><input class="input-box" type="text" name = "id" value="${userInfo.id}" readonly></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input class="input-box" type="text" name = "name" value="${userInfo.name}"></td>
				</tr>
				<tr>
					<td>Position</td>
					<td><input class="input-box" type="text" value="${userInfo.posit_cd_title}" readonly></td>
				</tr>
				<tr>
					<td>State</td>
					<td><input class="input-box" type="text" value="${userInfo.state_cd_title}" readonly></td>
				</tr>
				<tr>
					<td>E-mail</td>
					<td><input class="input-box" type="text" name = "email" value="${userInfo.email}"></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><input class="input-box" type="tel" name = "phone" value="${userInfo.phone}"></td>
				</tr>
				<tr>
					<td>Company</td>
					<td><input class="input-box" type="text" value="${userInfo.company_name}" readonly></td>
				</tr>
				<tr>
					<td>Company Code</td>
					<td><input class="input-box" type="text" name = "company_cd" value="${userInfo.company_cd}"	readonly></td>
				</tr>

			</tbody>
		</table>

		<div align="right">
				<input type="submit" id="modBtn" class="button" value="SAVE">
				<input type="button" id="deleteBtn" class="button" value= "DELETE" style="background-color: #ff0000;">
		</div>
		</form>
	</div>


</div>


