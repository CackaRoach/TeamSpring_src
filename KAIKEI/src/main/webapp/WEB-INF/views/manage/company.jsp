<!-- CompanyList Page.HLS -->
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
		var url = "/manage/company.do?";
		var state_op = $("#stateCompany_selct option:selected").val();
		var input_tx = $("#findCompany-input").val();
		url = url + "mINPUT=" + input_tx + "&STAT_op=" + state_op + "&mPAGE="
				+ "1";

		location.href = url;
	}
</script>

<div>

	<div style="padding: 20px">
		<span style="font-size: 1.7em;">Manage-Company</span>
	</div>


	<div>
		<div align="right">
			 <input class="input-box" id="findCompany-input" type="text"
				placeholder="Search for Company">
			<button class="button" id="findCompany_btn">FIND</button>
		</div>
	</div>
	
	<table class="company">
		<thead>
			<tr>
				<th></th>
				<th>Code</th>
				<th>Company</th>
				<th>CEO</th>
				<th>Domain</th>
				<th>Phone</th>
				<th><select class="button" id="stateCompany_selct"
				onchange="getCompanyList()" style="background-color: #1591ff;">
				<option value="">State</option>
				<option value="00">ALL</option>
				<option value="01">ACCEPT</option>
				<option value="02">RESULT</option>
				<option value="03">HOLD OFF</option>
			</select></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items='${companyList}' var="item" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${item.company_cd}</td>
					<td><a href="/manage/companyDetail.do?id=${item.company_cd}">
							${item.title} </a></td>
					<td>${item.name}</td>
					<td>${item.domain}</td>
					<td>${item.phone}</td>
					<td>${item.auth_cd}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
