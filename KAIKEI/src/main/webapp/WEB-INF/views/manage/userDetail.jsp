<!-- CompanyDetail Page.HLS -->
<%@ page language="java" contentType="text/html; charset=Shift_JIS"
	pageEncoding="Shift_JIS"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set value="${userInfo}" var="userInfo"></c:set>

<script type="text/javascript">
	$(document).ready(function() {
		$("#modBtn").click(function() {
			location.href = "/manage/userDetail.do?mod=M&id=${userInfo.id}";
		});
		$("#fodList").click(function(){
			location.href = "/manage/users.do";
		});
	})
</script>

<div>
	<div>
		<h3>Manage - UserDetail</h3>
	</div>

	<div style="margin: 5px">
		<div align="right">
			<button class="button" id="fodList">List</button>
		</div>

		<table class="detail">
			<tbody>

				<tr>
					<td>ID</td>
					<td>${userInfo.id}</td>
				</tr>
				<tr>
					<td>Name</td>
					<td>${userInfo.name}</td>
				</tr>
				<tr>
					<td>Position</td>
					<td>${userInfo.posit_cd_title}</td>
				</tr>
				<tr>
					<td>State</td>
					<td>${userInfo.state_cd_title}</td>
				</tr>
				<tr>
					<td>E-mail</td>
					<td>${userInfo.email}</td>
				</tr>
				<tr>
					<td>Phone</td>
					<td>${userInfo.phone}</td>
				</tr>
				<tr>
					<td>Company</td>
					<td>${userInfo.company_name}</td>
				</tr>
				<tr>
					<td>Company Code</td>
					<td>${userInfo.company_cd}</td>
				</tr>

			</tbody>
		</table>

		<div align="right">
			<button id="modBtn" class="button" style="background-color: #e1d10f">User Modify</button>
		</div>
	</div>


</div>


