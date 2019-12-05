<!-- CompanyDetail Page.HLS -->
<%@ page language="java" contentType="text/html; charset=Shift_JIS"
	pageEncoding="Shift_JIS"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set value="${companyInfo}" var="companyInfo"></c:set>

<script type="text/javascript">
	$(document).ready(function() {
		default_val();

		$("#deleteBtn").click(function(){
			location.href = "/manage/companyDelete.do?id=${companyInfo.company_cd}";
		});

		$("#cencelBtn").click(function(){
			location.href = "/manage/companyDetail.do?id=${companyInfo.company_cd}";
		});
	});

	function default_val() {
		var id = '${companyInfo.aut}';
		$("#state-select").val(id).prop("selected", true);
	}
</script>

<div>
	<div>
		<h3>Manage - Company Modify</h3>
	</div>

	<div style="margin: 5px">
		<div align="right">
			<button class="button" id="cencelBtn">Cancel</button>
		</div>
		
		<form action = "/manage/companyModify.do" method = "POST">
			<table class="detail">

				<tbody>

					<tr>
						<td>Company</td>
						<td><input class="input-box" type="text" name = "title" value="${companyInfo.title}" placeholder="Company-Name" required>
						</td>
					</tr>
					<tr>
						<td>Company Code</td>
						<td><input class="input-box" type="text" name = "company_cd" value="${companyInfo.company_cd}" minlength="5" maxlength="5" required></td>
					</tr>
					<tr>
						<td>Logo</td>
						<td><input type="button" class="button" value="UPLOAD" style="background-color: #BDBDBD;"></td>
					</tr>
					<tr>
						<td>State</td>
						<td>
							<select class="button" id="state-select" name = "auth_cd">
								<option value="001">ACCEPT</option>
								<option value="002">REJECT</option>
								<option value="003">HOLD OFF</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>Accept Date</td>
						<td>${companyInfo.ent_date}</td>
					</tr>
					<tr>
						<td>Buisiness License Number</td>
						<td><input class="input-box" type="text" name = "reg_cd" value="${companyInfo.reg_cd}" placeholder="Buisiness License Number" required></td>
					</tr>
					<tr>
						<td>Fax</td>
						<td><input class="input-box" type="text" name="fax" value="${companyInfo.fax}" placeholder="FAX"></td>
					</tr>
					<tr>
						<td>Phone</td>
						<td><input class="input-box" type="text" name="phone" value="${companyInfo.phone}" placeholder="Phone"></td>
					</tr>
					<tr>
						<td>Domain</td>
						<td><input class="input-box" type="text" name="domain" value="${companyInfo.domain}" placeholder="Domain"></td>
					</tr>
					<tr>
						<td>Bank</td>
						<td rowspan="2">
							<input class="input-box" type="text" value="${companyInfo.bank_title}" placeholder="Bank-Name"><br>
							<input class="input-box" type="text" value="${companyInfo.bank_acc}" placeholder="Bank Account Number">
						</td>
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




