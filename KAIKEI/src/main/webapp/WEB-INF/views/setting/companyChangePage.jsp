<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
		<script type="text/javascript" src="/js/perAndComChange.js" ></script>
		<div>
			<div style="padding: 30px">
				<span style="font-size: 2em">Company</span>
			</div>
			<hr>
			<div>
				<form action="/setting/companyChange.do" method="post" name="frm">
					<table>
						<tr>
							<td>Company</td>
							<td><input type="text" class="input-box" name="title" value="${companyVO.title}"></td>
						</tr>
						<tr>
							<td>Company Code</td>
							<td><input type="text" class="input-box" name="company_cd" value="${companyVO.company_cd}"></td>
						</tr>
						<tr>
							<td>Company Logo</td>
							<td>?</td>
						</tr>
						<tr>
							<td>Business License Number</td>
							<td><input type="text" class="input-box" name="reg_cd" value="${companyVO.regist_cd}"></td>
						</tr>
						<tr>
							<td>FAX</td>
							<td><input type="text" class="input-box" name="fax" value="${companyVO.fax}"></td>
						</tr>
						<tr>
							<td>Phone</td><td>
							<input type="text" class="input-box" name="phone" value="${companyVO.phone}"></td>
						</tr>
						<tr>
							<td>Domain</td>
							<td><input type="text" class="input-box" name="domain" value="${companyVO.domain}"></td>
						</tr>
						<tr>
							<td>Bank</td>
							<td><input type="text" class="input-box" name="bank_title" value="${companyVO.bank_title}"></td>
						</tr>
				</table>
				<div align="right" style="padding: 15px;">
					<input type="submit" class="button" value="Modify" onClick = "return cChangeCheck()">
					<input type="button" class="button" onClick = "location.href='/setting/company.do'" value="Cancel">
				</div>
			</form>
			</div>
		</div>