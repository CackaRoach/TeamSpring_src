<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
		<script type="text/javascript" src="/js/perAndComChange.js" ></script>

		<form action="/setting/companyChange.do" method="post" name="frm">
				<table>
					<tr>
						<th>Company</th><td><input type="text" name="title" placeholder="${companyVO.title}"></td>
					</tr>
					<tr>
						<th>Company Code</th><td><input type="text" name="company_cd" placeholder="${companyVO.company_cd}"></td>
					</tr>
					<tr>
						<th>Company Logo</th><td>?</td>
					</tr>
					<tr>
						<th>Business License Number</th><td><input type="text" name="reg_cd" placeholder="${companyVO.regist_cd}"></td>
					</tr>
					<tr>
						<th>FAX</th><td><input type="text" name="fax" placeholder="${companyVO.fax}"></td>
					</tr>
					<tr>
						<th>Phone</th><td><input type="text" name="phone" placeholder="${companyVO.phone}"></td>
					</tr>
					<tr>
						<th>Domain</th><td><input type="text" name="domain" placeholder="${companyVO.domain}"></td>
					</tr>
					<tr>
						<th>Bank</th><td><input type="text" name="bank_title" placeholder="${companyVO.bank_title}"></td>
					</tr>
				</table>
				<input type="submit" value="Modify" onClick = "return cChangeCheck()">
				<input type="reset" value="Reset">
				<input type="button" onClick = "location.href='/setting/company.do'" value="Cancel">
			</form>