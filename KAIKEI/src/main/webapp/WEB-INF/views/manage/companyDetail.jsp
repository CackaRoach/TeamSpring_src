<!-- CompanyDetail Page.HLS -->
<%@ page language="java" contentType="text/html; charset=Shift_JIS"
	pageEncoding="Shift_JIS"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set value="${companyInfo}" var="companyInfo"></c:set>

<script type="text/javascript">
	$(document).ready(function() {
		$("#modBtn").click(function() {
			location.href = "/manage/companyDetail.do?mod=M&id=${companyInfo.company_cd}";
		});
		$("#siteBtn").click(function(){
			location.href = "/manage/companySite.do?id=${companyInfo.company_cd}";
		});
		$("#fodList").click(function(){
			location.href = "/manage/company.do";
		});
	})
</script>

<div>
	<div>
		<h3>Manage - CompanyDetail</h3>
	</div>

	<div style="margin: 5px">
		<div align="right">
			<button class="button" id="fodList">List</button>
		</div>

		<table class="detail">
			<tbody>

				<tr>
					<td>Company</td>
					<td>${companyInfo.title}</td>
				</tr>
				<tr>
					<td>Company Code</td>
					<td>${companyInfo.company_cd}</td>
				</tr>
				<tr>
					<td>Logo</td>
					<td></td>
				</tr>
				<tr>
					<td>State</td>
					<td>${companyInfo.auth_cd}</td>
				</tr>
				<tr>
					<td>Accept Date</td>
					<td>${companyInfo.ent_date}</td>
				</tr>
				<tr>
					<td>Buisiness License Number</td>
					<td>${companyInfo.reg_cd}</td>
				</tr>
				<tr>
					<td>Fax</td>
					<td>${companyInfo.fax}</td>
				</tr>
				<tr>
					<td>Phone</td>
					<td>${companyInfo.phone}</td>
				</tr>
				<tr>
					<td>Domain</td>
					<td>${companyInfo.domain}</td>
				</tr>
				<tr>
					<td>Bank</td>
					<td rowspan="2">${companyInfo.bank_title}<br>
						${companyInfo.bank_acc}
					</td>
				</tr>

			</tbody>
		</table>

		<div align="right">
			<button id="modBtn" class="button" style="background-color: #e1d10f">Company
				Modify</button>
			<button id="siteBtn" class="button" style="background-color: #ff0000;">Company Site</button>
		</div>
	</div>


</div>


