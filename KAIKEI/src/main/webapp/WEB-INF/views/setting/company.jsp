<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="Shift_JIS"%>
    	<!-- 11-10 -->

		<div>
				<table>
					<tr>
						<th>Company</th><td>${companyVO.title }</td>
					</tr>
					<tr>
						<th>Company Code</th><td>${companyVO.company_cd }</td>
					</tr>
					<tr>
						<th>Company Logo</th><td>?</td>
					</tr>
					<tr>
						<th>Business License <br> Number</th><td>${companyVO.regist_cd }</td>
					</tr>
					<tr>
						<th>FAX</th><td>${companyVO.fax}</td>
					</tr>
					<tr>
						<th>Phone</th><td>${companyVO.phone }</td>
					</tr>
					<tr>
						<th>Domain</th><td>${companyVO.domain }</td>
					</tr>
					<tr>
						<th>Bank</th><td>${companyVO.bank_title }</td>
					</tr>
				</table>
			<button onClick = "location.href='/setting/companyChangePage.do'">Modify</button>
		</div>