<!-- UserList Page.HLS -->
<%@ page language="java" contentType="text/html; charset=Shift_JIS"
	pageEncoding="Shift_JIS"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(document).ready(function() {

		$("#findCompany_btn").click(function() {
			getCompanyList();
		});
	})

	function getCompanyList() {
		var url = "/manage/users.do?";
		var state_op = $("#stateCompany_selct option:selected").val();
		var input_tx = $("#findCompany-input").val();
		url = url + "mINPUT=" + input_tx + "&STAT_op=" + state_op + "&mPAGE="
				+ "1";

		location.href = url;
	}
</script>

<div>

	<div style="padding: 20px">
		<span style="font-size: 1.7em;">Manage-User</span>
	</div>


	<div>
		<div align="right">
			<input class="input-box" id="findCompany-input" type="text"
				placeholder="Search for User">
			<button class="button" id="findCompany_btn">FIND</button>
		</div>
	</div>
	
	<table class="company">
		<thead>
			<tr>
				<th></th>
				<th>ID</th>
				<th>Name</th>
				<th>E-mail</th>
				<th>Company</th>
				<th>Position</th>
				<th>
					<select class="button" id="stateCompany_selct" onchange="getCompanyList()" style="background-color: #1591ff;">
					<option value="">State</option>
					<option value="00">ALL</option>
					<option value="01">WORK</option>
					<option value="02">RETIRE</option>
					<option value="03">Extended leave</option>
				</select>
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items='${userList}' var="item" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td><a href="/manage/userDetail.do?id=${item.id}">${item.id}</a></td>
					<td>${item.name}</td>
					<td>${item.email}</td>
					<td>${item.company_name} (${item.company_cd})</td>
					<td>${item.posit_cd_title}</td>
					<td>${item.state_cd_title}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
